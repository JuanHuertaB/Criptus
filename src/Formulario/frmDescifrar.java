/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formulario;

import com.sun.awt.AWTUtilities;
import java.awt.Color;
import java.awt.FileDialog;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.Shape;
import java.awt.Toolkit;
import java.awt.geom.RoundRectangle2D;
import java.io.FileWriter;
import java.io.PrintWriter;
import javax.swing.JOptionPane;


public class frmDescifrar extends javax.swing.JFrame {
    
    public frmDescifrar() {
        initComponents();
        this.setLocationRelativeTo(null);
        Shape forma = new RoundRectangle2D.Double(0, 0, this.getBounds().width, this.getBounds().height, 15,15);
        AWTUtilities.setWindowShape(this,forma);
        
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagenes/Neptune.png"));
        setIconImage(icon);
        
        txtToDecode.requestFocus();
        //BOTONES TRANSPARENTES
        btnMinimizar.setContentAreaFilled(false);
        btnCerrar.setContentAreaFilled(false);
        btnVolverC.setContentAreaFilled(false);
        btnDecrypt.setContentAreaFilled(false);
        btnSaveDecrypted.setContentAreaFilled(false);
        btnClear.setContentAreaFilled(false);

        
        //EFECTOS INICIALES EN EL BOTON CERRAR
        pnlCerrar.setVisible(true);
        pnlCerrar.setBackground(null);
 
        
        //EFECTOS BOTON MINIMIZAR
        pnlMin.setVisible(true);
        pnlMin.setBackground(null);
        
        lblAtrasDescifrar.setForeground(Color.gray);
        
        pnlDecrypt.setBackground(null);
        pnlClear.setBackground(null);
        pnlSave.setBackground(null);

    }
    
