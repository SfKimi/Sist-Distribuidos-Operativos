package com.example.emilio;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.emilio.Vista.MenuView.VistaMenu;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Cuarto extends AppCompatActivity {
    private Button salir;
    private TextView t1;
    private TextView t2;
    private int a= 0;
    boolean b=true;
    int c=0;
    int AlertaF=0;
    boolean AlertaB=false;
    String Alerta="";
    DatabaseReference mRootRefence;


    private Handler mHandler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.primero);
        t1=findViewById(R.id.Frecuencia);
        salir=(Button)findViewById(R.id.Salir);
        final Random myRandon = new Random();
        final TextView textGenerateNumber = (TextView) findViewById(R.id.Frecuencia);

        mRootRefence = FirebaseDatabase.getInstance().getReference();


        //SendMail();
        Thread logo = new Thread(){
            public void run(){
                while(b==true){
                    try{
                        //////////////que es//////////
                        int tiempo=0;
                        while(tiempo<5000){
                            sleep(100);
                            tiempo=tiempo+100;
                        }
                        ///////////////////////////////////
                        //textGenerateNumber.setText(String.valueOf(myRandon.nextInt( 50)+55));
                        textGenerateNumber.setText(String.valueOf(random()));
                        System.out.println("frecuencia "+t1.getText().toString());
                        int lol =Integer.parseInt(t1.getText().toString());

                        if(lol>165 || lol<83){
                            System.out.println("ALERTA frecuencia"+t1.getText().toString());
                            Alerta = "ALERTA Frecuencia Peligro Usuario p@gmail.com : -->"+t1.getText().toString();
                            // Carga();
                            //SendMail();
                            enviarMensaje("3102965408",Alerta);
                            b=false;
                        }
                    }
                    catch(InterruptedException e){
                        e.printStackTrace();
                    }
                    ////////////suma iteracion de while/////

                }
            }
        };
        logo.start();
        ///////////////////////////////////////////////////////////////////////////////////////////////
        if (ActivityCompat.checkSelfPermission(Cuarto.this, Manifest.permission.SEND_SMS)
                != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(Cuarto.this, Manifest.permission.SEND_SMS)
                != PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(Cuarto.this, new String[]
                    {Manifest.permission.SEND_SMS,}, 1000);

        }
        else{

        };

////////////////////////////////////////////////////////////////////////////////////////////
        salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(Cuarto.this, VistaMenu.class);
                startActivity(i);
            }
        });
    }

    private void Carga() {
        String Correo = "p@gmail.com";
        int FRT = Integer.parseInt(t1.getText().toString());
        Map<String, Object> datosUsuario = new HashMap<>();
        datosUsuario.put("correo",Correo);
        datosUsuario.put("Frecuencia",FRT);
        mRootRefence.child("Usuario").push().setValue(datosUsuario);
    }


    private void SendMail() {
        //String mail = mEmail.getText().toString().trim();
        // MainActivity mainActivity = new MainActivity();
        //+t1.getText().toString().trim()
        int mas= Integer.parseInt(t1.getText().toString());
        // System.out.println(correoIni);
        String mail ="sofiacatwi@gmail.com";
        String message="Frecuencia es: "+ mas ;
        String subject="ALERTA FRCUENCIA DE CUENTA: p@gmail.com ";

        JavaMailAPI javaMailAPI = new JavaMailAPI(this,mail,subject,message);
        javaMailAPI.execute();
    }


    public int random(){

        int ritmo = (int) Math.floor(Math.random()*185+63);

        return ritmo;
    }


    private void enviarMensaje(String numero, String mensaje){
        try {
            SmsManager sms = SmsManager.getDefault();
            sms.sendTextMessage(numero,null,mensaje,null,null);
            // Toast.makeText(getApplicationContext(),"mensaje enviado",Toast.LENGTH_LONG).show();

        }catch (Exception e){

            //  Toast.makeText(getApplicationContext(),"mensaje no enviado, Datos Incorrectos",Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }

    }
}
