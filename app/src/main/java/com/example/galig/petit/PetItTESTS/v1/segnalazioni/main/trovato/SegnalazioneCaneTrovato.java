package com.example.galig.petit.PetItTESTS.v1.segnalazioni.main.trovato;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.galig.petit.R;
import com.example.galig.petit.PetItTESTS.v1.segnalazioni.main.SegnalazioneFragment;

public class SegnalazioneCaneTrovato extends Fragment implements View.OnClickListener {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View myView = inflater.inflate(R.layout.petit_segnalazione_cane, container, false);

        Button razza1 = (Button) myView.findViewById(R.id.razza1);

        razza1.setOnClickListener(this);

        return myView;

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.razza1:
                getFragmentManager().beginTransaction().replace(R.id.fragment_container, new SegnalazioneFragment()).commit();
                //aggiungere logica per mandare scelta al DB
                break;
            case R.id.razza2:
                getFragmentManager().beginTransaction().replace(R.id.fragment_container, new SegnalazioneFragment()).commit();
                //aggiungere logica per mandare scelta al DB
                break;
            case R.id.razza3:
                getFragmentManager().beginTransaction().replace(R.id.fragment_container, new SegnalazioneFragment()).commit();
                //aggiungere logica per mandare scelta al DB
                break;
            case R.id.razza4:
                getFragmentManager().beginTransaction().replace(R.id.fragment_container, new SegnalazioneFragment()).commit();
                //aggiungere logica per mandare scelta al DB
                break;
            case R.id.razza5:
                getFragmentManager().beginTransaction().replace(R.id.fragment_container, new SegnalazioneFragment()).commit();
                //aggiungere logica per mandare scelta al DB
                break;
            case R.id.razza6:
                getFragmentManager().beginTransaction().replace(R.id.fragment_container, new SegnalazioneFragment()).commit();
                //aggiungere logica per mandare scelta al DB
                break;
            default:
                break;
        }

    }


}
