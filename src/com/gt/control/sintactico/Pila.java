package com.gt.control.sintactico;

import com.gt.modelo.Token;
import java.util.*;
import javax.swing.JOptionPane;

public class Pila {
//---

    private Stack<String> automata;
    private Stack<Nodo> recorrido;
    private Arbol arbol;
    private Nodo cabeza; 
    private Token token;  
    private int size = 0;
    
    //--- Definición - Gramatica LL1
    private Gramatica gramatica = new Gramatica("L",                                                                                                        //Épsilon
            new String[]{"(", ")", "=", "+", "*", "ENTERO", "IDENTIFICADOR", "LITERAL", "ESCRIBIR", "REPETIR", "INICIAR", "SI", "VERDADERO", "FALSO", "ENTONCES", "FIN", ""}
            , new String[]{"ESCRIBIR", "REPETIR", "INICIAR", "SI", "VERDADERO", "FALSO", "ENTONCES", "FIN"}
            , new String[]{"LITERAL", "ENTERO", "IDENTIFICADOR"}
            //Tabla de Análisis Sintáctico LL1 - δ
            , new Reglas[]{                                                                                                                                            //Épsilon
                new Reglas("L", new String[][]{{"ESCRITURA", "L"}, {"REPEAT", "L"}, {"CONDICIONAL", "L"}, {"OPERACION", "L"}, {""}}), 
                //Derivaciones Estructura -> ESCRITURA
                    new Reglas("ESCRITURA", new String[][]{{"ESCRIBIR", "U", "FIN"}}),
                    //Derivaciones No Terminal -> U
                    new Reglas("U", new String[][]{{"LITERAL"}, {"ENTERO"}, {"IDENTIFICADOR"}}),
                    
                //Derivaciones Estructura -> REPETIR
                    new Reglas("REPEAT", new String[][]{{"REPETIR", "P", "FIN"}}),
                    //Derivaciones No Terminal -> P
                    new Reglas("P", new String[][]{{"ENTERO", "INICIAR", "T"}, {"IDENTIFICADOR", "INICIAR", "T"}}),
                        //Derivaciones No Terminal -> T
                        new Reglas("T", new String[][]{{"ESCRITURA", "T"}, {""}}),
                        
                //Derivaciones Estructura -> CONDICIONAL
                    new Reglas("CONDICIONAL", new String[][]{{"SI", "S", "FIN"}}),
                    //Derivaiones No Terminal -> S
                    new Reglas("S", new String[][]{{"VERDADERO", "ENTONCES", "Q"}, {"FALSO", "ENTONCES", "Q"}}),
                        //Derivaiones No Terminal -> Q
                        new Reglas("Q", new String[][]{{"ESCRITURA"}, {""}}),
                    
                //Derivaciones Estructura -> OPERACION - ASIGNACION
                    new Reglas("OPERACION", new String[][]{{"IDENTIFICADOR", "X", "FIN"}, {"M", "FIN"}}),
                    //Derivaciones No Terminal -> X
                    new Reglas("X", new String[][]{{"=", "V"}, {"+", "V"}, {"*", "V"}}),
                        //Derivaciones No Terminal -> ASIGNACION
                        new Reglas("ASIGNACION", new String[][]{{"V"}}),
                            //Derivaciones No Terminal -> V 
                            new Reglas("V", new String[][]{{"B", "A"}}),
                                //Derivaciones No Terminal -> A
                                new Reglas("A", new String[][]{{"+", "B"}, {""}}),
                                    //Derivaciones No Terminal -> B
                                    new Reglas("B", new String[][]{{"R", "Y"}, {""}}),
                                        //Derivaciones No Terminal -> Y
                                        new Reglas("Y", new String[][]{{"*", "R"}, {""}}),
                                            //Derivaciones No Terminal -> R
                                            new Reglas("R", new String[][]{{"IDENTIFICADOR"}, {"ENTERO"}, {"(", "V", ")"}}),
                                            
                //Derivaciones ESTRUCTURA -> EXPRESION
                new Reglas("M", new String[][]{{"N", "O"}}),
                    //Derivaciones No Terminal -> O
                    new Reglas("O", new String[][]{{"+", "N"}, {""}}),
                        //Derivacione No Terminal -> N
                        new Reglas("N", new String[][]{{"F", "E"}}),
                            //Derivaciones No Terminal -> E
                            new Reglas("E", new String[][]{{"*", "F"}, {""}}),
                                //Derivaciones No Terminal -> F
                                new Reglas("F", new String[][]{{"ENTERO"}, {"(", "M", ")"}}),
            });
    

