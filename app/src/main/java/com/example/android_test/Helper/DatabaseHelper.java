package com.example.android_test.Helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String Id_CL="id";
    private final static String db_name="userdata_tb";
    byte[] imageinBytes;

    public DatabaseHelper(Context context) {
        super(context, db_name,null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String qry="create table usertb_data(id integer primary key,image BLOB, name TEXT,species TEXT, breed TEXT,size TEXT,gender BOOLEAN,neutered BOOLEAN,vaccinated BOOLEAN,Friendlywithdogs BOOLEAN,Friendlywithcats BOOLEAN,Friendlywithkids10 BOOLEAN,Friendlywithkids10G BOOLEAN)";
        db.execSQL(qry);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String qry = "DROP TABLE IF EXISTS usertb_data";
        db.execSQL(qry);
    }

    public boolean insertData(ContentValues contentValues){
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        long i=sqLiteDatabase.insert(" usertb_data ",null,contentValues);
        if (i==-1){
            return false;
        }else {
            return true;
        }
    }

    public boolean updateRecord(ContentValues contentValues,String id){
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



       long i= db.update(" usertb_data ", contentValues , Id_CL + " = ? ", new String[]{id});
       if (i==-1){
           return false;
       }else {
           return true;
       }

    }

    public void deleteData(String id){
        SQLiteDatabase db=this.getWritableDatabase();
        db.delete("usertb_data",Id_CL + " = ? ", new String[]{id});
    }

    public void delteAllData(){
        SQLiteDatabase db=this.getWritableDatabase();
        db.execSQL("DELETE FROM usertb_data ");
    }

    public Cursor getData(){
        SQLiteDatabase db=this.getWritableDatabase();
        String qry=" select * from usertb_data";
        Cursor cursor=db.rawQuery(qry, null);
        return cursor;
    }
}
