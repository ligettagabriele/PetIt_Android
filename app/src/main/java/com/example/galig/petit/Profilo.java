package com.example.galig.petit;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class Profilo extends Activity {

    private Button home;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profilo);
        home = findViewById(R.id.home);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = HomePage.getInstanceIntent(Profilo.this, "ciao");
                startActivity(intent);
            }
        });

    }


    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.MENU1) {

            Intent intent0 = new Intent(Profilo.this, HomePage.class);
            startActivity(intent0);
        }
        if (itemId == R.id.MENU2) {
            Intent intent1 = new Intent(Profilo.this, Profilo.class);
            startActivity(intent1);
        }
        if (itemId == R.id.MENU3) {
            Intent intent2 = new Intent(Profilo.this, MainActivity.class);
            startActivity(intent2);
        }
        if (itemId == R.id.MENU4) {
            Intent intent2 = new Intent(Profilo.this, Registrazione.class);
            startActivity(intent2);
        }
        if (itemId == R.id.MENU5) {
            Intent intent2 = new Intent(Profilo.this, MainActivity.class);
            startActivity(intent2);
        }
        return super.onOptionsItemSelected(item);
    }
}
