package com.justforfun.automatabuilder.functions;

import android.support.v4.util.LongSparseArray;

import org.mariuszgromada.math.mxparser.FunctionExtension;


/**
 * Created by hectormoreno on 11/20/17.
 */

public class StoreFunction implements FunctionExtension{

    public LongSparseArray<String> storeTable;

    private double x;
    private double y;
    public StoreFunction() {
        x = Double.NaN;
        y = Double.NaN;
    }

    public void setStoreTable(LongSparseArray<String> storeTable) {
        this.storeTable = storeTable;
    }

    public StoreFunction(double x, double y) {
        this.x = x;
        this.y = y;
    }
    public int getParametersNumber() {
        return 2;
    }
    public void setParameterValue(int argumentIndex, double argumentValue) {
        if (argumentIndex == 0) x = argumentValue;
        if (argumentIndex == 1) y = argumentValue;
    }

    @Override
    public String getParameterName(int i) {
        return null;
    }

    public double calculate() {
        if (storeTable!= null)
        {
            Double index = x;
            storeTable.put(index.longValue(),y+"");
        }
        return y;
    }

    public FunctionExtension clone() {
        return new StoreFunction(x, y);
    }
}
