package com.example.lipzlaundry;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class PemesananSatuan extends AppCompatActivity {
    TextView mHasil,mTotalHarga;
    int hitung = 0;
    int total;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pemesanan_satuan);

        mHasil = (TextView)findViewById(R.id.hasil);
        mTotalHarga = (TextView)findViewById(R.id.total_harga);

    }

    public void tambah(View view) {
        hitung++;
        mHasil.setText(Integer.toString(hitung));
        total = hitung * 5000;
        mTotalHarga.setText(Integer.toString(total));

    }

    public void kurang(View view) {
        hitung--;
        if(hitung<0){
            hitung = 0;
        }
        mHasil.setText(Integer.toString(hitung));
        total = hitung * 5000;
        mTotalHarga.setText(Integer.toString(total));
    }
}
