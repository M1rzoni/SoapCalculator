package com.example.rma_1_mirza_sabanovic;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ChooseSoapType extends AppCompatActivity {

    Spinner spinner;
    Spinner spinner2;
    Spinner spinner3;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_choose_soap_type);

        spinner = findViewById(R.id.spinner);
        spinner2 = findViewById(R.id.spinner2);
        spinner3 = findViewById(R.id.spinner3);
        button = findViewById(R.id.button2);

        ArrayAdapter<CharSequence>adapter= ArrayAdapter.createFromResource(this, R.array.soapType, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);

        ArrayAdapter<CharSequence>adapter2= ArrayAdapter.createFromResource(this, R.array.soapWeight, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);

        ArrayAdapter<CharSequence>adapter3= ArrayAdapter.createFromResource(this, R.array.superfattingLevel, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);

        spinner.setAdapter(adapter);
        spinner2.setAdapter(adapter2);
        spinner3.setAdapter(adapter3);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String chosenSoapType = spinner.getSelectedItem().toString();
                String chosenSoapWeight = spinner2.getSelectedItem().toString();
                String chosenSuperfattingLevel = spinner3.getSelectedItem().toString();

                Intent intent = new Intent(ChooseSoapType.this, CreateSoap.class);
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