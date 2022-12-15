package com.example.android_test.Helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;

import androidx.annotation.Nullable;

import java.io.ByteArrayOutputStream;

public class DataB_Helper extends SQLiteOpenHelper {
    byte[] imageinBytes;
    private final static String DB_name="datab_data";

    public DataB_Helper(Context context) {
        super(context, DB_name,null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String qry="create table datab_records(id integer primary key autoincrement, name TEXT,species TEXT, breed TEXT, image BLOB NOT NULL )";
        db.execSQL(qry);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String qry = "DROP TABLE IF EXISTS datab_records";
        db.execSQL(qry);
    }
//, Bitmap image
    public boolean addRecord(String name, String species, String breed, Bitmap image){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();

        ByteArrayOutputStream outputStream=new ByteArrayOutputStream();
        image.compress(Bitmap.CompressFormat.PNG, 0, outputStream);
        imageinBytes =outputStream.toByteArray();


        contentValues.put("name", name);
        contentValues.put("species",species);
        contentValues.put("breed", breed);
        contentValues.put("image", imageinBytes);

        long id=db.insert(" datab_records ", null, contentValues);
        if (id == -1){
            return false;
        }else {
            return true;
        }

    }
    public Cursor getData(){
        SQLiteDatabase db=this.getWritableDatabase();
        String qry=" select * from datab_records";
        Cursor cursor=db.rawQuery(qry, null);
        return cursor;
    }
}
