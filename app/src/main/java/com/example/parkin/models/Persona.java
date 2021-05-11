package com.example.parkin.models;

import android.content.Context;
import android.database.Cursor;

public class Persona {

    private Integer id;
    private String nombre;
    private String apellido;
    private String correo;
    private String celular;
    private String username;
    private String password;

    public Persona(Integer id, String nombre, String apellido, String correo, String celular, String username, String password) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.celular = celular;
        this.username = username;
        this.password = password;
    }

    public Persona(String nombre, String apellido, String correo, String celular, String username, String password) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.celular = celular;
        this.username = username;
        this.password = password;
    }

    public Persona() {
    }

    public void guardar(Context context){
        BaseSQLHelper baseSQLHelper= new BaseSQLHelper(context);
        String sql = "INSERT INTO persona (personanombre,personaapellido,personacorreo,personacelular,personausername,personapassword) VALUES ('"+getNombre()+"','"+getApellido()+"','"+getCorreo()+"','"+getCelular()+"','"+getUsername()+"','"+getPassword()+"');";
        baseSQLHelper.noQuery(sql);
        baseSQLHelper.close();
    }

    public static Cursor getCursor(Context context){
        BaseSQLHelper baseSQLHelper = new BaseSQLHelper(context);
        String sql="SELECT * FROM persona;";
        return baseSQLHelper.query(sql);
    }

    public static Cursor getLogin(Context context, String username, String password){
        BaseSQLHelper baseSQLHelper = new BaseSQLHelper(context);
        String sql="SELECT * FROM persona p WHERE p.personausername = '"+username+"' and p.personapassword = '"+password+"';";
        return baseSQLHelper.query(sql);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
