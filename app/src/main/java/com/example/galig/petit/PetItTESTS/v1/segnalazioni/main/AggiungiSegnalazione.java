package com.example.galig.petit.PetItTESTS.v1.segnalazioni.main;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.galig.petit.R;
import com.example.galig.petit.database.DbAdapter;

public class AggiungiSegnalazione extends Activity {

    private String colorePelo;
    private String tipoPelo;
    private String taglia;
    private String statoFisico;
    private String statoMentale;
    private String note;


    private DbAdapter dbHelper;
    private Cursor cursor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form_segnalazione);

        dbHelper = new DbAdapter(this);
        dbHelper.open();
        cursor = dbHelper.fetchAllSegnalazioni();

        final EditText colorePeloET = (EditText) findViewById(R.id.colorePelo);
        final EditText tipoPeloET = (EditText) findViewById(R.id.tipoPelo);
        final Spinner tagliaSP = (Spinner) findViewById(R.id.taglia);
        final EditText statoFisicoET = (EditText) findViewById(R.id.statoFisico);
        final EditText statoMentaleET = (EditText) findViewById(R.id.statoMentale);
        final EditText noteET = (EditText) findViewById(R.id.infoExtra);
        //  ImageButton posizione = (ImageButton) findViewById(R.id.bottone_posizione);
        Button inviaSegnalazione = (Button) findViewById(R.id.immettiSegnalazione);


        inviaSegnalazione.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                colorePelo = colorePeloET.getText().toString();
                tipoPelo = tipoPeloET.getText().toString();
                taglia = tagliaSP.getSelectedItem().toString();
                statoFisico = statoFisicoET.getText().toString();
                statoMentale = statoMentaleET.getText().toString();
                note = noteET.getText().toString();


                dbHelper.creaSegnalazione(colorePelo, tipoPelo, taglia, statoFisico, statoMentale, note);


                Toast.makeText(AggiungiSegnalazione.this, taglia, Toast.LENGTH_SHORT).show();
            }
        });


    }
}
