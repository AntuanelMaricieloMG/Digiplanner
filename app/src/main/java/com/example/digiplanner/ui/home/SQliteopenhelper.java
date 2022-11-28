package com.example.digiplanner.ui.home;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SQliteopenhelper extends SQLiteOpenHelper {

    private final static String CREATE_EVENTS_TABLE = "create table "
            + Estructura.EVENT_TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT,"
            + Estructura.EVENTOS + "TEXT , "
            + Estructura.TIEMPO + "TEXT, "
            + Estructura.DATE + "TEXT, "
            + Estructura.MONTH + "TEXT, "
            + Estructura.YEAR + "TEXT)";
    private static final String DROP_EVENTS_TABLE = "DROP TABLE IF EXISTS " + Estructura.EVENT_TABLE_NAME;

    public SQliteopenhelper(@Nullable Context context) {
        super(context, Estructura.DB_NAME, null, Estructura.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_EVENTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_EVENTS_TABLE);
        onCreate(db);
    }

    public void SaveEvent(String event, String time, String date, String month , String year , SQLiteDatabase database){
        ContentValues contentValue= new ContentValues();
        contentValue.put(Estructura.EVENTOS , event);
        contentValue.put(Estructura.EVENTOS , time);
        contentValue.put(Estructura.EVENTOS , date);
        contentValue.put(Estructura.EVENTOS , month);
        contentValue.put(Estructura.EVENTOS , year);
        database.insert(Estructura.EVENT_TABLE_NAME, null, contentValue);
    }
    public Cursor ReadEvents(String date ,SQLiteDatabase database){
        String [] Projections = {Estructura.EVENTOS, Estructura.TIEMPO , Estructura.DATE , Estructura.MONTH , Estructura.YEAR};
        String selection = Estructura.DATE + "=?";
        String [] SelectionArgs = {date};
        return database.query(Estructura.EVENT_TABLE_NAME, Projections , selection, SelectionArgs,null,null, null);
    }
    public Cursor ReadEventsperMonth(String month , String year, SQLiteDatabase database){
        String [] Projections = {Estructura.EVENTOS, Estructura.TIEMPO , Estructura.DATE , Estructura.MONTH , Estructura.YEAR};
        String selection = Estructura.MONTH + "=? and " + Estructura.YEAR + "=?";
        String [] SelectionArgs = {month,year};
        return database.query(Estructura.EVENT_TABLE_NAME, Projections , selection, SelectionArgs,null,null, null);
    }
}
