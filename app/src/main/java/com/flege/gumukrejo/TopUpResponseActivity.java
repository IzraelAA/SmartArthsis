package com.flege.gumukrejo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class TopUpResponseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_up_response);

        Intent intent = getIntent();
        String method = intent.getStringExtra("method");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(method);
    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
