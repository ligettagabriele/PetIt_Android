package com.example.galig.petit.PetItTESTS.v1.FeedAndMap;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.galig.petit.PetItTESTS.v1.FeedAndMap.ListView.CustomAdapter;
import com.example.galig.petit.PetItTESTS.v1.FeedAndMap.ListView.ElementoFeedAperto;
import com.example.galig.petit.PetItTESTS.v1.FeedAndMap.ListView.ElementoLista;
import com.example.galig.petit.R;
import com.example.galig.petit.database.DatabaseHelper;
import com.example.galig.petit.database.DbAdapter;

import java.util.LinkedList;
import java.util.List;

import static android.content.ContentValues.TAG;
import static android.os.Build.ID;

public class FeedFragment extends Fragment {

    private DbAdapter dbHelper;
    private Cursor cursor;
    private ListView listView;
    private CustomAdapter customAdapter;

    private long id;


    private static List<ElementoLista> list = new LinkedList<ElementoLista>();

    /*
            static {
                list.add(new ElementoLista("Cagnolino Disperso", "Pincher", "via abc 23"));
                list.add(new ElementoLista("Gatto trovato", "Persiano", "corso lodi 12"));
                list.add(new ElementoLista("Ho visto un cane", "Bassotto", "corso sempione 132"));
                list.add(new ElementoLista("Perso il mio gatto", "incrocio", "via moscova 23"));
            }

        */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.petit_fragment_feed, container, false);
        listView = rootView.findViewById(R.id.feed_list);

        // List<ElementoLista> list = new LinkedList<>();


        // deve prendere l'id che gli passa la classe SegnalazioneFragment
        // deve estrarre la riga che è nel DB relativa a quell'id
        // deve popolare i campi dei text view con la riga
        dbHelper = new DbAdapter(getContext());
        dbHelper.open();
        cursor = dbHelper.fetchAllSegnalazioni();

        cursor.moveToFirst();

        while (!cursor.isClosed()) {
            String nome = cursor.getString(cursor.getColumnIndex(DbAdapter.KEY_TAGLIA));
            String razza = cursor.getString(cursor.getColumnIndex(DbAdapter.KEY_TAGLIA));
            String posizione = cursor.getString(cursor.getColumnIndex(DbAdapter.KEY_TAGLIA));
            ElementoLista elementoLista = new ElementoLista(nome, razza, posizione);
            list.add(elementoLista);
        }

        cursor.close();
        dbHelper.close();

        customAdapter = new CustomAdapter(getActivity(), R.layout.petit_feed_item, list);
        listView.setAdapter(customAdapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), ElementoFeedAperto.class);
                intent.putExtra("RowID", position);
                startActivity(intent);

            }
        });

        /*

        dbHelper = new DbAdapter(getContext());
        dbHelper.open();
        cursor = dbHelper.fetchAllSegnalazioni();

        cursor.moveToFirst();

        while (cursor.moveToNext()) {
            Integer segnalazioneID = cursor.getInt(cursor.getColumnIndex((DbAdapter.KEY_ID)));
            String taglia = cursor.getString(cursor.getColumnIndex(DbAdapter.KEY_TAGLIA));
            Toast.makeText(getActivity(), taglia, Toast.LENGTH_SHORT).show();
            Log.d(TAG, "contact id = " + segnalazioneID);
        }

        cursor.close();
        dbHelper.close();

        */

        return rootView;
    }
/*
    @Override
    public void onStart() {
        super.onStart();
        Bundle args = getArguments();
        if (args != null) {
            id = args.getLong("Id");
        }
    } */

    public static List<ElementoLista> getList() {
        return list;
    }


  /*  private List<ElementoLista> getResults() {


        dbHelper = new DbAdapter(getContext());
        dbHelper.open();

        List<ElementoLista> resultList = new LinkedList<>();


        Cursor c = dbHelper.fetchAllSegnalazioni(); //function to retrieve all values from a table- written in MyDb.java file
        while (c.moveToNext()) {
            String date = c.getString(c.getColumnIndex("taglia"));

            try {
                ElementoLista elementoLista = new ElementoLista();
                elementoLista.setNomeSegnalazione(date);// setDate function is written in Class file
                resultList.add(elementoLista);
            } catch (Exception e) {
                Log.e(TAG, "Error " + e.toString());
            }

        }

        c.close();

        dbHelper.close();
        return resultList;
    } */
}
