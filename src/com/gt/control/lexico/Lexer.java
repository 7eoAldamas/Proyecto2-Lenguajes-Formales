package com.gt.control.lexico;

import static com.gt.control.enums.Tipo.*;
import com.gt.modelo.Token;
import java.util.*;
import javax.swing.JTextArea;

public class Lexer {
//--- Analizador Léxico - Validaciones AFD  
    
    private List<Token> rTokenValido = new ArrayList<>();
    private List<Token> rTokenErroneo = new ArrayList<>();
    private String cadena;
    private boolean isFila = false;
    private int pos = 0;
    private int fila = 1;
    private int col = 0;
    private int estadoActual = 0;
    
    //--- Matriz de Transición δ

                               //1-ID ; 2-D ; 3-Literal ; 5-Comentario ; 6-Agrupación ; 7-Operador ; 8-Signo Igual ; 13-Error  
                               //[0,0][0,1][0,2][0,3][0,4][0,5][0,6][0,7][0,8][0,9][0,10][0,11][0,12][0,13]
    private int [][] matrizT = {{  1,  -1,   2,  -1,   2,   4,  -1,   7,   6,   9,   8,    0,    0,    -1}, 
                               //[1,0][1,1][1,2][1,3][1,4][1,5][1,6][1,7][1,8][1,9][1,10][1,11][1,12][1,13]
                                {  1,   1,   1,   1,   1,  -1,  -1,  -1,   6,  -1,   -1,   0,    0,    -1}, 
                               //[2,0][2,1][2,2][2,3][2,4][2,5][2,6][2,7][2,8][2,9][2,10][2,11][2,12][2,13]
                                { -1,  -1,  -1,   2,   2,  -1,  -1,  -1,   6,  -1,   -1,   0,    0,    -1}, 
                               //[3,0][3,1][3,2][3,3][3,4][3,5][3,6][3,7][3,8][3,9][3,10][3,11][3,12][3,13]
                                { -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,   -1,   0,    0,    -1}, 
                               //[4,0][4,1][4,2][4,3][4,4][4,5][4,6][4,7][4,8][4,9][4,10][4,11][4,12][4,13]
                                {  4,   4,   4,   4,   4,   3,   4,   4,   4,   4,   4,    4,   -1,    -1}, 
                               //[5,0][5,1][5,2][5,3][5,4][5,5][5,6][5,7][5,8][5,9][5,10][5,11][5,12][5,13]
                                {  5,   5,   5,   5,   5,   5,   5,   5,   5,   5,   5,    5,    0,    -1}, 
                               //[6,0][6,1][6,2][6,3][6,4][6,5][6,6][6,7][6,8][6,9][6,10][6,11][6,12][6,13]
                                {  1,  -1,   2,  -1,   2,  -1,  -1,  -1,   6,  -1,  -1,    0,    0,    -1}, 
                               //[7,0][7,1][7,2][7,3][7,4][7,5][7,6][7,7][7,8][7,9][7,10][7,11][7,12][7,13]
                                { -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,   -1,   0,    0,    -1}, 
                               //[8,0][8,1][8,2][8,3][8,4][8,5][8,6][8,7][8,8][8,9][8,10][8,11][8,12][8,13]
                                { -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,   -1,   0,    0,    -1}, 
                               //[9,0][9,1][9,2][9,3][9,4][9,5][9,6][9,7][9,8][9,9][9,10][9,11][9,12][9,13]
                                { -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,  -1,   5,   -1,  -1,   -1,    -1}};
                               
        
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
            
            if (Character.isWhitespace(caracter) && estadoActual != 4) {
                siguiente = false;
            } else {
                isFila = false;
                int auxEstado = estadoActual;
                estadoActual = validarSiguienteEstado(estadoActual, caracter);
                token += caracter;  
                txtLog.append("Estado ->  " +auxEstado+ "     |     Transición ->  "+estadoActual+"     |     Caracter [ "+caracter+" ]");                
                txtLog.append("\n");
            }
            
            if (estadoActual == -1) {
                siguiente = false;
            }
            
