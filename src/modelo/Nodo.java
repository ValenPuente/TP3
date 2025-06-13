package modelo;

import interfaces.INodo;

import java.util.ArrayList;
import java.util.List;

public class Nodo<T> implements INodo<T> {
    private T dato;
    private List<INodo<T>> vecinos;

    public List<INodo<T>> getVecinos() {
        return vecinos;
    }

    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    public Nodo(T dato) {
        this.dato = dato;
        this.vecinos = new ArrayList<>();
    }

    public void agregarVecino(INodo<T> v) {
        if (!vecinos.contains(v)) {
            vecinos.add(v);
        }
    }

}
