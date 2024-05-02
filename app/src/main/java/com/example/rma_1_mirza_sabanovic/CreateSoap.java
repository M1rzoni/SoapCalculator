package com.example.rma_1_mirza_sabanovic;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.room.Room;

import java.util.List;

public class CreateSoap extends AppCompatActivity {

    Button btn;
    EditText editTextText;
    EditText editTextText2;
    EditText valueOfSoap;
    EditText valueOfSoap2;
    Button btn2;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_create_soap);



        btn = findViewById(R.id.button6);
        editTextText = findViewById(R.id.editTextText);
        editTextText2 = findViewById(R.id.editTextText2);
        valueOfSoap = findViewById(R.id.editTextNumberDecimal6);
        valueOfSoap2 = findViewById(R.id.editTextNumberDecimal18);
        btn2 = findViewById(R.id.button7);

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CreateSoap.this, Ingredients.class));
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userInput = editTextText.getText().toString();
                String userInput2 = editTextText2.getText().toString();
                String userValue = valueOfSoap.getText().toString();
                String userValue2 = valueOfSoap2.getText().toString();

                Intent intent = new Intent(CreateSoap.this, Result.class);
                intent.putExtra("userInput", userInput);
                intent.putExtra("UserInput2", userInput2);
                intent.putExtra("UserValue", userValue);
                intent.putExtra("UserValue2", userValue2);
                startActivity(intent);
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }


}