package com.example.marek.bmicalculatorver1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText userInputWeight;
    private EditText userInputHeight;
    private EditText opinion;
    private Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userInputWeight = (EditText) findViewById(R.id.weightID);
        userInputHeight = (EditText) findViewById(R.id.heightID);
        opinion = (EditText) findViewById(R.id.opinionID);
        button = (Button) findViewById(R.id.buttonID);

        final View.OnClickListener ourOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opinion.setText("");
                Double weight = Double.parseDouble(userInputWeight.getText().toString());
                Double height = Double.parseDouble(userInputHeight.getText().toString());
                height = height / 100;
                Double bmi = weight / (height * height);
                String result = null;

                if (bmi < 18.5) {
                    result = ", you need to eat more!";
                } else if (bmi >= 18.5 && bmi <= 24.99) {
                    result = ", you doing good!";
                } else  {
                    result = ", you are to fat!";
                }
                opinion.append("Your BMI is: " + String.format("%.0f", bmi).toString() + result); //redundant code, needs change
            }
        };
        button.setOnClickListener(ourOnClickListener);
    }
}
