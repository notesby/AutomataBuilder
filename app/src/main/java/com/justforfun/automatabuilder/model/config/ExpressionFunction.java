package com.justforfun.automatabuilder.model.config;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;

/**
 * Created by hectormoreno on 11/25/17.
 */

@Entity(primaryKeys = {"expression_id","function_id"},
        indices = {@Index("expression_id"),@Index("function_id")},
        foreignKeys = {@ForeignKey(entity = Expression.class,
                                    childColumns = "expression_id",
                                        parentColumns = "id"),
                        @ForeignKey(entity = Function.class,
                                    childColumns = "function_id",
                                    parentColumns = "id")})
public class ExpressionFunction {

    @ColumnInfo(name = "expression_id")
    private int expressionId;
    @ColumnInfo(name = "function_id")
    private int functionId;

    public void setExpressionId(int expressionId) {
        this.expressionId = expressionId;
    }

    public void setFunctionId(int functionId) {
        this.functionId = functionId;
    }

    public int getExpressionId() {
        return expressionId;
    }

    public int getFunctionId() {
        return functionId;
    }
}
