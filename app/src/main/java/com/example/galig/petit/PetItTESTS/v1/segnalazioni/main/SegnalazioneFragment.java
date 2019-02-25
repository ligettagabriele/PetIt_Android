package com.example.galig.petit.PetItTESTS.v1.segnalazioni.main;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.galig.petit.R;

public class SegnalazioneFragment extends Fragment implements View.OnClickListener {

    EditText posizione;
    EditText colorePelo;
    EditText tipoPelo;
    Spinner taglia;
    EditText statoFisico;
    EditText statoMentale;
    EditText noteAggiuntive;
    Button immettiSegnalazione;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View myView = inflater.inflate(R.layout.form_segnalazione, container, false);

        posizione = (EditText) myView.findViewById(R.id.posizione);
        colorePelo = (EditText) myView.findViewById(R.id.colorePelo);
        tipoPelo = (EditText) myView.findViewById(R.id.tipoPelo);
        taglia = (Spinner) myView.findViewById(R.id.taglia);
        statoFisico = (EditText) myView.findViewById(R.id.statoFisico);
        statoMentale = (EditText) myView.findViewById(R.id.statoMentale);
        noteAggiuntive = (EditText) myView.findViewById(R.id.infoExtra);

        immettiSegnalazione = (Button) myView.findViewById(R.id.immettiSegnalazione);

        immettiSegnalazione.setOnClickListener(this);


        return myView;

    }

    @Override
    public void onClick(View v) {

        String posizioneInserita = posizione.getText().toString();
        String colorePeloInserito = colorePelo.getText().toString();
        String tipoPeloInserito = tipoPelo.getText().toString();
        String statoFisicoInserito = statoFisico.getText().toString();
        String statoMentaleInserito = statoMentale.getText().toString();
        String noteAggiuntiveInserite = noteAggiuntive.getText().toString();
        String tagliaScelta = taglia.getSelectedItem().toString();

        //queste variabili memorizzano tutti i dati inseriti dall'utente
        //bisogna implementare la logica che le spedisca al DB

        switch (v.getId()) {
            case R.id.immettiSegnalazione:
                //implementare logica DB
                getFragmentManager().beginTransaction().replace(R.id.fragment_container, new MessaggioFineSegnalazione()).commit();

                break;
            default:
                break;
        }


        //logica per spedire i dati al db
    }
}
