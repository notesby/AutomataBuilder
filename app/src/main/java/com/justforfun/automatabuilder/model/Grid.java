package com.justforfun.automatabuilder.model;

import java.util.List;

/**
 * Created by hectormoreno on 11/19/17.
 */

public class Grid {
    private int id;

    private int width;
    private int height;

    private List<List<Cell>> cells;


    public void setId(int id) {
        this.id = id;
    }

    public void setCells(List<List<Cell>> cells) {
        this.cells = cells;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getId() {
        return id;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public List<List<Cell>> getCells() {
        return cells;
    }
}
