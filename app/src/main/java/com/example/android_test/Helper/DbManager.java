package com.example.android_test.Helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbManager extends SQLiteOpenHelper {

    private final static String DB_name = "userdb";

    public DbManager(Context context) {
        super(context, DB_name, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String qry = "create table user_records(id integer primary key autoincrement, name TEXT,email TEXT, mobile TEXT, password TEXT )";
        db.execSQL(qry);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String qry = "DROP TABLE IF EXISTS user_records";
        db.execSQL(qry);
    }


    public boolean addRecord(String name, String email, String mobile, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();


        contentValues.put("name", name);
        contentValues.put("email", email);
        contentValues.put("mobile", mobile);
        contentValues.put("password", password);

        long id = db.insert(" user_records ", null, contentValues);
        if (id == -1) {
            return false;
        } else {
            return true;
        }
    }

    public Boolean checkuser(String email) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from user_records where email = ?", new String[]{email});
        if (cursor.getCount() > 0) {
            return true;
        } else {
            return false;
        }


    }

    public Boolean checkusermailpass(String email, String password) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from user_records where email = ? and password = ?", new String[]{email, password});
        if (cursor.getCount() > 0) {
            return true;
        } else {
            return false;
        }

    }

}