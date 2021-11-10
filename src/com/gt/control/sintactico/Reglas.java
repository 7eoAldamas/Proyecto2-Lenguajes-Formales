package com.gt.control.sintactico;

public class Reglas {
//--- Reglas de Producción    
    
    private String inicio;
    private String[][] derivaciones;
    
    public Reglas(String inicio, String[][] derivaciones) {
        this.inicio = inicio;
        this.derivaciones = derivaciones;
    }

    public String getInicio() {
        return inicio;
    }

    public String[][] getDerivaciones() {
        return derivaciones;
    }
    
    //---
    public boolean isEpsilon() {
        boolean isValido = false;
        for (String[] derivacione : derivaciones) {
            if (derivacione[0].equals("")) {
                isValido = true;
            }
        }
        return isValido;
    }
    
}