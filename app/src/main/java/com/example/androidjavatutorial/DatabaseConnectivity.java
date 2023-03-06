package com.example.androidjavatutorial;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseConnectivity extends SQLiteOpenHelper {
    
    public DatabaseConnectivity(@Nullable Context context, @Nullable String name,
                                @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    // Create a new table 
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "create table users (" +
                "username text,"+
                "email text,"+
                "password text"+
                ")";
        sqLiteDatabase.execSQL(query);
        
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void register(String userName , String email , String password) {
        ContentValues cv = new ContentValues();
        cv.put("username",userName);
        cv.put("email",email);
        cv.put("password",password);

        SQLiteDatabase db = getWritableDatabase();
        db.insert("users",null,cv);
        db.close();
    }

    public boolean isUserExists(String username , String password) {
        String [] params = new String[2];
        params[0] = username;
        params[1] = password;

        SQLiteDatabase db = getReadableDatabase();
        @SuppressLint("Recycle")
        Cursor userExists = db
                .rawQuery("select * from users where username = ? and password = ?",params);

        return userExists.moveToFirst()?true:false;

    }
}
