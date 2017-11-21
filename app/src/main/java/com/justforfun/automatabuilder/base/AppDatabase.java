package com.justforfun.automatabuilder.base;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.justforfun.automatabuilder.dao.BrainDao;
import com.justforfun.automatabuilder.dao.CellConfigDao;
import com.justforfun.automatabuilder.dao.DataDao;
import com.justforfun.automatabuilder.dao.PlanetConfigDao;
import com.justforfun.automatabuilder.model.config.Brain;
import com.justforfun.automatabuilder.model.config.CellConfig;
import com.justforfun.automatabuilder.model.config.Data;
import com.justforfun.automatabuilder.model.config.PlanetConfig;

/**
 * Created by hectormoreno on 11/19/17.
 */

@Database(entities = {
        PlanetConfig.class,
        CellConfig.class,
        Brain.class,
        Data.class
        },version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract BrainDao brainDao();
    public abstract CellConfigDao cellConfigDao();
    public abstract DataDao dataDao();
    public abstract PlanetConfigDao planetConfigDao();
}
