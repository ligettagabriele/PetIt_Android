package com.example.galig.petit;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;

public class AggiungiSegnalazione extends Activity {

    private String colorePelo;
    private String tipoPelo;
    private String taglia;
    private String statoFisico;
    private String statoMentale;
    private String note;

    private EditText colorePeloET = (EditText) findViewById(R.id.colorePelo);
    private EditText tipoPeloET = (EditText) findViewById(R.id.tipoPelo);
    private EditText tagliaET = (EditText) findViewById(R.id.taglia);
    private EditText statoFisicoET = (EditText) findViewById(R.id.statoFisico);
    private EditText statoMentaleET = (EditText) findViewById(R.id.statoMentale);
    private EditText noteET = (EditText) findViewById(R.id.infoExtra);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aggiungi_segnalazione);

        colorePelo = colorePeloET.getText().toString();
        tipoPelo = tipoPeloET.getText().toString();
        taglia = tagliaET.getText().toString();
        statoFisico = statoFisicoET.getText().toString();
        statoMentale = statoMentaleET.getText().toString();
        note = noteET.getText().toString();
    }
}
