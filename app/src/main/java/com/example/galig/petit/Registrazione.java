package com.example.galig.petit;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
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
}
