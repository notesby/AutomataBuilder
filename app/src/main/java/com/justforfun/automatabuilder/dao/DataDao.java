package com.justforfun.automatabuilder.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.justforfun.automatabuilder.model.config.Data;

import java.util.List;

/**
 * Created by hectormoreno on 11/20/17.
 */

@Dao
public interface DataDao {
    @Query("SELECT * FROM Data WHERE brain_id = :brainId")
    LiveData<List<Data>> getData(int brainId);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertOrUpdate(Data... data);
}
