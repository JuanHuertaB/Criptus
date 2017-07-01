
package Formulario;


import com.sun.awt.AWTUtilities;
import java.awt.Color;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Shape;
import java.awt.Toolkit;
import java.awt.geom.RoundRectangle2D;




public class Principal extends javax.swing.JFrame {

        frmCifrar cifrar = new frmCifrar();
        frmDescifrar descifrar = new frmDescifrar();
        frmPersonalizar pr = new frmPersonalizar();
        
//Principal principal = new Principal();

    public Principal() {
        initComponents();
        Shape forma = new RoundRectangle2D.Double(0, 0, this.getBounds().width, this.getBounds().height, 13,13);
        AWTUtilities.setWindowShape(this,forma);
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagenes/triangle.png"));
        setIconImage(icon);
        //this.setVisible(true);
        
        //BOTONES TRANSPARENTES
        btnMinimizar.setContentAreaFilled(false);
        //btnMaximizar.setContentAreaFilled(false);
        btnCerrar.setContentAreaFilled(false);

        
        //EFECTOS INICIALES EN EL BOTON CERRAR
        pnlCerrar.setVisible(true);
        pnlCerrar.setBackground(null);
 
        
        //EFECTOS BOTON MINIMIZAR
        pnlMin.setVisible(true);
        pnlMin.setBackground(null);
        
        //EFECTOS BOTON MAXIMIZAR
        //pnlMax.setVisible(true);
        //pnlMax.setBackground(null);
        
        
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnCifrar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        pnlMin = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        btnMinimizar = new javax.swing.JButton();
        pnlCerrar = new javax.swing.JPanel();
        btnCerrar = new javax.swing.JButton();
        btnCustomize = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        btnDescifrar1 = new javax.swing.JButton();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 153, 153));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setForeground(new java.awt.Color(153, 153, 153));
        setUndecorated(true);
        setType(java.awt.Window.Type.POPUP);
        getContentPane().setLayout(null);

        jPanel2.setBackground(new java.awt.Color(0, 38, 56));
        jPanel2.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Bienvenido al Sistema de Ciframiento");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(140, 130, 510, 60);

        btnCifrar.setBackground(new java.awt.Color(0, 39, 53));
        btnCifrar.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 24)); // NOI18N
        btnCifrar.setForeground(new java.awt.Color(255, 255, 255));
        btnCifrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cifrar.png"))); // NOI18N
        btnCifrar.setText("Cifrar");
        btnCifrar.setBorder(null);
        btnCifrar.setIconTextGap(8);
        btnCifrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCifrarActionPerformed(evt);
            }
        });
        jPanel2.add(btnCifrar);
        btnCifrar.setBounds(160, 270, 220, 80);

        jLabel2.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 1, 30)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("UTP CRIPTO");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(280, 190, 190, 40);

        jPanel3.setBackground(new java.awt.Color(24, 51, 55));
        jPanel3.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel3MouseDragged(evt);
            }
        });
        jPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel3MousePressed(evt);
            }
        });
        jPanel3.setLayout(null);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/triangle02.png"))); // NOI18N
        jPanel3.add(jLabel4);
        jLabel4.setBounds(10, 0, 16, 30);

        jLabel5.setBackground(new java.awt.Color(101, 0, 0));
        jLabel5.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 10)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(153, 153, 153));
        jLabel5.setText("UTP CRIPTO");
        jPanel3.add(jLabel5);
        jLabel5.setBounds(350, 10, 70, 16);

        pnlMin.setBackground(new java.awt.Color(204, 204, 204));
        pnlMin.setLayout(null);

        jPanel6.setBackground(new java.awt.Color(204, 204, 204));
        jPanel6.setLayout(null);
        pnlMin.add(jPanel6);
        jPanel6.setBounds(660, 0, 50, 30);

        btnMinimizar.setBackground(new java.awt.Color(12, 23, 30));
        btnMinimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/1496904507_remove.png"))); // NOI18N
        btnMinimizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnMinimizarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnMinimizarMouseExited(evt);
            }
        });
        btnMinimizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMinimizarActionPerformed(evt);
            }
        });
        pnlMin.add(btnMinimizar);
        btnMinimizar.setBounds(0, 0, 50, 30);

        jPanel3.add(pnlMin);
        pnlMin.setBounds(660, 0, 50, 30);

        pnlCerrar.setBackground(new java.awt.Color(204, 0, 0));
        pnlCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlCerrarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnlCerrarMouseExited(evt);
            }
        });
        pnlCerrar.setLayout(null);

        btnCerrar.setBackground(new java.awt.Color(102, 0, 0));
        btnCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/1496904441_close.png"))); // NOI18N
        btnCerrar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 39, 60), 0, true));
        btnCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCerrarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCerrarMouseExited(evt);
            }
        });
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });
        pnlCerrar.add(btnCerrar);
        btnCerrar.setBounds(0, 0, 50, 30);

        jPanel3.add(pnlCerrar);
        pnlCerrar.setBounds(710, 0, 50, 30);

        jPanel2.add(jPanel3);
        jPanel3.setBounds(0, 0, 760, 30);

        btnCustomize.setBackground(new java.awt.Color(0, 39, 53));
        btnCustomize.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 12)); // NOI18N
        btnCustomize.setForeground(new java.awt.Color(255, 255, 255));
        btnCustomize.setText("Personalizar Sistema Cripto");
        btnCustomize.setBorder(null);
        btnCustomize.setIconTextGap(8);
        btnCustomize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCustomizeActionPerformed(evt);
            }
        });
        jPanel2.add(btnCustomize);
        btnCustomize.setBounds(530, 370, 210, 30);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/utp.png"))); // NOI18N
        jPanel2.add(jLabel6);
        jLabel6.setBounds(290, 40, 190, 100);

        btnDescifrar1.setBackground(new java.awt.Color(0, 39, 53));
        btnDescifrar1.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 24)); // NOI18N
        btnDescifrar1.setForeground(new java.awt.Color(255, 255, 255));
        btnDescifrar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/descifrar.png"))); // NOI18N
        btnDescifrar1.setText("Descifrar");
        btnDescifrar1.setBorder(null);
        btnDescifrar1.setIconTextGap(8);
        btnDescifrar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDescifrar1ActionPerformed(evt);
            }
        });
        jPanel2.add(btnDescifrar1);
        btnDescifrar1.setBounds(410, 270, 210, 80);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 0, 760, 420);

        setSize(new java.awt.Dimension(758, 418));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
       //frmCripto.setDefaultCloseOperation(frmCripto.EXIT_ON_CLOSE);
       System.exit(0);
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void btnMinimizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMinimizarActionPerformed
        this.setExtendedState(ICONIFIED); //Minimizar ventana
    }//GEN-LAST:event_btnMinimizarActionPerformed
    
    private int x;
    private int y;
    
    private void jPanel3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MousePressed
        //OBTENER LA POSICIÓN DEL FRAME
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_jPanel3MousePressed

    private void jPanel3MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseDragged
        //MODIFICAR LA POSICION DEL FRAME
        Point point = MouseInfo.getPointerInfo().getLocation();
        setLocation(point.x - x , point.y-y);
    }//GEN-LAST:event_jPanel3MouseDragged

    private void btnMinimizarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMinimizarMouseEntered
        btnMinimizar.setContentAreaFilled(false);
        pnlMin.setVisible(true);
        pnlMin.setBackground(Color.gray);
    }//GEN-LAST:event_btnMinimizarMouseEntered

    private void btnMinimizarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMinimizarMouseExited
        btnMinimizar.setContentAreaFilled(false);
        pnlMin.setVisible(true);
        pnlMin.setBackground(null);
        
    }//GEN-LAST:event_btnMinimizarMouseExited

    private void btnCerrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCerrarMouseEntered
        pnlCerrar.setVisible(true);
        pnlCerrar.setBackground(Color.red);
    }//GEN-LAST:event_btnCerrarMouseEntered

    private void btnCerrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCerrarMouseExited
        pnlCerrar.setBackground(null);
        btnCerrar.setVisible(true);
    }//GEN-LAST:event_btnCerrarMouseExited

    private void pnlCerrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlCerrarMouseExited

    }//GEN-LAST:event_pnlCerrarMouseExited

    private void pnlCerrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlCerrarMouseEntered

    }//GEN-LAST:event_pnlCerrarMouseEntered

    private void btnCifrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCifrarActionPerformed
            cifrar.setVisible(true);
            cifrar.setLocationRelativeTo(null) ;
            cifrar.setSize(996,630);
            this.setVisible(false);
    }//GEN-LAST:event_btnCifrarActionPerformed

    private void btnCustomizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCustomizeActionPerformed
            //pr.setVisible(true);
            //principal.setVisible(true);
            frmLogin l = new frmLogin();
            l.setVisible(true);
    }//GEN-LAST:event_btnCustomizeActionPerformed

    private void btnDescifrar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDescifrar1ActionPerformed
            descifrar.setVisible(true);
            descifrar.setLocationRelativeTo(null) ;
            descifrar.setSize(996,630);
            this.setVisible(false);
    }//GEN-LAST:event_btnDescifrar1ActionPerformed

    
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnCifrar;
    private javax.swing.JButton btnCustomize;
    private javax.swing.JButton btnDescifrar1;
    private javax.swing.JButton btnMinimizar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JPanel pnlCerrar;
    private javax.swing.JPanel pnlMin;
    // End of variables declaration//GEN-END:variables

 
}
