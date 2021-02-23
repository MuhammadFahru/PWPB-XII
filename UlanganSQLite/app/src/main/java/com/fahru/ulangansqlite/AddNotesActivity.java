package com.fahru.ulangansqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddNotesActivity extends AppCompatActivity implements View.OnClickListener {

    // Widgets
    private Button addToDoBtn;
    private EditText subjectEditText;
    private EditText descriptionEditText;
    private DBManager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTitle("Add Record");
        setContentView(R.layout.activity_add_notes);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Tambah Data Notes");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        subjectEditText     = findViewById(R.id.subject_editetxt);
        descriptionEditText = findViewById(R.id.description_editetxt);
        addToDoBtn          = findViewById(R.id.add_record);

        dbManager = new DBManager(this);
        dbManager.open();
        addToDoBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.add_record :
                final String name = subjectEditText.getText().toString();
                final String desc = descriptionEditText.getText().toString();
                dbManager.insert(name,desc);
                Intent main = new Intent(AddNotesActivity.this, MainActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(main);
                break;
        }
    }

    @Override
    public boolean onSupportNavigateUp(){
        Intent goToMain =  new Intent(AddNotesActivity.this, MainActivity.class);
        startActivity(goToMain);
        finish();
        return true;
    }
}