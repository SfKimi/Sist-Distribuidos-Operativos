package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class URL extends AppCompatActivity {
    public static final String IP = "10.0.2.2";
    public static final String sitio = "proyecto";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.url);
    }
}