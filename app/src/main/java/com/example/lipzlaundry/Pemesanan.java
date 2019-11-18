package com.example.lipzlaundry;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Pemesanan extends Activity {

    private ExpandableListView mExpandableListView;
    private ExpandListAdapter mAdapter;
    private List<String> mGroups;
    private HashMap<String, List<String>> mChilds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pemesanan);

        prepareData();
        mAdapter = new ExpandListAdapter(this, mGroups, mChilds);
        mExpandableListView = (ExpandableListView) findViewById(R.id.expand_listview3);

        mExpandableListView.setAdapter(mAdapter);
        mExpandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                switch (groupPosition) {
                    case 0:
                        switch (childPosition) {
                            case 0:
                                Toast.makeText(Pemesanan.this, "Satuan",
                                        Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(getApplicationContext(), PemesananSatuan.class));
                                break;
                            case 1:
                                Toast.makeText(Pemesanan.this, "Kiloan",
                                        Toast.LENGTH_SHORT).show();
                                break;
                            case 2:
                                Toast.makeText(Pemesanan.this, "Total",
                                        Toast.LENGTH_SHORT).show();
                                break;
                            default:
                                break;
                        }
                        break;
                    case 1:
                        switch (childPosition) {
                            case 0:
                                Toast.makeText(Pemesanan.this, "Satuan",
                                        Toast.LENGTH_SHORT).show();
                                break;
                            case 1:
                                Toast.makeText(Pemesanan.this, "Kiloan",
                                        Toast.LENGTH_SHORT).show();
                                break;
                            case 2:
                                Toast.makeText(Pemesanan.this, "Total",
                                        Toast.LENGTH_SHORT).show();
                                break;
                            default:
                                break;
                        }
                        break;
                    case 2:
                        switch (childPosition) {
                            case 0:
                                Toast.makeText(Pemesanan.this, "Satuan",
                                        Toast.LENGTH_SHORT).show();
                                break;
                            case 1:
                                Toast.makeText(Pemesanan.this, "Kiloan",
                                        Toast.LENGTH_SHORT).show();
                                break;
                            case 2:
                                Toast.makeText(Pemesanan.this, "Total",
                                        Toast.LENGTH_SHORT).show();
                                break;
                            default:
                                break;
                        }
                        break;
                    case 3:
                        switch (childPosition) {
                            case 0:
                                Toast.makeText(Pemesanan.this, "Satuan",
                                        Toast.LENGTH_SHORT).show();
                                break;
                            case 1:
                                Toast.makeText(Pemesanan.this, "Kiloan",
                                        Toast.LENGTH_SHORT).show();
                                break;
                            case 2:
                                Toast.makeText(Pemesanan.this, "Total",
                                        Toast.LENGTH_SHORT).show();
                                break;
                            default:
                                break;
                        }
                        break;
                    default:
                        break;
                }
                return false;
            }
        });
    }

    private void prepareData() {
        mGroups = new ArrayList<String>();
        mChilds = new HashMap<String, List<String>>();

        mGroups.add("Pakaian");
        mGroups.add("Kamar Tidur");
        mGroups.add("Aksesoris");

        List<String> menu = new ArrayList<String>();
        menu.add("Satuan");
        menu.add("Kiloan");
        menu.add("Total");

        mChilds.put(mGroups.get(0), menu);
        mChilds.put(mGroups.get(1), menu);
        mChilds.put(mGroups.get(2), menu);
    }

    public void pesan(View view) {
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
        finish();
    }
}