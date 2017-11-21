package com.justforfun.automatabuilder.base;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by hectormoreno on 11/19/17.
 */


public class Constants {
    @IntDef({
            FLOATVAL,
            INTVAL,
            SHORTVAL,
            STRINGVAL,
            BOOLVAL,
            LONGVAL,
            DOUBLEVAL
    })
    @Retention(RetentionPolicy.SOURCE)
    public @interface VarType {
    }

    static final int BOOLVAL = 0;
    static final int INTVAL = 1;
    static final int SHORTVAL = 2;
    static final int LONGVAL = 3;
    static final int STRINGVAL = 4;
    static final int FLOATVAL = 5;
    static final int DOUBLEVAL = 6;
}
