package com.example.galig.petit.PetItTESTS.v1.segnalazioni.main;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.galig.petit.PetItTESTS.v1.NavActivityTEST;
import com.example.galig.petit.R;
import com.example.galig.petit.database.DbAdapter;

public class SegnalazioneFragment extends Fragment {

    EditText posizione;
    EditText colorePelo;
    Spinner tipoPelo;
    Spinner taglia;
    Spinner statoFisico;
    Spinner statoMentale;
    EditText noteAggiuntive;
    Button immettiSegnalazione;

    private DbAdapter dbHelper;
    private Cursor cursor;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View myView = inflater.inflate(R.layout.petit_form_segnalazione, container, false);

        dbHelper = new DbAdapter(getActivity());
        dbHelper.open();
        cursor = dbHelper.fetchAllSegnalazioni();

        posizione = myView.findViewById(R.id.posizione);
        colorePelo = myView.findViewById(R.id.colorePelo);
        tipoPelo = myView.findViewById(R.id.tipoPelo);
        taglia = myView.findViewById(R.id.taglia);
        statoFisico = myView.findViewById(R.id.statoFisico);
        statoMentale = myView.findViewById(R.id.statoMentale);
        noteAggiuntive = myView.findViewById(R.id.infoExtra);

        immettiSegnalazione = myView.findViewById(R.id.immettiSegnalazione);

        immettiSegnalazione.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //queste variabili memorizzano tutti i dati inseriti dall'utente
                String posizioneInserita = posizione.getText().toString();
                String colorePeloInserito = colorePelo.getText().toString();
                String tipoPeloInserito = tipoPelo.getSelectedItem().toString();
                String statoFisicoInserito = statoFisico.getSelectedItem().toString();
                String statoMentaleInserito = statoMentale.getSelectedItem().toString();
                String noteAggiuntiveInserite = noteAggiuntive.getText().toString();
                String tagliaScelta = taglia.getSelectedItem().toString();
                // getFragmentManager().beginTransaction().replace(R.id.fragment_container, new MessaggioFineSegnalazione()).commit();
                long resId = dbHelper.creaSegnalazione(colorePeloInserito, tipoPeloInserito, tagliaScelta, statoFisicoInserito, statoMentaleInserito, noteAggiuntiveInserite);
                // deve passare la segnalazione alla classe FeedFragment , lo farà passando un id, quello della segnalazione inserita
                // la classe FeedFragment leggerà la riga del Db tramite l'id che gli viene passato
                Intent intent = new Intent(getActivity().getBaseContext(),
                        NavActivityTEST.class);
                intent.putExtra("Id", resId);
                getActivity().startActivity(intent);
                Log.d("SegnalazioneFragment", "ID = " + resId);

            }
        });


        return myView;

    }
}
