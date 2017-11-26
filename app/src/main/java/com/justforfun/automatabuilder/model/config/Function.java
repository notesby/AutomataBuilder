package com.justforfun.automatabuilder.model.config;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by hectormoreno on 11/25/17.
 */

@Entity(indices = {@Index("id"),
                    @Index(value = {"brain_id","definition"},unique = true)},
        foreignKeys = @ForeignKey(entity = Brain.class,
                                    parentColumns = "id",
                                    childColumns = "brain_id"))
public class Function {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "brain_id")
    private int brainId;
    private String definition;
    private String expression;

    public void setId(int id) {
        this.id = id;
    }

    public void setBrainId(int brainId) {
        this.brainId = brainId;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    public int getId() {
        return id;
    }

    public int getBrainId() {
        return brainId;
    }

    public String getDefinition() {
        return definition;
    }

    public String getExpression() {
        return expression;
    }
}