    //--- Análisis a Tokens - Construcción de Árbol Sintáctico
    public Arbol analizarToken(List<Token> tokens) {
        tokens.add(new Token("", "", tokens.get(tokens.size() - 1).getFila(), tokens.get(tokens.size() - 1).getCol()));
        arbol = new Arbol(new Nodo(gramatica.getInicio()));
        automata = new Stack<>();
        recorrido = new Stack<>();
        automata.push(gramatica.getInicio());
        cabeza = arbol.getRaiz();
        recorrido.push(cabeza);
        token = tokens.remove(0);

        while (!automata.isEmpty()) {
            if (gramatica.isTerminal(automata.peek())) {
                if (automata.peek().equals(token.getTipoToken()) || automata.peek().equals(token.getLexema())) {
                    accionReduce();
                    token = tokens.remove(0);
                } else {
                    JOptionPane.showMessageDialog(null, "Error Sintáctico\n"
                            + "Posición: \n"
                            + "\nFila:" + token.getFila()
                            + "\nColumna: " + token.getCol()
                            + "\nToken: " + token.getLexema()
                            + "\nProducción: " + automata.peek(), "Información", JOptionPane.INFORMATION_MESSAGE);
                    break;
                }
            } else {
                String[] derivaciones = gramatica.primeros(token, automata.peek());
                if (derivaciones != null) {
                    accionShift(derivaciones);
                } else {
                    JOptionPane.showMessageDialog(null, "Error Sintáctico\n"
                            + "Posición:"
                            + "\nFila:" + token.getFila()
                            + "\nColumna: " + token.getCol()
                            + "\nToken: " + token.getLexema()
                            + "\nProducción: " + automata.peek(), "Información", JOptionPane.INFORMATION_MESSAGE);
                    break;
                }
            }
        }
        return arbol;
    }    
    
    //--- Obtener Elemento Específico - Pila
    public String getLexema(int index) {
        int contador = 0;
        Nodo tmp = cabeza;
        while (contador < index) {            
            tmp = tmp.getNodo(index);
            contador++;
        }
        return tmp.getLexema();
    }
    
    //--- Método Reduce
    private void accionReduce() {
        if (!gramatica.isReservado(token.getLexema()) && gramatica.isTokenEspecial(token.getTipoToken())) {
            cabeza.addRama(new Nodo(token.getLexema()));
        }
        automata.pop();
        recorrido.pop();
        cabeza = recorrido.peek();
    }

    //--- Método Shift
    private void accionShift(String[] derivaciones) {
        if (derivaciones[0].equals("")) {
            cabeza.addRama(new Nodo("ϵ"));
            automata.pop();
            recorrido.pop();
        } else {
            automata.pop();
            recorrido.pop();
            for (int i = derivaciones.length - 1; i >= 0; i--) {
                Nodo nodoDerivacion = new Nodo(derivaciones[i]);
                automata.push(derivaciones[i]);
                recorrido.push(nodoDerivacion);
            }
            for (int i = 0; i < derivaciones.length; i++) {
                Nodo nodoDerivacion = recorrido.elementAt(recorrido.size() - 1 - i);
                cabeza.addRama(nodoDerivacion);
            }
        }
        if (!recorrido.empty()) {
            cabeza = recorrido.peek();
        }
    }

    //--- Verificar contenido - Pila - Empty
    public boolean isVacia() {
        return (cabeza == null);
    }
    
    //--- Tamaño - Pila
    public int size() {
        return size;
    }
    
    //--- Obtener Árbol Sintáctico
    public Arbol getArbol() {
        return arbol;
    }
    
}