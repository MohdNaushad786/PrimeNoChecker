package com.example.primenochecker;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private Button checkBtn;
    private TextView answerTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.enter_prime_number_editText);
        checkBtn = findViewById(R.id.prime_number_check_btn);
        answerTextView = findViewById(R.id.prime_number_answer_textView);

        checkBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (isPrimeNo()){
                    answerTextView.setText(editText.getText().toString() + " is a Prime Number");
                    answerTextView.setTextColor(Color.GREEN);
                }else {

                    answerTextView.setText(editText.getText().toString() + " is not a Prime Number");
                    answerTextView.setTextColor(Color.RED);

                }
            }
        });

    }

    private boolean isPrimeNo() {

        if (editText.getText().toString().equals("1")) {
            return false;
        } else if (editText.getText().toString().equals("2")) {
            return true;

        } else if (editText.getText().toString().equals("3")) {
            return true;

        } else {
            return check();
        }
    }

    private boolean check() {

        String number = editText.getText().toString();
        double num = Double.parseDouble(number);

        double a = 1;
        double b = 6;

        double resultA = (num + a) / b;
        double resultB = (num - a) / b;

        String answerA = String.valueOf(resultA);
        String answerB = String.valueOf(resultB);

        if (answerA.contains(".0")) {
            answerA = answerA.replaceAll(".0", "");
        }

        if (answerB.contains(".0")) {
            answerB = answerB.replaceAll(".0", "");
        }

        return !answerA.contains(".") || !answerB.contains(".");

    }
}
