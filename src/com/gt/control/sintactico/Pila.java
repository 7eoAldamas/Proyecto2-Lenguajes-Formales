package com.gt.control.sintactico;

public class Pila {
//--- Autómata de Pila
    
    private Nodo cabeza;
    private int size;

    public Pila() {
        this.cabeza = null;
        this.size = 0;
    }
    
    //--- Obtener Elemento - Pila
    public String obtenerElemento(int index) {
        int contador = 0;
        Nodo tmp = cabeza;
        while (contador < index) {            
            tmp = tmp.obtenerSiguiente();
            contador++;
        }
        return tmp.obtenerToken();
    }
    
    //--- Añadir Primero (Elemento - Token)
    public void addPrimero(String token) {
        if (cabeza == null) {
            cabeza = new Nodo(token);
        } else {
            Nodo tmp = cabeza;
            Nodo aux = new Nodo(token);            
            aux.enlazarSiguiente(tmp);
            cabeza = aux;
        }
        size++;
    }
    
    //--- Tamaño - Pila
    public int size() {
        return size;
    }
    
    //--- Verificar contenido - Pila
    public boolean isVacia() {
        return (cabeza == null);
    }
    
}