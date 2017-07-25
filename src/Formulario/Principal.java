
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
    
    public Principal() {
        
        initComponents();
        Shape forma = new RoundRectangle2D.Double(0, 0, this.getBounds().width, this.getBounds().height, 15,15);

        AWTUtilities.setWindowShape(this,forma);
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagenes/Neptune.png"));
        setIconImage(icon);
        
        //BOTONES TRANSPARENTES
        btnMinimizar.setContentAreaFilled(false);
        btnCerrar.setContentAreaFilled(false);
        btnCifrar.setBackground(null);
        btnDescifrar1.setContentAreaFilled(false);
        btnCustomize.setContentAreaFilled(false);
        
        //EFECTOS INICIALES EN EL BOTON CERRAR
        pnlCerrar.setVisible(true);
        pnlCerrar.setBackground(null);
        
        //EFECTOS BOTON MINIMIZAR
        pnlMin.setVisible(true);
        pnlMin.setBackground(null);
        pnlCifrar.setBackground(null);
        pnlDecifrar.setBackground(null);
        pnlPersonalizar.setBackground(new Color(5, 61, 72));
        
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        pnlCerrar = new javax.swing.JPanel();
        btnCerrar = new javax.swing.JButton();
        pnlMin = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        btnMinimizar = new javax.swing.JButton();
        pnlCifrar = new javax.swing.JPanel();
        btnCifrar = new javax.swing.JButton();
        pnlDecifrar = new javax.swing.JPanel();
        btnDescifrar1 = new javax.swing.JButton();
        pnlPersonalizar = new javax.swing.JPanel();
        btnCustomize = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

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
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(7, 64, 77));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 29, 48), 1, true), "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.ABOVE_BOTTOM));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("SISTEMA DE CIFRAMIENTO");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 60, 410, 60));

        jLabel2.setFont(new java.awt.Font("Microsoft JhengHei Light", 1, 30)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("My Cypher");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 120, -1, 40));

        jPanel3.setBackground(new java.awt.Color(0, 55, 59));
        jPanel3.setToolTipText("Criptus");
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
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Neptune.png"))); // NOI18N
        jLabel4.setToolTipText("");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 30, 30));

        jLabel5.setBackground(new java.awt.Color(101, 0, 0));
        jLabel5.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 10)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(153, 153, 153));
        jLabel5.setText("My Cypher");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 10, 50, 16));

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

        btnCerrar.setBackground(new java.awt.Color(126, 0, 0));
        btnCerrar.setFont(new java.awt.Font("Microsoft JhengHei", 1, 16)); // NOI18N
        btnCerrar.setForeground(new java.awt.Color(255, 255, 255));
        btnCerrar.setText("X");
        btnCerrar.setToolTipText("Cerrar");
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

        jPanel3.add(pnlCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 0, 50, 30));

        pnlMin.setBackground(new java.awt.Color(204, 204, 204));
        pnlMin.setLayout(null);

        jPanel6.setBackground(new java.awt.Color(204, 204, 204));
        jPanel6.setLayout(null);
        pnlMin.add(jPanel6);
        jPanel6.setBounds(660, 0, 50, 30);

        btnMinimizar.setBackground(new java.awt.Color(12, 23, 30));
        btnMinimizar.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 36)); // NOI18N
        btnMinimizar.setForeground(new java.awt.Color(204, 204, 204));
        btnMinimizar.setText("-");
        btnMinimizar.setToolTipText("Minimizar");
        btnMinimizar.setBorder(null);
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

        jPanel3.add(pnlMin, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 0, 50, 30));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 870, -1));

        btnCifrar.setBackground(new java.awt.Color(255, 255, 255));
        btnCifrar.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 24)); // NOI18N
        btnCifrar.setForeground(new java.awt.Color(255, 255, 255));
        btnCifrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cifrar.png"))); // NOI18N
        btnCifrar.setText("Cifrar");
        btnCifrar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(10, 121, 143), 1, true));
        btnCifrar.setContentAreaFilled(false);
        btnCifrar.setIconTextGap(8);
        btnCifrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCifrarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCifrarMouseExited(evt);
            }
        });
        btnCifrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCifrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlCifrarLayout = new javax.swing.GroupLayout(pnlCifrar);
        pnlCifrar.setLayout(pnlCifrarLayout);
        pnlCifrarLayout.setHorizontalGroup(
            pnlCifrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCifrarLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnCifrar, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlCifrarLayout.setVerticalGroup(
            pnlCifrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnCifrar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
        );

        jPanel2.add(pnlCifrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 280, 200, 80));

        btnDescifrar1.setBackground(new java.awt.Color(0, 39, 53));
        btnDescifrar1.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 24)); // NOI18N
        btnDescifrar1.setForeground(new java.awt.Color(255, 255, 255));
        btnDescifrar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/descifrar.png"))); // NOI18N
        btnDescifrar1.setText("Descifrar");
        btnDescifrar1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(10, 121, 143)));
        btnDescifrar1.setContentAreaFilled(false);
        btnDescifrar1.setIconTextGap(8);
        btnDescifrar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnDescifrar1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnDescifrar1MouseExited(evt);
            }
        });
        btnDescifrar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDescifrar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlDecifrarLayout = new javax.swing.GroupLayout(pnlDecifrar);
        pnlDecifrar.setLayout(pnlDecifrarLayout);
        pnlDecifrarLayout.setHorizontalGroup(
            pnlDecifrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnDescifrar1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
        );
        pnlDecifrarLayout.setVerticalGroup(
            pnlDecifrarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnDescifrar1, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
        );

        jPanel2.add(pnlDecifrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 280, -1, 80));

        btnCustomize.setBackground(new java.awt.Color(0, 39, 53));
        btnCustomize.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 12)); // NOI18N
        btnCustomize.setForeground(new java.awt.Color(255, 255, 255));
        btnCustomize.setText("Personalizar Sistema de Ciframiento");
        btnCustomize.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(10, 121, 143), 1, true)));
        btnCustomize.setContentAreaFilled(false);
        btnCustomize.setIconTextGap(8);
        btnCustomize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCustomizeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCustomizeMouseExited(evt);
            }
        });
        btnCustomize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCustomizeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlPersonalizarLayout = new javax.swing.GroupLayout(pnlPersonalizar);
        pnlPersonalizar.setLayout(pnlPersonalizarLayout);
        pnlPersonalizarLayout.setHorizontalGroup(
            pnlPersonalizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPersonalizarLayout.createSequentialGroup()
                .addComponent(btnCustomize, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnlPersonalizarLayout.setVerticalGroup(
            pnlPersonalizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPersonalizarLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnCustomize, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel2.add(pnlPersonalizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 410, 210, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/utp.png"))); // NOI18N
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 180, 190, 70));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 870, 460));

        setSize(new java.awt.Dimension(870, 458));
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
        pnlMin.setBackground(new Color(12,23,30));
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
        frmCifrar cifrar = new frmCifrar();
            cifrar.setVisible(true);
            cifrar.setLocationRelativeTo(null) ;
            cifrar.setSize(996,630);
            this.setVisible(false);
    }//GEN-LAST:event_btnCifrarActionPerformed

    private void btnCustomizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCustomizeActionPerformed
        frmLogin l = new frmLogin();
            l.setVisible(true);
            this.dispose();
    }//GEN-LAST:event_btnCustomizeActionPerformed

    private void btnDescifrar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDescifrar1ActionPerformed
        frmDescifrar descifrar = new frmDescifrar();
            descifrar.setVisible(true);
            descifrar.setLocationRelativeTo(null) ;
            descifrar.setSize(996,630);
            this.setVisible(false);
    }//GEN-LAST:event_btnDescifrar1ActionPerformed

    private void btnCifrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCifrarMouseEntered
        pnlCifrar.setBackground(new Color(7, 97, 104));   
    }//GEN-LAST:event_btnCifrarMouseEntered

    private void btnDescifrar1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDescifrar1MouseEntered
        pnlDecifrar.setBackground(new Color(7, 97, 104));
    }//GEN-LAST:event_btnDescifrar1MouseEntered

    private void btnCifrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCifrarMouseExited
        pnlCifrar.setBackground(null);
    }//GEN-LAST:event_btnCifrarMouseExited

    private void btnDescifrar1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDescifrar1MouseExited
        pnlDecifrar.setBackground(null);
    }//GEN-LAST:event_btnDescifrar1MouseExited

    private void btnCustomizeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCustomizeMouseEntered
        pnlPersonalizar.setBackground(new Color(7, 97, 104));
    }//GEN-LAST:event_btnCustomizeMouseEntered

    private void btnCustomizeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCustomizeMouseExited
        pnlPersonalizar.setBackground(null);
    }//GEN-LAST:event_btnCustomizeMouseExited

    
    
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
    private javax.swing.JPanel pnlCifrar;
    private javax.swing.JPanel pnlDecifrar;
    private javax.swing.JPanel pnlMin;
    private javax.swing.JPanel pnlPersonalizar;
    // End of variables declaration//GEN-END:variables

 
}
