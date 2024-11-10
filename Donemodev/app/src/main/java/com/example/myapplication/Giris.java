package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Giris extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giris);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(Giris.this, giris2.class));
                overridePendingTransition(0,0);
                finish();
            }
        },3500);

        anaekranagec();

    }
    private void anaekranagec() {
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.anim);
        ImageView girislogo = (ImageView) findViewById(R.id.logos);
        anim.reset();
        girislogo.clearAnimation();
        girislogo.startAnimation(anim);





    }
}