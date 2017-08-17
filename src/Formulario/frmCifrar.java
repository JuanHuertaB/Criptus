
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

public class frmCifrar extends javax.swing.JFrame {

    
    public frmCifrar() {
        initComponents();
        this.setLocationRelativeTo(null);
        Shape forma = new RoundRectangle2D.Double(0, 0, this.getBounds().width, this.getBounds().height, 15,15);
        AWTUtilities.setWindowShape(this,forma);
        
        txtToEncode.requestFocus();
        //CAMBIAR ICONO DE VENTANA
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagenes/Neptune.png"));
        setIconImage(icon);

        //BOTONES TRANSPARENTES
        btnMinimizar.setContentAreaFilled(false);
        btnCerrar.setContentAreaFilled(false);
        btnVolverC.setContentAreaFilled(false);
        btnEncrypt.setContentAreaFilled(false);
        //btnSaveCrypted.setContentAreaFilled(false);
        btnClear.setContentAreaFilled(false);
        
        //EFECTOS INICIALES EN EL BOTON CERRAR
        pnlCerrar.setVisible(true);
        pnlCerrar.setBackground(null);
        
        //EFECTOS BOTON MINIMIZAR
        pnlMin.setVisible(true);
        pnlMin.setBackground(null);
        
        //EFECTOS BOTON VOLVER
        lblGoToDecode.setForeground(Color.gray);
        lblGoToPrin.setForeground(Color.gray);
        
        pnlEncrypt.setBackground(null);
        //pnlSave.setBackground(null);
        pnlClear.setBackground(null);
   
    }
    
        String getMessage(){
             String message = txtToEncode.getText();
            return message;
        }
        
       
        void SaveCoded(){
            FileDialog da;
            da = new FileDialog(this,"Guardar como",FileDialog.SAVE);
            da.show();
            String file,directory;
            file = da.getFile()+".txt"; 
            directory = da.getDirectory();
            
        try(PrintWriter pw = new PrintWriter( new FileWriter(directory+file))) {
            
            pw.println(txtCoded.getText().trim());
            JOptionPane.showMessageDialog(null, "Mensaje Guardado");
        }catch(Exception e){
            
        }
    }
   
        void encode(String criptoa, String llano){
            txtCoded.setText("");
            frmPersonalizar p = new frmPersonalizar();
            String message = getMessage();
            char[] msgInArray = p.Conversion(message).toCharArray();
            char[] cripto = criptoa.toCharArray();
            char[] abc = llano.toCharArray();

            String encrypted = p.encrypt(msgInArray, cripto, abc);
            txtCoded.setText(encrypted);
        }
        static public boolean defaultP;
        String criptoDefault= "juancrlosbdefghikmñpqtvwxyz";
        String llanoDefault= "abcdefghijklmnñopqrstuvwxyz";
        static public String criptoCustom;
        static public String llanoCustom;
        
        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        pnlMin = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        btnMinimizar = new javax.swing.JButton();
        pnlCerrar = new javax.swing.JPanel();
        btnCerrar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtCoded = new javax.swing.JTextArea();
        lblGoToDecode = new javax.swing.JLabel();
        btnVolverC = new javax.swing.JButton();
        pnlEncrypt = new javax.swing.JPanel();
        btnEncrypt = new javax.swing.JButton();
        pnlClear = new javax.swing.JPanel();
        btnClear = new javax.swing.JButton();
        lblGoToPrin = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtToEncode = new javax.swing.JTextArea();

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
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/if_Venus_1715802 (1).png"))); // NOI18N
        jPanel3.add(jLabel4);
        jLabel4.setBounds(0, 0, 30, 30);

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
        btnCerrar.setFont(new java.awt.Font("Eras Light ITC", 1, 18)); // NOI18N
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

