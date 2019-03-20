package com.example.galig.petit.dbroom;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;

import static android.arch.persistence.room.ForeignKey.CASCADE;

@Entity(foreignKeys = {
        @ForeignKey(entity=Razza.class,
        parentColumns = "idRazza",
        childColumns = "razza",
                onDelete = CASCADE,
                onUpdate = CASCADE)
})
public class AnimaleSegnalato {

    @PrimaryKey(autoGenerate = true)
    private Integer idAnimale;
    private String colorePelo;
    private String tipoPelo;
    private String taglia;
    private String statoFisico;
    private String statoMentale;

    @ColumnInfo(name = "razza")
    private Integer razza;
    private Integer posizioni;
}
