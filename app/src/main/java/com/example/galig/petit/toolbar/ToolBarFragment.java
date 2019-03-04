package com.example.galig.petit.toolbar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.galig.petit.R;

public class ToolBarFragment extends AppCompatActivity {

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_tool_bar);

        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main_menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id= item.getItemId();
        switch (id)
        {
            case R.id.setting_item:
                Toast.makeText(getApplicationContext(),"hai cliccato su impostazioni", Toast.LENGTH_LONG).show();
                break;

            case R.id.setting_item2:
                Toast.makeText(getApplicationContext(),"hai cliccato su utente", Toast.LENGTH_LONG).show();
                break;


        }
        return super.onOptionsItemSelected(item);
    }
}
