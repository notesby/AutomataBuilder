package com.justforfun.automatabuilder.model;

import android.support.v4.util.LongSparseArray;

import org.mariuszgromada.math.mxparser.Function;
import org.mariuszgromada.math.mxparser.Expression;

import java.util.List;

/**
 * Created by hectormoreno on 11/19/17.
 */

public class Cell {
    LongSparseArray<Function> functions;
    LongSparseArray<Expression> expressions;
    LongSparseArray<String> store;

    Cell()
    {
        functions = new LongSparseArray<>();

    }
}
