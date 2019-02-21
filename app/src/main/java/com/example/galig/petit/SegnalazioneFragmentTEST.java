package com.example.galig.petit;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

public class SegnalazioneFragmentTEST extends Fragment implements View.OnClickListener {


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View myView = inflater.inflate(R.layout.segnalazione_v2, container, false);
        ImageButton gattoButton = (ImageButton) myView.findViewById(R.id.gatto);
        ImageButton caneButton = (ImageButton) myView.findViewById(R.id.cane);

        gattoButton.setOnClickListener(this);
        caneButton.setOnClickListener(this);
        return myView;

    }

    @Override
    public void onClick(View v) {
        final ImageButton gattoButton = (ImageButton) v.findViewById(R.id.gatto);
        final ImageButton caneButton = (ImageButton) v.findViewById(R.id.cane);

        switch (v.getId()) {
            case R.id.cane:
                Toast.makeText(getContext(), "cane", Toast.LENGTH_SHORT).show();
                break;
            case R.id.gatto:
                Toast.makeText(getContext(), "gatto", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }

    }


}
