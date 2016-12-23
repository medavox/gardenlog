package com.medavox.gardenlog.datastructs.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * @author Adam Howard on 14/12/2016.
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "GardenLog Database";
    //public static final String CREATE_ENTRIES_SQL = "";
    public static final int DATABASE_VERSION = 1;


    private void createTable(SQLiteDatabase db, DbContracts.TableDef tableDef) {
        String sql = "CREATE TABLE " + tableDef.getTableName() + " ( ";
        sql += tableDef._ID + " INTEGER PRIMARY KEY";
        for(String columnDef : tableDef.getColumDefinitions()) {
            sql += ", "+columnDef;
        }
            sql += " )";
        db.execSQL(sql);
    }

    public DatabaseHelper(Context c) {
        super(c, DATABASE_NAME, null /*:SQLiteDatabase.CursorFactory*/, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        for(DbContracts.DBTable dbt : DbContracts.tables) {
            createTable(db, dbt);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVer, int newVer) {

    }
}
