package com.example.pedro.pasardatosagenda;

import java.io.Serializable;

/**
 * Created by pedro on 7/11/14.
 */
public class Persona implements Serializable {

    private String nombre;
    private int telefono;

    public Persona(){

    }

    public Persona(String nombre, int telefono){

        this.setNombre(nombre);
        this.setTelefono(telefono);

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
}
