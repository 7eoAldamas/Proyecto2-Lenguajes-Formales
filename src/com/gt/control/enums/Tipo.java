package com.gt.control.enums;

public enum Tipo {
//--- Analizador Léxico - Tipos

    INICIO("Inicio"),
    ENTERO("Entero"),
    IDENTIFICADOR("Identificador"),
    COMENTARIOS("Comentario"),
    OPERADOR("O. Aritmético"),
    ASIGNACION("S. Igual"),
    AGRUPACION("S. Agrupación"),
    LITERALES("Literal"),
    ERROR("Error");

    private String tipoToken;

    private Tipo(String tipoToken) {
        this.tipoToken = tipoToken;
    }

    public String getTipoToken() {
        return tipoToken;
    }

}