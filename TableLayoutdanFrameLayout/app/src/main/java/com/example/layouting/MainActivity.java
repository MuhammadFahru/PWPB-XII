package com.example.layouting;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Menampilkan Table Layout
        // setContentView(R.layout.table_layout);

        // Menampilkan Frame Layout 1
         setContentView(R.layout.frame_layout1);

        // Menampilkan Frame Layout 2
        // setContentView(R.layout.frame_layout2);
    }
}