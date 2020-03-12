package com.flege.gumukrejo.feature;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.flege.gumukrejo.R;

public class JenisKelamin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jenis_kelamin);

        final TextView male, female;

        male = findViewById(R.id.male);
        female = findViewById(R.id.female);

        final Intent returnIntent = new Intent();
        male.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                returnIntent.putExtra("result",male.getText());
                setResult(Activity.RESULT_OK,returnIntent);
                finish();
            }
        });
        female.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                returnIntent.putExtra("result",female.getText());
                setResult(Activity.RESULT_OK,returnIntent);
                finish();
            }
        });
    }
}
