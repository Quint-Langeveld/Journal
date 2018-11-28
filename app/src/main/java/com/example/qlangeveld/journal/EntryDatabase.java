package com.example.qlangeveld.journal;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class EntryDatabase extends SQLiteOpenHelper {

    private static EntryDatabase instance;


    public static EntryDatabase getInstance(Context context) {
        if (instance == null) {
            instance = new EntryDatabase(context, "entries", null, 1 );
        }
        return instance;
    }

    private EntryDatabase(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String createEntries = "create table entries (_id INTEGER PRIMARY KEY AUTOINCREMENT, title TEXT, content TEXT, mood TEXT, Timestamp DATETIME DEFAULT CURRENT_TIMESTAMP)";
        db.execSQL(createEntries);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + "entries");
        onCreate(db);
    }

    public void selectAll() {
        String select = "SELECT id, example_column FROM entries WHERE name = ? AND example_column = ?";
        Cursor cursor = this.getWritableDatabase().rawQuery(select,  null);
    }
}
