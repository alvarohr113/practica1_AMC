/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/AWTForms/Frame.java to edit this template
 */
package FrameVisual;

import java.awt.BorderLayout;
import javax.swing.JPanel;

/**
 *
 * @author jaime
 */
public final class MainFrame extends java.awt.Frame {

    /**
     * Creates new form MainFrame
     */
    private Menu m;

    public MainFrame() {
        initComponents();
        this.setLocation(300, 100);
        this.setTitle("\tPRACTICA 1 - AMC");
        
        m = new Menu(this);
        
        cambiarPanel(m);

    }

    public void cambiarPanel(JPanel p) {
        p.setSize(800, 400);
        p.setLocation(0, 0);

        panelCambio.removeAll();
        panelCambio.add(p, BorderLayout.CENTER);
        panelCambio.validate();
        panelCambio.repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Base = new javax.swing.JPanel();
        panelCambio = new javax.swing.JPanel();

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                exitForm(evt);
            }
        });

        Base.setMinimumSize(new java.awt.Dimension(0, 0));

        panelCambio.setPreferredSize(new java.awt.Dimension(786, 400));

        javax.swing.GroupLayout panelCambioLayout = new javax.swing.GroupLayout(panelCambio);
        panelCambio.setLayout(panelCambioLayout);
        panelCambioLayout.setHorizontalGroup(
            panelCambioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 786, Short.MAX_VALUE)
        );
        panelCambioLayout.setVerticalGroup(
            panelCambioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );

        Base.add(panelCambio);

        add(Base, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Exit the Application
     */
    private void exitForm(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_exitForm
        System.exit(0);
    }//GEN-LAST:event_exitForm

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Base;
    private javax.swing.JPanel panelCambio;
    // End of variables declaration//GEN-END:variables
}
