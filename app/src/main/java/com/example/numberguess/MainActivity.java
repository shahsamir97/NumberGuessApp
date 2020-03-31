package com.example.numberguess;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class MainActivity extends AppCompatActivity {


    EditText editText;
    TextView textView;
    Random random = new Random();
    int number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editText);
        textView = findViewById(R.id.textView3);
        number = random.nextInt(20);
    }

    public void guessFunction(View view) {
        //Toast.makeText(this, String.valueOf(number), Toast.LENGTH_SHORT).show();
        if (!TextUtils.isEmpty(editText.getText().toString())) {
            int guessedNumber = Integer.parseInt(editText.getText().toString());
            if (number == guessedNumber) {
                textView.setText("Congrats! Guessed Right.");
                number = random.nextInt(20);
            } else if (guessedNumber > number) {
                textView.setText("Lower");
            } else {
                textView.setText("Higher");
            }
            number = random.nextInt(20);
        }

        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

}
