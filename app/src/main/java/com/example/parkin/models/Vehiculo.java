package com.example.parkin.models;

import android.content.Context;
import android.database.Cursor;

public class Vehiculo {

    private Integer id;
    private String marca;
    private String color;
    private String matricula;
    private String modelo;
    private String definicion;
    private Integer clienteid;

    public Vehiculo(Integer id, String marca, String color, String matricula, String modelo, String definicion, Integer clienteid) {
        this.id = id;
        this.marca = marca;
        this.color = color;
        this.matricula = matricula;
        this.modelo = modelo;
        this.definicion = definicion;
        this.clienteid = clienteid;
    }

    public Vehiculo(String marca, String color, String matricula, String modelo, String definicion, Integer clienteid) {
        this.marca = marca;
        this.color = color;
        this.matricula = matricula;
        this.modelo = modelo;
        this.definicion = definicion;
        this.clienteid = clienteid;
    }

    public Vehiculo() {
    }

    public void guardar(Context context){
        BaseSQLHelper baseSQLHelper= new BaseSQLHelper(context);
        String sql = "INSERT INTO vehiculo (vehiculomarca,vehiculocolor,vehiculomatricula,vehiculomodelo,vehiculodefinicion,clienteid) VALUES ('"+getMarca()+"','"+getColor()+"','"+getMatricula()+"','"+getModelo()+"','"+getDefinicion()+"','"+getClienteid()+"');";
        baseSQLHelper.noQuery(sql);
        baseSQLHelper.close();
    }

    public static Cursor getCursor(Context context){
        BaseSQLHelper baseSQLHelper = new BaseSQLHelper(context);
        String sql="SELECT * FROM vehiculo;";
        return baseSQLHelper.query(sql);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getDefinicion() {
        return definicion;
    }

    public void setDefinicion(String definicion) {
        this.definicion = definicion;
    }

    public Integer getClienteid() {
        return clienteid;
    }

    public void setClienteid(Integer clienteid) {
        this.clienteid = clienteid;
    }
}
