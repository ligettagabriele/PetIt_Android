package com.example.galig.petit;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.galig.petit.PetItTESTS.v1.NavActivityTEST;
import com.example.galig.petit.PetItTESTS.v1.login.LoginActivity;
import com.example.galig.petit.tutorial.TutorialActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        startActivity(new Intent(this, TutorialActivity.class));

        finish();
    }
}
