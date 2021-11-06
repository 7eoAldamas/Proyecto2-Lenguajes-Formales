package com.gt.control.sintactico;

/*
Estructura:
                    Raiz
            Rama            Rama
        Hoja                    Hoja
*/

public class Estructura {
//--- Estructura Sintáctica - Árbol de Sintaxis
 
    private Nodo raiz;
    
    public Estructura(Nodo raiz) {
        this.raiz = raiz;
    }

    public Nodo getRaiz() {
        return raiz;
    }

    public void setRaiz(Nodo raiz) {
        this.raiz = raiz;
    }
       
}