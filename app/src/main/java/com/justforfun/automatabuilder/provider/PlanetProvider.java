package com.justforfun.automatabuilder.provider;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.justforfun.automatabuilder.dao.PlanetConfigDao;
import com.justforfun.automatabuilder.model.Planet;
import com.justforfun.automatabuilder.model.config.PlanetConfig;

import java.util.List;

/**
 * Created by hectormoreno on 11/20/17.
 */

public class PlanetProvider {
    private PlanetConfigDao planetConfigDao;

    public PlanetProvider(PlanetConfigDao dao){
        this.planetConfigDao = dao;
    }

    public LiveData<List<PlanetConfig>> getPlanets()
    {
        return planetConfigDao.getPlanets();
    }

    public LiveData<PlanetConfig> findById(int id)
    {
        return planetConfigDao.findById(id);
    }

    public void insertPlanets(PlanetConfig... planetConfigs)
    {
        planetConfigDao.insertOrUpdate(planetConfigs);
    }
}
