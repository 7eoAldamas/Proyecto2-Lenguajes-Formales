package com.gt.vista.GUI;

import com.gt.vista.Borde;
import java.util.List;
import javax.swing.JDialog;

public class Result extends JDialog {
//--- Ventana Ingresar Patrón - Analizador Léxico

    private Principal menu;
    private boolean init;

    public Result(Principal parent, boolean modal, boolean init, List<String> result) {
        super(parent, modal);
        initComponents();
        this.menu = parent;
        this.init = init;
        txtArbol.setBorder(new Borde());
        iniciarDibujo(result);
        setSize(900, 450);
        setLocationRelativeTo(null);
    }

    //--- Mostrar Árbol - Resultado
    private void iniciarDibujo(List<String> result) {
        if (result.get(result.size() - 1).equals("")) {
            for (int i = 0; i < result.size() - 2; i++) {
                txtArbol.append(result.get(i) + "\n");
            }
            txtArbol.append(result.get(result.size() - 2) + "\n");
        } else {
            for (String n : result) {
                txtArbol.append(n + "\n");
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelD = new javax.swing.JPanel();
        lblPatron = new javax.swing.JLabel();
        scrollPatron = new javax.swing.JScrollPane();
        txtArbol = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Patrón");

        panelD.setBackground(new java.awt.Color(230, 176, 170));

        lblPatron.setBackground(new java.awt.Color(0, 0, 0));
        lblPatron.setFont(new java.awt.Font("Segoe UI", 3, 36)); // NOI18N
        lblPatron.setText("Árbol de Parseo");

        txtArbol.setColumns(20);
        txtArbol.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        txtArbol.setLineWrap(true);
        txtArbol.setRows(5);
        txtArbol.setWrapStyleWord(true);
        txtArbol.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        txtArbol.setEnabled(false);
        scrollPatron.setViewportView(txtArbol);

        javax.swing.GroupLayout panelDLayout = new javax.swing.GroupLayout(panelD);
        panelD.setLayout(panelDLayout);
        panelDLayout.setHorizontalGroup(
            panelDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDLayout.createSequentialGroup()
                .addGap(0, 102, Short.MAX_VALUE)
                .addGroup(panelDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDLayout.createSequentialGroup()
                        .addComponent(scrollPatron, javax.swing.GroupLayout.PREFERRED_SIZE, 706, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(92, 92, 92))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelDLayout.createSequentialGroup()
                        .addComponent(lblPatron)
                        .addGap(305, 305, 305))))
        );
        panelDLayout.setVerticalGroup(
            panelDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(lblPatron, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(scrollPatron, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(69, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblPatron;
    private javax.swing.JPanel panelD;
    private javax.swing.JScrollPane scrollPatron;
    private javax.swing.JTextArea txtArbol;
    // End of variables declaration//GEN-END:variables
}
