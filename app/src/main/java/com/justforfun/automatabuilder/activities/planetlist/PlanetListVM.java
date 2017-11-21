package com.justforfun.automatabuilder.activities.planetlist;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.justforfun.automatabuilder.dao.PlanetConfigDao;
import com.justforfun.automatabuilder.model.config.PlanetConfig;
import com.justforfun.automatabuilder.provider.PlanetProvider;

import java.util.List;

/**
 * Created by hectormoreno on 11/19/17.
 */

class PlanetListVM extends ViewModel{
    private LiveData<List<PlanetConfig>> planets;
    private PlanetProvider planetProvider;

    void init(PlanetConfigDao dao)
    {
        if (planetProvider == null) {
            this.planetProvider = new PlanetProvider(dao);
        }
    }

    LiveData<List<PlanetConfig>> getPlanets() {
        if (planets == null)
        {
            loadPlanets();
        }
        return planets;
    }

    private void loadPlanets()
    {
        planets = planetProvider.getPlanets();
    }

}
