package com.example.lenovo.eshop.sqllite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class favouritData extends SQLiteOpenHelper {
    public static final String DB_NAME = "favourite.db";
    public static final String TABLE_NAME ="favourite";
    public favouritData(Context context) {
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE favourite(id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT,phone TEXT,Image BLOB)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS favourite");
        onCreate(db);
    }

    public boolean addToFavourite(String name, String phone,byte[] image)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("phone", phone);
        values.put("Image",image);


        long status = db.insert(TABLE_NAME, null, values);
        if(status == -1){
            return false;
        }
        return true;
    }
    public ArrayList RetreiveAllData()
    {
        ArrayList<favouritelist> allPerson=new ArrayList();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor=db.rawQuery("SELECT * FROM favourite", null);
        if(cursor.moveToNext())
        {
            do{


                int id=cursor.getInt(0);
                String name=cursor.getString(1);
                String price=cursor.getString(2);
                byte[] image=cursor.getBlob(3);
                allPerson.add(new favouritelist(id,image,name,price));
            }while(cursor.moveToNext());
        }
        return allPerson;

    }

    public boolean removeAllData()
    {
        SQLiteDatabase db=this.getWritableDatabase();
        int del=  db.delete(TABLE_NAME,null,null);
        if(del>0)
        {
            return true;
        }return false;
    }
    public boolean deleteItem(String id)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        int del=db.delete(TABLE_NAME,"id=?",new String[]{id});
        if(del>0)
        {
            return true;
        }return false;
    }
}
