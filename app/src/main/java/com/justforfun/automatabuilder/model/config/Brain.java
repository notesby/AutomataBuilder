package com.justforfun.automatabuilder.model.config;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

import java.util.List;

/**
 * Created by hectormoreno on 11/19/17.
 */

@Entity(indices = @Index("id"),
        foreignKeys = @ForeignKey(entity = CellConfig.class,
                                    parentColumns = "id",
                                    childColumns = "cell_config_id"))
public class Brain {

    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "cell_config_id")
    private int cellConfigId;

    private String behavior;

    public void setId(int id) {
        this.id = id;
    }

    public void setCellConfigId(int cellConfigId) {
        this.cellConfigId = cellConfigId;
    }

    public void setBehavior(String behavior) {
        this.behavior = behavior;
    }

    public String getBehavior() {
        return behavior;
    }

    public int getId() {
        return id;
    }

    public int getCellConfigId() {
        return cellConfigId;
    }
}
