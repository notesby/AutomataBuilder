package com.justforfun.automatabuilder.model.config;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

import com.justforfun.automatabuilder.base.Constants;


/**
 * Created by hectormoreno on 11/19/17.
 */

@Entity(indices = @Index("id"),
        foreignKeys = @ForeignKey(entity = Brain.class,
                                    parentColumns = "id",
                                    childColumns = "brain_id"))
public class Data {
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "brain_id")
    private int brainId;

    private String name;

    @Constants.VarType
    private int type;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setBrainId(int brainId) {
        this.brainId = brainId;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getType() {
        return type;
    }

    public int getBrainId() {
        return brainId;
    }
}
