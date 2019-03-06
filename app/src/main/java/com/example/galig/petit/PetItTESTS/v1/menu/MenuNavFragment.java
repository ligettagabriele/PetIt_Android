package com.example.galig.petit.PetItTESTS.v1.menu;

import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.galig.petit.R;
import com.example.galig.petit.database.DbAdapter;

import static android.support.constraint.Constraints.TAG;

public class MenuNavFragment extends Fragment implements View.OnClickListener {

    private DbAdapter dbHelper;
    private Cursor cursor;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View myView = inflater.inflate(R.layout.fragment_menupage, container, false);

        LinearLayout modificaImpostazioni = (LinearLayout) myView.findViewById(R.id.modifica_impostazioni);

        modificaImpostazioni.setOnClickListener(this);


        return myView;


    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.modifica_impostazioni:
                //aggiungere logica per mandare scelta al DB

                dbHelper = new DbAdapter(getContext());
                dbHelper.open();
                cursor = dbHelper.fetchAllSegnalazioni();

                cursor.moveToFirst();

                while (cursor.moveToNext()) {
                    Integer segnalazioneID = cursor.getInt(cursor.getColumnIndex((DbAdapter.KEY_ID)));
                    String taglia = cursor.getString(cursor.getColumnIndex(DbAdapter.KEY_TAGLIA));
                    Toast.makeText(getContext(), taglia, Toast.LENGTH_SHORT).show();
                    Log.d(TAG, "contact id = " + segnalazioneID);
                }

                cursor.close();
                dbHelper.close();

        }
    }
}
