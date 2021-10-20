package com.gt.modelo;

public class Token {
//---
    
    private String tipoToken;
    private String lexema;
    private int fila;
    private int col;

    public Token(String tipoToken, String lexema, int fila, int col) {
        this.tipoToken = tipoToken;
        this.lexema = lexema;
        this.fila = fila;
        this.col = col;
    }

    public String getTipoToken() {
        return tipoToken;
    }

    public String getLexema() {
        return lexema;
    }

    public int getFila() {
        return fila;
    }

    public int getCol() {
        return col;
    }
            
}