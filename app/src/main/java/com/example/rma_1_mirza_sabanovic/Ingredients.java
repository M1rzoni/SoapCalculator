package com.example.rma_1_mirza_sabanovic;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Ingredients extends AppCompatActivity {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingredients);

        button = findViewById(R.id.button3);

        EditText editText1 = findViewById(R.id.editTextNumberDecimal);
        EditText editText2 = findViewById(R.id.editTextNumberDecimal2);

        String hintEditText1 = getHintText(editText1);
        String hintEditText2 = getHintText(editText2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String arganOil = editText1.getText().toString();
                String neemOil = editText2.getText().toString();

                Intent intent = new Intent(Ingredients.this, Result.class);
                intent.putExtra("arganOil", arganOil);
                intent.putExtra("neemOil", neemOil);
                intent.putExtra("hintEditText1", hintEditText1);
                intent.putExtra("hintEditText2", hintEditText2);
                startActivity(intent);
            }
        });

    }

    private String getHintText(EditText editText) {
        return editText.getHint().toString();
    }
}
