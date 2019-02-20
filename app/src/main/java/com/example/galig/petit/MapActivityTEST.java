package com.example.galig.petit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MapActivityTEST extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_test);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().add(R.id.container, new NavFragmentTEST()).commit();
        }
    }
}
