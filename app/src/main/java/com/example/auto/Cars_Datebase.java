package com.example.auto;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class Cars_Datebase extends SQLiteOpenHelper {
    public Cars_Datebase(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE CARS1 (_id INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,IMAGE_RESOURCE INTEGER, INFO TEXT);");
        insert_cars(db, "Audi", R.drawable.audi, "Creator - Germany, Color - Red, Max Speed - 310 km/h");
        insert_cars(db, "Audi", R.drawable.audi, "Creator - Germany, Color - Red, Max Speed - 310 km/h");
        insert_cars(db, "Audi", R.drawable.audi, "Creator - Germany, Color - Red, Max Speed - 310 km/h");
        insert_cars(db, "Audi", R.drawable.audi, "Creator - Germany, Color - Red, Max Speed - 310 km/h");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        upgradeDateBase(db, oldVersion, newVersion);
    }

    private static void insert_cars(SQLiteDatabase sqLiteDatabase, String name, int image, String text) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("NAME", name);
        contentValues.put("IMAGE_RESOURCE", image);
        contentValues.put("INFO", text);
        sqLiteDatabase.insert("CARS1", null, contentValues);
        long l = sqLiteDatabase.insert("CARS1", null, contentValues);

        Log.i("TAG", "insert rabotaet " + l);
    }

    public void upgradeDateBase(SQLiteDatabase db, int oldVersion, int newVersion) {
        ContentValues car = new ContentValues();
        car.put("FAVOURITE", 0);

        db.update("CARS1", car, null, null);

    }
}
