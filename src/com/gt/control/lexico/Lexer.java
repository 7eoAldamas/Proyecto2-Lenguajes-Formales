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
                             //
                             //[0,0][0,1][0,2][0,3][0,4][0,5][0,6][0,7]
    private int [][] matrizT = {{2,   1,   6,   5,   8,   9,  -1},
                             //[1,0][1,1][1,2][1,3][1,4][1,5][1,6][1,7]
                                {2,   1,   3,   4,   8,  -1,  -1},
                             //[2,0][2,1][2,2][2,3][2,4][2,5][2,6][2,7]
                                {2,   1,   3,   4,  -1,  -1,  -1},
                             //[3,0][3,1][3,2][3,3][3,4][3,5][3,6][3,7]
                                {2,   1,   3,   4,  -1,  -1,  -1},
                             //[4,0][4,1][4,2][4,3][4,4][4,5][4,6][4,7]
                                {2,   1,   3,   4,  -1,  -1,  -1},
                             //[5,0][5,1][5,2][5,3][5,4][5,5][5,6][5,7]
                                {-1, -1,   6,  -1,  -1,  -1,  -1},
                             //[6,0][6,1][6,2][6,3][6,4][6,5][6,6][6,7]
                                {-1, -1,   7,  -1,  -1,  -1,  -1},
                             //[7,0][7,1][7,2][7,3][7,4][7,5][7,6][7,7]
                                {-1, -1,   7,  -1,  -1,  -1,  -1},
                             //[8,0][8,1][8,2][8,3][8,4][8,5][8,6][8,7]
                                {-1, -1,   7,  -1,   8,  -1,  -1},
                             //[9,0][9,1][9,2][9,3][9,4][9,5][9,6][9,7]
                                {-1, -1,   7,  -1,  -1,   9,  -1}};
                               
    
    
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
                    continue;
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
            if (estadoActual >= 0 && estadoActual <=9) { 
                siguienteEstado = matrizT[estadoActual][evaluarAlfabeto(caracter)];
            }   
        } catch (Exception e) {
        }
        return siguienteEstado;
    }       
    
    //--- Evaluación del Alfabeto
    public int evaluarAlfabeto(char caracter) {
        int estado = 6;
        if (isLetra(caracter)) {
            estado = 0;
        } else if (caracter == '_') {
            estado = 1;
        } else if (isNumero(caracter)) {
            estado = 2;
        } else if (caracter == '-') {
            estado = 3;
        } else if (caracter == '"') {
            estado = 4;
        } else if (isLiteral(caracter)) {
            estado = 5;
        }
        return estado;
    }
    
    //--- Tipo Token
    public String getToken() {
        String token; 
        switch(estadoActual) {
            case 2, 3, 4 -> {token = IDENTIFICADOR.getTipoToken();}
            case 6, 7 -> {token = ENTERO.getTipoToken();}  
            case 9, 10 -> {token = LITERALES.getTipoToken();}
            case 11 -> {token = COMENTARIOS.getTipoToken();}
            default -> {token = ERROR.getTipoToken();}
        }        
        return token;
    }    
        
    //--- Alfabeto Permitido ---
    
    //--- Letras
    public boolean isLetra(char caracter) {
        boolean isValido = false;
        if (((caracter >= 'a') && (caracter <= 'z') || (caracter >= 'A') && (caracter <= 'Z'))) {
            return true;
        }
        return isValido;        
    }
    
    //--- Números
    public boolean isNumero(char caracter) {
        boolean isValido = false;
        if (caracter >= '0' && caracter <= '9') {
            return true;
        }
        return isValido;
    }
    
    //--- Literal - Símbolos
    public boolean isLiteral(char caracter) {
        boolean isValido = false;
        switch(caracter) {
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