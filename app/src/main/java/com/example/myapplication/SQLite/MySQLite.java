package com.example.myapplication.SQLite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MySQLite extends SQLiteOpenHelper {
    public MySQLite(Context context) {
        super(context, "mydata.sql", null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String user_table = "CREATE TABLE USER (username char(15) primary key" +
                ",name varchar(50),password varchar" +
                ",numberPhone char)";
        sqLiteDatabase.execSQL(user_table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
