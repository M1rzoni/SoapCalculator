package com.example.rma_1_mirza_sabanovic;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Result extends AppCompatActivity {

    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        btn = findViewById(R.id.button4);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Result.this, ChooseSoapType.class));
            }
        });

        String chosenSoapType = getIntent().getStringExtra("chosenSoapType");
        String chosenSoapWeight = getIntent().getStringExtra("chosenSoapWeight");
        String chosenSuperfattingLevel = getIntent().getStringExtra("chosenSuperfattingLevel");
        String userInput = getIntent().getStringExtra("userInput");
        String userInput2 = getIntent().getStringExtra("UserInput2");
        String inputValue = getIntent().getStringExtra("UserValue");
        String inputValue2 = getIntent().getStringExtra("UserValue2");

        int value1 = Integer.parseInt(inputValue);
        int value2 = Integer.parseInt(inputValue2);

        float sum = value1 + value2;

        float sumOfLye = (sum * 0.190f);
        String formatedLye = String.format("%.2f", sumOfLye);

        float gramsOfLiquid = (sum * 0.134f);
        String foramtedGr = String.format("%.2f", gramsOfLiquid);

        float totalSum = gramsOfLiquid + sumOfLye;

        String totalSumString = String.format("%.2f", totalSum);

        float total = sum + totalSum;

        String totalTotal = String.format("%.2f", total);

        TextView textView6 = findViewById(R.id.textView6);
        textView6.setText("a" + chosenSoapType + "nesto" + chosenSoapWeight  + "nesto"+ chosenSuperfattingLevel);

        TextView textView22 = findViewById(R.id.textView22);
        TextView textView23 = findViewById(R.id.textView23);
        TextView textView19 = findViewById(R.id.textView19);
        TextView textView20 = findViewById(R.id.textView20);
        TextView textView21 = findViewById(R.id.textView21);
        TextView textView14 = findViewById(R.id.textView14);
        TextView textView15 = findViewById(R.id.textView15);
        TextView textView16 = findViewById(R.id.textView16);
        TextView textView31 = findViewById(R.id.textView31);
        TextView textView32 = findViewById(R.id.textView32);
        TextView textView33 = findViewById(R.id.textView33);

        textView21.setText(String.format("%.2f", sum) + "g");
        textView14.setText(formatedLye);
        textView15.setText(foramtedGr);
        textView16.setText(totalSumString);
        textView31.setText(totalSumString);
        textView32.setText(String.format("%.2f", sum) + "g");
        textView33.setText(totalTotal);

        if (userInput != null) {
            textView22.setText(userInput);
        } else {
            textView22.setText("No user input available");
        }
        if (userInput2 != null) {
            textView23.setText(userInput2);
        } else {
            textView23.setText("No user input available");
        }
        if (inputValue != null) {
            textView19.setText(inputValue + "g");
        } else {
            textView19.setText("Empty no value");
        }
        if (inputValue2 != null) {
            textView20.setText(inputValue2 + "g");
        } else {
            textView20.setText("Empty!!");
        }

    }
}

