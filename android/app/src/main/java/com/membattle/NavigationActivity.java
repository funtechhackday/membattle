package com.membattle;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

public class NavigationActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private SharedPreferences mSettings;
    public static final String APP_PREFERENCES = "mysettings";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        mSettings = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
        //При запуске открываем Профиль
        Fragment fragment = null;
        Class fragmentClass = null;
        fragmentClass = Profile.class;
        try{
            fragment = (Fragment) fragmentClass.newInstance();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.container, fragment).commit();
        //

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        //View headerLayout = navigationView.getHeaderView(R.layout.nav_header_navigation);
        navigationView.removeHeaderView(navigationView.getHeaderView(0));
        View headerLayout = navigationView.inflateHeaderView(R.layout.nav_header_navigation);
        TextView title = (TextView) headerLayout.findViewById(R.id.titlehead);
        TextView Coins = (TextView) headerLayout.findViewById(R.id.coins);
        String login = mSettings.getString("login", "username");
        int coins = mSettings.getInt("coins", 0);
        String intcoins = coins+"";
        Coins.setText(intcoins);
        title.setText(login);
        Intent intent = getIntent();
        Log.i("code", intent.getIntExtra("coins", 1)+"");
        if(intent.getStringExtra("login")!=null){
            String username = intent.getStringExtra("login");
            int coins2 = intent.getIntExtra("coins", 1);
            String string = coins2+"";
            Coins.setText(string);
            title.setText(username);
            SharedPreferences.Editor editor = mSettings.edit();
            editor.putString("login", username);
            editor.putInt("coins", coins2);
            editor.apply();
        }
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
        getMenuInflater().inflate(R.menu.navigation, menu);
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
        Fragment fragment = null;
        Class fragmentClass = null;
        if (id == R.id.play) {
            fragmentClass = Play.class;
            try{
                fragment = (Fragment) fragmentClass.newInstance();
            }
            catch (Exception e){
                e.printStackTrace();
            }
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.container, fragment).commit();
            // Handle the camera action
        } else if (id == R.id.profile) {
            fragmentClass = Profile.class;
            try{
                fragment = (Fragment) fragmentClass.newInstance();
            }
            catch (Exception e){
                e.printStackTrace();
            }
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.container, fragment).commit();
        }  else if (id == R.id.history) {

        } else if (id == R.id.share) {
            Intent i = new Intent(Intent.ACTION_SEND);
            i.setType("text/plain");
            i.putExtra(Intent.EXTRA_TEXT, getNoteReport());
            i.putExtra(Intent.EXTRA_SUBJECT, "Поделиться");
            i = Intent.createChooser(i, "С помощью");
            startActivity(i);
        } else if (id == R.id.settings) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    private String getNoteReport() {
        String report = "Присоединяйтесь к memfun!";
        return report;
    }
}
