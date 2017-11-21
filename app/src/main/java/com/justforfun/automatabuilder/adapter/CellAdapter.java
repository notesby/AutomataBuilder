package com.justforfun.automatabuilder.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.justforfun.automatabuilder.R;
import com.justforfun.automatabuilder.base.BindingViewHolder;
import com.justforfun.automatabuilder.callback.OnSelectedItemCallback;
import com.justforfun.automatabuilder.databinding.RowCellBinding;
import com.justforfun.automatabuilder.model.config.CellConfig;

import java.util.List;

/**
 * Created by hectormoreno on 11/20/17.
 */

public class CellAdapter extends RecyclerView.Adapter<BindingViewHolder> {
    private List<CellConfig> cellConfigs;
    private Context context;
    private OnSelectedItemCallback<CellConfig> callback;


    public CellAdapter(Context context,List<CellConfig> cellConfigs)
    {
        this.context = context;
        this.cellConfigs = cellConfigs;
    }

    public void setCallback(OnSelectedItemCallback<CellConfig> callback) {
        this.callback = callback;
    }

    @Override
    public BindingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        RowCellBinding binding = DataBindingUtil.inflate(inflater, R.layout.row_cell,parent,false);
        return new BindingViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(BindingViewHolder holder, int position) {
        RowCellBinding binding = (RowCellBinding) holder.getBinding();
        binding.setCell(cellConfigs.get(position));
        final View.OnClickListener listener = view -> {
            if (callback != null)
            {
                callback.onSelectedItem(cellConfigs.get(position));
            }
        };
        binding.setSelectedItem(listener);
    }

    @Override
    public int getItemCount() {
        return cellConfigs.size();
    }
}
