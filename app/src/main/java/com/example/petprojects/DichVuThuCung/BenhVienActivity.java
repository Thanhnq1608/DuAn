package com.example.petprojects.DichVuThuCung;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.GridView;
import android.widget.Toast;

import com.example.petprojects.Adapter.BenhVienAdapter;
import com.example.petprojects.ModelThuCung.BenhVien;
import com.example.petprojects.R;
import com.example.petprojects.SQLite.BenhVienDAO;
import com.example.petprojects.SQLite.SQLiteDB;

import java.util.ArrayList;
import java.util.List;


public class BenhVienActivity extends AppCompatActivity {
    RecyclerView recBenhVien;
    BenhVienAdapter benhVienAdapter;
    private SQLiteDB sqLiteDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_benh_vien);
        getSupportActionBar().setTitle("Bệnh Viện Thú Cưng");

        sqLiteDB = new SQLiteDB(this);
        BenhVienDAO benhVienDAO = new BenhVienDAO(sqLiteDB);
        recBenhVien = findViewById(R.id.recBenhVien);
        ThemBenhVien();
        benhVienAdapter = new BenhVienAdapter(this);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        recBenhVien.setLayoutManager(gridLayoutManager);
        List<BenhVien> benhVienList = benhVienDAO.getAllBenhVien();
        benhVienAdapter.setData(benhVienList);
        recBenhVien.setAdapter(benhVienAdapter);
    }

//    private List<BenhVien> benhVienList() {
//        List<BenhVien> benhVienList = new ArrayList<>();
//        BenhVien benhVien = new BenhVien("BV01", "Bệnh Viện Thú Cưng", "Số 3 Nguyễn Trải", R.drawable.hospital_item))
//        ;
////        benhVienList.add(new BenhVien("BV01", "Thú Cưng Hà Nội", "Số 3 Nguyễn Trải", R.drawable.hospital_item));
////        benhVienList.add(new BenhVien("BV01", "Bệnh Viện Lan Anh", "Số 3 Nguyễn Trải", R.drawable.hospital_item));
////        benhVienList.add(new BenhVien("BV01", "Pets Hospital", "Số 3 Nguyễn Trải", R.drawable.hospital_item));
////        benhVienList.add(new BenhVien("BV01", "Animal Viet Nam", "Số 3 Nguyễn Trải", R.drawable.hospital_item));
//        BenhVienDAO benhVienDAO = new BenhVienDAO(sqLiteDB);
//        benhVienDAO.themBenhVien(benhVien);
//        return benhVienList;
//
//    }

    private void ThemBenhVien() {
        BenhVien benhVien = new BenhVien("BV01", "Ánh Xạ Thú Cưng", "Số 3 Nguyễn Trải", R.drawable.hospital_item);
        BenhVien benhVien2 = new BenhVien("BV02", "Bệnh Viện Thú Cưng", "Số 3 Nguyễn Trải", R.drawable.hospital_item);
        BenhVien benhVien3 = new BenhVien("BV03", "Bệnh Viện Thú Cưng", "Số 3 Nguyễn Trải", R.drawable.hospital_item);
        BenhVien benhVien4 = new BenhVien("BV04", "Bệnh Viện Thú Cưng", "Số 3 Nguyễn Trải", R.drawable.hospital_item);
        BenhVienDAO benhVienDAO = new BenhVienDAO(sqLiteDB);
        benhVienDAO.themBenhVien(benhVien);
        benhVienDAO.themBenhVien(benhVien2);
        benhVienDAO.themBenhVien(benhVien3);
        benhVienDAO.themBenhVien(benhVien4);
    }
}