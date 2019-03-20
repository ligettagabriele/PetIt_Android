package com.example.galig.petit.dbroom;

import android.arch.persistence.room.Entity;

import java.util.Date;

@Entity
public class Segnalatore extends UtenteRegistrato{

    private String codiceFiscale;
    private String nome;
    private String cognome;
    private Date dataNascita;



}
