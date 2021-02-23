package com.fahru.ulangansqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ModifyNotesActivity extends AppCompatActivity implements View.OnClickListener {

    // Widgets
    private EditText titleText;
    private EditText descText;
    private Button updateBtn, deleteBtn;

    private long _id;
    private DBManager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setTitle("Edit Record");
        setContentView(R.layout.activity_modify_notes);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Detail Data Notes");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        dbManager = new DBManager(this);
        dbManager.open();

        titleText = findViewById(R.id.subject_editetxt);
        descText = findViewById(R.id.description_editetxt);

        updateBtn = findViewById(R.id.btn_update);
        deleteBtn = findViewById(R.id.btn_delete);

        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
        String name = intent.getStringExtra("title");
        String desc = intent.getStringExtra("desc");

        _id = Long.parseLong(id);
        titleText.setText(name);
        descText.setText(desc);
        updateBtn.setOnClickListener(this);
        deleteBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_update:
                String title = titleText.getText().toString();
                String desc = descText.getText().toString();
                dbManager.update(_id, title, desc);
                this.returnHome();
                break;

            case R.id.btn_delete:
                dbManager.delete(_id);
                this.returnHome();
                break;
        }
    }

    public void returnHome() {
        Intent home_intent = new Intent(getApplicationContext(), MainActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(home_intent);
    }

    @Override
    public boolean onSupportNavigateUp(){
        Intent goToMain =  new Intent(ModifyNotesActivity.this, MainActivity.class);
        startActivity(goToMain);
        finish();
        return true;
    }
}