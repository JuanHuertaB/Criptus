
package Formulario;

import com.sun.awt.AWTUtilities;
import java.awt.Color;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Shape;
import java.awt.Toolkit;
import java.awt.geom.RoundRectangle2D;


public class frmLogin extends javax.swing.JFrame {

    public frmLogin() {
        initComponents();
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagenes/Neptune.png"));
        setIconImage(icon);
        Shape forma = new RoundRectangle2D.Double(0, 0, this.getBounds().width, this.getBounds().height, 13,13);
        AWTUtilities.setWindowShape(this,forma);
        setLocationRelativeTo(null);
        
        txtUsuario.requestFocus();
        btnCerrarLogin.setContentAreaFilled(false);
        pnlCerrarLogin.setBackground(new Color(102,0,0));
        lblLogin.setVisible(false);
        pnlCancel.setBackground(null);
        pnlLogin.setBackground(null);
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        txtPsw = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        lblLogin = new javax.swing.JLabel();
        pnlLogin = new javax.swing.JPanel();
        btnLogin = new javax.swing.JButton();
        pnlCancel = new javax.swing.JPanel();
        btnCancel = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        pnlCerrarLogin = new javax.swing.JPanel();
        btnCerrarLogin = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 58, 68));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Usuario");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 80, 20));

        jLabel2.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Contraseña");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 80, 20));

        txtUsuario.setBackground(new java.awt.Color(0, 41, 60));
        txtUsuario.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 11)); // NOI18N
        txtUsuario.setForeground(new java.awt.Color(204, 204, 204));
        txtUsuario.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 41, 60), 1, true));
        txtUsuario.setCaretColor(new java.awt.Color(0, 110, 107));
        jPanel1.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, 200, 25));

        txtPsw.setBackground(new java.awt.Color(0, 41, 60));
        txtPsw.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 11)); // NOI18N
        txtPsw.setForeground(new java.awt.Color(204, 204, 204));
        txtPsw.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        txtPsw.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 41, 60), 1, true));
        txtPsw.setCaretColor(new java.awt.Color(0, 110, 107));
        jPanel1.add(txtPsw, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, 200, 25));
        txtPsw.getAccessibleContext().setAccessibleName("");

        jLabel3.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Iniciar Sesión");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 120, 32));

        lblLogin.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 11)); // NOI18N
        lblLogin.setForeground(new java.awt.Color(153, 153, 153));
        lblLogin.setText("* Usuario o contraseña incorrecta");
        jPanel1.add(lblLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, 180, -1));

        pnlLogin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnLogin.setBackground(new java.awt.Color(153, 204, 255));
        btnLogin.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 13)); // NOI18N
        btnLogin.setForeground(new java.awt.Color(204, 204, 204));
        btnLogin.setText("Ingresar");
        btnLogin.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(10, 121, 143), 1, true));
        btnLogin.setContentAreaFilled(false);
        btnLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnLoginMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnLoginMouseExited(evt);
            }
        });
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        pnlLogin.add(btnLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 90, 30));

        jPanel1.add(pnlLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 170, 90, 30));

        pnlCancel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnCancel.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 13)); // NOI18N
        btnCancel.setForeground(new java.awt.Color(204, 204, 204));
        btnCancel.setText("Cancelar");
        btnCancel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(10, 121, 143), 1, true));
        btnCancel.setContentAreaFilled(false);
        btnCancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCancelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCancelMouseExited(evt);
            }
        });
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
        pnlCancel.add(btnCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 90, 30));

        jPanel1.add(pnlCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 170, 90, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 390, 220));

        jPanel2.setBackground(new java.awt.Color(0, 47, 52));
        jPanel2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel2MouseDragged(evt);
            }
        });
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel2MousePressed(evt);
            }
        });
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlCerrarLogin.setBackground(new java.awt.Color(204, 0, 0));
        pnlCerrarLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlCerrarLoginMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnlCerrarLoginMouseExited(evt);
            }
        });
        pnlCerrarLogin.setLayout(null);

        btnCerrarLogin.setBackground(new java.awt.Color(102, 0, 0));
        btnCerrarLogin.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 11)); // NOI18N
        btnCerrarLogin.setForeground(new java.awt.Color(255, 255, 255));
        btnCerrarLogin.setText("X");
        btnCerrarLogin.setToolTipText("Cerrar");
        btnCerrarLogin.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 39, 60), 0, true));
        btnCerrarLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCerrarLoginMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCerrarLoginMouseExited(evt);
            }
        });
        btnCerrarLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarLoginActionPerformed(evt);
            }
        });
        pnlCerrarLogin.add(btnCerrarLogin);
        btnCerrarLogin.setBounds(0, 0, 30, 20);

        jPanel2.add(pnlCerrarLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 0, 30, 20));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 390, 20));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        String usr = txtUsuario.getText();
        String pass = txtPsw.getText();
        frmPersonalizar p = new frmPersonalizar();
        Principal prin = new Principal();
        
        
        if("admin".equals(usr) && "123".equals(pass)){
            p.setVisible(true);
            prin.dispose();
            this.dispose();    
        }else
        {
            lblLogin.setVisible(true);
        }
    }//GEN-LAST:event_btnLoginActionPerformed

    private int x;
    private int y;
    
    private void jPanel2MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseDragged
         //MODIFICAR LA POSICION DEL FRAME
        Point point = MouseInfo.getPointerInfo().getLocation();
        setLocation(point.x - x , point.y-y);
    }//GEN-LAST:event_jPanel2MouseDragged

    private void jPanel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MousePressed
        //OBTENER LA POSICIÓN DEL FRAME
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_jPanel2MousePressed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        Principal prin = new Principal();
        prin.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnCerrarLoginMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCerrarLoginMouseEntered
        pnlCerrarLogin.setBackground(Color.red);
    }//GEN-LAST:event_btnCerrarLoginMouseEntered

    private void btnCerrarLoginMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCerrarLoginMouseExited
        pnlCerrarLogin.setBackground(new Color(102,0,0)); 
    }//GEN-LAST:event_btnCerrarLoginMouseExited

    private void btnCerrarLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarLoginActionPerformed
        Principal prin = new Principal();
        prin.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCerrarLoginActionPerformed

    private void pnlCerrarLoginMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlCerrarLoginMouseEntered

    }//GEN-LAST:event_pnlCerrarLoginMouseEntered

    private void pnlCerrarLoginMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlCerrarLoginMouseExited

    }//GEN-LAST:event_pnlCerrarLoginMouseExited

    private void btnLoginMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLoginMouseEntered
        pnlLogin.setBackground(new Color(7, 97, 104)); 
    }//GEN-LAST:event_btnLoginMouseEntered

    private void btnCancelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelMouseEntered
        pnlCancel.setBackground(new Color(7, 97, 104));
    }//GEN-LAST:event_btnCancelMouseEntered

    private void btnLoginMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLoginMouseExited
        pnlLogin.setBackground(null);
    }//GEN-LAST:event_btnLoginMouseExited

    private void btnCancelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelMouseExited
        pnlCancel.setBackground(null);
    }//GEN-LAST:event_btnCancelMouseExited

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
            java.util.logging.Logger.getLogger(frmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnCerrarLogin;
    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblLogin;
    private javax.swing.JPanel pnlCancel;
    private javax.swing.JPanel pnlCerrarLogin;
    private javax.swing.JPanel pnlLogin;
    private javax.swing.JPasswordField txtPsw;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
