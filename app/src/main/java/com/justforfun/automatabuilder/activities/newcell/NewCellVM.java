package com.justforfun.automatabuilder.activities.newcell;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.justforfun.automatabuilder.callback.DaoTaskCallback;
import com.justforfun.automatabuilder.dao.CellConfigDao;
import com.justforfun.automatabuilder.model.config.CellConfig;
import com.justforfun.automatabuilder.provider.CellProvider;
import com.justforfun.automatabuilder.task.SaveCellTask;

/**
 * Created by hectormoreno on 11/20/17.
 */

public class NewCellVM extends ViewModel {
    private CellProvider cellProvider;
    private LiveData<CellConfig> cellConfigLiveData;

    public void init(CellConfigDao cellConfigDao){
        this.cellProvider = new CellProvider(cellConfigDao);
    }

    public LiveData<CellConfig> getCell(int id)
    {
        if (cellConfigLiveData == null)
        {
            loadCell(id);
        }
        return cellConfigLiveData;
    }

    private void loadCell(int id)
    {
        this.cellConfigLiveData = cellProvider.findById(id);
    }

    public void saveCell(CellConfig cellConfig, DaoTaskCallback callback){
        SaveCellTask saveCellTask = new SaveCellTask(cellProvider,cellConfig,callback);
        saveCellTask.execute();
    }
}
