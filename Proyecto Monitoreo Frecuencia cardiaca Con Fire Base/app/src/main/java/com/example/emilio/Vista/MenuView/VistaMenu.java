package com.example.emilio.Vista.MenuView;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.emilio.Cuarto;
import com.example.emilio.Presentador.MenuPresentador.PresentadorMenu;
import com.example.emilio.Primero;
import com.example.emilio.Quinto;
import com.example.emilio.R;
import com.example.emilio.Segundo;
import com.example.emilio.Sexto;
import com.example.emilio.Tercero;
import com.example.emilio.Vista.LoginView.VistaLogin;

public class VistaMenu extends AppCompatActivity implements View.OnClickListener {
    Button b1,b2,b3,b4,b5,b6,b7;
    private PresentadorMenu presentadorMenu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
         presentadorMenu = new PresentadorMenu(this);
         Button mb1 = findViewById(R.id.button1);
        mb1.setOnClickListener(this);
        Button mb2 = findViewById(R.id.button2);
        mb2.setOnClickListener(this);
        Button mb3 = findViewById(R.id.button3);
        mb3.setOnClickListener(this);
        Button mb4 = findViewById(R.id.button4);
        mb4.setOnClickListener(this);
        Button mb5 = findViewById(R.id.button5);
        mb5.setOnClickListener(this);
        Button mb6 = findViewById(R.id.button6);
        mb6.setOnClickListener(this);
        Button mb7 = findViewById(R.id.button7);
        mb7.setOnClickListener(this);
       /* b1 =(Button) findViewById(R.id.button1);
        b2 =(Button) findViewById(R.id.button2);
        b3 =(Button) findViewById(R.id.button3);
        b4 =(Button) findViewById(R.id.button4);
        b5 =(Button) findViewById(R.id.button5);
        b6 =(Button) findViewById(R.id.button6);
        b7 =(Button) findViewById(R.id.button7);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Menu.this, Primero.class);
                startActivity(i);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Menu.this, Segundo.class);
                startActivity(i);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Menu.this, Tercero.class);
                startActivity(i);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Menu.this, Cuarto.class);
                startActivity(i);
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Menu.this, Quinto.class);
                startActivity(i);
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Menu.this, Sexto.class);
                startActivity(i);
            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Menu.this, VistaLogin.class);
                startActivity(i);
            }
        });*/
    }

    @Override
    public void onClick(View v) {
        System.out.println("no salio de la  vista");
        switch (v.getId()) {
            case R.id.button1:

                presentadorMenu.Direccion(1);
                break;
            case R.id.button2:
                presentadorMenu.Direccion(2);
                break;
            case R.id.button3:
                presentadorMenu.Direccion(3);
                break;
            case R.id.button4:
                presentadorMenu.Direccion(4);
                break;
            case R.id.button5:
                presentadorMenu.Direccion(5);
                break;
            case R.id.button6:
                presentadorMenu.Direccion(6);
                break;
            case R.id.button7:
                presentadorMenu.Direccion(7);
                break;
        }
    }
}
