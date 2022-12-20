package com.example.android_test.Helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;

import androidx.annotation.Nullable;

import java.io.ByteArrayOutputStream;

public class DbManager8 extends SQLiteOpenHelper {
    private static final String NAME_CL="name";
    byte[] imageinBytes;
    public DbManager8(Context context) {
        super(context, "userdata", null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String qry="create table usertb(id integer primary key autoincrement,image BLOB, name TEXT,species TEXT, breed TEXT,size TEXT,gender BOOLEAN,neutered BOOLEAN,vaccinated BOOLEAN,Friendlywithdogs BOOLEAN,Friendlywithcats BOOLEAN,Friendlywithkids10 BOOLEAN,Friendlywithkids10G BOOLEAN)";
        db.execSQL(qry);
    }



    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String qry = "DROP TABLE IF EXISTS usertb";
        db.execSQL(qry);
    }

    public boolean addRecord(ContentValues contentValues){
//        value= new boolean[]{false, false, false, false, false, false};
        SQLiteDatabase db=this.getWritableDatabase();
//     ContentValues contentValues=new ContentValues();

//        ByteArrayOutputStream outputStream=new ByteArrayOutputStream();
//        image.compress(Bitmap.CompressFormat.JPEG, 100, outputStream);
//        imageinBytes =outputStream.toByteArray();


//        contentValues.put("image", imageinBytes);
//        contentValues.put("name", name);
//        contentValues.put("species",species);
//        contentValues.put("breed", breed);
//        contentValues.put("state", value[0]);
//        contentValues.put("state2", value[1]);
//        contentValues.put("state3", value[2]);
//        contentValues.put("state4", value[3]);
//        contentValues.put("state5", value[4]);
//        contentValues.put("state6", value[5]);


        long id=db.insert(" usertb ", null, contentValues);
        if (id == -1){
            return false;
        }else {
            return true;
        }

    }


    public void updateRecord(ContentValues contentValues){
//        value= new boolean[]{false, false, false, false, false, false};
        SQLiteDatabase db=this.getWritableDatabase();
//     ContentValues contentValues=new ContentValues();

//        ByteArrayOutputStream outputStream=new ByteArrayOutputStream();
//        image.compress(Bitmap.CompressFormat.JPEG, 100, outputStream);
//        imageinBytes =outputStream.toByteArray();


//        contentValues.put("image", imageinBytes);
//        contentValues.put("name", name);
//        contentValues.put("species",species);
//        contentValues.put("breed", breed);
//        contentValues.put("state", value[0]);
//        contentValues.put("state2", value[1]);
//        contentValues.put("state3", value[2]);
//        contentValues.put("state4", value[3]);
//        contentValues.put("state5", value[4]);
//        contentValues.put("state6", value[5]);


        String name = null;
        db.update(" usertb ",contentValues,NAME_CL +" =?",new String[]{name});


    }


    public Cursor getData(){
        SQLiteDatabase db=this.getWritableDatabase();
        String qry=" select * from usertb";
        Cursor cursor=db.rawQuery(qry, null);
        return cursor;
    }
}
