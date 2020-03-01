package com.bdu.music;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "user.db";
    public static final String TABLE_NAME= "user_info";
    public static final String fname= "full_name";
    public static final String usrname= "user_name";
    public static final String phone= "phone";
    public static final String email= "email";
    public static final String password = "password";
    public static final String sex = "sex";
    public static final String date = "Date";
    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createUserTable = "CREATE TABLE " + TABLE_NAME +
                " ( "
                + fname + " varchar(50) ,"
                + usrname + " varchar(50) ,"
                + phone + " varchar(50) ,"
                + email + " varchar(50) ,"
                + password + " varchar(50) ,"
                + sex + " varchar(50) ,"
                + date + " varchar(50) "
                + " ) ";
        db.execSQL(createUserTable);
    }


    //called when the database needs to upgrade
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if( oldVersion != newVersion){
            db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);
            onCreate(db);
        }
    }

    public long insert(User user ){

        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        //contentValues.put("imgUri",imgPath);
        contentValues.put("full_name",user.getFname());
        contentValues.put("user_name",user.getUsername());
        contentValues.put("email",user.getEmail());
        contentValues.put("phone",user.getPhone());
        contentValues.put("password",user.getPassword());
        contentValues.put("sex",user.getSex());
        contentValues.put("date",new Date().toString());
        long result= db.insert(TABLE_NAME,null,contentValues);
      return result;
    }

    public List getAllData() {
        SQLiteDatabase db= getWritableDatabase();
        String query="SELECT * FROM "+TABLE_NAME;
        List list=new ArrayList();
        Cursor res = db.rawQuery(query,null);
        while (res.moveToNext())
        {
            list.add(new User(res.getString(0),
                    res.getColumnName(1),
                    res.getColumnName(2),
                    res.getColumnName(3),
                    res.getColumnName(4),
                    res.getColumnName(5)));
        }
        return list;

    }
    public Cursor getDataForRecycler(){
        SQLiteDatabase db = getWritableDatabase();
        List list=new ArrayList();
        Cursor res = db.rawQuery("SELECT * FROM "+TABLE_NAME,null);
        return  res;
    }
    public Boolean getDataForLogin(String mail){
        SQLiteDatabase db = getWritableDatabase();
        String filter = email + " , " + password;
        String condition = "'"+ mail +"'" + " = " + email;
        Cursor res = db.rawQuery("SELECT "+ filter + " FROM " + TABLE_NAME + " WHERE " + condition, null );
        boolean r=false;
        if (res.getCount()==0)
        {
            r=false;
        }
        else
        {
            r=true;
        }
        return r;
    }
}
