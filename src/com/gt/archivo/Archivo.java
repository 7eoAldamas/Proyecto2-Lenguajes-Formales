package com.gt.archivo;

import com.gt.vista.GUI.Principal;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Archivo {
//---

    //--- Lectura de Archivo
    public void leerArchivo(File path, JTextArea txtArea) {
        txtArea.selectAll();
        txtArea.replaceSelection(null);
        try (FileReader file = new FileReader(path);
                BufferedReader br = new BufferedReader(file)) {

            String lineaTxt;
            while ((lineaTxt = br.readLine()) != null) {
                txtArea.append(lineaTxt);
                txtArea.append("\n");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(txtArea, "Lectura de Archivo", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    //--- Nuevo - Archivo
    public void abrirArchivo(File path, JTextArea txtArea) {
        txtArea.selectAll();
        txtArea.replaceSelection(null);
        if (path != null) {
            leerArchivo(path, txtArea);
        }
    }

    //--- Guardar - Archivo
    public void guardarArchivo(File path, JTextArea txtArea) {
        try (FileWriter fwriter = new FileWriter(path);
                BufferedWriter bw = new BufferedWriter(fwriter)) {

            bw.write(txtArea.getText());
            bw.newLine();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(txtArea, "Guardar Archivo", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    //--- Guardar Como - Archivo
    public File guardarComoArchivo(JFileChooser file, JTextArea txtArea, Principal menu) {
        File aux = null;
        int select = file.showOpenDialog(menu);
        if (select == JFileChooser.APPROVE_OPTION) {
            aux = new File(file.getSelectedFile() + ".txt");
            try (FileWriter fwriter = new FileWriter(aux);
                    BufferedWriter bw = new BufferedWriter(fwriter)) {

                bw.write(txtArea.getText());
                bw.newLine();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(txtArea, "Guardar Archivo", "Error", JOptionPane.ERROR_MESSAGE);
            }            
        }
        return aux;
    }

    //--- Obtener Path - Archivo
    public File obtenerPath(JFileChooser file, Principal menu) {
        File auxPath = null;
        int select = file.showOpenDialog(menu);
        if (select == JFileChooser.APPROVE_OPTION) {
            auxPath = file.getSelectedFile();
        }
        return auxPath;
    }

}