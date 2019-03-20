package com.example.galig.petit.dbroom;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

import static android.arch.persistence.room.ForeignKey.CASCADE;

@Entity(foreignKeys = {
        @ForeignKey(entity = Specie.class,
        parentColumns = "idSpecie",
        childColumns = "specie",
        onDelete = CASCADE,
        onUpdate = CASCADE)
})
public class Razza {

    @PrimaryKey(autoGenerate = true)
    private Integer idRazza;
    private String nomeRazza;

    @ColumnInfo(name = "specie")
    private Integer specie;

    public Integer getIdRazza() {
        return idRazza;
    }

    public void setIdRazza(Integer idRazza) {
        this.idRazza = idRazza;
    }

    public String getNomeRazza() {
        return nomeRazza;
    }

    public void setNomeRazza(String nomeRazza) {
        this.nomeRazza = nomeRazza;
    }

    public Integer getSpecie() {
        return specie;
    }

    public void setSpecie(Integer specie) {
        this.specie = specie;
    }
}
