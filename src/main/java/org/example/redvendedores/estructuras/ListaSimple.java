package org.example.redvendedores.estructuras;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

public class ListaSimple<T> implements Iterable<T> {
	
	private Nodo<T> nodoPrimero;
	private Nodo<T> nodoUltimo;
	private int tamanio;
	
	public ListaSimple() {
		nodoPrimero = null;
		nodoUltimo = null;
		tamanio = 0;
	}
	//Agregar al inicio de la lista
	public void agregarInicio(T valorNodo) {
		Nodo<T> nuevoNodo = new Nodo<>(valorNodo);
		if(estaVacia())	{
			nodoPrimero = nuevoNodo;
			nodoUltimo = nuevoNodo;
		}
		else{
			nuevoNodo.setSiguiente(nodoPrimero);
			nodoPrimero = nuevoNodo;
		}
		tamanio++;
	}

	//Agregar al final de la lista
	public void agregarFinal(T valorNodo) {
		Nodo<T> nodo = new Nodo<>(valorNodo);
		
		if( estaVacia() ) {
			nodoPrimero = nodoUltimo = nodo;
		}else {
			nodoUltimo.setSiguiente(nodo);
			nodoUltimo = nodo;
		}
		tamanio++;
	}

	//Obtener Nodo el valor de un Nodo
	public T obtenerValorNodo(int indice) {
		Nodo<T> nodoTemporal = null;
		int contador = 0;
		if(indiceValido(indice)){
			nodoTemporal = nodoPrimero;
			while (contador < indice) {
				nodoTemporal = nodoTemporal.getSiguiente();
				contador++;
			}
		}if(nodoTemporal != null)
			return nodoTemporal.getDato();
		else
			return null;
	}
	
	//Verificar si indice es valido
	private boolean indiceValido(int indice) {		
		if( indice >= 0 && indice < tamanio ) {
			return true;
		}			
		throw new IndexOutOfBoundsException("Indice no valido");
	}

	//Verificar si la lista esta vacia
	public boolean estaVacia() {
		return(nodoPrimero == null)?true:false;
	}

	
	//imprimir lista
	public void imprimirLista() {
		
		Nodo<T> aux = nodoPrimero;
		
		while(aux!=null) {
			System.out.print( aux.getDato()+"\t" );
			aux = aux.getSiguiente();
		}
		
		System.out.println();
	}
	
	//Eliminar dado el valor de un nodo
	public T eliminar(T dato){
		Nodo<T> nodo = nodoPrimero;
		Nodo<T> previo = null;
		Nodo<T> siguiente = null;
		boolean encontrado = false;
		
		//buscar el nodo previo
		while(nodo!=null) {			
			if( nodo.getDato() == dato ) {
				encontrado = true;
				break;
			}
			previo = nodo;
			nodo = nodo.getSiguiente();
		}
		
		if(encontrado) {
			siguiente = nodo.getSiguiente();
			if( previo==null ) {
				nodoPrimero = siguiente;
			}else {
				previo.setSiguiente(siguiente);
			}
			
			if(siguiente==null) {
				nodoUltimo = previo;
			}else {
				nodo.setSiguiente(null);
			}
			
			nodo = null;
			tamanio--;
			return dato;			
		}
		throw new RuntimeException("El elemento no existe");
	}

	//Elimina el primer nodo de la lista
	public T eliminarPrimero() {
		
		if( !estaVacia() ) {
			Nodo<T> n = nodoPrimero;
		    T valor = n.getDato();
			nodoPrimero = n.getSiguiente();
			
			if(nodoPrimero==null) {
				nodoUltimo = null;
			}
			
			tamanio--;
			return valor;
		}
		
		throw new RuntimeException("Lista vac�a");		
	}

	private Nodo<T> obtenerNodo(int indice) {
		
		if(indice>=0 && indice<tamanio) {
		
			Nodo<T> nodo = nodoPrimero;
			
			for (int i = 0; i < indice; i++) {
				nodo = nodo.getSiguiente();
			}
		
			return nodo;			
		}
		
		return null;
	}

	public void modificarNodo(int indice, T nuevo) {
		
		if( indiceValido(indice) ) {			
			Nodo<T> nodo = obtenerNodo(indice);
			nodo.setDato(nuevo);
		}
		
	}

	public int obtenerPosicionNodo(T dato) {

		int i = 0;
		
		for( Nodo<T> aux = nodoPrimero ; aux!=null ; aux = aux.getSiguiente() ) {
			if( aux.getDato().equals(dato) ) {
				return i;
			}
			i++;
		}
		
		return -1;
	}

	@Override
	public Iterator<T> iterator() {
		
		return new IteradorListaSimple (nodoPrimero);
	}
	
	public class IteradorListaSimple implements Iterator<T>{
		private Nodo<T> nodo;
		private int posicion;

		public IteradorListaSimple(Nodo<T> nodo) {
			this.nodo = nodo;
			this.posicion = 0;
		}
		@Override
		public boolean hasNext() {
			return nodo!=null;
		}
		@Override
		public T next() {
			T valor = nodo.getDato();
			nodo = nodo.getSiguiente();// i++;
			posicion++;
			return valor;
		}

		public int getPosicion() {
			return posicion;
		}
		
	}

	//Metodos get y set de la clase ListaSimple
	
	
	public Nodo<T> getNodoPrimero() {
		return nodoPrimero;
	}


	public void setNodoPrimero(Nodo<T> nodoPrimero) {
		this.nodoPrimero = nodoPrimero;
	}


	public int getTamanio() {
		return tamanio;
	}


	public void setTamanio(int tamanio) {
		this.tamanio = tamanio;
	}

}
