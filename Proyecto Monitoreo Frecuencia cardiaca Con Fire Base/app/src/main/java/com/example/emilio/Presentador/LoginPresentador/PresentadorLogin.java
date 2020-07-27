package com.example.emilio.Presentador.LoginPresentador;

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

public class PresentadorLogin {
    private Context mContext;
    private String TAG = "PresentadorLogin";
    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;

    public PresentadorLogin(Context mContext, FirebaseAuth mAuth, DatabaseReference mDatabase) {
        this.mContext = mContext;

        this.mAuth = mAuth;
        this.mDatabase = mDatabase;
    }

    public void singInUser(String email, String password) {

        final ProgressDialog dialog = new ProgressDialog(mContext);
        dialog.setMessage("Ingresando...");
        dialog.setCancelable(false);
        dialog.show();
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithEmail: Exitoso");
                            dialog.dismiss();
                            mDatabase.child("Usuario")
                                    .child(task.getResult().getUser().getUid())
                                    .child("Titulo").setValue("Chokolate");
                            Intent intent = new Intent(mContext, VistaMenu.class);
                            mContext.startActivity(intent);
                        } else {
                            dialog.dismiss();
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithEmail:failure", task.getException());
                            Toast.makeText(mContext, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();

                        }

                        // ...
                    }
                });

    }
}
