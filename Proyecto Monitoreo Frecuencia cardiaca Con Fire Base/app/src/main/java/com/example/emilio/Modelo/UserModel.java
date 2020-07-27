package com.example.emilio.Modelo;

public class UserModel {
    private String Edad;
    private  String Email;
    private  String EmailContanto;
    private  String Genero;
    private  String NumeroContacto;
    private  String Password;
    //private  String Titulo;
    private String nombre;

    public UserModel() {

    }

    public String getEmailContanto() {
        return EmailContanto;
    }

    public void setEmailContanto(String emailContanto) {
        EmailContanto = emailContanto;
    }

    public String getEdad() {
        return Edad;
    }

    public void setEdad(String edad) {
        Edad = edad;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }



    public String getGenero() {
        return Genero;
    }

    public void setGenero(String genero) {
        Genero = genero;
    }

    public String getNumeroContacto() {
        return NumeroContacto;
    }

    public void setNumeroContacto(String numeroContacto) {
        NumeroContacto = numeroContacto;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
