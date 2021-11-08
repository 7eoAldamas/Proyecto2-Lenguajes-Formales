package com.gt.control.sintactico;

import com.gt.modelo.Token;

public class Gramatica {
//--- Gramática LL1
    
    private String inicio;
    private String[] terminales;
    private String[] reservados;
    private String[] tokensEspeciales;
    private Reglas[] derivaciones;

    public Gramatica(String inicio, String[] terminales, String[] reservados, String[] tokensEspeciales, Reglas[] derivaciones) {
        this.inicio = inicio;
        this.terminales = terminales;
        this.reservados = reservados;
        this.tokensEspeciales = tokensEspeciales;
        this.derivaciones = derivaciones;
    }

    public String getInicio() {
        return inicio;
    }

    public String[] getTerminales() {
        return terminales;
    }

    public String[] getNoTerminales() {
        return tokensEspeciales;
    }

    public Reglas[] getReglas() {
        return derivaciones;
    }
    
    //--- Evaluación de Primeros
    public String[] primeros(Token token, String actual) {
        String[] aux = null;
        Reglas derivacionInicial = getDerivaciones(actual);
        for (String[] derivacion : derivacionInicial.getDerivaciones()) {
            String simboloInicial = derivacion[0];
            if (isTerminal(simboloInicial)) {
                if (simboloInicial.equals(token.getTipoToken()) || simboloInicial.equals(token.getLexema())) {
                   return derivacion; 
                }
            } else {
                if (primeros(token, simboloInicial) != null) {
                    return derivacion;
                }
            }
        }
        if (derivacionInicial.isEpsilon()) {
            aux = new String[]{""};
            return aux;
        }
        return aux;
    }
    
    //--- Derivaciones de No Terminales
    public Reglas getDerivaciones(String derivacion) {
        for (Reglas derivacionesR : derivaciones) {
            if (derivacionesR.getInicio().equals(derivacion)) {
                return derivacionesR;
            }
        }
        return null;
    }
    
    //--- Símbolo Terminal
    public boolean isTerminal(String token) {
        boolean isValido = false;
        for (String terminal : terminales) {
            if (token.equals(terminal)) {
                isValido = true;
            }
        }
        return isValido;
    }
    
    //--- Tokens Especiales
    public boolean isTokenEspecial(String token) {
        boolean isValido = false;
        for (String noTerminal : tokensEspeciales) {
            if (token.equals(noTerminal)) {
                isValido = true;
            }
        }
        return isValido;
    }
    
    //--- Palabra Reservada - Estructuras
    public boolean isReservado(String token) {
        boolean isValido = false;
        for (String reservado : reservados) {
            if (token.equals(reservado)) {
                isValido = true;
            }
        }
        return isValido;
    }    
    
}