package com.justforfun.automatabuilder.model;

/**
 * Created by hectormoreno on 11/19/17.
 */
public class Planet {
    private int id;

    private String name;
    private Grid grid;

    public void setName(String name) {
        this.name = name;
    }

    public void setGrid(Grid grid) {
        this.grid = grid;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Grid getGrid() {
        return grid;
    }

    public int getId() {
        return id;
    }
}
