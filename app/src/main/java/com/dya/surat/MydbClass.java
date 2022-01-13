package com.dya.surat;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class MydbClass extends SQLiteOpenHelper {
    public static String dbName = "quran.db";
    public static int dbVersion = 1;
    public static String dbPath ="";
    Context myContext;

    public MydbClass(@Nullable Context context) {
        super(context,dbName,null,dbVersion);
        this.myContext=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    private boolean ExistDatabase(){
        File myFile = new File(dbPath+dbName);

        return myFile.exists();
    }

    private void CopyDataBase(){

        try {
            InputStream myInput = myContext.getAssets().open(dbName);
            OutputStream myOutput =new FileOutputStream(dbPath+dbName);
            byte [] myBuffer = new byte[1024];
            int length;
            while ((length = myInput.read(myBuffer))>0){
                myOutput.write(myBuffer,0,length);
            }
            myOutput.flush(); myOutput.close(); myInput.close();
        }catch (Exception ex){

        }
    }

    public void StartWork(){

        dbPath = myContext.getFilesDir().getParent()+"/databases/";
        if (!ExistDatabase()){
            this.getReadableDatabase();
            CopyDataBase();
        }

    }

   Cursor readAllData(){
        String query ="select * from surat";
       SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=null;
        if (db != null){
            cursor = db.rawQuery(query,null);
        }
        return cursor;

    }

    Cursor readAllZikrData(){
        String query ="select * from dhikrname";
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=null;
        if (db != null){
            cursor = db.rawQuery(query,null);
        }
        return cursor;

    }

    Cursor readAllAyahData(String id){

        String query ="select * from ayah_text WHERE suraId ="+id+" ORDER BY ayah ASC";
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=null;
        if (db != null){
            cursor = db.rawQuery(query,null);
        }
        return cursor;

    }

    Cursor readAllTafsirData(String id){

        String query ="select * from tafsir WHERE sura ="+id+" ORDER BY ayah ASC";
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=null;
        if (db != null){
            cursor = db.rawQuery(query,null);
        }
        return cursor;

    }

    Cursor readAllDataZikr(String id){

        String query ="select * from dhikr WHERE dhikrid ="+id+" ORDER BY id ASC";
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=null;
        if (db != null){
            cursor = db.rawQuery(query,null);
        }
        return cursor;

    }

}
