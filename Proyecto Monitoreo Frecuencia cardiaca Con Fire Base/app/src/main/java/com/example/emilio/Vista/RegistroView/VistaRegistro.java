package com.example.emilio.Vista.RegistroView;

import android.os.Bundle;

import com.example.emilio.Presentador.RegistroPresenter.PresentadorRegistro;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.emilio.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class VistaRegistro extends AppCompatActivity implements View.OnClickListener {
private EditText mEtxtNombre, mEtxtEdad, mEtxtGenero, mEtxtNumeroContacto, mEtxtEmailContancto, mEtxtEmail, mEtxtPassword;
private PresentadorRegistro presentadorRegistro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vista_registro);
        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
presentadorRegistro = new PresentadorRegistro(this,mAuth,mDatabase);
        mEtxtNombre = findViewById(R.id.etNombre);
        mEtxtGenero = findViewById(R.id.etGenero);
        mEtxtEdad = findViewById(R.id.etEdad);
        mEtxtNumeroContacto = findViewById(R.id.etNumeroContacto);
        mEtxtEmailContancto = findViewById(R.id.etEmailContacto);
        mEtxtEmail = findViewById(R.id.etEmail);
        mEtxtPassword = findViewById(R.id.etPassword);
        Button mRegisterBtn = findViewById(R.id.btnRegistrarUsuario);
        mRegisterBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
switch (v.getId()){
    case R.id.btnRegistrarUsuario:

        String nombre = mEtxtNombre.getText().toString().trim();
        String genero = mEtxtGenero.getText().toString().trim();
        String edad = mEtxtEdad.getText().toString().trim();
        String numerocontacto = mEtxtNumeroContacto.getText().toString().trim() ;
        String emailcontacto = mEtxtEmailContancto.getText().toString().trim();
        String email = mEtxtEmail.getText().toString().trim();
        String password = mEtxtPassword.getText().toString().trim();
        presentadorRegistro.signUpUser(email,password,nombre,edad,genero,numerocontacto,emailcontacto);
        break;

}

    }
}
