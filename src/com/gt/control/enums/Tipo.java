package com.gt.control.enums;

public enum Tipo {
//--- Analizador Léxico - Tipos

    INICIO("INICIO"),
    ENTERO("ENTERO"),
    IDENTIFICADOR("IDENTIFICADOR"),
    COMENTARIOS("COMENTARIO"),
    OPERADOR("O. ARITMETICO"),
    ASIGNACION("S. IGUAL"),
    AGRUPACION("S. AGRUPACION"),
    LITERAL("LITERAL"),
    FINAL("FINAL"),
    ERROR("Error");

    private String tipoToken;

    private Tipo(String tipoToken) {
        this.tipoToken = tipoToken;
    }

    public String getTipoToken() {
        return tipoToken;
    }

}