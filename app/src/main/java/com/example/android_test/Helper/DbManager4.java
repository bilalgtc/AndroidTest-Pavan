package com.example.android_test.Helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;

import androidx.annotation.Nullable;

import java.io.ByteArrayOutputStream;

public class DbManager4 extends SQLiteOpenHelper {
    private final static String DB_Name="user_datarec";
    byte[] imageinBytes;

    public DbManager4(Context context) {
        super(context, DB_Name, null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String qry="create table userd_recordd(id integer primary key autoincrement,image BLOB, name TEXT,species TEXT, breed TEXT)";
        db.execSQL(qry);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String qry = "DROP TABLE IF EXISTS userd_recordd";
        db.execSQL(qry);
    }

    public boolean addRecord(Bitmap image,String name, String species, String breed){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();

        ByteArrayOutputStream outputStream=new ByteArrayOutputStream();
        image.compress(Bitmap.CompressFormat.JPEG, 100, outputStream);
        imageinBytes =outputStream.toByteArray();


        contentValues.put("image", imageinBytes);
        contentValues.put("name", name);
        contentValues.put("species",species);
        contentValues.put("breed", breed);

        long id=db.insert(" userd_recordd ", null, contentValues);
        if (id == -1){
            return false;
        }else {
            return true;
        }

    }

    public Cursor getData(){
        SQLiteDatabase db=this.getWritableDatabase();
        String qry=" select * from userd_recordd";
        Cursor cursor=db.rawQuery(qry, null);
        return cursor;
    }

}
