package com.example.jumlahbilangan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edtBilangan1;
    private EditText edtBilangan2;
    private EditText edtHasil;
    private Button btnCalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtBilangan1 =findViewById(R.id.bilangan1);
        edtBilangan2 =findViewById(R.id.bilangan2);
        edtHasil =findViewById(R.id.hasil);
        btnCalculate = findViewById(R.id.btn_calculate);

        btnCalculate.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btn_calculate) {
            String inputBilangan1 = edtBilangan1.getText().toString().trim();
            String inputBilangan2 = edtBilangan2.getText().toString().trim();

            boolean isEmptyFields = false;

            if (TextUtils.isEmpty(inputBilangan1)) {
                isEmptyFields = true;
                edtBilangan1.setError("Field ini tidak boleh kosong");
            }
            if (TextUtils.isEmpty(inputBilangan2)) {
                isEmptyFields = true;
                edtBilangan2.setError("Field ini tidak boleh kosong");
            }
            if (!isEmptyFields) {
                double jumlah = Double.valueOf(inputBilangan1) + Double.valueOf(inputBilangan2);
                edtHasil.setText(String.valueOf(jumlah));
            }
        }
    }

}