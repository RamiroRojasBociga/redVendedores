package org.example.redvendedores.estructuras;

import java.util.EmptyStackException;

public class Pila<T> {
    private Nodo<T> nodoTope; // Nodo en la parte superior de la pila
    private int tamanio; // Tamaño actual de la pila

    // Constructor: inicializa una pila vacía
    public Pila() {
        this.nodoTope = null;
        this.tamanio = 0;
    }

    // Método para agregar un elemento a la parte superior de la pila
    public void apilar(T dato) {
        Nodo<T> nuevoNodo = new Nodo<>(dato); // Creamos un nuevo nodo con el dato proporcionado
        nuevoNodo.setSiguiente(nodoTope); // Establecemos el siguiente del nuevo nodo como el nodo actual en la parte superior de la pila
        nodoTope = nuevoNodo; // Actualizamos el nodoTope para que apunte al nuevo nodo
        tamanio++; // Incrementamos el tamaño de la pila
    }

    // Método para eliminar y devolver el elemento en la parte superior de la pila
    public T desapilar() {
        if (estaVacia()) {
            throw new EmptyStackException(); // Lanza una excepción si la pila está vacía
        }
        T dato = nodoTope.getDato(); // Obtenemos el dato del nodo en la parte superior de la pila
        nodoTope = nodoTope.getSiguiente(); // Avanzamos al siguiente nodo
        tamanio--; // Decrementamos el tamaño de la pila
        return dato; // Devolvemos el dato eliminado
    }

    // Método para obtener el elemento en la parte superior de la pila sin eliminarlo
    public T verTope() {
        if (estaVacia()) {
            throw new EmptyStackException(); // Lanza una excepción si la pila está vacía
        }
        return nodoTope.getDato(); // Devuelve el dato del nodo en la parte superior de la pila
    }

    // Método para verificar si la pila está vacía
    public boolean estaVacia() {
        return nodoTope == null; // Devuelve true si el nodoTope es nulo, lo que indica que la pila está vacía
    }

    // Método para obtener el tamaño actual de la pila
    public int size() {
        return tamanio; // Devuelve el tamaño de la pila
    }

    // Método para eliminar todos los elementos de la pila
    public void vaciar() {
        nodoTope = null; // Simplemente establecemos el nodoTope como nulo para eliminar todos los nodos de la pila
        tamanio = 0; // Restablecemos el tamaño de la pila a cero
    }

    // Método para eliminar elementos entre dos niveles específicos
    public void eliminarElementos(int nivelInf, int nivelSup) {
        if (nivelInf < 1 || nivelSup < nivelInf || estaVacia()) {
            return; // Si los niveles son inválidos o la pila está vacía, no hacemos nada
        }

        Pila<T> auxiliar = new Pila<>(); // Creamos una pila auxiliar para almacenar elementos

        // Pasamos los elementos hasta el nivel inferior a la pila auxiliar
        for (int i = 1; i < nivelInf; i++) {
            if (!estaVacia()) {
                auxiliar.apilar(desapilar());
            }
        }

        // Eliminamos los elementos entre los niveles indicados
        for (int i = nivelInf; i <= nivelSup; i++) {
            if (!estaVacia()) {
                desapilar();
            }
        }

        // Pasamos los elementos restantes de la pila original a la pila auxiliar
        while (!estaVacia()) {
            auxiliar.apilar(desapilar());
        }

        // Pasamos los elementos de la pila auxiliar de vuelta a la pila original
        while (!auxiliar.estaVacia()) {
            apilar(auxiliar.desapilar());
        }
    }

    // Método para obtener una representación de cadena de la pila
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Nodo<T> actual = nodoTope;
        while (actual != null) {
            sb.append(actual.getDato());
            if (actual.getSiguiente() != null) {
                sb.append(", ");
            }
            actual = actual.getSiguiente();
        }
        sb.append("]");
        return sb.toString();
    }
    //Metodo para clonar una pila
    public Pila<T> clonar() {
        Pila<T> pilaClonada = new Pila<>();
        Pila<T> pilaAuxiliar = new Pila<>(); // Pila auxiliar para mantener el orden

        // Pasar los elementos de la pila original a la pila auxiliar en el orden correcto
        while (!estaVacia()) {
            pilaAuxiliar.apilar(desapilar());
        }

        // Pasar los elementos de la pila auxiliar a la pila original y a la pila clonada
        while (!pilaAuxiliar.estaVacia()) {
            T dato = pilaAuxiliar.desapilar();
            apilar(dato); // Devolver los elementos a la pila original
            pilaClonada.apilar(dato); // Copiar los elementos a la pila clonada
        }

        return pilaClonada;
    }


    /*public static void imprimirPila(Pila<Integer> pila) {
        Pila<Integer> auxiliar = new Pila<>();
        while (!pila.estaVacia()) {
            int elemento = pila.desapilar();
            System.out.println(elemento);
            auxiliar.apilar(elemento);
        }
        while (!auxiliar.estaVacia()) {
            pila.apilar(auxiliar.desapilar());
        }
    }*/
}