package com.justforfun.automatabuilder.task;

import android.os.AsyncTask;

import com.justforfun.automatabuilder.callback.DaoTaskCallback;
import com.justforfun.automatabuilder.model.config.PlanetConfig;
import com.justforfun.automatabuilder.provider.PlanetProvider;

/**
 * Created by hectormoreno on 11/20/17.
 */

public class SavePlanetTask extends AsyncTask<Void,Void,Void> {
    private PlanetProvider planetProvider;
    private PlanetConfig planetConfig;
    private DaoTaskCallback callback;

    public SavePlanetTask(PlanetProvider planetProvider, PlanetConfig planetConfig,DaoTaskCallback callback)
    {
        this.planetProvider = planetProvider;
        this.planetConfig = planetConfig;
        this.callback = callback;
    }

    @Override
    protected Void doInBackground(Void... voids) {

        planetProvider.insertPlanets(planetConfig);

        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);

        callback.onSuccess();
    }
}
