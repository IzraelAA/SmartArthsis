package com.flege.gumukrejo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.flege.gumukrejo.main.MainActivity;
import com.journeyapps.barcodescanner.BarcodeEncoder;

import java.text.NumberFormat;
import java.util.Locale;

public class InvoiceActivity extends AppCompatActivity {
    Button btnBack, btnClose;
    TextView jumlah_pembelian, nomor_keran;

    public ImageView image;
    MultiFormatWriter multiFormatWriter = new MultiFormatWriter();

    String teksbarcode;
    String pembelian;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invoice);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Smart Arthesis");

        image = (ImageView)findViewById(R.id.qrcode);
        btnBack = findViewById(R.id.btnVerifikasi);
        btnClose = findViewById(R.id.btnClose);
        jumlah_pembelian = findViewById(R.id.jumlah_pembelian);
        nomor_keran = findViewById(R.id.nomor_keran);

        Intent intent = getIntent();
        pembelian = intent.getStringExtra("pembelian");
        teksbarcode = "1"+pembelian+"2789162";
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
        barcode();
        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InvoiceActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void barcode() {
        try                {
            Toast.makeText(getApplicationContext(), teksbarcode, Toast.LENGTH_SHORT).show();
            BitMatrix      bitMatrix = multiFormatWriter.encode(teksbarcode, BarcodeFormat.CODE_128, 400,170);
            BarcodeEncoder encoder   = new BarcodeEncoder();
            Bitmap         bitmap    = encoder.createBitmap(bitMatrix);
            image.setImageBitmap(bitmap);

        } catch (WriterException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
