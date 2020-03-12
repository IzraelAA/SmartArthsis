package com.flege.gumukrejo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.flege.gumukrejo.main.MainActivity;

import java.text.NumberFormat;
import java.util.Locale;

public class InvoiceActivity extends AppCompatActivity {
    Button btnBack, btnClose;
    TextView jumlah_pembelian, nomor_keran;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invoice);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Smart Arthesis");

        btnBack = findViewById(R.id.btnVerifikasi);
        btnClose = findViewById(R.id.btnClose);
        jumlah_pembelian = findViewById(R.id.jumlah_pembelian);
        nomor_keran = findViewById(R.id.nomor_keran);

        Intent intent = getIntent();
        String pembelian = intent.getStringExtra("pembelian");
        int no_keran = intent.getIntExtra("nomor_keran",0);
        double liter = Double.parseDouble(pembelian);

        Locale localeID = new Locale("in", "ID");
        NumberFormat formatID = NumberFormat.getNumberInstance(localeID);

        jumlah_pembelian.setText(String.format(formatID.format(liter)+" Liter"));
        nomor_keran.setText(String.format(no_keran+""));

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InvoiceActivity.super.onBackPressed();
            }
        });

        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InvoiceActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
