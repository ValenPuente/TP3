package test;

import Modelo.*;
import Interfaces.*;

public class testgrafo {
    public static void main(String[] args) {
        IGrafo<IPersona> grafo = new Grafo<>();

        IPersona ana = new Persona("Ana", 123);
        IPersona beto = new Persona("Beto", 456);
        IPersona caro = new Persona("Caro", 789);
        IPersona dino = new Persona("Dino", 999);

        grafo.agregarNodo(ana, ana);
        grafo.agregarNodo(beto, beto);
        grafo.agregarNodo(caro, caro);
        grafo.agregarNodo(dino, dino);

        grafo.agregarArista(ana, beto);
        grafo.agregarArista(beto, caro);
        grafo.agregarArista(caro, dino);

        grafo.mostrarMatrizAdyacencia();

        System.out.println("\nRecorrido BFS desde Ana:");
        grafo.bfs(ana);

        System.out.println("\nRecorrido DFS desde Ana:");
        grafo.dfs(ana);
    }
}
