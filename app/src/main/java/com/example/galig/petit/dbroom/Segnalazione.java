package com.example.galig.petit.dbroom;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Segnalazione {

    @PrimaryKey(autoGenerate = true)
    private Integer id;
    private String note;
    private AnimaleSegnalato animale;
}
