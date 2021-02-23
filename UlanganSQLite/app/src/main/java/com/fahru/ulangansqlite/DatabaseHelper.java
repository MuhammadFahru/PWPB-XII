package com.fahru.ulangansqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper{

    // Table Name
    public static final String TABLE_NAME = "NOTES";

    // Table Columns
    public static final String _ID = "_id";
    public static final String SUBJECT = "subject";
    public static final String DESC = "description";
    public static final String DATETIME = "datetime";

    // Database Information
    static final  String DB_NAME = "PWPB.DB";

    // Database Version
    static final int DB_VERSION = 1;

    // Creating Table Query
    private static final String CREATE_TABLE = "create table " +
            TABLE_NAME + "(" + _ID
            + " INTEGER PRIMARY KEY AUTOINCREMENT, " + SUBJECT +
            " TEXT NOT NULL, " + DESC + " TEXT, " + DATETIME + "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ); ";

    // Constructor
    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        // Executing the Query
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
