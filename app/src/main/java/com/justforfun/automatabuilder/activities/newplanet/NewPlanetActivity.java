package com.justforfun.automatabuilder.activities.newplanet;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.justforfun.automatabuilder.MyApplication;
import com.justforfun.automatabuilder.R;
import com.justforfun.automatabuilder.callback.DaoTaskCallback;
import com.justforfun.automatabuilder.task.SavePlanetTask;
import com.justforfun.automatabuilder.databinding.ActivityNewPlanetBinding;
import com.justforfun.automatabuilder.model.config.PlanetConfig;

public class NewPlanetActivity extends AppCompatActivity
                                implements DaoTaskCallback{

    NewPlanetVM newPlanetVM;

    PlanetConfig planetConfig;

    ActivityNewPlanetBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_new_planet);

        Intent intent = getIntent();
        int planetId = intent.getIntExtra("planetId",0);

        newPlanetVM = ViewModelProviders.of(this).get(NewPlanetVM.class);
        newPlanetVM.init(MyApplication.getDatabase().planetConfigDao());

        if (planetConfig == null)
        {
            newPlanetVM.getPlanet(planetId).observe(this,planetConfig1 -> {
                planetConfig = planetConfig1;
            });
        }
    }

    public void savePlanet(View view)
    {
        if (planetConfig == null)
        {
            planetConfig = new PlanetConfig();
        }

        planetConfig.setName(binding.textEditName.getText().toString());

        newPlanetVM.savePlanet(planetConfig,this);
    }

    @Override
    public void onSuccess() {
        this.finish();
    }
}
