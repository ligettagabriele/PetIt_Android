package com.example.galig.petit;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.galig.petit.R;

public class Registrazione extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        final EditText userName = (EditText) findViewById(R.id.regETUsername);
        final EditText email = (EditText) findViewById(R.id.regETEmail);
        final EditText password= (EditText) findViewById(R.id.regETPassword);
        Button registratiB = (Button) findViewById(R.id.regBRegistrati);

        registratiB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences preferences = getSharedPreferences("MYPREFS", Context.MODE_PRIVATE);
                String nuovoUtente = userName.getText().toString();
                String nuovaEmail = email.getText().toString();
                String nuovaPassword = password.getText().toString();

                SharedPreferences.Editor editor = preferences.edit();

                editor.putString(nuovoUtente + nuovaPassword + "data", nuovoUtente + "\n" + nuovaEmail);
                editor.commit();

                Intent schermataLogin = new Intent(Registrazione.this, MainActivity.class);
                startActivity(schermataLogin);
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

            Intent intent0 = new Intent(Registrazione.this, HomePage.class);
            startActivity(intent0);
        }
        if (itemId == R.id.MENU2) {
            Intent intent1 = new Intent(Registrazione.this, Profilo.class);
            startActivity(intent1);
        }
        if (itemId == R.id.MENU3) {
            Intent intent2 = new Intent(Registrazione.this, MainActivity.class);
            startActivity(intent2);
        }
        if (itemId == R.id.MENU4) {
            Intent intent2 = new Intent(Registrazione.this, Registrazione.class);
            startActivity(intent2);
        }
        if (itemId == R.id.MENU5) {
            Intent intent2 = new Intent(Registrazione.this, MainActivity.class);
            startActivity(intent2);
        }
        return super.onOptionsItemSelected(item);
    }
}
