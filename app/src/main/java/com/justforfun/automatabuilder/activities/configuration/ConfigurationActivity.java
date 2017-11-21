package com.justforfun.automatabuilder.activities.configuration;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.justforfun.automatabuilder.MyApplication;
import com.justforfun.automatabuilder.R;
import com.justforfun.automatabuilder.callback.ProgressCallback;
import com.justforfun.automatabuilder.fragment.CellConfigurationFragment;
import com.justforfun.automatabuilder.fragment.GridConfigurationFragment;

public class ConfigurationActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, ProgressCallback {

    public static final String ARGS_PLANET_ID = "ARGS_PLANET_ID";

    DrawerLayout drawer;
    int planetId = 0;

    Menu drawerMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuration);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        drawerMenu = navigationView.getMenu();

        ConfigurationVM configurationVM = ViewModelProviders.of(this).get(ConfigurationVM.class);
        configurationVM.init(MyApplication.getDatabase().planetConfigDao(),
                            MyApplication.getDatabase().cellConfigDao());

        Intent intent = getIntent();
        planetId = intent.getIntExtra(ARGS_PLANET_ID,0);

        step1();
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.configuration, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        Fragment fragment = null;
        if (id == R.id.nav_step_1) {
            step1();
        } else if (id == R.id.nav_step_2) {
            step2();
        } else if (id == R.id.nav_step_3) {
            step3();
        } else if (id == R.id.nav_step_4) {
            step4();
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void step1()
    {
        MenuItem item = drawerMenu.getItem(0);
        item.setChecked(true);
        item.setEnabled(true);

        Bundle bundle = new Bundle();
        bundle.putInt(ARGS_PLANET_ID,planetId);

        GridConfigurationFragment fragment = new GridConfigurationFragment();
        fragment.setProgressCallback(this);
        fragment.setArguments(bundle);
        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
    }

    private void step2()
    {
        MenuItem item = drawerMenu.getItem(1);
        item.setChecked(true);
        item.setEnabled(true);

        Bundle bundle = new Bundle();
        bundle.putInt(ARGS_PLANET_ID,planetId);

        CellConfigurationFragment fragment = new CellConfigurationFragment();
        fragment.setArguments(bundle);
        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
    }

    private void step3()
    {
        MenuItem item = drawerMenu.getItem(2);
        item.setChecked(true);
        item.setEnabled(true);

    }

    private void step4()
    {
        MenuItem item = drawerMenu.getItem(3);
        item.setChecked(true);
        item.setEnabled(true);
    }

    @Override
    public void stepCompleted(int step) {
        switch (step){
            case 1: step2();break;
            case 2: step3();break;
            case 3: step4();break;
            default: break;
        }
    }
}
