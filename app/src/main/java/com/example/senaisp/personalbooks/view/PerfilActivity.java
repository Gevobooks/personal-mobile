package com.example.senaisp.personalbooks.view;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.senaisp.personalbooks.R;
import com.example.senaisp.personalbooks.model.viewModel.UserFiles;
import com.example.senaisp.personalbooks.repository.ICallback;
import com.example.senaisp.personalbooks.repository.UserRepository;

public class PerfilActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private PerfilHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

       // helper = new PerfilHelper(this);



            SharedPreferences prefs = getSharedPreferences("preferencias",Context.MODE_PRIVATE);
            String access_token = prefs.getString("access_token","nao tem");



        UserRepository.getUserFiles(access_token, new ICallback<UserFiles>() {
            @Override
          public void Callback(final UserFiles Files, final Exception error)
            {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (error != null)
                        {
                            //tratar o erro
                        }
                        else
                        {

                        }

                    }
                });
            }
        });



        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

      //  helper.preencheFormulario(usuario);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.perfil, menu);
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

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.minha_biblioteca) {

        } else if (id == R.id.biblioteca_nativa) {

        } else if (id == R.id.sair) {
            Intent StartSession = new Intent(getContext(), MainActivity.class);
            startActivity(StartSession);
            setContentView(R.layout.activity_main);
            finish();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if(drawer != null)
            drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private Context getContext(){
        return this;
    }
}