package com.justforfun.automatabuilder.model.config;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by hectormoreno on 11/19/17.
 */

@Entity(indices = @Index("id"))
public class Brain {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String name;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
