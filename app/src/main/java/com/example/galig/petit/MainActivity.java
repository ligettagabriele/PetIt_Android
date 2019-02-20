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
import android.widget.TextView;

import com.example.galig.petit.R;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText email = (EditText) findViewById(R.id.email);
        final EditText actETPassword = (EditText) findViewById(R.id.actETPassword);
        Button actBAccedi = (Button) findViewById(R.id.actBAccedi);
        Button actBRegistrati = (Button) findViewById(R.id.actBRegistrati);

        actBAccedi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String utente = email.getText().toString();
                String password = actETPassword.getText().toString();

                SharedPreferences  preferences = getSharedPreferences("MYPREFS", Context.MODE_PRIVATE);
                String datiUtente = preferences.getString(utente + password + "data", "Username o password non valido");
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("display", datiUtente);
                editor.commit();

                Intent schermataDisplay = new Intent(MainActivity.this, SchermataDisplay.class);
                startActivity(schermataDisplay);

            }
        });

        actBRegistrati.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registrazione = new Intent(MainActivity.this, Registrazione.class);
                startActivity(registrazione);
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

            Intent intent0 = new Intent(MainActivity.this, HomePage.class);
            startActivity(intent0);
        }
        if (itemId == R.id.MENU2) {
            Intent intent1 = new Intent(MainActivity.this, Profilo.class);
            startActivity(intent1);
        }
        if (itemId == R.id.MENU3) {
            Intent intent2 = new Intent(MainActivity.this, Registrazione.class);
            startActivity(intent2);
        }
        if (itemId == R.id.MENU4) {
            Intent intent2 = new Intent(MainActivity.this, MainActivity.class);
            startActivity(intent2);
        }
        if (itemId == R.id.MENU5) {
            Intent intent2 = new Intent(MainActivity.this, MainActivity.class);
            startActivity(intent2);
        }
        return super.onOptionsItemSelected(item);
    }


    /*
    private final static String MY_PREFERENCES = "MyPref";
    private final static String TEXT_DATA_KEY = "textData";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        updatePreferencesData();
    }

    public void savePreferencesData(View view) {
        SharedPreferences prefs = getSharedPreferences(MY_PREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();

        EditText outputView = (EditText) findViewById(R.id.actETUsername);
        CharSequence textData = outputView.getText();
        if (textData != null) {
            editor.putString(TEXT_DATA_KEY, textData.toString());
            editor.commit();
        }
        updatePreferencesData();

        EditText outputView2 = (EditText) findViewById(R.id.actETPassword);
        CharSequence textData2 = outputView2.getText();
        if (textData2 != null) {
            editor.putString(TEXT_DATA_KEY, textData2.toString());
            editor.commit();
        }
        updatePreferencesData2();
    }

    private void updatePreferencesData(){
        SharedPreferences prefs = getSharedPreferences(MY_PREFERENCES, Context.MODE_PRIVATE);
        String textData = prefs.getString(TEXT_DATA_KEY, "No Preferences!");
        TextView outputView = (TextView) findViewById(R.id.outputDataEmail);
        outputView.setText(textData);
    }

    private void updatePreferencesData2() {
        SharedPreferences prefs = getSharedPreferences(MY_PREFERENCES, Context.MODE_PRIVATE);
        String textData2 = prefs.getString(TEXT_DATA_KEY, "No Preferences!");
        TextView outputView2 = (TextView) findViewById(R.id.outputDataPassword);
        outputView2.setText(textData2);
    } */

}



