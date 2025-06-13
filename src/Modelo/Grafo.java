package Modelo;

import Interfaces.IGrafo;
import Interfaces.INodo;

import java.util.*;

public class Grafo<T> implements IGrafo<T>{

	private Map<T, Nodo<T>> nodos = new HashMap<>();


    public void agregarNodo(T llave, T dato) {
        if (!nodos.containsKey(llave)) {
        	nodos.put(llave, new Nodo<T>(dato));

        }
    }


    public void agregarArista(T origen, T destino) {
        if (nodos.containsKey(origen) && nodos.containsKey(destino)) {
            INodo<T> nodoOrigen = nodos.get(origen);
            INodo<T> nodoDestino = nodos.get(destino);
            nodoOrigen.agregarVecino(nodoDestino);
            nodoDestino.agregarVecino(nodoOrigen);
        }
    }


    @Override
    public void mostrarMatrizAdyacencia() {
        System.out.println("Matriz de Adyacencia:");
        List<T> claves = new ArrayList<>(nodos.keySet());

        // Encabezado
        System.out.printf("%-20s", ""); // espacio vacío arriba a la izquierda
        for (T clave : claves) {
            System.out.printf("%-20s", clave.toString());
        }
        System.out.println();

        // Filas
        for (T i : claves) {
            System.out.printf("%-20s", i.toString()); // nombre fila
            for (T j : claves) {
                Nodo<T> nodoI = nodos.get(i);
                Nodo<T> nodoJ = nodos.get(j);
                boolean conectado = nodoI.getVecinos().contains(nodoJ);
                System.out.printf("%-20s", conectado ? "1" : "0");
            }
            System.out.println();
        }
    }

    
    public void bfs(T inicio) {
        if (!nodos.containsKey(inicio)) return;
        Set<T> visitados = new HashSet<>();
        Queue<INodo<T>> cola = new LinkedList<>();
        Nodo<T> nodoInicio = nodos.get(inicio);
        visitados.add(inicio);
        cola.add(nodoInicio);
        System.out.println("Recorrido BFS:");
        while (!cola.isEmpty()) {
            INodo<T> actual = cola.poll();
            System.out.print(actual.getDato() + " ");

            for (INodo<T> vecino : actual.getVecinos()) {
                if (!visitados.contains(vecino.getDato())) {
                    visitados.add(vecino.getDato());
                    cola.add((Nodo<T>) vecino);
                }
            }
        }
    }

    public void dfs(T inicio) {
        if (!nodos.containsKey(inicio)) return;

        Set<T> visitados = new HashSet<>();
        System.out.println("Recorrido DFS:");
        dfsRec(nodos.get(inicio), visitados);
        System.out.println();
    }

    private void dfsRec(Nodo<T> actual, Set<T> visitados) {
        visitados.add(actual.getDato());
        System.out.println(actual.getDato() + " ");

        List<INodo<T>> vecinos = actual.getVecinos();
        for (int i = vecinos.size() - 1; i >= 0; i--) {
            INodo<T> vecino = vecinos.get(i);
            if (!visitados.contains(vecino.getDato())) {
                dfsRec((Nodo<T>) vecino, visitados);
            }
        }
    }
}
