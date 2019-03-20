package com.example.galig.petit.PetItTESTS.v1.FeedAndMap;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.galig.petit.PetItTESTS.v1.NavActivityTEST;
import com.example.galig.petit.R;
import com.example.galig.petit.database.DbAdapter;

import java.util.LinkedList;
import java.util.List;

import static android.support.constraint.Constraints.TAG;

public class FeedFragment extends Fragment {

    private DbAdapter dbHelper;
    private Cursor cursor;
    private ListView listView;
    private CustomAdapter customAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.petit_fragment_feed, container, false);

        listView = rootView.findViewById(R.id.feed_list);

        List<ElementoLista> list = new LinkedList<ElementoLista>();

        list.add(new ElementoLista("Cagnolino Disperso", "Pincher", "Posizione"));
        list.add(new ElementoLista("Gatto trovato", "Persiano", "Posizione"));
        list.add(new ElementoLista("Ho visto un cane", "Bassotto", "Posizione"));
        list.add(new ElementoLista("Perso il mio gatto", "incrocio", "Posizione"));

        customAdapter = new CustomAdapter(getActivity(), R.layout.petit_feed_item, list);
        listView.setAdapter(customAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), ElementoFeedAperto.class);
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

}
