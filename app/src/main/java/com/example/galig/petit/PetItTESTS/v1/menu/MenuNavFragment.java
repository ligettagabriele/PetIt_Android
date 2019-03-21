package com.example.galig.petit.PetItTESTS.v1.menu;

import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.LinearLayout;

import com.example.galig.petit.R;
import com.example.galig.petit.database.DbAdapter;

public class MenuNavFragment extends Fragment implements View.OnClickListener {

    private DbAdapter dbHelper;
    private Cursor cursor;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View myView = inflater.inflate(R.layout.petit_fragment_menupage, container, false);

        LinearLayout modificaImpostazioni = myView.findViewById(R.id.modifica_impostazioni);

        modificaImpostazioni.setOnClickListener(this);

        LinearLayout modificaProfilo = myView.findViewById(R.id.aggiorna_profilo);

        modificaProfilo.setOnClickListener(this);

        return myView;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.modifica_impostazioni:
                getFragmentManager().beginTransaction().replace(R.id.fragment_container, new ModificaImpostazioniFragment()).commit();
                break;
            case R.id.aggiorna_profilo:
                getFragmentManager().beginTransaction().replace(R.id.fragment_container, new ModificaProfilo()).commit();
                break;
        }
    }
}
