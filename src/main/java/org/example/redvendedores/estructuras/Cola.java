package org.example.redvendedores.estructuras;

import java.util.NoSuchElementException;

public class Cola<T> {
    private Nodo<T> nodoPrimero;
    private Nodo<T> nodoUltimo;
    private int tamanio;

    public Cola() {
        this.nodoPrimero = null;
        this.nodoUltimo= null;
        this.tamanio = 0;
    }

    // Métodos de la cola: enqueue, dequeue, obtenerPrimero, isEmpty, size, etc.
    public void encolar(T dato) {
        Nodo<T> nuevoNodo = new Nodo<>(dato);

        if (estaVacia()) {
            // Si la cola está vacía, el nuevo nodo será el primero y el último
            nodoPrimero = nuevoNodo;
            nodoUltimo = nuevoNodo;
        } else {
            // Si la cola no está vacía, agregamos el nuevo nodo al final y actualizamos la referencia al último nodo
            nodoUltimo.siguiente = nuevoNodo;
            nodoUltimo = nuevoNodo;
        }
        tamanio++;
    }
    public boolean estaVacia() {

        return nodoPrimero == null;
    }
    public T desencolar() {
        if (estaVacia()) {
            throw new NoSuchElementException("La cola está vacía");
        }

        T dato = nodoPrimero.dato; // Acceder al dato del primer nodo
        nodoPrimero = nodoPrimero.siguiente; // Avanzar al siguiente nodo

        if (nodoPrimero == null) {
            nodoUltimo = null; // Si la cola está vacía, el final también debe ser nulo
        }
        tamanio--;

        return dato;
    }
    public Cola<T> clonarCola() {
        Cola<T> colaClonada = new Cola<>();
        Cola<T> colaAuxiliar = new Cola<>();

        // Clonamos la cola original
        while (!estaVacia()) {
            T elemento = desencolar();
            colaClonada.encolar(elemento);
            colaAuxiliar.encolar(elemento); // Usamos una cola auxiliar para mantener el orden original
        }

        // Devolvemos los elementos a la cola original
        while (!colaAuxiliar.estaVacia()) {
            T elemento = colaAuxiliar.desencolar();
            encolar(elemento);
        }

        return colaClonada;
    }
    public void imprimirCola() {
        Cola<T> auxiliar = new Cola<>();
        while (!estaVacia()) {
            T dato = desencolar();
            System.out.println(dato);
            auxiliar.encolar(dato);
        }
        while (!auxiliar.estaVacia()) {
            encolar(auxiliar.desencolar());
        }
    }

    public T obtenerPrimero() {
        if (estaVacia()) {
            throw new NoSuchElementException("La cola está vacía");
        }
        return nodoPrimero.dato;
    }

    public int size() {
        return tamanio;
    }

}
