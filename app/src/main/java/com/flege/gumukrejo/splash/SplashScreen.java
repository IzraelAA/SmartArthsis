package com.flege.gumukrejo.splash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import com.flege.gumukrejo.R;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        final TextView tvAppName = findViewById(R.id.tvAppName);

//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                tvAppName.setVisibility(View.VISIBLE);
//            }
//        },700);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen.this, SplashVideo.class);
                startActivity(intent);
                finish();
            }
        },1500);
    }
}
