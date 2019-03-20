package com.example.galig.petit.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class DbAdapterUtente {

    @SuppressWarnings("unused")
    private static final String LONG_TAG = DbAdapterUtente.class.getSimpleName();

    private Context context;
    private SQLiteDatabase database;
    private DatabaseHelper dbHelper;

    public static final String DATABASE_TABLE = "utenti";

    public static final String KEY_EMAIL = "email";
    public static final String KEY_USERNAME = "username";
    public static final String KEY_PASSWORD = "password";

    public DbAdapterUtente(Context context) {
        this.context = context;
    }

    public DbAdapterUtente open() throws SQLException {
        dbHelper = new DatabaseHelper(context);
        database = dbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        dbHelper.close();
    }

    private ContentValues createContentValues(String email, String username, String password) {
        ContentValues values = new ContentValues();
        values.put(KEY_EMAIL, email);
        values.put(KEY_USERNAME, username);
        values.put(KEY_PASSWORD, password);

        return values;
    }

    //rimettere private
    public long creaUtente(String email, String username, String password) {
        ContentValues initialValues = createContentValues(email, username, password);
        return database.insertOrThrow(DATABASE_TABLE, null, initialValues);
    }

    public Cursor fetchAllUtenti() {
        return database.query(DATABASE_TABLE, new String[]{KEY_EMAIL, KEY_USERNAME, KEY_PASSWORD}, null, null, null, null, null);
    }

    //update a contact
    public boolean aggiornaUtente( String email, String username, String password) {
        ContentValues updateValues = createContentValues(email, username, password);
        return database.update(DATABASE_TABLE, updateValues, KEY_EMAIL + "=" + email,
                null) > 0;
    }

    public boolean rimuoviUtente(String email) {
        return database.delete(DATABASE_TABLE, KEY_EMAIL + "=" + email, null) > 0;

    }
}
