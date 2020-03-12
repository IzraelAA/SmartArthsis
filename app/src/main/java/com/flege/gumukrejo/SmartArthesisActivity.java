package com.flege.gumukrejo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.flege.gumukrejo.feature.InputFilterMinMax;
import com.flege.gumukrejo.model.DefaultResponse;
import com.flege.gumukrejo.rest.ApiClient;
import com.flege.gumukrejo.rest.ApiInterface;
import com.flege.gumukrejo.session.SessionManager;
import com.google.android.material.textfield.TextInputEditText;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SmartArthesisActivity extends AppCompatActivity {
    Button btnliterair, btnRupiah, btnLanjutkan;
    TextInputEditText inputNominal, inputLiter;
    TextView saldo, topup, jumlah_liter, jumlah_rupiah;
    RelativeLayout container_rupiah, container_liter;

    int balance = 0;
    Locale localeID = new Locale("in", "ID");
    NumberFormat formatID = NumberFormat.getNumberInstance(localeID);

    SessionManager session;
    ApiInterface mApiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smart_arthesis);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Smart Arthesis");

        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        session =  new SessionManager(SmartArthesisActivity.this);

        get_balance();

        btnliterair = findViewById(R.id.btnliterair);
        btnRupiah = findViewById(R.id.btnRupiah);
        btnLanjutkan = findViewById(R.id.btnLanjutkan);
        inputNominal = findViewById(R.id.inputNominal);
        inputLiter = findViewById(R.id.inputLiter);
        saldo = findViewById(R.id.saldo);
        topup = findViewById(R.id.topup);
        jumlah_liter = findViewById(R.id.jumlah_liter);
        jumlah_rupiah = findViewById(R.id.jumlah_rupiah);
        container_rupiah = findViewById(R.id.container_rupiah);
        container_liter = findViewById(R.id.container_liter);

        saldo.setText(formatID.format(balance) + " Liter");

        //sementara tidak digunakan dahulu----------------------------------------------------------------------------
        inputNominal.setFilters(new InputFilter[]{ new InputFilterMinMax("1", balance+"")});
        btnRupiah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnliterair.setBackground(getResources().getDrawable(R.drawable.btn_rounded_white));
                btnliterair.setTextColor(getResources().getColor(R.color.black));
                btnRupiah.setBackground(getResources().getDrawable(R.drawable.btn_rounded_selected));
                btnRupiah.setTextColor(getResources().getColor(R.color.colorNotification));
                container_rupiah.setVisibility(View.VISIBLE);
                container_liter.setVisibility(View.GONE);

            }
        });
        inputNominal.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable s) {}

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.length() != 0){
                    double nominal = Double.parseDouble(inputNominal.getText().toString());
                    jumlah_liter.setText(String.format("%s",NumberFormat.getNumberInstance(Locale.US).format(nominal)));
                }else{
                    jumlah_liter.setText("0");
                }
            }
        });
        //sampai sini--------------------------------------------------------------------------------------------------

        inputLiter.setFilters(new InputFilter[]{ new InputFilterMinMax("1", String.valueOf(balance))});
        btnliterair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnRupiah.setBackground(getResources().getDrawable(R.drawable.btn_rounded_white));
                btnRupiah.setTextColor(getResources().getColor(R.color.black));
                btnliterair.setBackground(getResources().getDrawable(R.drawable.btn_rounded_selected));
                btnliterair.setTextColor(getResources().getColor(R.color.colorNotification));
                container_rupiah.setVisibility(View.GONE);
                container_liter.setVisibility(View.VISIBLE);
            }
        });
        inputLiter.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable s) {}

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.length() != 0){
                    double nominal = Double.parseDouble(inputLiter.getText().toString());
                    jumlah_rupiah.setText(String.format("Rp%s", NumberFormat.getNumberInstance(Locale.US).format(nominal)));
                }else{
                    jumlah_rupiah.setText("0");
                }
            }
        });

        topup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SmartArthesisActivity.this, TopUpActivity.class);
                startActivity(intent);
            }
        });

        btnLanjutkan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(container_liter.getVisibility() == View.VISIBLE){
                    if(inputLiter.getText().length() > 0){
                        Intent intent = new Intent(SmartArthesisActivity.this, InvoiceActivity.class);
                        int no_keran = new Random().nextInt(20) + 1;
                        intent.putExtra("pembelian", inputLiter.getText().toString());
                        intent.putExtra("nomor_keran", no_keran);
                        startActivity(intent);
                    }else{
                        Toast.makeText(SmartArthesisActivity.this, "Nominal harus diisi", Toast.LENGTH_SHORT).show();
                    }
                }
                if(container_rupiah.getVisibility() == View.VISIBLE){
                    if(inputNominal.getText().length() > 0){
                        Intent intent = new Intent(SmartArthesisActivity.this, InvoiceActivity.class);
                        int no_keran = new Random().nextInt(20) + 1;
                        intent.putExtra("pembelian", jumlah_liter.getText());
                        intent.putExtra("nomor_keran", no_keran);
                        startActivity(intent);
                    }else{
                        Toast.makeText(SmartArthesisActivity.this, "Jumlah liter harus diisi", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }

    private void get_balance(){
        Call<DefaultResponse> get_balance = mApiInterface.get_balance(
                session.get_id_pelanggan(),
                session.get_nik());
        get_balance.enqueue(new Callback<DefaultResponse>() {
            @Override
            public void onResponse(Call<DefaultResponse> call, Response<DefaultResponse> response) {
                String message = response.body().getMessage();
                int code = response.body().getCode();
                if(code == 200){
                    balance = Integer.parseInt(message);
                    saldo.setText(formatID.format(balance) + " Liter");
                    inputLiter.setFilters(new InputFilter[]{ new InputFilterMinMax("1", String.valueOf(balance))});
                }
            }

            @Override
            public void onFailure(Call<DefaultResponse> call, Throwable t) {
                Log.e("Retrofit Gets", t.toString());
            }
        });
    }
}
