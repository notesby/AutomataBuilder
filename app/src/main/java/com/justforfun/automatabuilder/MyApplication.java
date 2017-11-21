package com.justforfun.automatabuilder;

import android.app.Application;
import android.arch.persistence.room.Room;
import android.util.Log;

import com.justforfun.automatabuilder.base.AppDatabase;
import com.justforfun.automatabuilder.functions.StoreFunction;

import org.mariuszgromada.math.mxparser.Expression;
import org.mariuszgromada.math.mxparser.Function;


/**
 * Created by hectormoreno on 11/19/17.
 */

public class MyApplication extends Application {
    private static AppDatabase database;

    @Override
    public void onCreate() {
        super.onCreate();
        if (database == null)
        {
            database = Room.databaseBuilder(getApplicationContext(),AppDatabase.class,"planets").build();
        }


        Function f = new Function("f",new StoreFunction());
        Function g = new Function("g","f(2,x)*2","x");
        Expression e = new Expression("g(g(3,2))",f,g);
        e.calculate();
        Expression e2 = new Expression("f(3,5)",f);
        e2.calculate();

        for(String s:StoreFunction.storeTable.values())
            Log.d("MyApplication",s);


    }

    public static AppDatabase getDatabase() {
        return database;
    }
}
