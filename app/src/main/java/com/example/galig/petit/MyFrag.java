package com.example.galig.petit;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class MyFrag extends Fragment {

    public MyFrag(){
    }

    @Override
    public View onCreateView( LayoutInflater inflater,  ViewGroup container,
                              Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tutorial1_layout,
                container, false);
        return rootView;
    }
}
