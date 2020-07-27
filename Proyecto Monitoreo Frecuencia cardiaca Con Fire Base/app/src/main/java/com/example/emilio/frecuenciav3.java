package com.example.emilio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.Random;

public class frecuenciav3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_frecuenciav3);
     // R.id.FrecuenciaBoton
        final Random myRandon = new Random();
        final TextView textGenerateNumber = (TextView) findViewById(R.id.FrecuenciaNumero);
        textGenerateNumber.setText(String.valueOf(myRandon.nextInt( 9)));
    }
}
