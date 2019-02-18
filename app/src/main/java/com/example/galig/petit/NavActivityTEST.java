package com.example.galig.petit;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.Toast;

public class NavActivityTEST extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav);

        BottomNavigationView bottomNavigationView = (BottomNavigationView)findViewById(R.id.bottom_navigation);
    bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            switch (menuItem.getItemId())
            {
                case R.id.action_add:
                    Toast.makeText(NavActivityTEST.this, "Add", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.action_mappa:
                    Toast.makeText(NavActivityTEST.this, "Mappa", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.action_menu:
                    Toast.makeText(NavActivityTEST.this, "Menu", Toast.LENGTH_SHORT).show();
                    break;
            }
            return true;
        }
    });

    }
}
