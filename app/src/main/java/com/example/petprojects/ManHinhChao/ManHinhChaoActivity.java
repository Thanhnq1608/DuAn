package com.example.petprojects.ManHinhChao;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.example.petprojects.R;

public class ManHinhChaoActivity extends AppCompatActivity {
    ImageView imgLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_hinh_chao);
        imgLogo = findViewById(R.id.imglogoThuCung);
        AnimationLogo();
    }

    private void AnimationLogo() {
        Animation animation = AnimationUtils.loadAnimation(ManHinhChaoActivity.this, R.anim.logo);
        animation.setRepeatMode(Animation.REVERSE);
        animation.setDuration(2000);
        imgLogo.startAnimation(animation);
    }

}