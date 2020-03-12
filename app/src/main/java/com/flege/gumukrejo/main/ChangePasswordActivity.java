package com.flege.gumukrejo.main;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.flege.gumukrejo.R;
import com.flege.gumukrejo.model.DefaultResponse;
import com.flege.gumukrejo.rest.ApiClient;
import com.flege.gumukrejo.rest.ApiInterface;
import com.flege.gumukrejo.session.SessionManager;
import com.google.android.material.textfield.TextInputEditText;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChangePasswordActivity extends AppCompatActivity {
    Button btnChangePassword;
    TextInputEditText inputOldPassword, inputnewPassword, inputConfirmPassword;

    ApiInterface mApiInterface;
    SessionManager session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);

        btnChangePassword = findViewById(R.id.btnChangePassword);
        inputOldPassword = findViewById(R.id.inputOldPassword);
        inputnewPassword = findViewById(R.id.inputnewPassword);
        inputConfirmPassword = findViewById(R.id.inputConfirmPassword);

        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        session =  new SessionManager(ChangePasswordActivity.this);

        btnChangePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(inputOldPassword.getText().length() > 0 && inputnewPassword.getText().length() > 0 && inputnewPassword.getText().length() > 0){
                    if(inputnewPassword.getText().toString().equals(inputConfirmPassword.getText().toString())){
                        Call<DefaultResponse> change_password = mApiInterface.changePasswowd(
                                session.get_id_pelanggan(),
                                session.get_nik(),
                                inputOldPassword.getText().toString(),
                                inputnewPassword.getText().toString());
                        change_password.enqueue(new Callback<DefaultResponse>() {
                            @Override
                            public void onResponse(Call<DefaultResponse> call, Response<DefaultResponse> response) {
                                String message = response.body().getMessage();
                                Toast.makeText(ChangePasswordActivity.this,message,Toast.LENGTH_SHORT).show();
                                int code = response.body().getCode();
                                if(code == 200){
                                    finish();
                                }
                            }

                            @Override
                            public void onFailure(Call<DefaultResponse> call, Throwable t) {
                                Log.e("Retrofit Gets", t.toString());
                            }
                        });
                    }else{
                        Toast.makeText(ChangePasswordActivity.this,"Password baru tidak sama",Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(ChangePasswordActivity.this,"Form tidak boleh kosong",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
