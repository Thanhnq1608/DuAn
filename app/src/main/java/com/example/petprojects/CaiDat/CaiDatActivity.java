package com.example.petprojects.CaiDat;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.petprojects.R;

public class CaiDatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cai_dat);
        getSupportActionBar().setTitle("Cài Đặt");
    }
}