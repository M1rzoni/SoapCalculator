package com.example.rma_1_mirza_sabanovic;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Result extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_result);

        String chosenSoapType = getIntent().getStringExtra("chosenSoapType");
        String chosenSoapWeight = getIntent().getStringExtra("chosenSoapWeight");
        String chosenSuperfattingLevel = getIntent().getStringExtra("chosenSuperfattingLevel");

        TextView textView6 = findViewById(R.id.textView6);
        textView6.setText("A " + chosenSoapType + " soap, measured in " + chosenSoapWeight + " with superfatting level of " + chosenSuperfattingLevel);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }


}
