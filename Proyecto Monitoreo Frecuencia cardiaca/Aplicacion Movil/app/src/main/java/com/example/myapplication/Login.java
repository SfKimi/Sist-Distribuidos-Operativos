package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.TargetApi;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;

import static com.example.myapplication.URL.IP;
import static com.example.myapplication.URL.sitio;

public class Login extends AppCompatActivity {
    Button blogin;

    EditText cusu, clav, nom,id,perfil;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        //Construcción de variables
        cusu=(EditText)findViewById(R.id.cusu);
        clav=(EditText)findViewById(R.id.cclave);
        blogin=(Button)findViewById(R.id.editar);
        blogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(cusu.getText().toString().isEmpty() || clav.getText().toString().isEmpty() ){
                    Toast.makeText(getApplicationContext(), "Usuario o Contraseña incorrecta", Toast.LENGTH_SHORT).show();
                }
                else{
                    new Login.ConsultarDatos().execute("http://"+IP+"/"+sitio+"/"+"consulta_login.php?cusuario="+cusu.getText().toString()+"&cclave="+clav.getText().toString());
                }

            }
        });



    }


    private class ConsultarDatos extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... urls) {

            // params comes from the execute() call: params[0] is the url.
            try {
                return downloadUrl(urls[0]);
            } catch (IOException e) {
                return "Unable to retrieve web page. URL may be invalid.";
            }
        }


        // onPostExecute displays the results of the AsyncTask.
        @Override
        protected void onPostExecute(String result) {

            JSONArray ja = null;
            try {
                ja = new JSONArray(result);

                //Validación de contraseña
                if(cusu.getText().toString().equals(ja.getString(0)) && clav.getText().toString().equals(ja.getString(1)) ){

                    //Validación de Usuario, contraseña y perfil del Administrador
                        if(ja.getInt(3)>18 ) {
                            if(ja.getInt(3)<25){
                            Intent i = new Intent(Login.this, Primero.class);
                            i.putExtra("cnum",ja.getString(4));
                            i.putExtra("cnom",ja.getString(2));
                            i.putExtra("cidU",ja.getString(5));
                            i.putExtra("cidM",ja.getString(6));
                            startActivity(i);
                            cusu.setText("");
                            clav.setText("");
                            }
                        }else if(ja.getInt(3)>26 ) {
                            if(ja.getInt(3)<35){
                                Intent i = new Intent(Login.this, Segundo.class);
                                i.putExtra("cnum",ja.getString(4));
                                i.putExtra("cnom",ja.getString(2));
                                i.putExtra("cidU",ja.getString(5));
                                i.putExtra("cidM",ja.getString(6));
                                startActivity(i);
                                cusu.setText("");
                                clav.setText("");
                            }
                        }else if(ja.getInt(3)>36 ) {
                            if(ja.getInt(3)<45){
                                Intent i = new Intent(Login.this, Tercero.class);
                                i.putExtra("cnum",ja.getString(4));
                                i.putExtra("cnom",ja.getString(2));
                                i.putExtra("cidU",ja.getString(5));
                                i.putExtra("cidM",ja.getString(6));
                                startActivity(i);
                                cusu.setText("");
                                clav.setText("");
                            }
                        }
                        else if(ja.getInt(3)>46 ) {
                            if(ja.getInt(3)<55){
                                Intent i = new Intent(Login.this, Cuarto.class);
                                i.putExtra("cnum",ja.getString(4));
                                i.putExtra("cnom",ja.getString(2));
                                i.putExtra("cidU",ja.getString(5));
                                i.putExtra("cidM",ja.getString(6));
                                startActivity(i);
                                cusu.setText("");
                                clav.setText("");
                            }
                        }else if(ja.getInt(3)>56 ) {
                            if(ja.getInt(3)<65){
                                Intent i = new Intent(Login.this, Quinto.class);
                                i.putExtra("cnum",ja.getString(4));
                                i.putExtra("cnom",ja.getString(2));
                                i.putExtra("cidU",ja.getString(5));
                                i.putExtra("cidM",ja.getString(6));
                                startActivity(i);
                                cusu.setText("");
                                clav.setText("");
                            }
                        }else if(ja.getInt(3)>66 ) {
                                Intent i = new Intent(Login.this, Sexto.class);
                                i.putExtra("cnum",ja.getString(4));
                                i.putExtra("cnom",ja.getString(2));
                                i.putExtra("cidU",ja.getString(5));
                                i.putExtra("cidM",ja.getString(6));
                                startActivity(i);
                                cusu.setText("");
                                clav.setText("");
                        }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
    private String downloadUrl(String myurl) throws IOException {
        Log.i("URL",""+myurl);
        myurl = myurl.replace(" ","%20");
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




