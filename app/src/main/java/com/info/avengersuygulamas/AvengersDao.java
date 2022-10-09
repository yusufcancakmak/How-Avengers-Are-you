package com.info.avengersuygulamas;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class AvengersDao {
    public ArrayList<Avengers> rastgele5getir(Veritabani vt){
ArrayList<Avengers>avengersArrayList = new ArrayList<>();
        SQLiteDatabase db =vt.getWritableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM avengers ORDER BY RANDOM () LIMIT 10",null);
        while (c.moveToNext()){
            @SuppressLint("Range") Avengers a =new Avengers(c.getInt(c.getColumnIndex("avengers_id"))
                    ,c.getString(c.getColumnIndex("avengers_ad"))
            ,c.getString(c.getColumnIndex("avengers_resim")));
avengersArrayList.add(a);
        }
        return avengersArrayList;
    }
    public ArrayList<Avengers> rastgele3YanlısSecenekGetir(Veritabani vt, int avengers_id){
        ArrayList<Avengers>avengersArrayList = new ArrayList<>();
        SQLiteDatabase db =vt.getWritableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM avengers WHERE avengers_id !="+avengers_id+" ORDER BY RANDOM () LIMIT 3",null);
        while (c.moveToNext()){
             @SuppressLint("Range") Avengers a = new Avengers(c.getInt(c.getColumnIndex("avengers_id")),c.getString(c.getColumnIndex("avengers_ad")),c.getString(c.getColumnIndex("avengers_resim")));
            avengersArrayList.add(a);
        }
        return avengersArrayList;
    }
}
