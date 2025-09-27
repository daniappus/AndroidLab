package com.example.menu;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity3 extends AppCompatActivity {

    EditText inputNumber, resultView;
    Button calculateBtn, exitBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        inputNumber = findViewById(R.id.editTextText2);
        resultView = findViewById(R.id.editTextText4);
        calculateBtn = findViewById(R.id.button3);
        exitBtn = findViewById(R.id.button4);

        calculateBtn.setOnClickListener(v -> {
            String inputStr = inputNumber.getText().toString();

            if (!inputStr.isEmpty()) {
                int num = Integer.parseInt(inputStr);
                int original = num;
                int reversed = 0;

                while (num > 0) {
                    int digit = num % 10;
                    reversed = reversed * 10 + digit;
                    num = num / 10;
                }

                if (original == reversed) {
                    resultView.setText(original + " is a Palindrome number.");
                } else {
                    resultView.setText(original + " is NOT a Palindrome number.");
                }
            } else {
                resultView.setText("Please enter a number.");
            }
        });

        exitBtn.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity3.this, MainActivity.class);
            startActivity(intent);
            finish();
        });
    }
}
