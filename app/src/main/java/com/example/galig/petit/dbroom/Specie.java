package com.example.galig.petit.dbroom;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Specie {

    @PrimaryKey(autoGenerate = true)
    private Integer idSpecie;
    private String nomeSpecie;

    public Integer getIdSpecie() {
        return idSpecie;
    }

    public void setIdSpecie(Integer idSpecie) {
        this.idSpecie = idSpecie;
    }

    public String getNomeSpecie() {
        return nomeSpecie;
    }

    public void setNomeSpecie(String nomeSpecie) {
        this.nomeSpecie = nomeSpecie;
    }
}