        jLabel5.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 13)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Cifrar");
        jPanel3.add(jLabel5);
        jLabel5.setBounds(0, 0, 1000, 30);

        jPanel1.add(jPanel3);
        jPanel3.setBounds(0, 0, 1000, 30);

        jLabel1.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Este es el mensaje cifrado");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(100, 340, 250, 40);

        jLabel2.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Ingrese el mensaje que desea cifrar");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(90, 80, 330, 40);

        txtCoded.setEditable(false);
        txtCoded.setBackground(new java.awt.Color(21, 52, 65));
        txtCoded.setColumns(20);
        txtCoded.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 13)); // NOI18N
        txtCoded.setForeground(new java.awt.Color(255, 255, 255));
        txtCoded.setRows(5);
        txtCoded.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 41, 60), 1, true));
        txtCoded.setCaretColor(new java.awt.Color(255, 255, 255));
        jScrollPane2.setViewportView(txtCoded);

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(100, 380, 820, 170);

        lblGoToDecode.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 13)); // NOI18N
        lblGoToDecode.setForeground(new java.awt.Color(255, 255, 255));
        lblGoToDecode.setText("Ir a descifrar");
        lblGoToDecode.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblGoToDecodeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblGoToDecodeMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lblGoToDecodeMouseReleased(evt);
            }
        });
        jPanel1.add(lblGoToDecode);
        lblGoToDecode.setBounds(880, 40, 80, 30);

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

        btnEncrypt.setBackground(new java.awt.Color(0, 21, 29));
        btnEncrypt.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 15)); // NOI18N
        btnEncrypt.setForeground(new java.awt.Color(255, 255, 255));
        btnEncrypt.setText("Cifrar mensaje");
        btnEncrypt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(10, 121, 143)));
        btnEncrypt.setContentAreaFilled(false);
        btnEncrypt.setFocusPainted(false);
        btnEncrypt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEncryptMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEncryptMouseExited(evt);
            }
        });
        btnEncrypt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEncryptActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlEncryptLayout = new javax.swing.GroupLayout(pnlEncrypt);
        pnlEncrypt.setLayout(pnlEncryptLayout);
        pnlEncryptLayout.setHorizontalGroup(
            pnlEncryptLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlEncryptLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnEncrypt, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlEncryptLayout.setVerticalGroup(
            pnlEncryptLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlEncryptLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnEncrypt, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.add(pnlEncrypt);
        pnlEncrypt.setBounds(420, 290, 170, 40);

        btnClear.setBackground(new java.awt.Color(0, 21, 29));
        btnClear.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 15)); // NOI18N
        btnClear.setForeground(new java.awt.Color(255, 255, 255));
        btnClear.setText("Limpiar campos");
        btnClear.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(10, 121, 143)));
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
            .addComponent(btnClear, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
        );
        pnlClearLayout.setVerticalGroup(
            pnlClearLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnClear, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jPanel1.add(pnlClear);
        pnlClear.setBounds(420, 570, 170, 40);

        lblGoToPrin.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 13)); // NOI18N
        lblGoToPrin.setForeground(new java.awt.Color(255, 255, 255));
        lblGoToPrin.setText("Ir a Inicio");
        lblGoToPrin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblGoToPrinMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblGoToPrinMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblGoToPrinMouseExited(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lblGoToPrinMouseReleased(evt);
            }
        });
        jPanel1.add(lblGoToPrin);
        lblGoToPrin.setBounds(40, 40, 60, 30);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/if_Right_arrow_2202241.png"))); // NOI18N
        jButton1.setBorder(null);
        jButton1.setContentAreaFilled(false);
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton1MouseExited(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(940, 40, 50, 30);

        txtToEncode.setBackground(new java.awt.Color(21, 52, 65));
        txtToEncode.setColumns(20);
        txtToEncode.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 13)); // NOI18N
        txtToEncode.setForeground(new java.awt.Color(255, 255, 255));
        txtToEncode.setRows(5);
        txtToEncode.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 41, 60), new java.awt.Color(0, 41, 60), new java.awt.Color(0, 41, 60), new java.awt.Color(0, 41, 60)));
        txtToEncode.setCaretColor(new java.awt.Color(255, 255, 255));
        txtToEncode.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jScrollPane3.setViewportView(txtToEncode);

        jPanel1.add(jScrollPane3);
        jScrollPane3.setBounds(90, 120, 830, 150);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 996, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
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
        //frmCripto.setDefaultCloseOperation(frmCripto.EXIT_ON_CLOSE);
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
         

    @SuppressWarnings("DeadBranch")
    private void btnEncryptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEncryptActionPerformed

        if(defaultP )
            encode(criptoCustom,llanoCustom);
        else
            encode(criptoDefault,llanoDefault);

        txtToEncode.requestFocus();
    }//GEN-LAST:event_btnEncryptActionPerformed

    private void lblGoToDecodeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblGoToDecodeMouseEntered
        lblGoToDecode.setForeground(Color.white);
    }//GEN-LAST:event_lblGoToDecodeMouseEntered

    private void lblGoToDecodeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblGoToDecodeMouseExited
        lblGoToDecode.setForeground(Color.gray);
    }//GEN-LAST:event_lblGoToDecodeMouseExited

    private void lblGoToDecodeMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblGoToDecodeMouseReleased
        frmDescifrar dec = new frmDescifrar();
        dec.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblGoToDecodeMouseReleased

    private void btnVolverCMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVolverCMouseEntered
        //pnlVolverC.setBackground(Color.gray);
        lblGoToPrin.setForeground(Color.white);
    }//GEN-LAST:event_btnVolverCMouseEntered

    private void btnVolverCMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVolverCMouseExited
        //pnlVolverC.setBackground(null);
        lblGoToPrin.setForeground(Color.gray);
        
    }//GEN-LAST:event_btnVolverCMouseExited

    private void btnVolverCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverCActionPerformed
        Principal prn = new Principal();
        prn.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnVolverCActionPerformed

    private void btnEncryptMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEncryptMouseEntered
        pnlEncrypt.setBackground(new Color(7, 97, 104));
    }//GEN-LAST:event_btnEncryptMouseEntered

    private void btnClearMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnClearMouseEntered
        pnlClear.setBackground(new Color(7, 97, 104));
    }//GEN-LAST:event_btnClearMouseEntered

    private void btnEncryptMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEncryptMouseExited
        pnlEncrypt.setBackground(null);
    }//GEN-LAST:event_btnEncryptMouseExited

    private void btnClearMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnClearMouseExited
        pnlClear.setBackground(null);
    }//GEN-LAST:event_btnClearMouseExited

    private void lblGoToPrinMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblGoToPrinMouseEntered
       lblGoToPrin.setForeground(Color.white);
    }//GEN-LAST:event_lblGoToPrinMouseEntered

    private void lblGoToPrinMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblGoToPrinMouseExited
        lblGoToPrin.setForeground(Color.gray);
    }//GEN-LAST:event_lblGoToPrinMouseExited

    private void lblGoToPrinMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblGoToPrinMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_lblGoToPrinMouseReleased

    private void lblGoToPrinMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblGoToPrinMouseClicked
        Principal prn = new Principal();
        prn.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblGoToPrinMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        frmDescifrar dec = new frmDescifrar();
        dec.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseEntered
        lblGoToDecode.setForeground(Color.white);
    }//GEN-LAST:event_jButton1MouseEntered

    private void jButton1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseExited
        lblGoToDecode.setForeground(Color.gray);
    }//GEN-LAST:event_jButton1MouseExited

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        txtToEncode.setText("");
        txtCoded.setText("");
        txtToEncode.requestFocus();
    }//GEN-LAST:event_btnClearActionPerformed

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
            java.util.logging.Logger.getLogger(frmCifrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmCifrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmCifrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmCifrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmCifrar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnEncrypt;
    private javax.swing.JButton btnMinimizar;
    private javax.swing.JButton btnVolverC;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblGoToDecode;
    private javax.swing.JLabel lblGoToPrin;
    private javax.swing.JPanel pnlCerrar;
    private javax.swing.JPanel pnlClear;
    private javax.swing.JPanel pnlEncrypt;
    private javax.swing.JPanel pnlMin;
    private javax.swing.JTextArea txtCoded;
    private javax.swing.JTextArea txtToEncode;
    // End of variables declaration//GEN-END:variables
}