    void SaveDecoded(){
            FileDialog da;
            da = new FileDialog(this,"Guardar como",FileDialog.SAVE);
            da.show();
            String file,directory;
            file = da.getFile()+".txt"; 
            directory = da.getDirectory();
            
        try(PrintWriter pw = new PrintWriter( new FileWriter(directory+file))) {
            
            pw.println(txtDecoded.getText().trim());
            JOptionPane.showMessageDialog(null, "Mensaje Guardado");
        }catch(Exception e){
            
        }
    }
        String getMessage(){
            String message = txtToDecode.getText();
            return message;
        }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        pnlCerrar = new javax.swing.JPanel();
        btnCerrar = new javax.swing.JButton();
        pnlMin = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        btnMinimizar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtToDecode = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDecoded = new javax.swing.JTextArea();
        btnVolverC = new javax.swing.JButton();
        lblAtrasDescifrar = new javax.swing.JLabel();
        pnlDecrypt = new javax.swing.JPanel();
        btnDecrypt = new javax.swing.JButton();
        pnlSave = new javax.swing.JPanel();
        btnSaveDecrypted = new javax.swing.JButton();
        pnlClear = new javax.swing.JPanel();
        btnClear = new javax.swing.JButton();
        lblGoToCode = new javax.swing.JLabel();
        btnGoToCode = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(7, 64, 77));
        jPanel1.setLayout(null);

        jPanel3.setBackground(new java.awt.Color(0, 55, 59));
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

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Neptune.png"))); // NOI18N
        jPanel3.add(jLabel4);
        jLabel4.setBounds(0, 0, 30, 30);

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
        btnCerrar.setFont(new java.awt.Font("Eras Light ITC", 1, 20)); // NOI18N
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

        jPanel3.add(pnlCerrar);
        pnlCerrar.setBounds(950, 0, 50, 30);

        pnlMin.setBackground(new java.awt.Color(204, 204, 204));
        pnlMin.setLayout(null);

        jPanel6.setBackground(new java.awt.Color(204, 204, 204));
        jPanel6.setLayout(null);
        pnlMin.add(jPanel6);
        jPanel6.setBounds(660, 0, 50, 30);

        btnMinimizar.setBackground(new java.awt.Color(12, 23, 30));
        btnMinimizar.setFont(new java.awt.Font("Eras Light ITC", 0, 48)); // NOI18N
        btnMinimizar.setForeground(new java.awt.Color(255, 255, 255));
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

        jPanel3.add(pnlMin);
        pnlMin.setBounds(900, 0, 50, 30);

        jLabel5.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Descifrar");
        jPanel3.add(jLabel5);
        jLabel5.setBounds(0, 0, 1000, 30);

        jPanel1.add(jPanel3);
        jPanel3.setBounds(0, 0, 1000, 30);

        jLabel2.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Ingrese el mensaje que desea descifrar");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(90, 80, 370, 40);

        jLabel1.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Este es el mensaje descifrado");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(100, 340, 340, 40);

        txtToDecode.setBackground(new java.awt.Color(0, 41, 60));
        txtToDecode.setColumns(20);
        txtToDecode.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 13)); // NOI18N
        txtToDecode.setForeground(new java.awt.Color(204, 204, 204));
        txtToDecode.setRows(5);
        txtToDecode.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 41, 60), new java.awt.Color(0, 41, 60), new java.awt.Color(0, 41, 60), new java.awt.Color(0, 41, 60)));
        txtToDecode.setCaretColor(new java.awt.Color(255, 255, 255));
        txtToDecode.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtToDecode.setRequestFocusEnabled(false);
        jScrollPane2.setViewportView(txtToDecode);

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(90, 120, 830, 150);

        txtDecoded.setEditable(false);
        txtDecoded.setBackground(new java.awt.Color(0, 41, 60));
        txtDecoded.setColumns(20);
        txtDecoded.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 13)); // NOI18N
        txtDecoded.setForeground(new java.awt.Color(204, 204, 204));
        txtDecoded.setRows(5);
        txtDecoded.setBorder(null);
        txtDecoded.setCaretColor(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(txtDecoded);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(100, 380, 820, 170);

        btnVolverC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/if_Left_arrow_2202280.png"))); // NOI18N
        btnVolverC.setBorder(null);
        btnVolverC.setContentAreaFilled(false);
        btnVolverC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnVolverCMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnVolverCMouseExited(evt);
            }
        });
        btnVolverC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverCActionPerformed(evt);
            }
        });
        jPanel1.add(btnVolverC);
        btnVolverC.setBounds(10, 40, 50, 30);

        lblAtrasDescifrar.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 13)); // NOI18N
        lblAtrasDescifrar.setForeground(new java.awt.Color(255, 255, 255));
        lblAtrasDescifrar.setText("Ir a Inicio");
        lblAtrasDescifrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblAtrasDescifrarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblAtrasDescifrarMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lblAtrasDescifrarMouseReleased(evt);
            }
        });
        jPanel1.add(lblAtrasDescifrar);
        lblAtrasDescifrar.setBounds(40, 40, 60, 30);

        pnlDecrypt.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnDecrypt.setBackground(new java.awt.Color(0, 21, 29));
        btnDecrypt.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 14)); // NOI18N
        btnDecrypt.setForeground(new java.awt.Color(255, 255, 255));
        btnDecrypt.setText("Descifrar Mensaje");
        btnDecrypt.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(10, 129, 165), 1, true));
        btnDecrypt.setContentAreaFilled(false);
        btnDecrypt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnDecryptMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnDecryptMouseExited(evt);
            }
        });
        btnDecrypt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDecryptActionPerformed(evt);
            }
        });
        pnlDecrypt.add(btnDecrypt, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 170, 40));

        jPanel1.add(pnlDecrypt);
        pnlDecrypt.setBounds(420, 280, 170, 40);

        btnSaveDecrypted.setBackground(new java.awt.Color(0, 21, 29));
        btnSaveDecrypted.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 14)); // NOI18N
        btnSaveDecrypted.setForeground(new java.awt.Color(255, 255, 255));
        btnSaveDecrypted.setText("Guardar Mensaje");
        btnSaveDecrypted.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(10, 121, 143), 1, true));
        btnSaveDecrypted.setContentAreaFilled(false);
        btnSaveDecrypted.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSaveDecryptedMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSaveDecryptedMouseExited(evt);
            }
        });
        btnSaveDecrypted.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveDecryptedActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlSaveLayout = new javax.swing.GroupLayout(pnlSave);
        pnlSave.setLayout(pnlSaveLayout);
        pnlSaveLayout.setHorizontalGroup(
            pnlSaveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnSaveDecrypted, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
        );
        pnlSaveLayout.setVerticalGroup(
            pnlSaveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSaveLayout.createSequentialGroup()
                .addComponent(btnSaveDecrypted, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel1.add(pnlSave);
        pnlSave.setBounds(430, 570, 170, 40);

        btnClear.setBackground(new java.awt.Color(0, 21, 29));
        btnClear.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 13)); // NOI18N
        btnClear.setForeground(new java.awt.Color(255, 255, 255));
        btnClear.setText("Limpiar Campos");
        btnClear.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(10, 121, 143), 1, true));
        btnClear.setContentAreaFilled(false);
        btnClear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnClearMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnClearMouseExited(evt);
            }
        });
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlClearLayout = new javax.swing.GroupLayout(pnlClear);
        pnlClear.setLayout(pnlClearLayout);
        pnlClearLayout.setHorizontalGroup(
            pnlClearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlClearLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlClearLayout.setVerticalGroup(
            pnlClearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlClearLayout.createSequentialGroup()
                .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel1.add(pnlClear);
        pnlClear.setBounds(810, 580, 150, 30);

        lblGoToCode.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 13)); // NOI18N
        lblGoToCode.setForeground(new java.awt.Color(255, 255, 255));
        lblGoToCode.setText("Ir a cifrar");
        lblGoToCode.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblGoToCodeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblGoToCodeMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lblGoToCodeMouseReleased(evt);
            }
        });
        jPanel1.add(lblGoToCode);
        lblGoToCode.setBounds(900, 40, 60, 30);

        btnGoToCode.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/if_Right_arrow_2202241.png"))); // NOI18N
        btnGoToCode.setBorder(null);
        btnGoToCode.setContentAreaFilled(false);
        btnGoToCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGoToCodeActionPerformed(evt);
            }
        });
        jPanel1.add(btnGoToCode);
        btnGoToCode.setBounds(940, 40, 50, 30);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 996, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 630, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCerrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCerrarMouseEntered
        pnlCerrar.setVisible(true);
        pnlCerrar.setBackground(Color.red);
    }//GEN-LAST:event_btnCerrarMouseEntered

    private void btnCerrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCerrarMouseExited
        pnlCerrar.setBackground(null);
        btnCerrar.setVisible(true);
    }//GEN-LAST:event_btnCerrarMouseExited

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
       System.exit(0);
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void pnlCerrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlCerrarMouseEntered

    }//GEN-LAST:event_pnlCerrarMouseEntered

    private void pnlCerrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlCerrarMouseExited

    }//GEN-LAST:event_pnlCerrarMouseExited

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

    private void btnMinimizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMinimizarActionPerformed
        this.setExtendedState(ICONIFIED); //Minimizar ventana
    }//GEN-LAST:event_btnMinimizarActionPerformed
        private int x;
        private int y;
    private void jPanel3MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseDragged
        //MODIFICAR LA POSICION DEL FRAME
        java.awt.Point point = MouseInfo.getPointerInfo().getLocation();
        setLocation(point.x - x , point.y-y);
    }//GEN-LAST:event_jPanel3MouseDragged

    private void jPanel3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MousePressed
        //OBTENER LA POSICIÓN DEL FRAME
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_jPanel3MousePressed

    private void btnVolverCMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVolverCMouseEntered
        //pnlVolverC.setBackground(Color.gray);
        lblAtrasDescifrar.setForeground(Color.white);
    }//GEN-LAST:event_btnVolverCMouseEntered

    private void btnVolverCMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVolverCMouseExited
        //pnlVolverC.setBackground(null);
        lblAtrasDescifrar.setForeground(Color.gray);
    }//GEN-LAST:event_btnVolverCMouseExited

    private void btnVolverCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverCActionPerformed
        Principal prn = new Principal();
        prn.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVolverCActionPerformed

    private void lblAtrasDescifrarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAtrasDescifrarMouseReleased
        Principal prn = new Principal();
        prn.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblAtrasDescifrarMouseReleased

    private void lblAtrasDescifrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAtrasDescifrarMouseEntered
         lblAtrasDescifrar.setForeground(Color.white);
    }//GEN-LAST:event_lblAtrasDescifrarMouseEntered

    private void lblAtrasDescifrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAtrasDescifrarMouseExited
        lblAtrasDescifrar.setForeground(Color.gray);
    }//GEN-LAST:event_lblAtrasDescifrarMouseExited

    private void btnDecryptMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDecryptMouseEntered
        pnlDecrypt.setBackground(new Color(10, 97, 104));
    }//GEN-LAST:event_btnDecryptMouseEntered

    private void btnSaveDecryptedMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveDecryptedMouseEntered
         pnlSave.setBackground(new Color(7, 97, 104));
    }//GEN-LAST:event_btnSaveDecryptedMouseEntered

    private void btnClearMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnClearMouseEntered
        pnlClear.setBackground(new Color(7, 97, 104));
    }//GEN-LAST:event_btnClearMouseEntered

    private void btnDecryptMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDecryptMouseExited
        btnDecrypt.setForeground(Color.white);
        pnlDecrypt.setBackground(null);
    }//GEN-LAST:event_btnDecryptMouseExited

    private void btnSaveDecryptedMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveDecryptedMouseExited
        pnlSave.setBackground(null);
    }//GEN-LAST:event_btnSaveDecryptedMouseExited

    private void btnClearMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnClearMouseExited
        pnlClear.setBackground(null);
    }//GEN-LAST:event_btnClearMouseExited

    private void lblGoToCodeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblGoToCodeMouseEntered
        lblGoToCode.setForeground(Color.white);
    }//GEN-LAST:event_lblGoToCodeMouseEntered

    private void lblGoToCodeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblGoToCodeMouseExited
        lblGoToCode.setForeground(Color.gray);
    }//GEN-LAST:event_lblGoToCodeMouseExited

    private void lblGoToCodeMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblGoToCodeMouseReleased
        frmCifrar cif = new frmCifrar();
        cif.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblGoToCodeMouseReleased

    private void btnGoToCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGoToCodeActionPerformed
        frmCifrar cif = new frmCifrar();
        cif.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnGoToCodeActionPerformed

    private void btnSaveDecryptedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveDecryptedActionPerformed
        SaveDecoded();
    }//GEN-LAST:event_btnSaveDecryptedActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        txtDecoded.setText("");
        txtToDecode.setText("");
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnDecryptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDecryptActionPerformed
        frmPersonalizar p = new frmPersonalizar();
        String message = getMessage();
        
        char[] messageInArray = p.Conversion(message).toCharArray();
        char[] cripto = "juancrloshikmñpqtvwxyzbdefg".toCharArray();
        char[] abc = "hijklmnñopqrstuvwxyzabcdefg".toCharArray();
        String encrypted = p.decrypt(messageInArray, cripto, abc);
        txtDecoded.setText(encrypted);
    }//GEN-LAST:event_btnDecryptActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(frmDescifrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmDescifrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmDescifrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmDescifrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmDescifrar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDecrypt;
    private javax.swing.JButton btnGoToCode;
    private javax.swing.JButton btnMinimizar;
    private javax.swing.JButton btnSaveDecrypted;
    private javax.swing.JButton btnVolverC;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblAtrasDescifrar;
    private javax.swing.JLabel lblGoToCode;
    private javax.swing.JPanel pnlCerrar;
    private javax.swing.JPanel pnlClear;
    private javax.swing.JPanel pnlDecrypt;
    private javax.swing.JPanel pnlMin;
    private javax.swing.JPanel pnlSave;
    private javax.swing.JTextArea txtDecoded;
    private javax.swing.JTextArea txtToDecode;
    // End of variables declaration//GEN-END:variables
}
