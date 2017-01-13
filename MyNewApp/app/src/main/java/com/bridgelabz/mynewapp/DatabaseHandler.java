package com.bridgelabz.mynewapp;

/**
 * Created by bridgeit on 9/1/17.
 */

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHandler extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "contactsManager";
    private static final String TABLE_N = "User";
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_PASS = "pass";
    private static final String KEY_PHONE = "phone";
    private static final String KEY_ADD= "address";
    SQLiteDatabase db;
    private Cursor c;
    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        //3rd argument to be passed is CursorFactory instance
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_N + "("
                + KEY_ID + " INTEGER PRIMARY KEY,"
                + KEY_NAME + " TEXT,"
                + KEY_PASS+ " TEXT ,"
                + KEY_PHONE+ " TEXT,"
                + KEY_ADD+ " TEXT "+")";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_N);
         onCreate(db);
    }

    // code to add the new contact
    void InsertRec(String name,String pass,String phone,String add) {
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, name); // Contact Name
        values.put(KEY_PASS, pass); // Contact pass
        values.put(KEY_PHONE, phone); // Contact Phone
        values.put(KEY_ADD, add); // Contact add

        // Inserting Row
        db.insert(TABLE_N, null, values);
        //2nd argument is String containing nullColumnHack
        db.close(); // Closing database connection
    }
    public List<String> getAllNames(){
        List<String> labels = new ArrayList<String>();
         String selectQuery = "SELECT  * FROM " + TABLE_N;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                labels.add(cursor.getString(1));
            } while (cursor.moveToNext());
        }

        // closing connection
        cursor.close();
        db.close();

        // returning lables
        return labels;
    }
    //
    public boolean deleteTitle(String name)
    {
        db = this.getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_N+ " WHERE "+KEY_NAME+"='"+name+"'");
        db.close();
       return true;
    }
        public boolean isUser(String name,String pass){
        String selectQuery = "SELECT  * FROM " + TABLE_N+" where name ='"+name+"' and pass= '"+pass+"'";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if(cursor.moveToFirst()){
            return true;
        }
        else{
            return false;
        }
    }
    public Cursor getUser( String name){
        String selectQuery = "SELECT  * FROM " + TABLE_N+" where name ='"+name+"' ";
        db = this.getWritableDatabase();
        Cursor cursor=db.rawQuery(selectQuery,null);
        return cursor;

    }

}