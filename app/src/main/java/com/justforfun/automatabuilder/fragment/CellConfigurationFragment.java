package com.justforfun.automatabuilder.fragment;


import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.justforfun.automatabuilder.R;
import com.justforfun.automatabuilder.activities.configuration.ConfigurationVM;
import com.justforfun.automatabuilder.activities.newcell.NewCellActivity;
import com.justforfun.automatabuilder.adapter.CellAdapter;
import com.justforfun.automatabuilder.callback.OnSelectedItemCallback;
import com.justforfun.automatabuilder.databinding.FragmentCellConfigurationBinding;
import com.justforfun.automatabuilder.model.config.CellConfig;

import java.util.ArrayList;
import java.util.List;

import static com.justforfun.automatabuilder.activities.configuration.ConfigurationActivity.ARGS_PLANET_ID;

/**
 * A simple {@link Fragment} subclass.
 */
public class CellConfigurationFragment extends Fragment implements OnSelectedItemCallback<CellConfig> {
    CellAdapter adapter;
    List<CellConfig> cellConfigs;
    FragmentCellConfigurationBinding binding;
    Bundle bundle;
    ConfigurationVM configurationVM;
    int planetId;

    public CellConfigurationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_cell_configuration,container,false);
        cellConfigs = new ArrayList<>();

        adapter = new CellAdapter(getContext(),cellConfigs);
        adapter.setCallback(this);

        binding.recyclerView.setAdapter(adapter);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        planetId = bundle.getInt(ARGS_PLANET_ID);

        configurationVM = ViewModelProviders.of(getActivity()).get(ConfigurationVM.class);
        configurationVM.getCells(planetId).observe(this,cellConfigs -> {
            if (cellConfigs == null)
            {
                return;
            }

            this.cellConfigs.addAll(cellConfigs);
            this.adapter.notifyDataSetChanged();
        });
        binding.setListener(view -> newCell());

        // Inflate the layout for this fragment
        return binding.getRoot();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bundle = getArguments();
    }

    private void newCell()
    {
        Intent intent = new Intent(getContext(), NewCellActivity.class);
        intent.putExtra(ARGS_PLANET_ID,planetId);
        startActivity(intent);
    }

    @Override
    public void onSelectedItem(CellConfig item) {

    }
}
