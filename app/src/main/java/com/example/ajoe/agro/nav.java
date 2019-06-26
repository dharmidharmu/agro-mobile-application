package com.example.ajoe.agro;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.ajoe.agro.activities.MainActivity;

import prefs.UserSession;
import prefs.UserInfo;


public class nav extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawer;
    public UserSession session;
    public UserInfo info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawer=findViewById(R.id.drawer_layout);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);





         ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        if(savedInstanceState==null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new phfragment()).commit();
            navigationView.setCheckedItem(R.id.nav_agriculturenews);
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
        getMenuInflater().inflate(R.menu.nav, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull  MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {

            startActivity(new Intent(this,AgromainActivity.class));
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        switch (item.getItemId())
        {

            case R.id.nav_farmlandmanagement:
            // Handle the camera action
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new phfragment()).commit();
            break;
            case R.id.nav_agriculturenews:
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new moisturefragment()).commit();
            break;
            case R.id.nav_weather:
            Intent intent=new  Intent (this,MainActivity.class);
            startActivity(intent);
            break;
            case R.id.nav_commodity:
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new commodityfragment()).commit();
            break;
            case R.id.nav_crops:
                startActivity(new Intent(this,cropsfragment.class));
            break;
            case R.id.nav_chat:
                startActivity(new Intent(this,cropsfragment.class));
                break;
            case R.id.nav_share:
            Intent i=new Intent(android.content.Intent.ACTION_SEND);
            i.setType("text/plain");
            i.putExtra(
                    android.content.Intent.EXTRA_TEXT,"Share your app");
            startActivity(Intent.createChooser(
                    i,
                    "Share Via"
            ));
            break;
            case R.id.nav_rate:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new ratefragment()).commit();
                break;
            case R.id.nav_logout:
                session.setlogout();
                info.clearUserInfo();
                startActivity(new Intent(this,AgromainActivity.class));
                finish();
                break;

        }


        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
