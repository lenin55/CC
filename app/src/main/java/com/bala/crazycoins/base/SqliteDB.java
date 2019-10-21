/*
 * @category crazy coins app
 * @copyright Copyright (C) 2019 . All rights reserved.
 * @license http://www.apache.org/licenses/LICENSE-2.0
 */
package com.bala.crazycoins.base;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;


public class SqliteDB extends SQLiteOpenHelper {

    private String DB_NAME = "VEHICLE";

    private String TABLE_NAME = "VEHICLE_INFO";

    public SqliteDB(@Nullable Context context,
                    @Nullable String name,
                    @Nullable SQLiteDatabase.CursorFactory factory,
                    int version) {
        super(context, name, factory, version);
    }

    public boolean insertVehicle(String emailId, int engineSpeed, int vehicleSpeed,
                                 int fuelEconomy, long time) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("EMAIL_ID", emailId);
        contentValues.put("ENGINE_SPEED", engineSpeed);
        contentValues.put("VEHICLE_SPEED", vehicleSpeed);
        contentValues.put("FUEL_ECONOMY", fuelEconomy);
        contentValues.put("TIMESTAMP", time);
        db.insert(TABLE_NAME, null, contentValues);
        return true;
    }

    public Cursor getData(String id) {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("select * from " + TABLE_NAME + " where " +
                        "EMAIL_ID = ?",
                new String[]{id});
    }

    public void deleteData(String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME,
                "EMAIL_ID = ?", new String[]{id});
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + "(" +
                "EMAIL_ID" + " TEXT NOT NULL," +
                "ENGINE_SPEED" + " INTEGER NOT NULL," +
                "VEHICLE_SPEED" + " INTEGER NOT NULL," +
                "FUEL_ECONOMY" + " INTEGER NOT NULL," +
                "TIMESTAMP" + " DATETIME," +
                "_ID" + " INTEGER PRIMARY KEY AUTOINCREMENT" + ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + DB_NAME);
        onCreate(db);
    }

}



