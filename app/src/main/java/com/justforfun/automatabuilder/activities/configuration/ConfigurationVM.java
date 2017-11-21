package com.justforfun.automatabuilder.activities.configuration;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.justforfun.automatabuilder.callback.DaoTaskCallback;
import com.justforfun.automatabuilder.dao.CellConfigDao;
import com.justforfun.automatabuilder.provider.CellProvider;
import com.justforfun.automatabuilder.task.SaveCellTask;
import com.justforfun.automatabuilder.task.SavePlanetTask;
import com.justforfun.automatabuilder.dao.PlanetConfigDao;
import com.justforfun.automatabuilder.model.config.CellConfig;
import com.justforfun.automatabuilder.model.config.PlanetConfig;
import com.justforfun.automatabuilder.provider.PlanetProvider;

import java.util.List;

/**
 * Created by hectormoreno on 11/20/17.
 */

public class ConfigurationVM extends ViewModel {

    private PlanetProvider planetProvider;
    private CellProvider cellProvider;
    private LiveData<PlanetConfig> planetConfig;
    private LiveData<List<CellConfig>> cellConfigLiveData;

    void init(PlanetConfigDao planetConfigDao, CellConfigDao cellConfigDao)
    {
        this.planetProvider = new PlanetProvider(planetConfigDao);
        this.cellProvider = new CellProvider(cellConfigDao);
    }

    public LiveData<PlanetConfig> getPlanet(int id)
    {
        if (planetConfig == null)
        {
            loadPlanet(id);
        }
        return planetConfig;
    }

    public LiveData<List<CellConfig>> getCells(int planetId)
    {
        if (cellConfigLiveData == null)
        {
            loadCells(planetId);
        }
        return cellConfigLiveData;
    }

    private void loadCells(int planetId){
        this.cellConfigLiveData = cellProvider.getCells(planetId);
    }

    private void loadPlanet(int id)
    {
        planetConfig = planetProvider.findById(id);
    }

    public void savePlanet(PlanetConfig planetConfig, DaoTaskCallback callback)
    {
        SavePlanetTask savePlanetTask = new SavePlanetTask(planetProvider,planetConfig,callback);
        savePlanetTask.execute();
    }

    public void saveCell(CellConfig cellConfig, DaoTaskCallback callback){
        SaveCellTask saveCellTask = new SaveCellTask(cellProvider,cellConfig,callback);
        saveCellTask.execute();
    }
}
