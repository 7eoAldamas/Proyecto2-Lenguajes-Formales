package com.gt.vista;

import javax.swing.event.*;
import javax.swing.undo.UndoManager;

public class UndoControl implements UndoableEditListener{
//--- 
    
    private UndoManager undoManager;

    public UndoControl(UndoManager undoManager) {
        this.undoManager = undoManager;
    }        
    
    @Override
    public void undoableEditHappened(UndoableEditEvent e) {
        undoManager.addEdit(e.getEdit());
    }
    
}