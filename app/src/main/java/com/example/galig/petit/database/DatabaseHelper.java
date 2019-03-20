package com.example.galig.petit.database;

import android.arch.persistence.room.Database;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "mydatabase.db";
    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_CREATE = "create table " + DbAdapter.DATABASE_TABLE + "  (_id Integer primary key autoincrement, colorePelo text not null, tipoPelo" +
            " text not null, taglia text not null,statoFisico text , statoMentale text , note text);";
    private static final String DATABASE_CREATE_UTENTE = "create table " + DbAdapterUtente.DATABASE_TABLE + "  (_email String primary key, username text not null, password" +
            " text not null);";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(DATABASE_CREATE);
        database.execSQL(DATABASE_CREATE_UTENTE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
        database.execSQL("DROP TABLE IF EXISTS segnalazioni");
        database.execSQL("DROP TABLE IF EXISTS utenti");
        onCreate(database);
    }
}
