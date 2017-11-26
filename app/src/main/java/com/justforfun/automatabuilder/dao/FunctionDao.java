package com.justforfun.automatabuilder.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.justforfun.automatabuilder.model.config.Function;

import java.util.List;

/**
 * Created by hectormoreno on 11/25/17.
 */

@Dao
public interface FunctionDao {
    @Query("SELECT * FROM Function where brain_id = :braindId")
    LiveData<List<Function>> getFunctionsForBrain(int brainId);

    @Insert(onConflict = OnConflictStrategy.FAIL)
    void insertOrUpdate(Function... functions);
}
