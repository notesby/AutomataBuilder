package com.justforfun.automatabuilder.model.config;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.Relation;

import java.util.List;

/**
 * Created by hectormoreno on 11/19/17.
 */

@Entity(indices = @Index("id"))
public class PlanetConfig {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String name;

    @Embedded
    private GridConfig gridConfig;


    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setGridConfig(GridConfig gridConfig) {
        this.gridConfig = gridConfig;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public GridConfig getGridConfig() {
        return gridConfig;
    }
}
