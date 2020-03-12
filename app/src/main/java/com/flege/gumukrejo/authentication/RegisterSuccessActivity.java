package com.flege.gumukrejo.authentication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.flege.gumukrejo.R;

import java.util.Objects;

public class RegisterSuccessActivity extends AppCompatActivity {
    Button btnVerifikasi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_success);

        btnVerifikasi = findViewById(R.id.btnVerifikasi);

        Intent intent = getIntent();
        final String message = intent.getStringExtra("message");
        final String kontak = intent.getStringExtra("kontak");

        final DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        };
        AlertDialog.Builder builder = new AlertDialog.Builder(RegisterSuccessActivity.this);
        builder.setCancelable(false).setMessage(message).setPositiveButton("OK", dialogClickListener).show();

        btnVerifikasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterSuccessActivity.this, KonfirmasiPendaftaranActivity.class);
                intent.putExtra("kontak",kontak);
                startActivity(intent);
            }
        });
    }
}
