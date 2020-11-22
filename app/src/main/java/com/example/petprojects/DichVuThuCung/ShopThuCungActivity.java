package com.example.petprojects.DichVuThuCung;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.petprojects.R;

public class ShopThuCungActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_thu_cung);
        getSupportActionBar().setTitle("Cửa Hàng Thú Cưng");
    }
}