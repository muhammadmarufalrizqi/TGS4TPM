package com.example.tugasnavbar;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class HeroDetail extends AppCompatActivity {

    private ImageView gambar;
    private TextView nama, deskripsi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);


        nama = findViewById(R.id.detailNama);
        deskripsi = findViewById(R.id.detailDeskripsi);

        Bundle bundle = getIntent().getExtras();
        String nameHero = bundle.getString("nama");
        String deskripsiHero = bundle.getString("deskripsi");

        nama.setText(nameHero);
        deskripsi.setText(deskripsiHero);
    }
}
