package com.example.galig.petit;

import android.app.Activity;
import android.os.Bundle;

public class Tutorial00 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial00);
    if (savedInstanceState== null){
        getFragmentManager().beginTransaction().add(R.id.cc, new MyFrag()).commit();
    }
    }
}
