package com.example.galig.petit.PetItTESTS.v1.login;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.galig.petit.HomePage;
import com.example.galig.petit.MainActivity;
import com.example.galig.petit.Profilo;
import com.example.galig.petit.R;

public class RegistrazioneActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText username;
    private EditText email;
    private EditText password;
    private Button registratiButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrazione);

        username = (EditText) findViewById(R.id.username);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        registratiButton = (Button) findViewById(R.id.button_registrati);

        registratiButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_registrati:
                SharedPreferences preferences = getSharedPreferences("MYPREFS", Context.MODE_PRIVATE);
                String nuovoUtente = username.getText().toString();
                String nuovaEmail = email.getText().toString();
                String nuovaPassword = password.getText().toString();

                SharedPreferences.Editor editor = preferences.edit();

                editor.putString(nuovoUtente + nuovaPassword + "data", nuovoUtente + "\n" + nuovaEmail);
                editor.commit();

                Intent schermataLogin = new Intent(RegistrazioneActivity.this, MainActivity.class);
                startActivity(schermataLogin);
                break;

        }

    }
}
