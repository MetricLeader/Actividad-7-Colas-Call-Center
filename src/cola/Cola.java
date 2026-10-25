package cola;

import java.util.Iterator;

public class Cola<T> implements ICola<T> {
    
    protected int nElementos;
    protected NodoSimple<T> inicio;
    protected NodoSimple<T> fin;
    
    public Cola(){
        nElementos = 0;
        inicio = null;
        fin = null;
    }
    
    private class NodoSimple<T> {
        private T dato;
        private NodoSimple<T> sig;
        
        public NodoSimple(T dato){
            this.dato = dato;
        }
    }
    
    @Override
    public void enqueue(T dato) {
    NodoSimple<T> nodoNuevo = new NodoSimple<>(dato);
    NodoSimple<T> nodo = new NodoSimple<>(dato);
        if(inicio == null){
            inicio = nodoNuevo;
            fin = inicio;
        }
        fin.sig = nodoNuevo;
        fin = fin.sig;
        nElementos++;
        
    }

    @Override
    public T dequeue() throws ColaExcepcion {
        if(empty()){
            throw new ColaExcepcion("Cola vacia");
        }
        NodoSimple<T> Eliminado = inicio; 
        inicio = inicio.sig;
        nElementos--;
        return Eliminado.dato;
    }

    @Override
    public T peek() {
        if(empty()){
            throw new ColaExcepcion("Cola vacia");
        }
        return inicio.dato;
    }

    @Override
    public boolean empty() {
        return nElementos ==0;
    }

    @Override
    public int size() {
        return nElementos;
    }

    @Override
    public void enqueuePrioritario(T dato) {
    NodoSimple<T> nodoNuevo = new NodoSimple<>(dato);
    NodoSimple<T> nodo = new NodoSimple<>(dato);
    
    if(inicio == null){
        inicio = nodoNuevo;
        fin = nodoNuevo;
    }
    nodo = inicio;
    nodoNuevo.sig = nodo;
    inicio = nodoNuevo;    
    nElementos++;
    }
    
    @Override 
    public String toString(){
        String s = "[";
        NodoSimple<T> nodo = inicio;
        while(nodo != null){
            s+= nodo.dato.toString();
            if(nodo.sig != null){
                s+=",";
            }
            nodo = nodo.sig;
        }
        s+="]";
        return s;
    }
}