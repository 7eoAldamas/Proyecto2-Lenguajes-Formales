package com.gt.vista;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.undo.*;

public class Redo extends AbstractAction {
//--- Redo    

    private UndoManager redo;

    public Redo(UndoManager redo) {
        this.redo = redo;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            redo.redo();
        } catch (CannotRedoException ex) {
        }
    }

}