package com.example.galig.petit.dbroom;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Indirizzo {

    @PrimaryKey(autoGenerate = true)
    private Integer id;
    private String via;
    private String civico;
    private String interno;
    private String città;
    private String provincia;
    private Integer cap;
}
