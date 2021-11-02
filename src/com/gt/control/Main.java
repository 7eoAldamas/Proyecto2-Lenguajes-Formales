package com.gt.control;

import com.gt.control.sintactico.Pila;
import com.gt.vista.GUI.Principal;
import java.awt.EventQueue;

public class Main {
//---
    
     public static void main(String[] args) {
        //--- Código Ejecutable
        EventQueue.invokeLater(() -> {
            new Principal().setVisible(true);
        });

        Pila token1 = new Pila();
        token1.addPrimero("ESCRIBIR");
        token1.addPrimero("FIN");
        token1.addPrimero("PARA");
        token1.addPrimero("3");
        token1.addPrimero("REPETIR");
        token1.addPrimero("FINULTIMO");
        
         System.out.println(token1.isVacia());
         System.out.println(token1.obtenerElemento(0));
    }
    
}