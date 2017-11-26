package com.justforfun.automatabuilder.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.justforfun.automatabuilder.model.config.Expression;

import java.util.List;

/**
 * Created by hectormoreno on 11/25/17.
 */

@Dao
public interface ExpressionDao {
    @Query("SELECT * FROM Expression where brain_id = :braindId")
    LiveData<List<Expression>> getExpressionsForBrain(int brainId);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertOrUpdate(Expression... expressions);
}
