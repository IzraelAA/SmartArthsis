package com.flege.gumukrejo.main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.flege.gumukrejo.R;

public class PollingActivity extends AppCompatActivity {
Button pilih1,pilih2,profil1,profil2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_polling);
        pilih1 = findViewById(R.id.pilih1);
        pilih2 = findViewById(R.id.pilih2);
        profil1 = findViewById(R.id.profil1);
        profil2 = findViewById(R.id.profil12);
        pilih2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(PollingActivity.this, "Under Miantance", Toast.LENGTH_SHORT).show();
            }
        });
        pilih1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(PollingActivity.this, "Under Miantance", Toast.LENGTH_SHORT).show();
            }
        });
        profil1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(PollingActivity.this,ProfilePolingActivity.class);
                i.putExtra("Name","Panca Adnan Andrian");
                i.putExtra("Nomer","1");
                i.putExtra("Lulusan","ITB");
                i.putExtra("Pekerjaan","Android Developer");
                i.putExtra("Visi Misi","Membangun susana bertetangga yang elegan dan berteknologi tinggi");
                startActivity(i);
            }
        });
        profil2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(PollingActivity.this,ProfilePolingActivity.class);
                i.putExtra("Name","Izrael Adnan Assegaf");
                i.putExtra("Nomer","2");
                i.putExtra("Lulusan","SMA NEGERI 1 SUMBERREJO");
                i.putExtra("Pekerjaan","Bertani");
                i.putExtra("Visi Misi","Bergotong royong dalam meningkatkan hasil Panen");
                startActivity(i);
            }
        });
    }
}
