package com.justforfun.automatabuilder.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.justforfun.automatabuilder.model.config.PlanetConfig;

import java.util.List;

/**
 * Created by hectormoreno on 11/19/17.
 */

@Dao
public interface PlanetConfigDao {
    @Query("SELECT * FROM PlanetConfig")
    LiveData<List<PlanetConfig>> getPlanets();
    @Query("SELECT * FROM PlanetConfig WHERE id = :id")
    LiveData<PlanetConfig> findById(int id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertOrUpdate(PlanetConfig... planets);
}
