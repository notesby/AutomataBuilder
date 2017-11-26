package com.justforfun.automatabuilder.model.config;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by hectormoreno on 11/25/17.
 */
@Entity(indices = @Index("id"),
        foreignKeys = @ForeignKey(entity = Brain.class,
                parentColumns = "id",
                childColumns = "brain_id"))

public class Literal {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "function_id")
    private int functionId;
    private String value;

    public void setId(int id) {
        this.id = id;
    }

    public void setFunctionId(int functionId) {
        this.functionId = functionId;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public int getFunctionId() {
        return functionId;
    }

    public String getValue() {
        return value;
    }
}
