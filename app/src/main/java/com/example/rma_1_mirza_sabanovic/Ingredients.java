package com.example.rma_1_mirza_sabanovic;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Ingredients extends AppCompatActivity {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ingredients);

        button = findViewById(R.id.button3);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Dohvatanje vrijednosti iz ChooseSoapType
                String chosenSoapType = getIntent().getStringExtra("chosenSoapType");
                String chosenSoapWeight = getIntent().getStringExtra("chosenSoapWeight");
                String chosenSuperfattingLevel = getIntent().getStringExtra("chosenSuperfattingLevel");

                Intent intent = new Intent(Ingredients.this, Result.class);
                intent.putExtra("chosenSoapType", chosenSoapType);
                intent.putExtra("chosenSoapWeight", chosenSoapWeight);
                intent.putExtra("chosenSuperfattingLevel", chosenSuperfattingLevel);
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