package com.example.galig.petit.PetItTESTS.v1.FeedAndMap.ListView;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.galig.petit.PetItTESTS.v1.FeedAndMap.FeedFragment;
import com.example.galig.petit.R;

import java.util.List;

public class ElementoFeedAperto extends AppCompatActivity {

    private TextView nome;
    private TextView razza;
    private TextView posizione;
    private TextView pelo;
    private TextView colore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.petit_feed_item_open);

        FeedFragment feedFragment = new FeedFragment();
        List<ElementoLista> list = FeedFragment.getList();

        Integer rowId;
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                rowId = null;
            } else {
                rowId = extras.getInt("RowID");
            }
        } else {
            rowId = (int) savedInstanceState.getSerializable("RowID");
        }

        int id = rowId;
        nome = findViewById(R.id.nome_segnalazione);
        razza = findViewById(R.id.razza_segnalazione);
        posizione = findViewById(R.id.posizione_segnalazione);
        pelo = findViewById(R.id.pelo_segnalazione);
        colore = findViewById(R.id.colore_segnalazione);

        ElementoLista c = list.get(id);

        nome.setText(c.getNomeSegnalazione());
        razza.setText(c.getRazzaSegnalazione());
        posizione.setText(c.getPosizioneSegnalazione());

    }
}
