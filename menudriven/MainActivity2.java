package com.example.menu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    EditText inputNumber, resultView;
    Button calculateBtn, exitBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        inputNumber = findViewById(R.id.editTextText);
        resultView = findViewById(R.id.editTextText3);
        calculateBtn = findViewById(R.id.button);
        exitBtn = findViewById(R.id.button2);

        calculateBtn.setOnClickListener(v -> {
            String inputStr = inputNumber.getText().toString();
            if (!inputStr.isEmpty()) {
                int num = Integer.parseInt(inputStr);
                if (isArmstrong(num)) {
                    resultView.setText(num + " is an Armstrong number.");
                } else {
                    resultView.setText(num + " is NOT an Armstrong number.");
                }
            } else {
                resultView.setText("Please enter a number.");
            }
        });

        exitBtn.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity2.this, MainActivity.class);
            startActivity(intent);
            finish();
        });
    }

    private boolean isArmstrong(int number) {
        int original = number;
        int result = 0;
        int digits = String.valueOf(number).length();

        while (number > 0) {
            int digit = number % 10;
            result += Math.pow(digit, digits);
            number /= 10;
        }

        return result == original;
    }
}
