package com.example.android_test.Helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;

import androidx.annotation.Nullable;

import java.io.ByteArrayOutputStream;

public class DbManager7 extends SQLiteOpenHelper {

    private static final String DB_Name="userdata_datab";
    public DbManager7(Context context) {
        super(context, DB_Name, null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String qry="create table userrecordd_db(id integer primary key autoincrement,state BOOLEAN)";
        db.execSQL(qry);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String qry = "DROP TABLE IF EXISTS userrecordd_db";
        db.execSQL(qry);
    }



    public boolean addRecord(boolean state){
//        values= new boolean[]{false, false, false, false, false, false};
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();

        contentValues.put("state", state);



        long id=db.insert(" userrecordd_db ", null, contentValues);
        if (id == -1){
            return false;
        }else {
            return true;
        }

    }


    public Cursor getData(){
        SQLiteDatabase db=this.getWritableDatabase();
        String qry=" select * from userrecordd_db";
        Cursor cursor=db.rawQuery(qry, null);
        return cursor;
    }

//    public void addRecord(boolean b, boolean b1, boolean b2, boolean b3, boolean b4, boolean b5) {
//
//        SQLiteDatabase db=this.getWritableDatabase();
//        ContentValues contentValues=new ContentValues();
//
//        contentValues.put("state", b);
//        contentValues.put("state2", b1);
//        contentValues.put("state3", b2);
//        contentValues.put("state4", b3);
//        contentValues.put("state5", b4);
//        contentValues.put("state6", b5);
//
//        db.insert(" userrecord_db ", null, contentValues);
//
//
//    }
}
