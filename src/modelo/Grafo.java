package modelo;

import interfaces.IGrafo;
import interfaces.INodo;

import java.util.*;

public class Grafo<K, T> implements IGrafo<K, T> {

    private Map<K, INodo<T>> nodos = new HashMap<>(); // guarda como clave un dato tipo K, y un INodo de tipo T!!

    @Override
    public void agregarNodo(K llave, T dato) {
        if (!nodos.containsKey(llave)) {
            nodos.put(llave, new Nodo<>(dato));
        }
    }

    @Override
    public void agregarArista(K origen, K destino) {
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
        List<K> claves = new ArrayList<>(nodos.keySet());

        System.out.printf("%-20s", "");
        for (K clave : claves) {
            System.out.printf("%-20s", clave.toString());
        }
        System.out.println();

        for (K i : claves) {
            System.out.printf("%-20s", i.toString());
            for (K j : claves) {
                INodo<T> nodoI = nodos.get(i);
                INodo<T> nodoJ = nodos.get(j);
                boolean conectado = nodoI.getVecinos().contains(nodoJ);
                System.out.printf("%-20s", conectado ? "1" : "0");
            }
            System.out.println();
        }
    }

    @Override
    public void bfs(K inicio) {
        if (!nodos.containsKey(inicio)) return;
        Set<K> visitados = new HashSet<>();
        Queue<INodo<T>> cola = new LinkedList<>();
        INodo<T> nodoInicio = nodos.get(inicio);
        visitados.add(inicio);
        cola.add(nodoInicio);
        System.out.println("Recorrido BFS:");
        while (!cola.isEmpty()) {
            INodo<T> actual = cola.poll();
            System.out.print(actual.getDato() + " ");
            for (INodo<T> vecino : actual.getVecinos()) {
                // Buscar la clave del vecino para saber si ya lo visité
                K claveVecino = getClavePorNodo(vecino);
                if (claveVecino != null && !visitados.contains(claveVecino)) {
                    visitados.add(claveVecino);
                    cola.add(vecino);
                }
            }
        }
        System.out.println();
    }

    @Override
    public void dfs(K inicio) {
        if (!nodos.containsKey(inicio)) return;
        Set<K> visitados = new HashSet<>();
        System.out.println("Recorrido DFS:");
        dfsRec(nodos.get(inicio), visitados);
        System.out.println();
    }

    private void dfsRec(INodo<T> actual, Set<K> visitados) {
        System.out.print(actual.getDato() + " ");
        K claveActual = getClavePorNodo(actual);
        if (claveActual == null) return;
        visitados.add(claveActual);
        for (INodo<T> vecino : actual.getVecinos()) {
            K claveVecino = getClavePorNodo(vecino);
            if (claveVecino != null && !visitados.contains(claveVecino)) {
                dfsRec(vecino, visitados);
            }
        }
    }

    private K getClavePorNodo(INodo<T> nodo) {
        for (Map.Entry<K, INodo<T>> entry : nodos.entrySet()) {
            if (entry.getValue() == nodo) {
                return entry.getKey();
            }
        }
        return null;
    }
}