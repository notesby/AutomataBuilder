package com.justforfun.automatabuilder.fragment;


import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.justforfun.automatabuilder.R;
import com.justforfun.automatabuilder.callback.DaoTaskCallback;
import com.justforfun.automatabuilder.activities.configuration.ConfigurationVM;
import com.justforfun.automatabuilder.callback.ProgressCallback;
import com.justforfun.automatabuilder.databinding.FragmentGridConfigurationBinding;
import com.justforfun.automatabuilder.model.config.GridConfig;
import com.justforfun.automatabuilder.model.config.PlanetConfig;

import static com.justforfun.automatabuilder.activities.configuration.ConfigurationActivity.ARGS_PLANET_ID;


/**
 * A simple {@link Fragment} subclass.
 */
public class GridConfigurationFragment extends Fragment implements DaoTaskCallback{

    ConfigurationVM configurationVM;
    PlanetConfig planetConfig;
    FragmentGridConfigurationBinding binding;
    ProgressCallback progressCallback;

    Bundle bundle;

    public GridConfigurationFragment() {
        // Required empty public constructor
    }

    public void setProgressCallback(ProgressCallback progressCallback) {
        this.progressCallback = progressCallback;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_grid_configuration,container,false);
        configurationVM = ViewModelProviders.of(getActivity()).get(ConfigurationVM.class);
        configurationVM.getPlanet(bundle.getInt(ARGS_PLANET_ID)).observe(this,planetConfig1 -> {
            if (planetConfig1 == null){
                return;
            }

            this.planetConfig = planetConfig1;
            if (this.planetConfig.getGridConfig() == null)
            {
                planetConfig.setGridConfig(new GridConfig());
            }
            binding.setX(planetConfig.getGridConfig().getX()+"");
            binding.setY(planetConfig.getGridConfig().getY()+"");
            binding.setZ(planetConfig.getGridConfig().getZ()+"");
        });
        View.OnClickListener onClickListener = view -> saveGrid();
        binding.setSaveListener(onClickListener);
        return binding.getRoot();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        bundle = getArguments();
    }

    public void saveGrid()
    {
        int x;
        int y;
        int z = 0;

        if (!binding.textEditX.getText().toString().isEmpty()) {
            x = Integer.parseInt(binding.textEditX.getText().toString());
            binding.textInputLayoutX.setErrorEnabled(false);
        }
        else {
            binding.textInputLayoutX.setError("Required");
            binding.textInputLayoutX.setErrorEnabled(true);
            return;
        }
        if (!binding.textEditY.getText().toString().isEmpty()) {
            y = Integer.parseInt(binding.textEditY.getText().toString());
            binding.textInputLayoutY.setErrorEnabled(false);
        }
        else {
            binding.textInputLayoutY.setError("Required");
            binding.textInputLayoutY.setErrorEnabled(true);
            return;
        }
        if (!binding.textEditZ.getText().toString().isEmpty()) {
            z = Integer.parseInt(binding.textEditZ.getText().toString());
        }

        planetConfig.getGridConfig().setX(x);
        planetConfig.getGridConfig().setY(y);
        planetConfig.getGridConfig().setZ(z);

        configurationVM.savePlanet(planetConfig,this);
    }

    @Override
    public void onSuccess() {
        if (progressCallback != null)
        {
            progressCallback.stepCompleted(1);
        }
    }
}
