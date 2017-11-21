package com.justforfun.automatabuilder.activities.newcell;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.justforfun.automatabuilder.MyApplication;
import com.justforfun.automatabuilder.R;
import com.justforfun.automatabuilder.callback.DaoTaskCallback;
import com.justforfun.automatabuilder.databinding.ActivityNewCellBinding;
import com.justforfun.automatabuilder.model.config.CellConfig;

import static com.justforfun.automatabuilder.activities.configuration.ConfigurationActivity.ARGS_PLANET_ID;

public class NewCellActivity extends AppCompatActivity implements DaoTaskCallback {
    public static final String ARGS_CELL_ID = "ARGS_CELL_ID";

    NewCellVM newCellVM;
    ActivityNewCellBinding binding;
    CellConfig cellConfig;
    int planetId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_new_cell);
        newCellVM = ViewModelProviders.of(this).get(NewCellVM.class);
        newCellVM.init(MyApplication.getDatabase().cellConfigDao());

        planetId = getIntent().getIntExtra(ARGS_PLANET_ID,0);
        int cellId = getIntent().getIntExtra(ARGS_CELL_ID,0);

        if (cellId != 0)
        {
            newCellVM.getCell(cellId).observe(this,cellConfig1 -> {
                this.cellConfig = cellConfig1;

                if (this.cellConfig != null)
                {
                    binding.setName(this.cellConfig.getName());
                }
                else
                {
                    binding.setName("");
                }
            });
        }

    }

    public void saveCell(View view)
    {
        if (cellConfig == null)
        {
            cellConfig = new CellConfig();
            cellConfig.setPlanetId(planetId);
        }
        if (binding.textEditName.getText().toString().isEmpty())
        {
            binding.textInputLayoutName.setError("Required");
            binding.textInputLayoutName.setErrorEnabled(true);
            return;
        }

        binding.textInputLayoutName.setErrorEnabled(false);
        cellConfig.setName(binding.textEditName.getText().toString());
        newCellVM.saveCell(cellConfig,this);
    }

    @Override
    public void onSuccess() {
        this.finish();
    }
}
