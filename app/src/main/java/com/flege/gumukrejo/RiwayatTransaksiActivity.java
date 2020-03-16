package com.flege.gumukrejo;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.flege.gumukrejo.adapter.RiwayatTransaksiAdapter;
import com.flege.gumukrejo.dataclass.RiwayatTransaksi;

import java.util.ArrayList;

public class RiwayatTransaksiActivity extends AppCompatActivity {
    ListView lv_history;
    ArrayList<RiwayatTransaksi> list_riwayat_transaksi = new ArrayList<>();
    private static RiwayatTransaksiAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_riwayat_transaksi);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Riwayat Transaksi");
        lv_history = findViewById(R.id.lv_history);
        list_riwayat_transaksi.add(new RiwayatTransaksi("Pembelian Saldo Air Sebesar Rp20.000","OnProgress","26-02-2020"));
        list_riwayat_transaksi.add(new RiwayatTransaksi("Pembelian Saldo Air Sebesar Rp15.000","Berhasil","23-02-2020"));
        list_riwayat_transaksi.add(new RiwayatTransaksi("Pembelian Saldo Air Sebesar Rp25.000","Berhasil","20-02-2020"));
        list_riwayat_transaksi.add(new RiwayatTransaksi("Pembelian Saldo Air Sebesar Rp5.000","Batal","15-02-2020"));
        list_riwayat_transaksi.add(new RiwayatTransaksi("Pembelian Saldo Air Sebesar Rp10.000","Berhasil","15-02-2020"));

        adapter = new RiwayatTransaksiAdapter(list_riwayat_transaksi,getApplicationContext());

        lv_history.setAdapter(adapter);
        lv_history.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
