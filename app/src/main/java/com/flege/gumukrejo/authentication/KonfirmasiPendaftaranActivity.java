package com.flege.gumukrejo.authentication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.flege.gumukrejo.R;
import com.flege.gumukrejo.model.DefaultResponse;
import com.flege.gumukrejo.rest.ApiClient;
import com.flege.gumukrejo.rest.ApiInterface;
import com.google.android.material.textfield.TextInputEditText;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class KonfirmasiPendaftaranActivity extends AppCompatActivity {
    TextInputEditText inputNoHandphone, inputKode;
    Button btnKonfirmasi;

    ApiInterface mApiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_konfirmasi_pendaftaran);

        mApiInterface = ApiClient.getClient().create(ApiInterface.class);

        inputNoHandphone = findViewById(R.id.inputNoHandphone);
        inputKode = findViewById(R.id.inputKode);
        btnKonfirmasi = findViewById(R.id.btnKonfirmasi);

        Intent intent = getIntent();
        final String kontak = intent.getStringExtra("kontak");

        inputNoHandphone.setText(kontak);

        btnKonfirmasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(inputNoHandphone.getText().length()>0 && inputKode.getText().length()>0){
                    Call<DefaultResponse> registrasi = mApiInterface.konfirmasi_pendaftaran(
                            inputNoHandphone.getText().toString(),
                            inputKode.getText().toString());
                    registrasi.enqueue(new Callback<DefaultResponse>() {
                        @Override
                        public void onResponse(Call<DefaultResponse> call, Response<DefaultResponse> response) {
                            String message = response.body().getMessage();
                            Toast.makeText(KonfirmasiPendaftaranActivity.this,message,Toast.LENGTH_SHORT).show();
                            int code = response.body().getCode();
                            if(code == 200){
                                if(kontak.length()>0){
                                    Intent intent = new Intent(KonfirmasiPendaftaranActivity.this, LoginActivity.class);
                                    startActivity(intent);
                                }
                                finish();
                            }
                        }

                        @Override
                        public void onFailure(Call<DefaultResponse> call, Throwable t) {
                            Log.e("Retrofit Gets", t.toString());
                        }
                    });
                }else{
                    Toast.makeText(KonfirmasiPendaftaranActivity.this,"Form tidak boleh kosong",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
