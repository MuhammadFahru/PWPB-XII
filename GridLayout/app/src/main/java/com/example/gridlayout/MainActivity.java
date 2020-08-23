package com.example.gridlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Menampilkan Grid Layout
        // setContentView(R.layout.grid_layout);

        // Menampilkan Latihan Grid
        setContentView(R.layout.latihan_grid);
    }
}