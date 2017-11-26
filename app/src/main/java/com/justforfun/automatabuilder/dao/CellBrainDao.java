package com.justforfun.automatabuilder.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.justforfun.automatabuilder.model.config.Brain;
import com.justforfun.automatabuilder.model.config.CellBrain;
import com.justforfun.automatabuilder.model.config.CellConfig;

import java.util.List;

/**
 * Created by hectormoreno on 11/25/17.
 */

public interface CellBrainDao {

    @Query("SELECT * FROM CellConfig " +
            "JOIN CellBrain ON cell_config_id = id " +
            "WHERE brain_id = :brainId")
    LiveData<List<CellConfig>> getCellsForBrain(int brainId);

    @Query("SELECT * FROM Brain " +
            "JOIN CellBrain ON brain_id = id " +
            "WHERE cell_config_id = :cellConfigId")
    LiveData<List<Brain>> getBrainForCell(int cellConfigId);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertOrUpdate(CellBrain... cellBrains);
}
