package com.gt.vista;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.undo.*;

public class Undo extends AbstractAction {
//--- Undo 

    private UndoManager undo;

    public Undo(UndoManager undo) {
        this.undo = undo;
    }        

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            undo.undo();
        } catch (CannotUndoException ex) {
        }
    }

}