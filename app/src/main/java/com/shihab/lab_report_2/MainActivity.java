package com.shihab.lab_report_2;

import static android.widget.Toast.LENGTH_LONG;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText etName, etPass, etEmail;
    Button btnOk;
    LinearLayout btnReset;
    String name, pass, email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
        etPass = findViewById(R.id.etPass);
        etEmail = findViewById(R.id.etEmail);
        btnOk = findViewById(R.id.btnOk);
        btnReset = findViewById(R.id.btnReset);

        btnOk.setOnClickListener(view -> {

            name = etName.getText().toString();
            pass = etPass.getText().toString();
            email = etEmail.getText().toString();

            if (!name.isEmpty() && !pass.isEmpty() && name.equals("admin") && email.equals("admin@gmail.com") && pass.equals("pass")) {
                Toast.makeText(this, "Login successful!\nName: " + name + ", Email: " + email + ", Pass: " + pass, LENGTH_LONG).show();

                startActivity(new Intent(this, TemperatureActivity.class));


            } else Toast.makeText(this, "Invalid Credentials!", Toast.LENGTH_SHORT).show();

        });

        btnReset.setOnClickListener(view -> {

            name = etName.getText().toString();
            pass = etPass.getText().toString();
            email = etEmail.getText().toString();

            if (!name.isEmpty() || !pass.isEmpty() || !email.isEmpty()) {
                etName.getText().clear();
                etPass.getText().clear();
                etEmail.getText().clear();

                Toast.makeText(this, "Reset Done!", Toast.LENGTH_SHORT).show();
            }


        });

    }
}