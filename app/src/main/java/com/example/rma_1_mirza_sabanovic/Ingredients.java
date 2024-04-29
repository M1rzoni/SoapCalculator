package com.example.rma_1_mirza_sabanovic;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class Ingredients extends AppCompatActivity {

    Button button;

    int[] imageRes = {R.drawable.soap1, R.drawable.soap2};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingredients);

        button = findViewById(R.id.button3);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random = new Random();
                int randomIndex = random.nextInt(imageRes.length);
                int randomImageResource = imageRes[randomIndex];
                Intent intent = new Intent(Ingredients.this, CreateSplash.class);
                intent.putExtra("imageRes", randomImageResource); // Dodajte ovo
                startActivity(intent);
            }
        });

    }

    private String getHintText(EditText editText) {
        return editText.getHint().toString();
    }
}
