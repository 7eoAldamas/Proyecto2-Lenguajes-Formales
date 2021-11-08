package com.gt.control.sintactico;

import java.util.*;

public class Nodo {
//---

    private String lexema;
    private Nodo siguiente;
    private List<Nodo> rama = new ArrayList<>();
    private List<String> lexemaRama = new ArrayList<>();

    public Nodo(String lexema, Nodo siguiente) {
        this.lexema = lexema;
        this.siguiente = siguiente;
    }

    public Nodo(String lexema) {
        this.lexema = lexema;
    }

    public String getLexema() {
        return lexema;
    }

    public void setLexema(String lexema) {
        this.lexema = lexema;
    }

    public List<String> getLexemaRama() {
        return lexemaRama;
    }

    public void setLexemaRama(List<String> lexemaHijos) {
        this.lexemaRama = lexemaHijos;
    }

    //--- Añadir Nodo Rama
    public void addRama(Nodo n) {
        this.rama.add(n);
    }

    //--- Obtener Elemento/Nodo Específico
    public Nodo getNodo(int index) {
        return this.rama.get(index);
    }
    
    //--- Evaluación de Elementos/Ramas
    public List<String> analizarRamas(int index) {
        String aux = "";
        if (rama.size() > 0) {
            aux += lexema;
            lexemaRama.add(aux);
            rama.stream().map(hijo -> hijo.analizarRamas(index + 1)).forEachOrdered(auxRama -> {
                auxRama.forEach(result -> {
                    lexemaRama.add(result);
                });
            });
        } else {
            aux += "\t" + lexema;
            lexemaRama.add(aux);
        }
        return lexemaRama;
    }

}