package com.flege.gumukrejo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

public class TopUpActivity extends AppCompatActivity {
    RadioGroup rgroup;
    Button btnNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_up);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Top Up");

        rgroup = findViewById(R.id.rgroup);
        btnNext = findViewById(R.id.btnNext);

        rgroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId != R.id.cash){
                    rgroup.check(0);
                    Toast.makeText(TopUpActivity.this,"Under Maintenance",Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (rgroup.getCheckedRadioButtonId()){
                    case R.id.cash:
                        Intent intent = new Intent(TopUpActivity.this, TopUpResponseActivity.class);
                        intent.putExtra("method","Cash");
                        startActivity(intent);
                        break;
                    default:
                        Toast.makeText(TopUpActivity.this,"Silahkan pilih metode pembayaran",Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
