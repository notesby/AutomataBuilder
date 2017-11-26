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
public class Expression {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "brain_id")
    private int brainId;
    private String value;
    private int order;

    public void setId(int id) {
        this.id = id;
    }

    public void setBrainId(int brainId) {
        this.brainId = brainId;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public int getId() {
        return id;
    }

    public int getBrainId() {
        return brainId;
    }

    public String getValue() {
        return value;
    }

    public int getOrder() {
        return order;
    }
}
