package com.info.avengersuygulamas;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Veritabani extends SQLiteOpenHelper {

    public Veritabani(@Nullable Context context) {
        super(context, "avengersquiz.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
db.execSQL("CREATE TABLE IF NOT EXISTS avengers(\n" +
        "\tavengers_id\tINTEGER PRIMARY KEY AUTOINCREMENT,\n" +
        "\tavengers_ad\tTEXT,\n" +
        "\tavengers_resim\tTEXT,\n" +
        "n" +
        ");");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
db.execSQL("DROP TABLE IF EXISTS avengers");
onCreate(db);
    }
}
