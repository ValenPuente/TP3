package Interfaces;

public interface IGrafo<K, T> {
    void agregarNodo(K llave, T dato);
    void agregarArista(K origen, K destino);
    void mostrarMatrizAdyacencia();
    void bfs(K inicio);
    void dfs(K inicio);
}