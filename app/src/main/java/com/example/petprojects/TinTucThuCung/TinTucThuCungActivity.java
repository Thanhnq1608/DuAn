package com.example.petprojects.TinTucThuCung;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Html;

import com.example.petprojects.Adapter.TinTucAdapter;
import com.example.petprojects.ModelThuCung.TinTuc;
import com.example.petprojects.R;

import java.util.ArrayList;
import java.util.List;

public class TinTucThuCungActivity extends AppCompatActivity {
    RecyclerView recyclerViewTinTuc;
    TinTucAdapter tinTucAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tin_tuc_thu_cung);
        getSupportActionBar().setTitle("Tin Tức Thú Cưng");

        recyclerViewTinTuc = findViewById(R.id.recTinTuc);
        tinTucAdapter = new TinTucAdapter(this);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        recyclerViewTinTuc.setLayoutManager(gridLayoutManager);
        tinTucAdapter.setData(tinTucList());
        recyclerViewTinTuc.setAdapter(tinTucAdapter);
        customActionBar();
    }

    private List<TinTuc> tinTucList() {
        List<TinTuc> tinTucList = new ArrayList<>();
        tinTucList.add(new TinTuc(R.drawable.thuoccanxi, "Các loại thuốc CanXi cho chó chất lượng"));
        tinTucList.add(new TinTuc(R.drawable.thuoccanxi, "TCác loại thuốc CanXi cho chó chất lượng"));
        tinTucList.add(new TinTuc(R.drawable.thuoccanxi, "Các loại thuốc CanXi cho chó chất lượng"));
        tinTucList.add(new TinTuc(R.drawable.thuoccanxi, "TCác loại thuốc CanXi cho chó chất lượng"));
        tinTucList.add(new TinTuc(R.drawable.thuoccanxi, "Các loại thuốc CanXi cho chó chất lượng"));
        tinTucList.add(new TinTuc(R.drawable.thuoccanxi, "TCác loại thuốc CanXi cho chó chất lượng"));
        tinTucList.add(new TinTuc(R.drawable.thuoccanxi, "Các loại thuốc CanXi cho chó chất lượng"));
        tinTucList.add(new TinTuc(R.drawable.thuoccanxi, "TCác loại thuốc CanXi cho chó chất lượng"));
        return tinTucList;
    }
    private void customActionBar(){
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(Html.fromHtml("<font color='#190707'>Tin Tức Thú Cưng </font>"));
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.YELLOW));
        actionBar.show();
    }
}