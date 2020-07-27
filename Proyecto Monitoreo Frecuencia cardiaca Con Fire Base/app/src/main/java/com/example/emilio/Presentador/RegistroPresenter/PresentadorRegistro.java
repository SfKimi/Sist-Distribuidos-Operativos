package com.example.emilio.Presentador.RegistroPresenter;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.emilio.Vista.MenuView.VistaMenu;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;

import java.util.HashMap;
import java.util.Map;

public class PresentadorRegistro {
    private Context mContext;
    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;
    private String TAG = "PresentadorRegistro";

    public PresentadorRegistro(Context mContext, FirebaseAuth mAuth, DatabaseReference mDatabase) {
        this.mContext = mContext;
        this.mAuth = mAuth;
        this.mDatabase = mDatabase;

    }

    public void  signUpUser(final String email, final String password, final String Nombre,
                            final String Edad, final String Genero, final String numeroContacto,
                            final String emailContacto){
        final ProgressDialog dialog = new ProgressDialog(mContext);
        dialog.setMessage("Registrando Usuario");
        dialog.setCancelable(false);
        dialog.show();
        mAuth.createUserWithEmailAndPassword(email, password)
           .addOnCompleteListener( new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d(TAG, "createUserWithEmail:success");
                    dialog.dismiss();
                    Map<String,Object> creaeUsuario = new HashMap<>();
                    creaeUsuario.put("nombre",Nombre);
                    creaeUsuario.put("Edad",Edad);
                    creaeUsuario.put("Genero",Genero);
                    creaeUsuario.put("NumeroContacto",numeroContacto);
                    creaeUsuario.put("EmailContanto",emailContacto);
                    creaeUsuario.put("Email",email);
                    creaeUsuario.put("Password",password);

                    mDatabase.child("Usuario")
                            .child(task.getResult().getUser().getUid())
                            .updateChildren(creaeUsuario);
                    Intent intent = new Intent(mContext, VistaMenu.class);
                    mContext.startActivity(intent);

                } else {
                    dialog.dismiss();
                    // If sign in fails, display a message to the user.
                    Log.w(TAG, "createUserWithEmail:failure", task.getException());
                    Toast.makeText(mContext, "Authentication failed.",
                            Toast.LENGTH_SHORT).show();

                }

                // ...
            }
        });

    }
}
