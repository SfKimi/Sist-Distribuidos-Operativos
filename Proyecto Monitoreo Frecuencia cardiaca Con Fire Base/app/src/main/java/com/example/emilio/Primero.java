package com.example.emilio;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.emilio.Modelo.UserModel;
import com.example.emilio.Vista.MenuView.VistaMenu;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Primero extends AppCompatActivity {
    ////////////////////////////*********************////////////////////////**************///////////////////////////////////////////////*********************////////////////////////**************///////////////////
    private Button salir;
    private TextView t1;
    private TextView t2;
    private int a = 0;
    boolean b = true;
    int c = 0;
    int AlertaF = 0;
    boolean AlertaB = false;

    String Alerta = "";
    DatabaseReference mRootRefence;

////////////////////////////*********************////////////////////////**************///////////////////////////////////////////////*********************////////////////////////**************///////////////////
Context mContext;
DatabaseReference mDatabase;
//FirebaseDatabase mAutch;
private  FirebaseAuth mAuth;
    DatabaseReference Referencia_Base = FirebaseDatabase.getInstance().getReference();
    DatabaseReference Documento_Child = Referencia_Base.child("NumeroContacto");





    ////////////////////////////*********************////////////////////////**************///////////////////////////////////////////////*********************////////////////////////**************///////////////////
    private Handler mHandler = new Handler();
    ////////////////////////////*********************////////////////////////**************///////////////////////////////////////////////*********************////////////////////////**************///////////////////
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.primero);
        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();

        welcomeMessage();

        ////////////////////////////*********************////////////////////////**************///////////////////////////////////////////////*********************////////////////////////**************///////////////////
        t1 = findViewById(R.id.Frecuencia);
        salir = (Button) findViewById(R.id.Salir);
        final Random myRandon = new Random();
        final TextView textGenerateNumber = (TextView) findViewById(R.id.Frecuencia);
        mRootRefence = FirebaseDatabase.getInstance().getReference();
        ////////////////////////////*********************////////////////////////**************///////////////////////////////////////////////*********************////////////////////////**************///////////////////



        ////////////////////////////*********************////////////////////////**************///////////////////////////////////////////////*********************////////////////////////**************///////////////////
        Thread logo = new Thread() {
            public void run() {
                while (b == true) {
                    try {
                        int tiempo = 0;
                        while (tiempo < 5000) {
                            sleep(100);
                            tiempo = tiempo + 100;
                        }
                        //textGenerateNumber.setText(String.valueOf(myRandon.nextInt( 50)+55));
                        textGenerateNumber.setText(String.valueOf(random()));
                        System.out.println("frecuencia " + t1.getText().toString());
                        int lol = Integer.parseInt(t1.getText().toString());
                        if (lol > 200 || lol < 100) {
                            System.out.println("ALERTA frecuencia" + t1.getText().toString());
                            Alerta = "ALERTA Frecuencia Peligro Usuario p@gmail.com : -->" + t1.getText().toString();
                            // Carga();
                            //SendMail();

                            enviarMensaje("3164049909",Alerta);

                            b = false;
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        logo.start();
        ////////////////////////////*********************////////////////////////**************///////////////////////////////////////////////*********************////////////////////////**************///////////////////


        ////////////////////////////*********************////////////////////////**************///////////////////////////////////////////////*********************////////////////////////**************///////////////////
        if (ActivityCompat.checkSelfPermission(Primero.this, Manifest.permission.SEND_SMS)
                != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(Primero.this, Manifest.permission.SEND_SMS)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(Primero.this, new String[]
                    {Manifest.permission.SEND_SMS,}, 1000);

        } else {

        }
        ;
        ////////////////////////////*********************////////////////////////**************///////////////////////////////////////////////*********************////////////////////////**************///////////////////



        ////////////////////////////*********************////////////////////////**************///////////////////////////////////////////////*********************////////////////////////**************///////////////////
        salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Carga();
                SendMail();

                Intent i = new Intent(Primero.this, VistaMenu.class);
                startActivity(i);
            }
        });
        ////////////////////////////*********************////////////////////////**************///////////////////////////////////////////////*********************////////////////////////**************///////////////////



    }

    ////////////////////////////*********************////////////////////////**************///////////////////////////////////////////////*********************////////////////////////**************///////////////////
    private void Carga() {
        String Correo = "p@gmail.com";
        int FRT = Integer.parseInt(t1.getText().toString());
         cargarFrecuencia(FRT);
        /*Map<String, Object> datosUsuario = new HashMap<>();
        datosUsuario.put("correo", Correo);
        datosUsuario.put("Frecuencia", FRT);

        mRootRefence.child("Usuario").push().setValue(datosUsuario);*/
        //8:30----36:30
    }
    ////////////////////////////*********************////////////////////////**************///////////////////////////////////////////////*********************////////////////////////**************///////////////////

    ////////////////////////////*********************////////////////////////**************///////////////////////////////////////////////*********************////////////////////////**************///////////////////
    private void SendMail() {
        UserModel userModel1 = new UserModel();

        //String mail = mEmail.getText().toString().trim();
        // MainActivity mainActivity = new MainActivity();
        //+t1.getText().toString().trim()
        int mas = Integer.parseInt(t1.getText().toString());
        // System.out.println(correoIni);
       String mail = "sofiacatwi@gmail.com";

        String message = "Frecuencia es: " + mas;
        String subject = "ALERTA FRCUENCIA DE CUENTA: p@gmail.com ";

        JavaMailAPI javaMailAPI = new JavaMailAPI(this, mail, subject, message);
        javaMailAPI.execute();
    }
    ////////////////////////////*********************////////////////////////**************///////////////////////////////////////////////*********************////////////////////////**************///////////////////

    ////////////////////////////*********************////////////////////////**************///////////////////////////////////////////////*********************////////////////////////**************///////////////////
    public int random() {

        int ritmo = (int) Math.floor(Math.random() * 220 + 80);

        return ritmo;
    }
    ////////////////////////////*********************////////////////////////**************///////////////////////////////////////////////*********************////////////////////////**************///////////////////


    ////////////////////////////*********************////////////////////////**************///////////////////////////////////////////////*********************////////////////////////**************///////////////////
    private void enviarMensaje(String numero, String mensaje) {
        try {
            SmsManager sms = SmsManager.getDefault();
            sms.sendTextMessage(numero, null, mensaje, null, null);
            // Toast.makeText(getApplicationContext(),"mensaje enviado",Toast.LENGTH_LONG).show();

        } catch (Exception e) {

            //  Toast.makeText(getApplicationContext(),"mensaje no enviado, Datos Incorrectos",Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }

    }
    ////////////////////////////*********************////////////////////////**************///////////////////////////////////////////////*********************////////////////////////**************///////////////////

    public void welcomeMessage(){

       mDatabase.child("Usuario")
               .child(mAuth.getCurrentUser().getUid())
               .addListenerForSingleValueEvent(new ValueEventListener() {
           @Override
           public void onDataChange(DataSnapshot dataSnapshot) {
               UserModel userModel = dataSnapshot.getValue(UserModel.class);
              // Toast.makeText(Primero.this, "Bienvenido: "+dataSnapshot.child("EmailContanto").getValue(), Toast.LENGTH_SHORT).show();
               Toast.makeText(Primero.this, "Bienvenido: "+ userModel.getNombre(), Toast.LENGTH_SHORT).show();
           }

           @Override
           public void onCancelled(DatabaseError databaseError) {

           }
       });
    }



    public  void  cargarFrecuencia(int Frecuencia2){

        int frecuencia= Frecuencia2;
        Map<String,Object> frecuencias = new HashMap<>();
        frecuencias.put("FrecuenciaMonitoreada", frecuencia);
        mDatabase.child("Usuario")
                .child(mAuth.getCurrentUser().getUid())
                .child("Frecuencia")
                .updateChildren(frecuencias);
    }







}
