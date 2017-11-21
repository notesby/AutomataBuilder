package com.justforfun.automatabuilder.model.config;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by hectormoreno on 11/19/17.
 */

@Entity(indices = @Index("id"),
        foreignKeys = @ForeignKey(entity = PlanetConfig.class,
                                    parentColumns = "id",
                                    childColumns = "planet_id"))
public class CellConfig {

    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "planet_id")
    private int planetId;

    private String name;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPlanetId(int planetId) {
        this.planetId = planetId;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPlanetId() {
        return planetId;
    }
}
