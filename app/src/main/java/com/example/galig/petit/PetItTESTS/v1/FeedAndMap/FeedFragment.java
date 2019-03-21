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
        /*---------------------------*/
        dbHelper = new DbAdapter(getContext());
        dbHelper.open();
        cursor = dbHelper.fetchAllSegnalazioni();

        cursor.moveToFirst();
        if (cursor.getCount() > 0) {
            while (!cursor.isClosed()) {
                String nome = cursor.getString(cursor.getColumnIndex(DbAdapter.KEY_NOME));
                String razza = cursor.getString(cursor.getColumnIndex(DbAdapter.KEY_NOME));
                String posizione = cursor.getString(cursor.getColumnIndex(DbAdapter.KEY_POSIZIONE));
                ElementoLista elementoLista = new ElementoLista(nome, razza, posizione);
                list.add(elementoLista);
                cursor.moveToNext();
                if (cursor.isAfterLast()) {
                    break;
                }
            }
            cursor.close();
            dbHelper.close();
        }
        /*---------------------------*/
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


        return rootView;
    }


    public static List<ElementoLista> getList() {
        return list;
    }

}
