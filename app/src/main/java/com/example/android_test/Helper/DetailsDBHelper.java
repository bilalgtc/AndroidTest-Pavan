package com.example.android_test.Helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;

import androidx.annotation.Nullable;

import com.example.android_test.Models.Recycle_model;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.jar.Attributes;

public class DetailsDBHelper extends SQLiteOpenHelper {
        public static final String DB_NAME="RECORDS_DB";

        public static final String TABLE_NAME ="RECORDS_TABLE";
        //FIELDS
    byte[] imgInBytes;

        public static final String C_ID ="ID";
    public static final String C_NAME ="NAME";
    public static final String C_BREED ="BREED";
    public static final String C_SPECIES ="SPECIES";
    public static final String C_IMAGE ="IMAGE";
    public static final String C_SIZE ="SIZE";
    public static final String C_MALE ="MALE";
    public static final String C_FEMALE ="FEMALE";
    public static final String C_NEUTERED ="NEUTERED";
    public static final String C_VACCINATED ="VACCINATED";
    public static final String C_FRWITHDOGS ="FRWITHDOGS";
    public static final String C_FRWITHCATS ="FRWITHCATS";
    public static final String C_FRKIDS ="FRKIDS";
    public static final String C_FRKIDSG ="FRKIDSG";

    public  static final String C_ADDED_TIMESTAMP ="ADDED_TIME_STAMP";
    public  static final String C_UPDATED_TIMESTAMP ="UPDATED_TIME_STAMP";
// + C_IMAGE + " BLOB NOT NULL,"

    public static final String CREATE_TABLE = " CREATE TABLE " + TABLE_NAME + "("
            + C_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + C_NAME + " TEXT,"
            + C_BREED + " TEXT,"
            + C_SPECIES + " TEXT,"
            +C_SIZE + " TEXT,"
            +C_MALE + " TEXT,"
            +C_FEMALE + " TEXT,"
            +C_NEUTERED + " TEXT,"
            +C_VACCINATED + " TEXT,"
            +C_FRWITHDOGS + " TEXT,"
            +C_FRWITHCATS + " TEXT,"
            +C_FRKIDS + " TEXT,"
            +C_FRKIDSG + " TEXT,"
            +C_ADDED_TIMESTAMP + " TEXT,"
            +C_UPDATED_TIMESTAMP + " TEXT" + ")";

    public DetailsDBHelper(Context context) {
        super(context, DB_NAME, null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);

    }

//    public long insertRecord(Byte image,String name,String species,String breed,String size,boolean male,boolean female,
//                             boolean neutered,boolean vaccinated,boolean frD,boolean frC,boolean frK,boolean frKG ,String addedTime,String updateTime) {
//
//        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
//
//        ContentValues contentValues = new ContentValues();
//        contentValues.put(C_IMAGE, image);
//        contentValues.put(C_NAME, name);
//        contentValues.put(C_SPECIES, species);
//        contentValues.put(C_BREED, breed);
//        contentValues.put(C_SIZE, size);
//        contentValues.put(C_MALE, male);
//        contentValues.put(C_FEMALE, female);
//        contentValues.put(C_NEUTERED, neutered);
//        contentValues.put(C_VACCINATED, vaccinated);
//        contentValues.put(C_FRWITHDOGS, frD);
//        contentValues.put(C_FRWITHCATS, frC);
//        contentValues.put(C_FRKIDS, frK);
//        contentValues.put(C_FRKIDSG, frKG);
//        contentValues.put(C_ADDED_TIMESTAMP, addedTime);
//        contentValues.put(C_UPDATED_TIMESTAMP, updateTime);
//
//        long id=sqLiteDatabase.insert(TABLE_NAME, null, contentValues);
//        sqLiteDatabase.close();
//
//        return  id;
//
//    }
//Bitmap image,
    public boolean insertRecords( String name,String breed){
        SQLiteDatabase sqLiteDatabase =this.getWritableDatabase();

//        ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
//        image.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
//        imgInBytes=byteArrayOutputStream.toByteArray();

        ContentValues contentValues =new ContentValues();
        contentValues.put(C_NAME, name);
//        contentValues.put(C_IMAGE, imgInBytes);
        contentValues.put(C_BREED, breed);

        long id = sqLiteDatabase.insert(TABLE_NAME, null, contentValues);
        if (id == -1){
            return false;
        }else {
            return true;
        }
    }

    public Cursor getUser(){

         SQLiteDatabase sqLiteDatabase =this.getReadableDatabase();
         String qry = "SELECT * FROM RECORDS_TABLE";
         Cursor cursor=null;
         if (sqLiteDatabase !=null){
          cursor = sqLiteDatabase.rawQuery(qry, null);
          }
         return cursor;
    }

//    public ArrayList<Recycle_model> getRecords(){
//        String selecQuery = "SELECT * FROM " + TABLE_NAME;
//
//        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
//        Cursor cursor=sqLiteDatabase.rawQuery(selecQuery, null);
//
//
//        ArrayList<Recycle_model> details=new ArrayList<>();
//
//        while (cursor.moveToNext()){
//                Recycle_model model=new Recycle_model();
//                model.id = cursor.getInt(0);
//                model.name = cursor.getString(1);
//                details.add(model);
//
//            }
//
//        sqLiteDatabase.close();
//        return details;
//    }


}
