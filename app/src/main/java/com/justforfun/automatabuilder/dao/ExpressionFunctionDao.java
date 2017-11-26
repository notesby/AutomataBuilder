package com.justforfun.automatabuilder.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.justforfun.automatabuilder.model.config.Expression;
import com.justforfun.automatabuilder.model.config.ExpressionFunction;
import com.justforfun.automatabuilder.model.config.Function;

import java.util.List;

/**
 * Created by hectormoreno on 11/25/17.
 */

public interface ExpressionFunctionDao {
    @Query("SELECT * FROM Function " +
            "JOIN ExpressionFunction ON function_id = id " +
            "WHERE expression_id = :expressionId")
    LiveData<List<Function>> getFunctionsForExpression(int expressionId);

    @Query("SELECT * FROM Expression " +
            "JOIN ExpressionFunction ON expression_id = id " +
            "WHERE function_id = :functionId")
    LiveData<List<Expression>> getExpressionsForFunction(int functionId);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertOrUpdate(ExpressionFunction... expressionFunctions);
}
