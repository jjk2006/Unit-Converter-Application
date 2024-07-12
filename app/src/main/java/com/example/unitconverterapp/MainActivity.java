package com.example.unitconverterapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText inputValue;
    private Spinner fromUnit;
    private Spinner toUnit;
    private Button convertButton;
    private TextView resultText;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputValue = findViewById(R.id.i1);
        fromUnit = findViewById(R.id.i2);
        toUnit = findViewById(R.id.i3);
        convertButton = findViewById(R.id.i4);
        resultText = findViewById(R.id.i5);

        String[] units = {"Meters", "Kilometers", "Miles", "cm", "mm"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, units);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        fromUnit.setAdapter(adapter);
        toUnit.setAdapter(adapter);

        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertUnits();
            }
        });
    }

    private void convertUnits() {
        double input = Double.parseDouble(inputValue.getText().toString());
        String from = fromUnit.getSelectedItem().toString();
        String to = toUnit.getSelectedItem().toString();

        double result = 0.0;

        switch (from) {
            case "Meters":
                switch (to) {
                    case "cm":
                        result = input*100;
                        break;
                    case "mm":
                        result = input*1000;
                        break;
                    case "Kilometers":
                        result = input / 1000;
                        break;
                    case "Miles":
                        result = input / 1609.34;
                        break;
                    case "Meters":
                        result = input;
                        break;
                }
                resultText.setText(String.valueOf(result));
                break;
            case "Kilometers":
                switch (to) {
                    case "Meters":
                        break;
                    case "cm":
                        result = input * 100000;
                        break;
                    case "mm":
                        result = input * 1000000;
                        break;
                    case "Kilometers":
                        result = input;
                        break;
                    case "Miles":
                        result = input / 1.60934;
                        break;
                }
                resultText.setText(String.valueOf(result));
                break;
            case "Miles":
                switch (to) {
                    case "Meters":
                        result = input * 1609.34;
                        break;
                    case "Kilometers":
                        result = input * 1.60934;
                        break;
                    case "cm":
                        result = input * 160934.4;
                        break;
                    case "mm":
                        result = input * 1609344;
                        break;
                    case "Miles":
                        result = input;
                        break;
                }
                resultText.setText(String.valueOf(result));
                break;
            case "cm":
                switch (to) {
                    case "Meters":
                        result = input * 1609.34;
                        break;
                    case "Kilometers":
                        result = input * 1.60934;
                        break;
                    case "Miles":
                        result = input * 1.60934;
                        break;
                    case "mm":
                        result = input * 10;
                        break;
                    case "cm":
                        result = input;
                        break;
                }
                resultText.setText(String.valueOf(result));
                break;
            case "mm":
                switch (to){
                    case "Meters":
                        result = input * 1609.34;
                        break;
                    case "Kilometers":
                        result = input * 1.60934;
                        break;
                    case "Miles":
                        result = input * 1.60934;
                        break;
                    case "mm" :
                        result = input;
                        break;
                    case "cm":
                        result = input * 160934.4;
                        break;

                }
                resultText.setText(String.valueOf(result));
        }
        Toast.makeText(this, "Successfully converted", Toast.LENGTH_SHORT).show();
    }}