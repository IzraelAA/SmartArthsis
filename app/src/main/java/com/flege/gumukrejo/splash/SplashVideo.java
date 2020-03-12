package com.flege.gumukrejo.splash;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.flege.gumukrejo.authentication.LoginActivity;
import com.flege.gumukrejo.R;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import java.util.ArrayList;

public class SplashVideo extends Activity {
    CarouselView carouselView;
    TextView btn_next;
    ArrayList<Integer> imagesSplash = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splasvideo);

        carouselView = findViewById(R.id.carouselView);
        btn_next = findViewById(R.id.btn_next);

        imagesSplash.add(R.drawable.splash1);
        imagesSplash.add(R.drawable.splash2);
        imagesSplash.add(R.drawable.splash3);

        carouselView.setPageCount(imagesSplash.size());
        carouselView.setImageListener(imageListener);

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SplashVideo.this, LoginActivity.class));
                finish();
            }
        });
    }

    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setImageResource(imagesSplash.get(position));
        }
    };

}
