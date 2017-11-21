package com.justforfun.automatabuilder.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.justforfun.automatabuilder.model.config.CellConfig;

import java.util.List;

/**
 * Created by hectormoreno on 11/19/17.
 */

@Dao
public interface CellConfigDao {
    @Query("SELECT * FROM CellConfig WHERE planet_id = :planetId")
    LiveData<List<CellConfig>> getCellsWithPlanetId(int planetId);

    @Query("SELECT * FROM CellConfig WHERE id = :id")
    LiveData<CellConfig> findById(int id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertOrUpdate(CellConfig... cellConfigs);
}
