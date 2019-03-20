package com.example.galig.petit.dbroom;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class PosizioniRilevamentiSegnalazioni {

    @PrimaryKey(autoGenerate = true)
    private Integer idPosizione;
    private String città;

}
