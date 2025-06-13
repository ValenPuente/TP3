package Modelo;

import Interfaces.IPersona;

public class Persona implements IPersona {
    private String nombre;
    private int DNI;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDNI() {
        return DNI;
    }

    public void setDNI(int DNI) {
        this.DNI = DNI;
    }

    public Persona(String nombre, int DNI) {
        this.nombre = nombre;
        this.DNI = DNI;
    }
    
    @Override
    public String toString() {
        return nombre + " (" + DNI + ")";
    }
}
