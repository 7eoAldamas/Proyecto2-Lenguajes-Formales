package com.gt.control.lexico;

import com.gt.modelo.Token;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Reporte {
//---
             
    public static void tablaTokens(List<Token> listaTokens, JTable tablaTokens) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Token");
        modelo.addColumn("Cadena");
        modelo.addColumn("Fila");
        modelo.addColumn("Columna");

        tablaTokens.setModel(modelo);
        
        listaTokens.forEach(t -> {
            modelo.addRow(new Object[]{t.getTipoToken(), t.getLexema(), t.getFila(), t.getCol()});
        });        
    }   
    
}