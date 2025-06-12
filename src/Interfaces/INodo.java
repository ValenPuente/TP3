package Interfaces;

import java.util.List;

public interface INodo<T> {
    T getDato();
    void setDato(T valor);
    void agregarVecino(INodo<T> v);
    List<INodo<T>> getVecinos();

}
