package com.example.galig.petit.toolbar;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.galig.petit.R;

public class ToolBarActivity extends AppCompatActivity {


    Toolbar toolbar;
    private AppCompatEditText nomeEditText;
    private TextInputLayout nomeTextInput;
    private AppCompatEditText cognomeEditText;
    private TextInputLayout cognomeTextInput;
    private AppCompatEditText telefonoEditText;
    private TextInputLayout telefonoTextInput;
    private AppCompatEditText indirizzoEditText;
    private TextInputLayout indirizzoTextInput;
    private AppCompatEditText emailEditText;
    private TextInputLayout emailTextInput;
    private AppCompatEditText passwordEditText;
    private TextInputLayout passwordTextInput;
    private AppCompatEditText confpassEditText;
    private TextInputLayout confpassTextInput;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tool_bar);
        nomeEditText= findViewById(R.id.nome);
        nomeTextInput= findViewById(R.id.nome_textInput);
        cognomeEditText= findViewById(R.id.cognome);
        cognomeTextInput= findViewById(R.id.cognome_textInput);
        telefonoEditText= findViewById(R.id.telefono);
        telefonoTextInput= findViewById(R.id.telefono_textInput);
        indirizzoEditText= findViewById(R.id.indirizzo);
        indirizzoTextInput= findViewById(R.id.indirizzo_textInput);
        emailEditText= findViewById(R.id.e_mail);
        emailTextInput= findViewById(R.id.e_mail_textInput);
        passwordEditText= findViewById(R.id.password);
        passwordTextInput= findViewById(R.id.password_textInput);
        confpassEditText= findViewById(R.id.conf_password);
        confpassTextInput= findViewById(R.id.conf_password_textInput);

        nomeEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(nomeEditText.getText().toString().isEmpty()) {
                    nomeTextInput.setErrorEnabled(true);
                    nomeTextInput.setError("Inserisci il tuo nome");
                }

                else {
                    nomeTextInput.setErrorEnabled(false);

                }

            }
        });

        cognomeEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(cognomeEditText.getText().toString().isEmpty()) {
                    cognomeTextInput.setErrorEnabled(true);
                    cognomeTextInput.setError("Inserisci il tuo nome");
                }

                else {
                    cognomeTextInput.setErrorEnabled(false);

                }

            }
        });


        telefonoEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(telefonoEditText.getText().toString().isEmpty()) {
                    telefonoTextInput.setErrorEnabled(true);
                    telefonoTextInput.setError("Inserisci il tuo nome");
                }

                else {
                    telefonoTextInput.setErrorEnabled(false);

                }

            }
        });


        indirizzoEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(indirizzoEditText.getText().toString().isEmpty()) {
                    indirizzoTextInput.setErrorEnabled(true);
                    indirizzoTextInput.setError("Inserisci il tuo nome");
                }

                else {
                    indirizzoTextInput.setErrorEnabled(false);

                }

            }
        });


        emailEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(emailEditText.getText().toString().isEmpty()) {
                    emailTextInput.setErrorEnabled(true);
                    emailTextInput.setError("Inserisci il tuo nome");
                }

                else {
                    emailTextInput.setErrorEnabled(false);

                }

            }
        });


        passwordEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(passwordEditText.getText().toString().isEmpty()) {
                    passwordTextInput.setErrorEnabled(true);
                    passwordTextInput.setError("Inserisci il tuo nome");
                }

                else {
                    passwordTextInput.setErrorEnabled(false);

                }

            }
        });


        confpassEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(confpassEditText.getText().toString().isEmpty()) {
                    confpassTextInput.setErrorEnabled(true);
                    confpassTextInput.setError("Inserisci il tuo nome");
                }

                else {
                    confpassTextInput.setErrorEnabled(false);

                }

            }
        });

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

