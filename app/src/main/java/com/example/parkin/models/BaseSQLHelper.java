package com.example.parkin.models;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class BaseSQLHelper extends SQLiteOpenHelper {

    private static final String BASE_DATOS = "Parkin.sqlite";

    Context miContext;
    public BaseSQLHelper(@Nullable Context context) {
        super(context, BASE_DATOS, null, 1);
        miContext = context;
        try{
            if(!existeBase()){
                copiarBase();
            }
        }catch (Exception e){
            copiarBase();
            e.printStackTrace();
        }
    }

    private boolean existeBase(){
        SQLiteDatabase tmpDB = null;
        tmpDB = SQLiteDatabase.openDatabase(
                miContext.getDatabasePath(BASE_DATOS).getAbsolutePath(),
                null, SQLiteDatabase.OPEN_READONLY
        );
        if(tmpDB != null){
            tmpDB.close();
            return true;
        }else{
            return false;
        }
    }

    private void copiarBase(){
        File archivoBD = miContext.getDatabasePath(BASE_DATOS);

        try{
            InputStream inputStream = miContext.getAssets().open(BASE_DATOS);
            OutputStream outputStream = new FileOutputStream(archivoBD);
            byte[] buffer = new byte[1024];
            int largo;

            while ((largo=inputStream.read(buffer))>0){
                outputStream.write(buffer,0,largo);
            }
            outputStream.flush();
            outputStream.close();
            inputStream.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void noQuery(String sql){
        this.getWritableDatabase().execSQL(sql);
    }

    public Cursor query(String sql){
        return this.getReadableDatabase().rawQuery(sql, null);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
