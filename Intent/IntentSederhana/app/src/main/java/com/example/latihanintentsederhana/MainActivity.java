package com.example.latihanintentsederhana;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.net.Uri;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Button explicitintent;
        Button implicitintent;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        explicitintent = (Button) findViewById(R.id.explicitintent);
        explicitintent.setOnClickListener(this);
        implicitintent = (Button) findViewById(R.id.implicitintent);
        implicitintent.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.explicitintent:
                Intent explicit = new Intent (MainActivity.this, IntentActivity.class);
                startActivity(explicit);
                break;
            case R.id.implicitintent:
                Intent implicit = new Intent (Intent.ACTION_VIEW, Uri.parse("http://www.w3school.com"));
                startActivity(implicit);
                break;
            default:
                break;
        }
    }
}