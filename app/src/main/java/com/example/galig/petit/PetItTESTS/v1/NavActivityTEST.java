package com.example.galig.petit.PetItTESTS.v1;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.galig.petit.PetItTESTS.v1.FeedAndMap.FeedAndMapFragment;
import com.example.galig.petit.PetItTESTS.v1.FeedAndMap.FeedFragment;
import com.example.galig.petit.PetItTESTS.v1.FeedAndMap.ListView.ElementoFeedAperto;
import com.example.galig.petit.PetItTESTS.v1.menu.MenuNavFragment;
import com.example.galig.petit.PetItTESTS.v1.segnalazioni.main.SegnalazioneMain;
import com.example.galig.petit.R;

import static android.provider.Contacts.SettingsColumns.KEY;

public class NavActivityTEST extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.petit_activity_nav);

        Intent intent = getIntent();
        long Id = intent.getLongExtra("Id", 0);

        Bundle bundle = new Bundle();
        bundle.putLong("Id", Id);
        //set Fragmentclass Arguments
        final FeedAndMapFragment fragobj = new FeedAndMapFragment();
        fragobj.setArguments(bundle);
        intent.putExtras(bundle);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new MenuNavFragment()).commit();
        }

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.action_add:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new SegnalazioneMain()).commit();
                        break;
                    case R.id.action_mappa:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragobj).commit();
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
