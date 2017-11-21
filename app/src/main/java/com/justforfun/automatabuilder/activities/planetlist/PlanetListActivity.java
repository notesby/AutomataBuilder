package com.justforfun.automatabuilder.activities.planetlist;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.justforfun.automatabuilder.BuildConfig;
import com.justforfun.automatabuilder.MyApplication;
import com.justforfun.automatabuilder.R;
import com.justforfun.automatabuilder.activities.configuration.ConfigurationActivity;
import com.justforfun.automatabuilder.activities.newplanet.NewPlanetActivity;
import com.justforfun.automatabuilder.adapter.PlanetAdapter;
import com.justforfun.automatabuilder.callback.OnSelectedItemCallback;
import com.justforfun.automatabuilder.databinding.ActivityMainBinding;
import com.justforfun.automatabuilder.model.config.PlanetConfig;

import java.util.ArrayList;
import java.util.List;

import static com.justforfun.automatabuilder.activities.configuration.ConfigurationActivity.ARGS_PLANET_ID;

public class PlanetListActivity extends AppCompatActivity implements OnSelectedItemCallback<PlanetConfig> {

    static final String TAG = PlanetListActivity.class.getName();

    private PlanetListVM planetListVM;
    ActivityMainBinding binding;
    private PlanetAdapter planetAdapter;
    private List<PlanetConfig> planetConfigs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);

        Toolbar toolbar = binding.toolbar;
        setSupportActionBar(toolbar);

        planetListVM = ViewModelProviders.of(this).get(PlanetListVM.class);
        planetListVM.init(MyApplication.getDatabase().planetConfigDao());

        planetConfigs = new ArrayList<>();

        planetAdapter = new PlanetAdapter(this,planetConfigs );
        planetAdapter.setPlanetAdapterCallback(this);

        binding.content.recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        binding.content.recyclerView.setAdapter(planetAdapter);


        if (BuildConfig.DEBUG) {
            Log.d(TAG, "onCreate: debug");
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        planetListVM.getPlanets().observe(this,planetConfigs -> {
            if (planetConfigs == null)
            {
                return;
            }
            if (BuildConfig.DEBUG) 
            {
                Log.d(TAG, "onStart: planetConfigs.Size = "+planetConfigs.size());
            }
            this.planetConfigs.clear();
            this.planetConfigs.addAll(planetConfigs);
            planetAdapter.notifyDataSetChanged();
        });
    }

    public void newPlanet(View view)
    {
        startNewPlanetActivity();
    }

    private void startNewPlanetActivity()
    {
        Intent intent = new Intent(this, NewPlanetActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onSelectedItem(PlanetConfig planetConfig) {
        Intent intent = new Intent(this, ConfigurationActivity.class);
        intent.putExtra(ARGS_PLANET_ID, planetConfig.getId());
        startActivity(intent);
    }
}
