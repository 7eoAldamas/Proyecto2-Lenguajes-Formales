package com.gt.vista.GUI;

import com.gt.archivo.Archivo;
import com.gt.vista.Borde;
import java.awt.Image;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Principal extends JFrame {
//--- Ventana Principal - Analizador (Léxico/Sintáctico)
    
    private ImageIcon image, icon, image2, icon2;
    private final Archivo archivo = new Archivo();   
    private File aux;
    
    public Principal() {
        initComponents();
        colocarImagenes();
        txtArea.setBorder(new Borde());
        setTitle("Analizador Lenguaje");
        setSize(900, 560);
        setResizable(false);
        setLocationRelativeTo(null);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        panelP = new javax.swing.JPanel();
        btnRehacer = new javax.swing.JButton();
        btnDeshacer = new javax.swing.JButton();
        btnLexico = new javax.swing.JButton();
        btnSintactico = new javax.swing.JButton();
        scrollAText = new javax.swing.JScrollPane();
        txtArea = new javax.swing.JTextArea();
        scrollLText = new javax.swing.JScrollPane();
        txtALog = new javax.swing.JTextArea();
        menuBarra = new javax.swing.JMenuBar();
        menuArchivos = new javax.swing.JMenu();
        itemAbrir = new javax.swing.JMenuItem();
        itemNuevo = new javax.swing.JMenuItem();
        itemGuardar = new javax.swing.JMenuItem();
        itemGuardarC = new javax.swing.JMenuItem();
        menuEdit = new javax.swing.JMenu();
        itemCopiar = new javax.swing.JMenuItem();
        itemPegar = new javax.swing.JMenuItem();
        menuReport = new javax.swing.JMenu();
        menuAcercaDe = new javax.swing.JMenu();

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        panelP.setBackground(new java.awt.Color(93, 109, 126));

        btnRehacer.setBorderPainted(false);
        btnRehacer.setContentAreaFilled(false);

        btnDeshacer.setBorderPainted(false);
        btnDeshacer.setContentAreaFilled(false);

        btnLexico.setText("Lexico");
        btnLexico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLexicoActionPerformed(evt);
            }
        });

        btnSintactico.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        btnSintactico.setText("Sintactico");
        btnSintactico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSintacticoActionPerformed(evt);
            }
        });

        txtArea.setColumns(20);
        txtArea.setRows(5);
        scrollAText.setViewportView(txtArea);

        txtALog.setColumns(20);
        txtALog.setRows(5);
        scrollLText.setViewportView(txtALog);

        javax.swing.GroupLayout panelPLayout = new javax.swing.GroupLayout(panelP);
        panelP.setLayout(panelPLayout);
        panelPLayout.setHorizontalGroup(
            panelPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(panelPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(scrollLText, javax.swing.GroupLayout.PREFERRED_SIZE, 725, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelPLayout.createSequentialGroup()
                        .addGroup(panelPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnSintactico, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(panelPLayout.createSequentialGroup()
                                    .addComponent(btnDeshacer, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnRehacer, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(btnLexico, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(37, 37, 37)
                        .addComponent(scrollAText, javax.swing.GroupLayout.PREFERRED_SIZE, 725, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        panelPLayout.setVerticalGroup(
            panelPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(panelPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelPLayout.createSequentialGroup()
                        .addGroup(panelPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnDeshacer, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnRehacer, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(btnLexico, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(btnSintactico, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(scrollAText, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(scrollLText, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        menuArchivos.setText("Archivos");

        itemAbrir.setText("Abrir");
        itemAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemAbrirActionPerformed(evt);
            }
        });
        menuArchivos.add(itemAbrir);

        itemNuevo.setText("Nuevo");
        itemNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemNuevoActionPerformed(evt);
            }
        });
        menuArchivos.add(itemNuevo);

        itemGuardar.setText("Guardar");
        itemGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemGuardarActionPerformed(evt);
            }
        });
        menuArchivos.add(itemGuardar);

        itemGuardarC.setText("Guardar Como");
        itemGuardarC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemGuardarCActionPerformed(evt);
            }
        });
        menuArchivos.add(itemGuardarC);

        menuBarra.add(menuArchivos);

        menuEdit.setText("Edición");

        itemCopiar.setText("Copiar");
        menuEdit.add(itemCopiar);

        itemPegar.setText("Pegar");
        menuEdit.add(itemPegar);

        menuBarra.add(menuEdit);

        menuReport.setText("Reportes");
        menuReport.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuReportMouseClicked(evt);
            }
        });
        menuBarra.add(menuReport);

        menuAcercaDe.setText("Acerca De");
        menuAcercaDe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuAcercaDeMouseClicked(evt);
            }
        });
        menuBarra.add(menuAcercaDe);

        setJMenuBar(menuBarra);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void itemAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemAbrirActionPerformed
        // Evento Abrir Archivo - Leer Archivo  
        JFileChooser jfile = new JFileChooser();
        jfile.setApproveButtonText("Abrir");
        aux = archivo.obtenerPath(jfile, this);
        archivo.leerArchivo(aux, txtArea);
    }//GEN-LAST:event_itemAbrirActionPerformed

    private void itemNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemNuevoActionPerformed
        // Evento Abrir Nuevo Archivo
        JFileChooser jfile = new JFileChooser();
        jfile.setApproveButtonText("Abrir");
        aux = archivo.obtenerPath(jfile, this);
        archivo.abrirArchivo(aux, txtArea);        
    }//GEN-LAST:event_itemNuevoActionPerformed

    private void itemGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemGuardarActionPerformed
        // Evento Guardar Archivo
        if (aux != null) {
            File auxPath = aux.getAbsoluteFile();
            archivo.guardarArchivo(auxPath, txtArea);
        } else {
            JOptionPane.showMessageDialog(txtArea, "La acción no se puede ejecutar\n    Presione Guardar Como", "Información", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_itemGuardarActionPerformed

    private void itemGuardarCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemGuardarCActionPerformed
        // Evento Guardar Como - Archivo
        JFileChooser jfile = new JFileChooser();
        jfile.setApproveButtonText("Guardar");
        aux = archivo.guardarComoArchivo(jfile, txtArea, this);        
    }//GEN-LAST:event_itemGuardarCActionPerformed

    private void btnLexicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLexicoActionPerformed
        // Análisis Léxico
    }//GEN-LAST:event_btnLexicoActionPerformed

    private void btnSintacticoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSintacticoActionPerformed
        // Análisis Sintáctico
    }//GEN-LAST:event_btnSintacticoActionPerformed

    private void menuAcercaDeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuAcercaDeMouseClicked
        // Evento - Acerca De
        JOptionPane.showMessageDialog(this, "202030011 - Leobardo Daniel González Aldamas\n"
                                          + "Centro Universitario de Occidente - USAC\n"       
                                          + "Lenguajes Formales y de Computación\n"
                                          + "2021", "Información", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_menuAcercaDeMouseClicked

    private void menuReportMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuReportMouseClicked
        // Evento Visualización de TokenR
        new TokenR(this, true, true).setVisible(true);
    }//GEN-LAST:event_menuReportMouseClicked

    //--- Imágenes Botones (Deshacer-Rehacer)
    private void colocarImagenes() {
        image = new ImageIcon(getClass().getResource("/com/gt/vista/image/previous.png"));
        icon = new ImageIcon(image.getImage().getScaledInstance(btnDeshacer.getWidth(), btnDeshacer.getHeight(), Image.SCALE_SMOOTH));
        btnDeshacer.setIcon(icon);
        
        image2 = new ImageIcon(getClass().getResource("/com/gt/vista/image/next.png"));
        icon2 = new ImageIcon(image2.getImage().getScaledInstance(btnRehacer.getWidth(), btnRehacer.getHeight(), Image.SCALE_SMOOTH));
        btnRehacer.setIcon(icon2);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDeshacer;
    private javax.swing.JButton btnLexico;
    private javax.swing.JButton btnRehacer;
    private javax.swing.JButton btnSintactico;
    private javax.swing.JMenuItem itemAbrir;
    private javax.swing.JMenuItem itemCopiar;
    private javax.swing.JMenuItem itemGuardar;
    private javax.swing.JMenuItem itemGuardarC;
    private javax.swing.JMenuItem itemNuevo;
    private javax.swing.JMenuItem itemPegar;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu menuAcercaDe;
    private javax.swing.JMenu menuArchivos;
    private javax.swing.JMenuBar menuBarra;
    private javax.swing.JMenu menuEdit;
    private javax.swing.JMenu menuReport;
    private javax.swing.JPanel panelP;
    private javax.swing.JScrollPane scrollAText;
    private javax.swing.JScrollPane scrollLText;
    private javax.swing.JTextArea txtALog;
    private javax.swing.JTextArea txtArea;
    // End of variables declaration//GEN-END:variables
}