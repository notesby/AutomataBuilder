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
import com.justforfun.automatabuilder.databinding.RowPlanetBinding;
import com.justforfun.automatabuilder.model.config.PlanetConfig;

import java.util.List;

/**
 * Created by hectormoreno on 11/19/17.
 */

public class PlanetAdapter extends RecyclerView.Adapter<BindingViewHolder> {

    static final String TAG = PlanetAdapter.class.getName();
    private List<PlanetConfig> planets;
    private Context context;
    private OnSelectedItemCallback<PlanetConfig> callback;

    public PlanetAdapter(Context context, List<PlanetConfig> planets) {
        this.context = context;
        this.planets = planets;
    }

    public void setPlanetAdapterCallback(OnSelectedItemCallback<PlanetConfig> callback)
    {
        this.callback = callback;
    }

    @Override
    public BindingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);

        RowPlanetBinding rowPlanetBinding =
                DataBindingUtil.inflate(inflater, R.layout.row_planet,parent,false);

        return new BindingViewHolder(rowPlanetBinding);
    }

    @Override
    public void onBindViewHolder(BindingViewHolder holder, int position) {
        RowPlanetBinding rowPlanetBinding = (RowPlanetBinding) holder.getBinding();
        rowPlanetBinding.setPlanet(planets.get(position));

        final View.OnClickListener onClickListener = view -> {
            if (callback != null)
            {
                callback.onSelectedItem(planets.get(position));
            }
        };
        rowPlanetBinding.setSelectedItem(onClickListener);
    }



    @Override
    public int getItemCount() {
        return planets.size();
    }

}
