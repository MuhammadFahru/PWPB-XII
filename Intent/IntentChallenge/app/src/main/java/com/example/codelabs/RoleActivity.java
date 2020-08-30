package com.example.codelabs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RoleActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_role);
        getSupportActionBar().hide();

        Button staff = (Button) findViewById(R.id.staff);
        staff.setOnClickListener(this);
        Button guest = (Button) findViewById(R.id.guest);
        guest.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.staff:
                Intent staff = new Intent (RoleActivity.this, StaffActivity.class);
                startActivity(staff);
                break;
            case R.id.guest:
                Intent guest = new Intent (RoleActivity.this, GuestActivity.class);
                startActivity(guest);
                break;
            default:
                break;
        }
    }

}