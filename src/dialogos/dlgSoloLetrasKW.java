/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dialogos;

import com.sun.awt.AWTUtilities;
import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;

/**
 *
 * @author JuanCarlos
 */
public class dlgSoloLetrasKW extends java.awt.Dialog {

    /**
     * Creates new form dlgWarrninf
     */
    public dlgSoloLetrasKW(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        this.setModal(true);
        Shape forma = new RoundRectangle2D.Double(0, 0, this.getBounds().width, this.getBounds().height, 13,13);
        AWTUtilities.setWindowShape(this,forma);
        
        btnOk.setContentAreaFilled(false);
        pnlOk.setBackground(null);
               
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtMessage = new javax.swing.JLabel();
        pnlOk = new javax.swing.JPanel();
        btnOk = new javax.swing.JButton();
        txtMessage1 = new javax.swing.JLabel();

        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 58, 68));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 47, 52));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Advertencia");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 310, 20));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 310, 20));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/if_101_Warning_183416.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 60, 50));

        txtMessage.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 11)); // NOI18N
        txtMessage.setForeground(new java.awt.Color(255, 255, 255));
        txtMessage.setText("Solo se permiten letras");
        jPanel1.add(txtMessage, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, 130, 40));

        pnlOk.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnOk.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 11)); // NOI18N
        btnOk.setForeground(new java.awt.Color(255, 255, 255));
        btnOk.setText("ACEPTAR");
        btnOk.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(10, 121, 143), 1, true));
        btnOk.setContentAreaFilled(false);
        btnOk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnOkMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnOkMouseExited(evt);
            }
        });
        btnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOkActionPerformed(evt);
            }
        });
        pnlOk.add(btnOk, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 90, 30));

        jPanel1.add(pnlOk, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 90, 90, 30));

        txtMessage1.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 14)); // NOI18N
        txtMessage1.setForeground(new java.awt.Color(255, 255, 255));
        txtMessage1.setText("Valor ingresado no válido");
        jPanel1.add(txtMessage1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 200, 40));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 310, 130));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Closes the dialog
     */
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeDialog

    private void btnOkMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnOkMouseEntered
        pnlOk.setBackground(new Color(7, 97, 104));
    }//GEN-LAST:event_btnOkMouseEntered

    private void btnOkMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnOkMouseExited
        pnlOk.setBackground(null);
    }//GEN-LAST:event_btnOkMouseExited

    private void btnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOkActionPerformed
        this.setVisible(false);
        
    }//GEN-LAST:event_btnOkActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                dlgSoloLetrasKW dialog = new dlgSoloLetrasKW(new java.awt.Frame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOk;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel pnlOk;
    private javax.swing.JLabel txtMessage;
    private javax.swing.JLabel txtMessage1;
    // End of variables declaration//GEN-END:variables
}
