package com.gt.control.lexico;

import static com.gt.control.enums.Tipo.*;
import javax.swing.JTextArea;

public class Lexer {
//--- Validaciones      
    
    private String cadena;
    private boolean isFila = false;
    private int pos = 0;
    private int fila = 1;
    private int col = 0;
    private int estadoActual = 0;
    
    //--- Matriz de Transición δ
                             //Numeros        Error
                             //[0,0][0,1][0,2][0,3]
    private int [][] matrizT = {{ 1,  2,   3,  -1},
                             //[1,0][1,1][1,2][1,3]
                                {-1, -1,  -1,  -1},
                             //[2,0][2,1][2,2][2,3]
                                {-1, -1,   3,  -1},
                             //[3,0][3,1][3,2][3,3]
                                { 4, -1,   3,  -1},
                             //[3,0][3,1][3,2][4,3]
                                { 4, -1,   3,  -1}};
    
    //--- Analizar Token
    public void analizarToken(JTextArea txtArea, JTextArea txtLog) {
        txtLog.selectAll();
        txtLog.replaceSelection(null);
        cadena = txtArea.getText();
        while (pos < cadena.length()) {            
            token(txtLog);
        }
    }    
    
    //--- Validación de Tokens
    public void token(JTextArea txtLog) {
        boolean siguiente = true;
        char caracter;
        estadoActual = 0;
        String token = "";
        
        while (siguiente && (pos < cadena.length())) {                          
            if (isFila) {
                fila++;
                col = 0;
            }
            
            caracter = cadena.charAt(pos);                                    
            
            if (Character.isWhitespace(caracter)) {
                siguiente = false;
            } else {
                isFila = false;
                int auxEstado = estadoActual;
                estadoActual = validarSiguienteEstado(estadoActual, caracter);
                token += caracter;  
                txtLog.append("Estado ->  " +auxEstado+ "     |     Transición ->  "+estadoActual+"     |     Caracter [ "+caracter+" ]");                
                txtLog.append("\n");
                
                if (estadoActual == -1) {
                    siguiente = false; //Error - Reinicio                
                    txtLog.append("*-\t Error     |     Caracter [ "+caracter+" ]");
                    txtLog.append("\n");
                    txtLog.append("*-\t Posible Token -----------------------------");
                }            
            }
            
            col++;
            pos++;
            isFila(caracter);
        }  
        txtLog.append("\n");
    }
    
    //--- Movimiento en la Matriz de Transición δ 
    public int validarSiguienteEstado(int estadoActual, char caracter) {
        int siguienteEstado = -1;
        try {
            if (estadoActual >= 0 && estadoActual <=4) { 
                siguienteEstado = matrizT[estadoActual][evaluarAlfabeto(caracter)];
            }   
        } catch (Exception e) {
        }
        return siguienteEstado;
    }       
    
    //--- Evaluación del Alfabeto
    public int evaluarAlfabeto(char caracter) {
        int estado = 3;
        if (caracter == '0') {
            estado = 0;
        } else if (isSigno(caracter)) {
            estado = 1;
        } else if (isNumero(caracter)) {
            estado = 2;
        }
        return estado;
    }
    
    //--- Tipo Token
    public String getToken() {
        String token; 
        switch(estadoActual) {
            case 1, 3, 4 -> {token = ENTERO.getTipoToken();}
            case 2 -> {token = IDENTIFICADOR.getTipoToken();}            
            default -> {token = ERROR.getTipoToken();}
        }        
        return token;
    }    
        
    //--- Alfabeto Permitido
    
    //--- Números
    public boolean isNumero(char caracter) {
        boolean isValido = false;
        if (caracter >= '1' && caracter <= '9') {
            return true;
        }
        return isValido;
    }
    
    //--- Sígnos
    public boolean isSigno(char caracter) {
        boolean isValido = false;
        switch(caracter) {
            case '-' -> {isValido = true;}
            case '+' -> {isValido = true;}
        }
        return isValido;
    }
    
    //--- Literal
    public boolean isLiteral(char caracter) {
        boolean isValido = false;
        switch(caracter) {
            case '"' -> {isValido = true;}
            case '<' -> {isValido = true;}
            case '>' -> {isValido = true;}
            case ':' -> {isValido = true;}
            case ',' -> {isValido = true;}
            case '/' -> {isValido = true;}
            case '=' -> {isValido = true;}
            case '+' -> {isValido = true;}
            case '-' -> {isValido = true;}
            case '*' -> {isValido = true;}                        
        }        
        return isValido;
    }
    
    //--- Fila
    public void isFila(char caracter) {
        if (caracter == '\n') {
            isFila = true;
        }
    }    
    
}   