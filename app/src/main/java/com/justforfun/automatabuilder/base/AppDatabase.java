package com.justforfun.automatabuilder.base;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.justforfun.automatabuilder.dao.BrainDao;
import com.justforfun.automatabuilder.dao.CellBrainDao;
import com.justforfun.automatabuilder.dao.CellConfigDao;
import com.justforfun.automatabuilder.dao.DataDao;
import com.justforfun.automatabuilder.dao.ExpressionDao;
import com.justforfun.automatabuilder.dao.ExpressionFunctionDao;
import com.justforfun.automatabuilder.dao.FunctionDao;
import com.justforfun.automatabuilder.dao.LiteralDao;
import com.justforfun.automatabuilder.dao.PlanetConfigDao;
import com.justforfun.automatabuilder.model.config.Brain;
import com.justforfun.automatabuilder.model.config.CellBrain;
import com.justforfun.automatabuilder.model.config.CellConfig;
import com.justforfun.automatabuilder.model.config.Data;
import com.justforfun.automatabuilder.model.config.Expression;
import com.justforfun.automatabuilder.model.config.ExpressionFunction;
import com.justforfun.automatabuilder.model.config.Function;
import com.justforfun.automatabuilder.model.config.Literal;
import com.justforfun.automatabuilder.model.config.PlanetConfig;

/**
 * Created by hectormoreno on 11/19/17.
 */

@Database(entities = {
        PlanetConfig.class,
        CellConfig.class,
        Brain.class,
        Data.class,
        Function.class,
        Literal.class,
        Expression.class,
        ExpressionFunction.class,
        CellBrain.class
        },version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract BrainDao brainDao();
    public abstract CellConfigDao cellConfigDao();
    public abstract DataDao dataDao();
    public abstract PlanetConfigDao planetConfigDao();
    public abstract LiteralDao literalDao();
    public abstract FunctionDao functionDao();
    public abstract ExpressionDao expressionDao();
    public abstract ExpressionFunctionDao expressionFunctionDao();
    public abstract CellBrainDao cellBrainDao();
}
