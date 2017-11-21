package com.justforfun.automatabuilder.activities.newplanet;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.justforfun.automatabuilder.callback.DaoTaskCallback;
import com.justforfun.automatabuilder.task.SavePlanetTask;
import com.justforfun.automatabuilder.dao.PlanetConfigDao;
import com.justforfun.automatabuilder.model.config.PlanetConfig;
import com.justforfun.automatabuilder.provider.PlanetProvider;

/**
 * Created by hectormoreno on 11/19/17.
 */

public class NewPlanetVM extends ViewModel {
    private PlanetProvider planetProvider;

    void init(PlanetConfigDao dao)
    {
        planetProvider = new PlanetProvider(dao);
    }

    LiveData<PlanetConfig> getPlanet(int id)
    {
        return planetProvider.findById(id);
    }

    void savePlanet(PlanetConfig planet,DaoTaskCallback callback)
    {
        SavePlanetTask savePlanetTask = new SavePlanetTask(planetProvider,planet,callback);
        savePlanetTask.execute();
    }
}
