package com.gt.vista.GUI;

import javax.swing.JFrame;

public class Principal extends JFrame {
//--- Ventana Principal - Analizador (Léxico/Sintáctico)
    
    public Principal() {
        initComponents();
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
        btnDeshacer1 = new javax.swing.JButton();
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

        btnLexico.setText("Lexico");

        btnSintactico.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        btnSintactico.setText("Sintactico");

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
                                    .addComponent(btnDeshacer1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                            .addComponent(btnDeshacer1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        menuArchivos.add(itemAbrir);

        itemNuevo.setText("Nuevo");
        menuArchivos.add(itemNuevo);

        itemGuardar.setText("Guardar");
        menuArchivos.add(itemGuardar);

        itemGuardarC.setText("Guardar Como");
        menuArchivos.add(itemGuardarC);

        menuBarra.add(menuArchivos);

        menuEdit.setText("Edición");

        itemCopiar.setText("Copiar");
        menuEdit.add(itemCopiar);

        itemPegar.setText("Pegar");
        menuEdit.add(itemPegar);

        menuBarra.add(menuEdit);

        menuReport.setText("Reportes");
        menuBarra.add(menuReport);

        menuAcercaDe.setText("Acerca De");
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDeshacer1;
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