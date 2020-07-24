package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;

import static com.example.myapplication.URL.IP;
import static com.example.myapplication.URL.sitio;

public class Quinto extends AppCompatActivity {
    private Button salir;
    private TextView t1;
    boolean b = true;
    String Alerta = "";
    String d1,d2,d3,d4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quinto);
        final Bundle extras=getIntent().getExtras();
        d1=extras.getString("cnum");
        d2=extras.getString("cnom");
        d3=extras.getString("cidU");
        d4=extras.getString("cidM");
        t1 = findViewById(R.id.Frecuencia);
        salir = (Button) findViewById(R.id.Salir);
        final TextView textGenerateNumber = (TextView) findViewById(R.id.Frecuencia);
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
                        if (lol > 86 || lol < 70) {
                            new Quinto.CargarDatos().execute("http://" + IP + "/" + sitio + "/" + "insertar_datos.php?cidM="+d4+"&cidU="+d3+"&cfre="+t1.getText().toString());
                            Alerta = "ALERTA Frecuencia Peligro Usuario "+d2+" : -->" + t1.getText().toString();
                            enviarMensaje(d1, Alerta);
                            b = false;
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        logo.start();
        if (ActivityCompat.checkSelfPermission(Quinto.this, Manifest.permission.SEND_SMS)
                != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(Quinto.this, Manifest.permission.SEND_SMS)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(Quinto.this, new String[]
                    {Manifest.permission.SEND_SMS,}, 1000);

        }
        salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Quinto.this, Login.class);
                startActivity(i);


            }
        });
    }
    private void enviarMensaje(String numero, String mensaje) {
        try {
            SmsManager sms = SmsManager.getDefault();
            sms.sendTextMessage(numero, null, mensaje, null, null);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public int random() {

        int ritmo = (int) Math.floor(Math.random() * 220 + 80);

        return ritmo;
    }
    private class CargarDatos extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... urls) {
            // params comes from the execute() call: params[0] is the url.
            try {
                return downloadUrl(urls[0]);
            } catch (IOException e) {
                e.printStackTrace();
                return "Unable to retrieve web page. URL may be invalid.";
            }
        }
        private String downloadUrl(String myurl) throws IOException {
            Log.i("URL", "" + myurl);
            myurl = myurl.replace(" ", "%20");
            InputStream is = null;
            // Only display the first 500 characters of the retrieved
            // web page content.
            int len = 500;

            try {
                java.net.URL url = new java.net.URL(myurl);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setReadTimeout(10000 /* milliseconds */);
                conn.setConnectTimeout(15000 /* milliseconds */);
                conn.setRequestMethod("GET");
                conn.setDoInput(true);
                // Starts the query
                conn.connect();
                int response = conn.getResponseCode();
                Log.d("respuesta", "The response is: " + response);
                is = conn.getInputStream();

                // Convert the InputStream into a string
                String contentAsString = readIt(is, len);
                return contentAsString;

                // Makes sure that the InputStream is closed after the app is
                // finished using it.
            } finally {
                if (is != null) {
                    is.close();
                }
            }
        }
        public String readIt(InputStream stream, int len) throws IOException, UnsupportedEncodingException {
            Reader reader = null;
            reader = new InputStreamReader(stream, "UTF-8");
            char[] buffer = new char[len];
            reader.read(buffer);
            return new String(buffer);
        }
    }
}
