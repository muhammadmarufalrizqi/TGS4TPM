package com.example.tugasnavbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    private BottomNavigationView bnvMain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bnvMain = findViewById(R.id.BNav);
        bnvMain.setOnNavigationItemSelectedListener(this);

    }
        private void setLayout(Fragment fragment){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fl,fragment)
                    .commit();
        }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.ItemHome:
                setLayout(new HomeFragment());
                return true;
            case R.id.ItemProfil:
                setLayout(new ProfilFragment());
                return true;
        }
        return false;
    }
}
