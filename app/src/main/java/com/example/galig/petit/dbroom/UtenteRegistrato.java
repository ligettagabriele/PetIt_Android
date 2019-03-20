package com.example.galig.petit.dbroom;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "utenti_registrati", indices = {@Index(value = {"email", "username"}, unique = true)})
public class UtenteRegistrato {

    @ColumnInfo(name = "email")
    @PrimaryKey
    private String email;
    @ColumnInfo(name = "username")
    private String username;
    @ColumnInfo(name = "password")
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String idUtente) {
        this.email = idUtente;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
