package com.flege.gumukrejo.authentication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.flege.gumukrejo.model.GetAuth;
import com.flege.gumukrejo.rest.ApiClient;
import com.flege.gumukrejo.rest.ApiInterface;
import com.flege.gumukrejo.session.SessionManager;
import com.flege.gumukrejo.main.MainActivity;
import com.flege.gumukrejo.R;
import com.google.android.material.textfield.TextInputEditText;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    TextInputEditText inputNoTelp, inputPassword;
    Button btnLogin;
    TextView lupaPassword, lupaKonfirmasiPendaftaran, register;

    SessionManager session;

    ApiInterface mApiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        session =  new SessionManager(LoginActivity.this);

        cek();

        mApiInterface = ApiClient.getClient().create(ApiInterface.class);

        inputNoTelp = findViewById(R.id.inputNoTelp);
        inputPassword = findViewById(R.id.inputPassword);
        btnLogin = findViewById(R.id.btnLogin);
        lupaPassword = findViewById(R.id.lupaPassword);
        lupaKonfirmasiPendaftaran = findViewById(R.id.lupaKonfirmasiPendaftaran);
        register = findViewById(R.id.register);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(inputNoTelp.getText().length()>0 && inputPassword.getText().length()>0){
                    send_login();
                }else{
                    Toast.makeText(LoginActivity.this,"Form tidak boleh kosong",Toast.LENGTH_SHORT).show();
                }
            }
        });

        lupaPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, ForgotPasswordActivity.class);
                startActivity(intent);
                finish();
            }
        });

        lupaKonfirmasiPendaftaran.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, KonfirmasiPendaftaranActivity.class);
                intent.putExtra("kontak","");
                startActivity(intent);
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void cek(){
        if(session.is_loggedin()){
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }
    }

    private void send_login(){
        Call<GetAuth> getPelanggan = mApiInterface.getPelanggan(inputNoTelp.getText().toString(), inputPassword.getText().toString());
        getPelanggan.enqueue(new Callback<GetAuth>() {
            @Override
            public void onResponse(Call<GetAuth> call, Response<GetAuth> response) {
                int code = response.body().getCode();
                if(code == 200){
                    session.set_id_pelanggan(response.body().getPelanggan().getId_pelanggan());
                    session.set_nik(response.body().getPelanggan().getNik());
                    session.set_nama(response.body().getPelanggan().getNama());
                    session.set_kontak(response.body().getPelanggan().getKontak());
                    session.set_gender(response.body().getPelanggan().getGender());
                    session.set_is_loggedin();
                    cek();
                }else{
                    String message = response.body().getMessage();
                    Toast.makeText(LoginActivity.this,message,Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<GetAuth> call, Throwable t) {
                Log.e("Retrofit Gets", t.toString());
            }
        });
    }
}
