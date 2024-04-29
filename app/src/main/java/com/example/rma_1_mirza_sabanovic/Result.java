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
        String hintEditText1 = getIntent().getStringExtra("hintEditText1");
        String hintEditText2 = getIntent().getStringExtra("hintEditText2");
        String arganOil = getIntent().getStringExtra("arganOil");
        String neemOil = getIntent().getStringExtra("neemOil");

        TextView textView6 = findViewById(R.id.textView6);
        textView6.setText("A " + chosenSoapType + " soap, measured in " + chosenSoapWeight + " with superfatting level of " + chosenSuperfattingLevel);

        TextView textView19 = findViewById(R.id.textView19);
        TextView textView20 = findViewById(R.id.textView20);

        textView19.setText(arganOil.isEmpty() ? hintEditText1 : arganOil);
        textView20.setText(neemOil.isEmpty() ? hintEditText2 : neemOil);
    }
}
