package com.gt.control.enums;

public enum Tipo {
//---
    
    ENTERO("Entero"),
    IDENTIFICADOR("Identificador"),
    LITERALES("Literal"),
    COMENTARIOS("Comentario"),
    ERROR("Error");
    
    private String tipoToken;
    
    private Tipo(String tipoToken){
        this.tipoToken = tipoToken;
    }

    public String getTipoToken() {
        return tipoToken;
    }
        
}