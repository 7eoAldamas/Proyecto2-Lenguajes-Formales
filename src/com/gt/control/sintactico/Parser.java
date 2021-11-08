package com.gt.control.sintactico;

import com.gt.modelo.Token;
import java.util.*;

public class Parser {
//--- Analizador Sintáctico - Validaciones LL1 

    private HashMap<String, Integer> simbolos = new HashMap<>();
    private List<String> cadena = new ArrayList<>();   
    private Pila pila = new Pila();
    private Arbol arbol;
    
    //--- Analizador Sintáctico 
    public void analizadorSintactico() {
        reiniciar();
        analizador(arbol.getRaiz());
    }
    
    //--- Analizar Pila - Parte Sintáctica
    public Object analizador(Nodo n) {
        switch (n.getLexema()) {
            case "ESTRUCTURA" -> {
                if (!n.getNodo(0).getLexema().equals("ϵ")) {
                    analizador(n.getNodo(0));
                    analizador(n.getNodo(1));
                }
            }
            case "ESCRITURA" -> {
                Nodo aux = n.getNodo(1).getNodo(0);
                String auxNodo = aux.getLexema();
                switch (auxNodo) {
                    case "LITERAL" -> {
                        String auxLiteral = aux.getNodo(0).getLexema();
                        cadena.add(auxLiteral.substring(1, auxLiteral.length() - 1));
                    }
                    case "ENTERO" -> {
                        cadena.add(aux.getNodo(0).getLexema());
                    }
                    case "IDENTIFICADOR" -> {
                        try {
                            String auxID = simbolos.get(aux.getNodo(0).getLexema()).toString();
                            cadena.add(auxID);
                        } catch (Exception e) {
                            System.out.println("Error, la variable: \'" + aux.getNodo(0).getLexema() + "\' no ha sido inicializada");
                        }
                    }
                }
            }
            case "REPEAT" -> {
                Nodo aux = n.getNodo(1);
                int registro = 0;
                String auxNodo = n.getNodo(0).getLexema();
                switch(auxNodo) {
                    case "ENTERO" -> {
                        registro = Integer.parseInt(n.getNodo(0).getNodo(0).getLexema());
                        if (registro <= 0) {
                            System.out.println("Salío algo mal y no sé exactamente que sea :c");
                        }
                    }
                    case "IDENTIFICADOR" -> {
                        try {
                            String auxID = simbolos.get(n.getNodo(0).getNodo(0).toString()).toString();
                            registro = Integer.valueOf(auxID);
                            if (registro <= 0) {
                                System.out.println("Salío algo mal y no sé exactamente que sea :c");
                            }
                        } catch (Exception e) {
                            System.out.println("Error, la variable: \'"+n.getNodo(0).getNodo(0).getLexema()+"\' no ha sido inicializada");
                        }
                    }
                }
                for (int i = 0; i < registro; i++) {
                    analizador(n.getNodo(2));
                }
            }
            case "CONDICIONAL" -> {
                Nodo aux = n.getNodo(1);
                String VF = aux.getNodo(0).getLexema();
                if (VF.equals("VERDADERO")) {
                    Nodo auxVerdadero = aux.getNodo(2);
                    if (!auxVerdadero.getNodo(0).getLexema().equals("e")) {
                        analizador(auxVerdadero.getNodo(0));
                    }
                }
            }
            case "OPERACION" -> {
                String auxVariable = "";
                Integer auxDato = 0;
                if (n.getNodo(0).getLexema().equals("IDENTIFICADOR")) {
                    Nodo aux = n.getNodo(1);
                    if (aux.getNodo(0).getLexema().equals("=")) {
                        Nodo auxAsignar = n.getNodo(0);
                        auxVariable = auxAsignar.getNodo(0).getLexema();
                        auxDato = (Integer) analizador(aux.getNodo(1));
                        
                        simbolos.put(auxVariable, auxDato);
                    }
                }
            }
            case "T" -> {
                if (!n.getNodo(0).getLexema().equals("ϵ")) {
                    analizador(n.getNodo(0));
                    analizador(n.getNodo(1));
                }
            }
            case "V" -> {
                Integer resultado;
                if (!n.getNodo(1).getNodo(0).getLexema().equals("ϵ")) {
                    resultado =  ((Integer) analizador(n.getNodo(0)) + (Integer) analizador(n.getNodo(1)));
                    return resultado;
                } else {
                    resultado = (Integer) analizador(n.getNodo(0));
                    return resultado;
                }
            }
            case "A" -> {
                Integer resultado;
                resultado = (Integer) analizador(n.getNodo(1));
                return resultado;
            }
            case "B" -> {
                Integer resultado;
                if (!n.getNodo(1).getNodo(0).getLexema().equals("ϵ")) {
                    resultado =  ((Integer) analizador(n.getNodo(0)) * (Integer) analizador(n.getNodo(1)));
                    return resultado;
                } else {
                    resultado = (Integer) analizador(n.getNodo(0));
                    return resultado;
                }                
            }
            case "Y" -> {
                Integer resultado;
                resultado = (Integer) analizador(n.getNodo(1));
                return resultado;                
            }
            case "R" -> {
                String aux = n.getNodo(0).getLexema();
                switch(aux) {
                    case "IDENTIFICADOR" -> {
                        try {
                            String auxValor = simbolos.get(n.getNodo(0).getNodo(0).getLexema()).toString();
                            Integer resultado = Integer.valueOf(aux);
                            return resultado;
                        } catch (Exception e) {
                            System.out.println("Error, la variable: \'"+n.getNodo(0).getNodo(0).getLexema()+"\' no ha sido inicializada");
                        }
                    }
                    case "ENTERO" -> {
                        Integer resultado = Integer.valueOf(n.getNodo(0).getNodo(0).getLexema());
                        return resultado;
                    }
                    case "(" -> {
                        Integer resultado = (Integer) analizador(n.getNodo(1));
                        return resultado;
                    }
                }
            }
        }
        return null;
    }
    
    //--- Registro del Análisis
    public List<String> evaluarToken(List<Token> tokens) {
        List<String> registro;
        try {
            arbol = pila.analizarToken(tokens);
            registro = arbol.getRaiz().analizarRamas(0);
        } catch (Exception e) {
            registro = pila.getArbol().getRaiz().analizarRamas(0);
            registro.add(e.getMessage());
            registro.add("");
        }
        return registro;
    }
    
    //--- Reinicio
    private void reiniciar() {
        simbolos = new HashMap<>();
        cadena = new ArrayList<>();
    }
    
}