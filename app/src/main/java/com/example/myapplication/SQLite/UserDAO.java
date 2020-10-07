package com.example.myapplication.SQLite;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.myapplication.model.NguoiDung;

import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    private MySQLite mySQLite;

    public UserDAO(MySQLite mySqlite) {
        this.mySQLite = mySqlite;
    }

    //add

    public boolean addUser(NguoiDung nguoiDung) {
        //xin quyền 1
        SQLiteDatabase sqLiteDatabase = mySQLite.getWritableDatabase();
        //ghép cặp giá trị vào tên cột 2
        ContentValues values = new ContentValues();
        values.put("username", nguoiDung.getUsername());
        values.put("password", nguoiDung.getPassword());
        values.put("phone", nguoiDung.getSdt());
        values.put("name", nguoiDung.getTen());
        //truy vấn 3
        long kq = sqLiteDatabase.insert("USER", null, values);

        if (kq > 0) {
            return true;
        } else {
            return false;
        }

    }

    // update
    public boolean updateUser(NguoiDung nguoiDung) {
        // xin quyen 1
        SQLiteDatabase sqLiteDatabase = mySQLite.getWritableDatabase();
        // ghép cặp giá trị vào tên cột 2
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", nguoiDung.getUsername());
        contentValues.put("name", nguoiDung.getTen());
        contentValues.put("password", nguoiDung.getPassword());
        contentValues.put("numberPhone", nguoiDung.getSdt());
        // truy vấn 3
        long kq = sqLiteDatabase.update("USER", contentValues, "username=?",
                new String[]{nguoiDung.getUsername()});

        if (kq > 0) return true;
        else return false;

    }
    // del
    public boolean delUser(String username) {
        // xin quyen 1
        SQLiteDatabase sqLiteDatabase = mySQLite.getWritableDatabase();

        // truy vấn 3
        long kq = sqLiteDatabase.delete("USER", "username=?",
                new String[]{username});

        if (kq > 0) return true;
        else return false;

    }

    // get all

    public List<NguoiDung> getAllUsers() {
        List<NguoiDung> nguoiDungList = new ArrayList<>();
        String sql = "SELECT * FROM USER";
        Cursor cursor = mySQLite.getReadableDatabase().rawQuery(sql, null);
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                String username = cursor.getString(0);
                String name = cursor.getString(1);
                String password = cursor.getString(2);
                String std = cursor.getString(3);

                NguoiDung nguoiDung = new NguoiDung();
                nguoiDung.setUsername(username);
                nguoiDung.setTen(name);
                nguoiDung.setPassword(password);
                nguoiDung.setSdt(std);

                nguoiDungList.add(nguoiDung);
                cursor.moveToNext();
            }
        }

        return nguoiDungList;
    }

    public List<NguoiDung> timKiemUsername(String TimUsername) {
        List<NguoiDung> nguoiDungList = new ArrayList<>();
        String sql = "SELECT * FROM USER WHERE username LIKE '%" + TimUsername + "%'";
        Cursor cursor = mySQLite.getReadableDatabase().rawQuery(sql, null);
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                String username = cursor.getString(0);
                String name = cursor.getString(1);
                String password = cursor.getString(2);
                String std = cursor.getString(3);

                NguoiDung nguoiDung = new NguoiDung();
                nguoiDung.setUsername(username);
                nguoiDung.setTen(name);
                nguoiDung.setPassword(password);
                nguoiDung.setSdt(std);

                nguoiDungList.add(nguoiDung);
                cursor.moveToNext();
            }
        }

        return nguoiDungList;
    }
}
