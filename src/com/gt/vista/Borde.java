package com.gt.vista;

import java.awt.*;
import javax.swing.JViewport;
import javax.swing.border.AbstractBorder;

public class Borde extends AbstractBorder{
//---
    
    private final int alturaLinea = 16; //Altura Fila - Caracteres
    private final int altura = 10; //Altura Número de Fila - Borde
    private final int ancho = 8; //Ancho Número de Fila - Borde
    private JViewport viewport; //Deslizamiento - Scroll

    @Override             //Componente -txtArea              Eje X  | Eje Y |  Ancho  |  Altura
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        int posX; //Posición - Eje X
        int posY; //Posición - Eje Y
        int pos = 0; //Posición 
        int tamanio;
        
        if (viewport == null) {
            buscarViewport(c);
        }
        
        Point point;
        Dimension size = null;
        if (viewport != null) {
            point = viewport.getViewPosition();           
        } else {
            point = new Point(); //(0, 0)
        }
        
        int auxFila = (height / alturaLinea);
        int fila = (auxFila + 1);
        String aux = String.valueOf(fila);
        int tamanioMax = aux.length();
        
        if (point.y > 0) {
            pos = (point.y / alturaLinea);
        }
        
        if (size != null) {
            auxFila = (size.height / alturaLinea);
            fila = (auxFila + 1);
            fila += pos + 1;
        }
        
        for (int i = 0; i < fila; i++) {
            aux = String.valueOf(i + 1);
            tamanio = aux.length();
            tamanio = tamanioMax - tamanio;
            
            posX = (ancho * tamanio + 2);
            posY = (alturaLinea * i + 14);
            
            g.drawString(aux, posX, posY);
        }
        
        int iz = ubicacionIz(height) + 5;
        g.drawLine(iz, 0, iz, height);
    }

    @Override
    public Insets getBorderInsets(Component c) {
        int iz = ubicacionIz(c.getHeight()) + 10;
        return new Insets(1, iz, 1, 1);
    }

    //--- Búsqueda del Componente
    private void buscarViewport(Component c) {
        Container parent = c.getParent();
        if (parent instanceof JViewport parentViewport) {
            viewport = parentViewport;
        }        
    }

    //--- Posición parte izquierda - Borde
    private int ubicacionIz(int height) {
        int auxFila = (height / alturaLinea);
        int fila = (auxFila + 1);
        String aux = String.valueOf(fila);
        int tamanio = aux.length();
        return (altura * tamanio);        
    }
             
}