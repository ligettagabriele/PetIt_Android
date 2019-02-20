package com.example.galig.petit;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Tutorial00 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial00);
    if (savedInstanceState== null){
        getFragmentManager().beginTransaction().add(R.id.cc, new MyFrag()).commit();
    }
    }
}
