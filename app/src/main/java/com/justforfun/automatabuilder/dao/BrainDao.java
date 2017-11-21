package com.justforfun.automatabuilder.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.justforfun.automatabuilder.model.config.Brain;

/**
 * Created by hectormoreno on 11/20/17.
 */

@Dao
public interface BrainDao {
    @Query("SELECT * FROM Brain WHERE cell_config_id = :cellConfigId")
    LiveData<Brain> getBrain(int cellConfigId);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertOrUpdate(Brain... brains);
}
