package com.justforfun.automatabuilder.model;


import com.justforfun.automatabuilder.base.Constants;

/**
 * Created by hectormoreno on 11/19/17.
 */
public class Variable {
    private int id;
    private String name;
    @Constants.VarType
    private int type;

    public Variable() {
    }
}
