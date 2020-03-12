package com.flege.gumukrejo.authentication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.flege.gumukrejo.R;
import com.flege.gumukrejo.feature.JenisKelamin;
import com.flege.gumukrejo.model.DefaultResponse;
import com.flege.gumukrejo.rest.ApiClient;
import com.flege.gumukrejo.rest.ApiInterface;
import com.flege.gumukrejo.session.SessionManager;
import com.google.android.material.textfield.TextInputEditText;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {
    TextInputEditText inputNik, inputNama, inputJenisKelamin, inputNoHandphone, inputPassword, inputConfirmPassword;
    String gender;
    Button btnRegister;
    TextView login;

    int request_code = 1;

    ApiInterface mApiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mApiInterface = ApiClient.getClient().create(ApiInterface.class);

        inputNik = findViewById(R.id.inputNik);
        inputNama = findViewById(R.id.inputNama);
        inputJenisKelamin = findViewById(R.id.inputJenisKelamin);
        inputNoHandphone = findViewById(R.id.inputNoHandphone);
        inputPassword = findViewById(R.id.inputPassword);
        inputConfirmPassword = findViewById(R.id.inputConfirmPassword);
        btnRegister = findViewById(R.id.btnRegister);
        login = findViewById(R.id.login);

        inputJenisKelamin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, JenisKelamin.class);
                startActivityForResult(intent, request_code);
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(is_form_complete()){
                    if(inputPassword.getText().toString().equals(inputConfirmPassword.getText().toString())){
                        Call<DefaultResponse> registrasi = mApiInterface.register_pelanggan(
                                inputNik.getText().toString(),
                                inputNama.getText().toString(),
                                gender,
                                inputNoHandphone.getText().toString(),
                                inputPassword.getText().toString());
                        registrasi.enqueue(new Callback<DefaultResponse>() {
                            @Override
                            public void onResponse(Call<DefaultResponse> call, Response<DefaultResponse> response) {
                                String message = response.body().getMessage();
                                int code = response.body().getCode();
                                if(code == 200){
                                    Intent intent = new Intent(RegisterActivity.this, RegisterSuccessActivity.class);
                                    intent.putExtra("message",message);
                                    intent.putExtra("kontak",inputNoHandphone.getText().toString());
                                    startActivity(intent);
                                    finish();
                                }else{
                                    Toast.makeText(RegisterActivity.this,message,Toast.LENGTH_SHORT).show();
                                }
                            }

                            @Override
                            public void onFailure(Call<DefaultResponse> call, Throwable t) {
                                Log.e("Retrofit Gets", t.toString());
                            }
                        });
                    }else{
                        Toast.makeText(RegisterActivity.this,"Password tidak sama",Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(RegisterActivity.this,"Form tidak boleh kosong",Toast.LENGTH_SHORT).show();
                }
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private boolean is_form_complete(){
        if(inputNik.getText().length()>0 && inputNama.getText().length()>0 && inputJenisKelamin.getText().length()>0 && inputNoHandphone.getText().length()>0 && inputPassword.getText().length()>0 && inputConfirmPassword.getText().length()>0){
            if(inputJenisKelamin.getText().toString().equalsIgnoreCase("perempuan")){
                gender = "female";
            }else{
                gender = "male";
            }
            return true;
        }else{
            return false;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == this.request_code) {
            if (resultCode == Activity.RESULT_OK) {
                String result = data.getStringExtra("result");
                inputJenisKelamin.setText(result);
            }
        }
    }
}
