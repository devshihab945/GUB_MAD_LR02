package com.shihab.lab_report_1;

import static android.view.View.VISIBLE;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class TemperatureActivity extends AppCompatActivity {

    TextInputEditText tidCelcius;
    Button btnConvert, btnConvertFTOC, btnBack;
    String degree;
    TextView tvResult;
    double resultFahrenheit;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temparature);

        tidCelcius = findViewById(R.id.tidCelcius);
        btnConvert = findViewById(R.id.btnConvert);
        tvResult = findViewById(R.id.tvResult);
        btnBack = findViewById(R.id.btnBack);
        btnConvertFTOC = findViewById(R.id.btnConvertFTOC);

        btnBack.setOnClickListener(view -> {
            finish();
        });

        btnConvert.setOnClickListener(view -> {

            degree = tidCelcius.getText().toString();

            if (!degree.isEmpty()) {
                double temp = Double.parseDouble(degree);
                resultFahrenheit = (temp * 1.8) + 32;

                tvResult.setVisibility(VISIBLE);
                tvResult.setText("Result: " + resultFahrenheit + "F");
                Toast.makeText(this, "Convert Successful!", Toast.LENGTH_SHORT).show();
            }


        });

        btnConvertFTOC.setOnClickListener(view -> {

            if (resultFahrenheit > 0) {

                double result = (resultFahrenheit - 32) / 1.8;

                tvResult.setVisibility(View.VISIBLE);
                tvResult.setText("Result: " + result + "°C");
                Toast.makeText(this, "Conversion Successful!", Toast.LENGTH_SHORT).show();

            } else Toast.makeText(this, "Please convert first!", Toast.LENGTH_SHORT).show();

        });


    }
}