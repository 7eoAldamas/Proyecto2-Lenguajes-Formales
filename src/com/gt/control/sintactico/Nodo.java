package com.gt.control.sintactico;

public class Nodo {
//---    
    
    private String token;
    private Nodo siguiente;
    
    public Nodo(String token) {
        this.token = token;
        this.siguiente = null;
    }

    public Nodo(String token, Nodo siguiente) {
        this.token = token;
        this.siguiente = siguiente;
    }
    
    //--- Obtener Valor
    public String obtenerToken() {
        return token;
    }
    
    //--- Enlazar Elementos
    public void enlazarSiguiente(Nodo n) {
        siguiente = n;
    }
    
    //--- Obtener Siguiente Elemento
    public Nodo obtenerSiguiente() {
        return siguiente;
    }
    
}