package com.example.emilio.Vista.LoginView;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.emilio.Presentador.LoginPresentador.PresentadorLogin;
import com.example.emilio.R;
import com.example.emilio.Vista.RegistroView.VistaRegistro;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class VistaLogin extends AppCompatActivity implements View.OnClickListener {
    private EditText mcorreo;
    private EditText mContrasena;
    private PresentadorLogin presentadorLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FirebaseAuth mAuth = FirebaseAuth.getInstance();/////
        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
        presentadorLogin = new PresentadorLogin(this, mAuth, mDatabase);
        mcorreo = (EditText) findViewById(R.id.et_correo);
        mContrasena = (EditText) findViewById(R.id.et_contrasena);
        Button mIniciar_Sesion = findViewById(R.id.iniciar_sesion);
        mIniciar_Sesion.setOnClickListener(this);
        Button mBtnRegistrar = findViewById(R.id.btnRegistrar);
        mBtnRegistrar.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iniciar_sesion:
                String email = mcorreo.getText().toString().trim();
                String pass = mContrasena.getText().toString().trim();
                presentadorLogin.singInUser(email, pass);
                break;
            case R.id.btnRegistrar:
                 Intent inten = new Intent(VistaLogin.this, VistaRegistro.class);
                 startActivity(inten);
                break;
        }
    }
}
