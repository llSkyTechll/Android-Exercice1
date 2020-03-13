package com.example.exercice1;

import androidx.annotation.ColorInt;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText inputNumber1;
    private EditText inputNumber2;
    private Button buttonTry;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputNumber1 = findViewById(R.id.editText_guessedNumber1);
        inputNumber2 = findViewById(R.id.editText_guessedNumber2);
        buttonTry    = findViewById(R.id.button_tryNumber);

        setListener();
    }

    private void setListener(){
        buttonTry.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                compare();
            }
        });
    }

    private void compare(){
        if ((TextUtils.isEmpty(inputNumber1.getText().toString()) == true) && (TextUtils.isEmpty(inputNumber2.getText().toString()) == true)) {
            int numberToCompare1 = Integer.parseInt(inputNumber1.getText().toString());
            int numberToCompare2 = Integer.parseInt(inputNumber2.getText().toString());

            if (numberToCompare1 > numberToCompare2) {
                showHint("Le premier nombre est plus grand");
                inputNumber1.setBackgroundColor(Color.parseColor("#00FF00"));
                inputNumber2.setBackgroundColor(0);
            } else if (numberToCompare1 < numberToCompare2) {
                showHint("Le deuxième nombre est plus grand");
                inputNumber1.setBackgroundColor(0);
                inputNumber2.setBackgroundColor(Color.parseColor("#00FF00"));
            } else {
                showHint("Les deux nombres sont égaux");
                inputNumber1.setBackgroundColor(0);
                inputNumber2.setBackgroundColor(0);
            }
        }
    }

    private void showHint(String hint){
        Toast.makeText(this, hint, Toast.LENGTH_SHORT).show();
    }
}
