package com.example.galig.petit.PetItTESTS.v1.FeedAndMap;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.galig.petit.R;

import java.util.List;

public class CustomAdapter extends ArrayAdapter<ElementoLista> {


    public CustomAdapter(Context context, int textViewResourceId,
                         List<ElementoLista> objects) {
        super(context, textViewResourceId, objects);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.petit_feed_item, null);
        TextView nomeSegnalazione = convertView.findViewById(R.id.nome_segnalazione);
        TextView razzaSegnalazione = convertView.findViewById(R.id.razza_segnalazione);
        TextView posizioneSegnalazione = convertView.findViewById(R.id.posizione_segnalazione);

        ElementoLista c = getItem(position);
        nomeSegnalazione.setText(c.getNomeSegnalazione());
        razzaSegnalazione.setText(c.getRazzaSegnalazione());
        posizioneSegnalazione.setText(c.getPosizioneSegnalazione());

        return convertView;
    }
}