            col++;
            pos++;
            isFila(caracter);
        }  
        txtLog.append("\n");
        if (!token.isBlank()) {
            if (!token.isBlank() && getToken().equals("Error")) {                
               rTokenErroneo.add(new Token(getToken(), token, this.fila, (col - 1)));
            } else {
               rTokenValido.add(new Token(getToken(), token, fila, (col - 1)));
            }
        }
    }
    
    //--- Movimiento en la Matriz de Transición δ 
    public int validarSiguienteEstado(int estadoActual, char caracter) {
        int siguienteEstado = -1;
        try {
            if (estadoActual >= 0 && estadoActual <=9) { 
                siguienteEstado = matrizT[estadoActual][evaluarAlfabeto(caracter)];
                System.out.println(siguienteEstado);
            }   
        } catch (Exception e) {
        }
        return siguienteEstado;
    }       
    
    //--- Evaluación del Alfabeto
    public int evaluarAlfabeto(char caracter) {
        int estado = 0; //Error
        if (isLetra(caracter)) {
            estado = 0;
        } else if (isNumero(caracter)) {
            estado = 4;
        } else if (isLiteral(caracter)) {
            estado = 5;
        } else if (isOperadorAritmetico(caracter)) {
            estado = 7;
        } else if (isSignoAgrupacion(caracter)) {
            estado = 8;
        } else if (isComentario(caracter)) {
            estado = 9;
        } else if (isAsignacion(caracter)) {
            estado = 10;
        }
        return estado;
    }
    
    //--- Tipo Token
    public String getToken() {
        String token; 
        switch(estadoActual) {
            case 1 -> {token = IDENTIFICADOR.getTipoToken();}
            case 2 -> {token = ENTERO.getTipoToken();}
            case 3 -> {token = LITERALES.getTipoToken();}
            case 5 -> {token = COMENTARIOS.getTipoToken();}            
            case 6 -> {token = AGRUPACION.getTipoToken();}
            case 7 -> {token = OPERADOR.getTipoToken();}
            case 8 -> {token = ASIGNACION.getTipoToken();}
            default -> {token = ERROR.getTipoToken();}
        }        
        return token;
    }    
        
    //--- Alfabeto Permitido ---
    
    //--- Letras
    public boolean isLetra(char caracter) {
        boolean isValido = false;
        if (((caracter >= 'a') && (caracter <= 'z') || (caracter >= 'A') && (caracter <= 'Z')) || (caracter == '-')
                || (caracter == '_')) {
            return true;
        }
        return isValido;        
    }
    
    //--- Números
    public boolean isNumero(char caracter) {
        boolean isValido = false;
        if ((caracter >= '1' && caracter <= '9') || (caracter == '0')) {
            return true;
        }
        return isValido;
    }
    
    //--- Literales        
    public boolean isLiteral(char caracter) {
        boolean isValido = false;
        if (caracter == '"') {
            isValido = true;
        }
        return isValido;
    }
    
    public boolean isLiteralRes(char caracter) {
        boolean isValido = false;
        switch(caracter) {
            case '<' -> {isValido = true;}
            case '>' -> {isValido = true;}
            case ':' -> {isValido = true;}
            case ';' -> {isValido = true;}
            case ',' -> {isValido = true;}
            case '\'' -> {isValido = true;}            
        }        
        return isValido;
    }
    
    //--- Comentarios
    public boolean isComentario(char caracter) {
        boolean isValido = false;
        if (caracter == '/') {
            isValido = true;
        }
        return isValido;
    }
    
    //--- Signos de Agrupación 
    public boolean isSignoAgrupacion(char caracter) {
        boolean isValido = false;
        switch(caracter) {
            case '(' -> {isValido = true;}
            case ')' -> {isValido = true;}
            case '{' -> {isValido = true;}
            case '}' -> {isValido = true;}
            case '[' -> {isValido = true;}
            case ']' -> {isValido = true;}
        }
        return isValido;
    }
    
    //--- Asignación
    public boolean isAsignacion(char caracter) {
        boolean isValido = false;
        if (caracter == '=') {
            isValido = true;
        }
        return isValido;
    }
    
     //--- Operadores Aritméticos
    public boolean isOperadorAritmetico(char caracter) {
        boolean isValido = false;
        switch(caracter) {
            case '+' -> {isValido = true;}
            case '-' -> {isValido = true;}
            case '*' -> {isValido = true;}
            case '%' -> {isValido = true;}
        }
        return isValido;
    }
    
    //--- Fila
    public void isFila(char caracter) {
        if (caracter == '\n') {
            isFila = true;
        }
    }  
    
    public List<Token> getRTokenValido() {
        return rTokenValido;
    }
    
    public List<Token> getRtokenErroneo() {
        return rTokenErroneo;
    }
    
}   