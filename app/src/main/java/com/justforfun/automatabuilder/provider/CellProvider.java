package com.justforfun.automatabuilder.provider;

import android.arch.lifecycle.LiveData;

import com.justforfun.automatabuilder.dao.CellConfigDao;
import com.justforfun.automatabuilder.model.config.CellConfig;

import java.util.List;

/**
 * Created by hectormoreno on 11/20/17.
 */

public class CellProvider {
    private CellConfigDao dao;

    public CellProvider(CellConfigDao dao)
    {
        this.dao = dao;
    }

    public LiveData<List<CellConfig>> getCells(int planetId)
    {
        return dao.getCellsWithPlanetId(planetId);
    }

    public LiveData<CellConfig> findById(int id){
        return dao.findById(id);
    }

    public void insertCells(CellConfig... cellConfigs)
    {
        dao.insertOrUpdate(cellConfigs);
    }

}
