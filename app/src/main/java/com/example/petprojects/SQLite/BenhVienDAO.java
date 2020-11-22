package com.example.petprojects.SQLite;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.petprojects.ModelThuCung.BenhVien;

import java.util.ArrayList;
import java.util.List;

public class BenhVienDAO {
    private SQLiteDB sqLiteDB;

    public BenhVienDAO(SQLiteDB sqLiteDB) {
        this.sqLiteDB = sqLiteDB;
    }

    public void themBenhVien(BenhVien benhVien) {
        SQLiteDatabase sqLiteDatabase = sqLiteDB.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("benhVienID", benhVien.getIdBenhVien());
        contentValues.put("tenBenhVien", benhVien.getTenBenhVien());
        contentValues.put("anhBenhVien", benhVien.getResouceImages());
        contentValues.put("diaChiBenhVien", benhVien.getDiaChiBenhVien());
        sqLiteDatabase.insert("benhVien", null, contentValues);

    }

    public List<BenhVien> getAllBenhVien() {
        List<BenhVien> benhVienList = new ArrayList<>();
        String truyVan = "SELECT * FROM benhVien";
        Cursor cursor = sqLiteDB.getWritableDatabase().rawQuery(truyVan, null);
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                String tenBenhVien = cursor.getString(1);
                int anhBenhVien = cursor.getInt(2);
                String diaChiBenhVien = cursor.getString(3);

                BenhVien benhVien = new BenhVien();
                benhVien.setTenBenhVien(tenBenhVien);
                benhVien.setDiaChiBenhVien(diaChiBenhVien);
                benhVien.setResouceImages(anhBenhVien);
                benhVienList.add(benhVien);
                cursor.moveToNext();
            }
            cursor.close();
        }
        return benhVienList;
    }
}
