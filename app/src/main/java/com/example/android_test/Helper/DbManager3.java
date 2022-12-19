package com.example.android_test.Helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;

import java.io.ByteArrayOutputStream;

public class DbManager3 extends SQLiteOpenHelper {

    private final static String Db_name = "userd_datas";

    public DbManager3(Context context) {
        super(context, Db_name, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String qry = "create table userd_drecords(id integer primary key autoincrement, gender TEXT)";
        db.execSQL(qry);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String qry = "DROP TABLE IF EXISTS userd_drecords";
        db.execSQL(qry);

    }

    public boolean insertRecord(String gender) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();


        contentValues.put("gender",gender);

        long id = db.insert(" userd_drecords ", null, contentValues);
        if (id == -1) {
            return false;
        } else {
            return true;
        }

    }
    public Cursor getData(){
        SQLiteDatabase db=this.getWritableDatabase();
        String qry=" select * from userd_drecords";
        Cursor cursor=db.rawQuery(qry, null);
        return cursor;
    }

}