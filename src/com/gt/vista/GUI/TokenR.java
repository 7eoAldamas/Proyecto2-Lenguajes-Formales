package com.gt.vista.GUI;

import com.gt.control.lexico.Reporte;
import com.gt.modelo.Token;
import java.util.List;
import javax.swing.JDialog;

public class TokenR extends JDialog {
//--- Ventana TokenR                            

    private Principal menu;
    private boolean init;
    
    public TokenR(Principal parent, boolean modal, boolean init, List<Token> listaTokens) {
        super(parent, modal);
        initComponents();
        this.menu = parent;
        this.init = init;
        Reporte.tablaTokens(listaTokens, tableReport);
        setTitle("Reportes");
        setSize(600, 350);
        setResizable(false);
        setLocationRelativeTo(null);           
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelReport = new javax.swing.JPanel();
        scrollReport = new javax.swing.JScrollPane();
        tableReport = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        panelReport.setBackground(new java.awt.Color(84, 153, 199));

        tableReport.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        scrollReport.setViewportView(tableReport);

        javax.swing.GroupLayout panelReportLayout = new javax.swing.GroupLayout(panelReport);
        panelReport.setLayout(panelReportLayout);
        panelReportLayout.setHorizontalGroup(
            panelReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelReportLayout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(scrollReport, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(68, Short.MAX_VALUE))
        );
        panelReportLayout.setVerticalGroup(
            panelReportLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelReportLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(scrollReport, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(82, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelReport, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelReport, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel panelReport;
    private javax.swing.JScrollPane scrollReport;
    private javax.swing.JTable tableReport;
    // End of variables declaration//GEN-END:variables
}