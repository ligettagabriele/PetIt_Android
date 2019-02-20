package com.example.galig.petit;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.Toast;

public class NavActivityTEST extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new MenuNavFragment()).commit();
        }

        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.action_add:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new SegnalazioneFragment()).commit();
                        break;
                    case R.id.action_mappa:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new MapFragment()).commit();
                        break;
                    case R.id.action_menu:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new MenuNavFragment()).commit();
                        break;
                }
                return true;
            }
        });


    }
}
