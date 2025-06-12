package Interfaces;

import Modelo.Nodo;
import Modelo.Persona;

public interface IGrafo<T> {

    void agregarNodo(T llave, T dato);
    void agregarArista(T origen, T destino);
    void mostrarMatrizAdyacencia();
    void bfs(T inicio);
    void dfs(T inicio);
}
