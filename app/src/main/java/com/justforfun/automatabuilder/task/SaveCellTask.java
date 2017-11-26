package com.justforfun.automatabuilder.task;

import android.os.AsyncTask;

import com.justforfun.automatabuilder.callback.DaoTaskCallback;
import com.justforfun.automatabuilder.model.config.CellConfig;
import com.justforfun.automatabuilder.provider.CellProvider;

/**
 * Created by hectormoreno on 11/20/17.
 */

public class SaveCellTask extends AsyncTask<Void,Void,Void> {
    private CellProvider cellProvider;
    private DaoTaskCallback callback;
    private CellConfig cellConfig;

    public SaveCellTask(CellProvider cellProvider,CellConfig cellConfig, DaoTaskCallback callback)
    {
        this.cellProvider = cellProvider;
        this.cellConfig = cellConfig;
        this.callback = callback;
    }

    @Override
    protected Void doInBackground(Void... voids) {
        cellProvider.insertCells(cellConfig);
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        callback.onSuccess();
    }
}
