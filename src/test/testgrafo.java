package test;

import modelo.*;
import interfaces.*;

public class testgrafo {
    public static void main(String[] args) {
        IGrafo<Integer, IPersona> grafo = new Grafo<>();

        IPersona ana = new Persona("Ana", 123);
        IPersona beto = new Persona("Beto", 456);
        IPersona caro = new Persona("Caro", 789);
        IPersona dino = new Persona("Dino", 999);

        grafo.agregarNodo(ana.getDNI(), ana);
        grafo.agregarNodo(beto.getDNI(), beto);
        grafo.agregarNodo(caro.getDNI(), caro);
        grafo.agregarNodo(dino.getDNI(), dino);

        // Agregar aristas usando claves (DNI)
        grafo.agregarArista(ana.getDNI(), beto.getDNI());
        grafo.agregarArista(beto.getDNI(), caro.getDNI());
        grafo.agregarArista(caro.getDNI(), dino.getDNI());

        grafo.mostrarMatrizAdyacencia();

        System.out.println("\nRecorrido BFS desde Ana:");
        grafo.bfs(ana.getDNI());

        System.out.println("\nRecorrido DFS desde Ana:");
        grafo.dfs(ana.getDNI());
    }
}