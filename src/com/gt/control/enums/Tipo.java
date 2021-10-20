package com.gt.control.enums;

public enum Tipo {
//---
    
    ENTERO("Número Entero"),
    IDENTIFICADOR("Identificador"),
    RESERVADO("Palabra Reservada"),
    LITERALES("Literal"),
    COMENTARIOS("Comentario"),
    ESPECIALES("Carácter Especial"),
    ERROR("Error");
    
    private String tipoToken;
    
    private Tipo(String tipoToken){
        this.tipoToken = tipoToken;
    }
    
}