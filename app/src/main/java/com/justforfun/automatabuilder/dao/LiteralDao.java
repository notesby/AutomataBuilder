package com.justforfun.automatabuilder.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.justforfun.automatabuilder.model.config.Literal;

import java.util.List;

/**
 * Created by hectormoreno on 11/25/17.
 */

@Dao
public interface LiteralDao {
    @Query("SELECT * FROM Literal where function_id = :functionId")
    LiveData<List<Literal>> getLiteralsForFunction(int functionId);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertOrUpdate(Literal... literals);
}
