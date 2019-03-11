package com.example.galig.petit.PetItTESTS.v1.login;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatEditText;
import android.util.Patterns;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.galig.petit.HomePage;
import com.example.galig.petit.MainActivity;
import com.example.galig.petit.PetItTESTS.v1.NavActivityTEST;
import com.example.galig.petit.Profilo;
import com.example.galig.petit.R;

import java.util.regex.Pattern;

public class RegistrazioneActivity extends AppCompatActivity implements View.OnClickListener {

    private AppCompatEditText username;
    private TextInputLayout usernameTextInput;
    private AppCompatEditText email;
    private TextInputLayout emailTextInput;
    private AppCompatEditText password;
    private TextInputLayout passwordTextInput;
    private AppCompatEditText confPassword;
    private TextInputLayout confPasswordTextInput;
    private Button registratiButton;
    private static final Pattern PASSWORD_PATTERN= Pattern.compile("^" +
            //"(?=.*[0-9])" +         //at least 1 digit
            //"(?=.*[a-z])" +         //at least 1 lower case letter
            //"(?=.*[A-Z])" +         //at least 1 upper case letter
            "(?=.*[a-zA-Z])" +      //any letter
            //"(?=.*[@#$%^&+=])" +    //at least 1 special character
            "(?=\\S+$)" +           //no white spaces
            ".{4,}" +               //at least 4 characters
            "$");

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrazione);

        username =  findViewById(R.id.username);
        usernameTextInput= findViewById(R.id.username_textInput);
        email =  findViewById(R.id.email);
        emailTextInput= findViewById(R.id.email_textInput);
        password = findViewById(R.id.password);
        passwordTextInput= findViewById(R.id.password_textInput);
        confPassword = findViewById(R.id.conferma_password);
        confPasswordTextInput = findViewById(R.id.confpassword_textInput);
        registratiButton = (Button) findViewById(R.id.button_registrati);

        registratiButton.setOnClickListener(this);

        username.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(username.getText().toString().isEmpty()) {
                    usernameTextInput.setErrorEnabled(true);
                    usernameTextInput.setError("Inserisci il tuo username");
                }

                else {
                    usernameTextInput.setErrorEnabled(false);

                }

            }
        });

        email.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                String emailInput = emailTextInput.getEditText().getText().toString().trim();
                if(email.getText().toString().isEmpty()) {
                    emailTextInput.setErrorEnabled(true);
                    emailTextInput.setError("Inserisci la tua e-mail");
                }
                else if(!Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()){
                    emailTextInput.setErrorEnabled(true);
                    emailTextInput.setError("Inserisci un indirizzo e-mail valido");
                }

                else {
                    emailTextInput.setErrorEnabled(false);

                }

            }
        });




        password.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                String passwordInput = passwordTextInput.getEditText().getText().toString().trim();
                if(password.getText().toString().isEmpty()) {
                    passwordTextInput.setErrorEnabled(true);
                    passwordTextInput.setError("Inserisci la password");
                }

                else if(!PASSWORD_PATTERN.matcher(passwordInput).matches()) {
                    passwordTextInput.setError("Password non sicura");
                }

                else {
                    passwordTextInput.setErrorEnabled(false);

                }

            }
        });


        confPassword.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(confPassword.getText().toString().isEmpty()) {
                    confPasswordTextInput.setErrorEnabled(true);
                    confPasswordTextInput.setError("Conferma la password");
                }

                else if(!confPassword.getText().toString().equals(password)){
                    confPasswordTextInput.setErrorEnabled(true);
                    confPasswordTextInput.setError("Le password non coincidono");
                }

                else {
                    confPasswordTextInput.setErrorEnabled(false);
                }

            }
        });

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

                Intent schermataLogin = new Intent(RegistrazioneActivity.this, NavActivityTEST.class);
                startActivity(schermataLogin);
                break;

        }

    }


}
