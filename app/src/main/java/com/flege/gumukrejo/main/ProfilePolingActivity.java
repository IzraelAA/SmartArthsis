package com.flege.gumukrejo.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.TextViewCompat;

import android.content.Intent;
import android.widget.Button;
import android.widget.TextView;
import android.os.Bundle;

import com.flege.gumukrejo.R;

public class ProfilePolingActivity extends AppCompatActivity {
TextView name,nomer,lulusan,pekerjaan,visimisi;
String names,nomers,lulusans,pekerjaans,visimisis;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_poling);
        name = findViewById(R.id.name);
        nomer = findViewById(R.id.number);
        lulusan = findViewById(R.id.lulusan);
        pekerjaan = findViewById(R.id.pekerjaan);
        visimisi = findViewById(R.id.visimisi);
        Intent iin= getIntent();
        Bundle b = iin.getExtras();
        names = (String) b.get("Name");
        nomers = (String) b.get("Nomer");
        lulusans = (String) b.get("Lulusan");
        pekerjaans = (String) b.get("Pekerjaan");
        visimisis = (String) b.get("Visi Misi");
        name.setText("Nama :"+names);
        nomer.setText("Nomer :"+nomers);
        lulusan.setText("Lulusan :"+lulusans);
        pekerjaan.setText("Perkerjaan :"+pekerjaans);
        visimisi.setText("Visi Misi :"+visimisis);

    }
}
