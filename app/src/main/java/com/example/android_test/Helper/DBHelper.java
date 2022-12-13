package com.example.android_test.Helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;
import android.widget.Toast;


public class DBHelper extends SQLiteOpenHelper {

//    String createTableUser = "CREATE TABLE if not exists 'user' ('id' INTEGER PRIMARY KEY AUTOINCREMENT, 'email' TEXT," + " 'password' TEXT, 'usermane' TEXT, 'mobile' TEXT )";

    public DBHelper(Context context) {
        super(context,"Login.db",null,1);
//        getWritableDatabase().execSQL(createTableUser);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table user(email Text primary key,password Text,mobile Text,name Text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists user");
    }


//  public  void addUser(ContentValues contentValues) {
//        getWritableDatabase().insert("user", "", contentValues);
//  }
//
//
//
//    public Boolean checkusermailpassword(String email,String  password) {
//        String sql ="Select count(*) from user where email='" + email + "' and password='" + password + "'";
//        SQLiteStatement statement = getReadableDatabase().compileStatement(sql);
//        long l=statement.simpleQueryForLong();
//        statement.close();
//
//        if (l==1){
//            return true;
//        }else{
//            return false;
//        }
//    }

    public Boolean insertData(String email,String password,String uname,String umobile){
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        ContentValues contentValues =new ContentValues();
        contentValues.put("email", email);
        contentValues.put("password", password);
        contentValues.put("name", uname);
        contentValues.put("mobile", umobile);


        long result=sqLiteDatabase.insert("user", null, contentValues);
        if (result == -1){
            return false;
        }else{
            return  true;
        }

    }


    public Boolean checkuser(String emailvalue){
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        Cursor cursor =sqLiteDatabase.rawQuery("select * from user where email = ?",new String[] {emailvalue});
        if (cursor.getCount()>1){
            return true;
        }else{
            return  false;
        }


    }


    public Boolean checkusermailpass(String emailvalue,String passwordvalue){
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        Cursor cursor =sqLiteDatabase.rawQuery("select * from user where email = ? and password = ?",new String[] {emailvalue,passwordvalue});
        if (cursor.getCount()>1){
            return true;
        }else{
            return  false;
        }

    }

    }

