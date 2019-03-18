package com.example.galig.petit;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

public class NavigationDrawerActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{


    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation_drawer);

        toolbar= findViewById(R.id.toolbar);
        drawerLayout= findViewById(R.id.drawerLayout);
        navigationView= findViewById(R.id.navigationDrawer);
        setSupportActionBar(toolbar);
        //ActionBar actionbar = getSupportActionBar();
        //actionbar.setDisplayHomeAsUpEnabled(true);
        //actionbar.setHomeAsUpIndicator(R.drawable.ic_menu_hamburger);

        navigationView.setNavigationItemSelectedListener(this);

        /* ActionBarDrawerToggle toggle;
        toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_open,
                R.string.navigation_close);
                */
    }
/*
    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        toggle.syncState();
    }*/

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        int id= menuItem.getItemId();

        switch (id)
        {

           /* case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                break;*/

            case R.id.inbox_id:
            Toast.makeText(getApplicationContext(),"Hai premuto inbox",Toast.LENGTH_SHORT).show();
            drawerLayout.closeDrawers();
            break;


            case R.id.delete_id:
            Toast.makeText(getApplicationContext(),"Hai premuto delete",Toast.LENGTH_SHORT).show();
            drawerLayout.closeDrawers();
            break;


            case R.id.send_id:
            Toast.makeText(getApplicationContext(),"Hai premuto send",Toast.LENGTH_SHORT).show();
            drawerLayout.closeDrawers();
            break;


            case R.id.email_archiviate_id:
            Toast.makeText(getApplicationContext(),"Hai premuto archive",Toast.LENGTH_SHORT).show();
            drawerLayout.closeDrawers();
            break;

        }

        return true;
    }
}
