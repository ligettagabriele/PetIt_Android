package com.example.galig.petit.PetItTESTS.v1.segnalazioni.main;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.galig.petit.R;
import com.example.galig.petit.database.DbAdapter;

public class AggiungiSegnalazione extends AppCompatActivity {

    private String nome;
    private String colorePelo;
    private String tipoPelo;
    private String taglia;
    private String statoFisico;
    private String statoMentale;
    private String note;
    private String posizione;


    private DbAdapter dbHelper;
    private Cursor cursor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.petit_form_segnalazione);

        dbHelper = new DbAdapter(this);
        dbHelper.open();
        cursor = dbHelper.fetchAllSegnalazioni();

        final EditText nomeET = findViewById(R.id.nome);
        final EditText colorePeloET = findViewById(R.id.colorePelo);
        final Spinner tipoPeloET = findViewById(R.id.tipoPelo);
        final Spinner tagliaSP = findViewById(R.id.taglia);
        final Spinner statoFisicoET = findViewById(R.id.statoFisico);
        final Spinner statoMentaleET = findViewById(R.id.statoMentale);
        final EditText noteET = findViewById(R.id.infoExtra);
        final EditText posizioneET = findViewById(R.id.posizione);
        Button inviaSegnalazione = findViewById(R.id.immettiSegnalazione);


        inviaSegnalazione.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                nome = nomeET.getText().toString();
                posizione = posizioneET.getText().toString();
                colorePelo = colorePeloET.getText().toString();
                tipoPelo = tipoPeloET.getSelectedItem().toString();
                taglia = tagliaSP.getSelectedItem().toString();
                statoFisico = statoFisicoET.getSelectedItem().toString();
                statoMentale = statoMentaleET.getSelectedItem().toString();
                note = noteET.getText().toString();


                dbHelper.creaSegnalazione(nome, posizione, colorePelo, tipoPelo, taglia, statoFisico, statoMentale, note);


                Toast.makeText(AggiungiSegnalazione.this, taglia, Toast.LENGTH_SHORT).show();
            }
        });


    }
}
