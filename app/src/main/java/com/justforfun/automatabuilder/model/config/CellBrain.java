package com.justforfun.automatabuilder.model.config;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;

/**
 * Created by hectormoreno on 11/25/17.
 */

@Entity(primaryKeys = {"cell_config_id","brain_id"},
        indices = {@Index("cell_config_id"),@Index("brain_id")},
        foreignKeys = {@ForeignKey(entity = CellConfig.class,
                childColumns = "cell_config_id",
                parentColumns = "id"),
                @ForeignKey(entity = Brain.class,
                        childColumns = "brain_id",
                        parentColumns = "id")})
public class CellBrain {

    @ColumnInfo(name = "cell_config_id")
    private int cellConfigId;
    @ColumnInfo(name = "brain_id")
    private int brainId;

    public void setBrainId(int brainId) {
        this.brainId = brainId;
    }

    public void setCellConfigId(int cellConfigId) {
        this.cellConfigId = cellConfigId;
    }

    public int getBrainId() {
        return brainId;
    }

    public int getCellConfigId() {
        return cellConfigId;
    }
}
