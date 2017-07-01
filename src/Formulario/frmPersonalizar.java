package Formulario;

import java.awt.FileDialog;
import java.io.FileWriter;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

public class frmPersonalizar extends javax.swing.JFrame {
    
    public frmPersonalizar() {
        
        initComponents();
        txtKeyWord.requestFocus();
        txtCripto.setEditable(false);
        txtEncrypted.setEditable(false);        
        rdoOrdenado.setSelected(true);        
        btnEnviar.setEnabled(false);  
        
    }
    
    char[] textComplete = new char[26]; //ARREGLO DONDE SE GUARDARÁ EL CRIPTO
    String abc = ""; //DEFINIMOS EL ALFABETO

    //PONER EL ABECEDARIO EN UN ARREGLO
        String abcInArray() {
        String cadena1 = "";
        String cadena2 = "";
        
        if (rdoOrdenado.isSelected() && rdoLetter.isSelected()) {
            String letter = txtLetter.getText();
            abc = "abcdefghijklmnopqrstuvwxyz";
            
            for (int i = 0; i < abc.length(); i++) {
                if (letter.equals(Character.toString(abc.charAt(i)))) {
                    cadena1 = abc.substring(i, abc.length());
                    cadena2 = abc.substring(0, i);
                    abc = cadena1.concat(cadena2);
                }
            }            
        } else if (rdoInverso.isSelected() && rdoLetter.isSelected()) {
            String letter = txtLetter.getText();
            abc = "zyxwvutsrqponmlkjihgfedcba";
            
            for (int j = 0; j < abc.length(); j++) {
                if (letter.equals(Character.toString(abc.charAt(j)))) {
                    cadena1 = abc.substring(j, abc.length());
                    cadena2 = abc.substring(0, j);
                    abc = cadena1.concat(cadena2);
                }
            }
        } else if (rdoOrdenado.isSelected()) {
            abc = "abcdefghijklmnopqrstuvwxyz";
        } else {
            abc = "zyxwvutsrqponmlkjihgfedcba";
        }
        return abc;
    }

    //OBTENEMOS LA PALABRA CLAVE 
    String getKeyWord() {
        return txtKeyWord.getText().trim();
    }

    //PONER LA PALABRA CLAVE EN UN ARREGLO
    char[] putInArray(String keyWord) {
        char achar[] = keyWord.toCharArray();
        return achar;
    }

    //BORRAR LETRAS REPETIDAS
    char[] deleteRepeted(char[] keyWordInArray) {
        
        int longitud = keyWordInArray.length;
        
        for (int i = 0; i < longitud; i++) {
            for (int j = 1; j < longitud; j++) {
                if (keyWordInArray[i] == keyWordInArray[j] && i != j) {                    
                    keyWordInArray[j] = ' ';
                }
            }            
        }
        return keyWordInArray;
    }

    //BORRAR ESPACIOS EN BLANCO
    char[] deleteSpaces(char[] text) {
        
        String cadena = "";
        for (int i = 0; i < text.length; i++) {
            cadena += Character.toString(text[i]);
        }
        for (int i = 0; i < cadena.length(); i++) {
            cadena = cadena.replace(" ", "");
        }
        char[] aCaracteres = cadena.toCharArray();
        
        return aCaracteres;        
    }

    //COMPLETAR TEXTO CON LAS LETRAS FALTANTES
    void completarArray(char[] aCharac, String abc) {
        //System.arraycopy(aCharac, 0, textComplete, 0, aCharac.length);
        txtCripto.setText("");
        for (int i = 0; i < aCharac.length; i++) {
            for (int j = 0; j < abc.length(); j++) {
                if (aCharac[i] == abc.charAt(j)) {
                    abc = abc.replace(abc.charAt(j), ' ');
                }
            }
        }
        char[] abcde = deleteSpaces(putInArray(abc));
        
        String cadenaUno = "", cadenaDos = "", cadenaFinal;
        for (int i = 0; i < abcde.length; i++) {
            cadenaUno += Character.toString(abcde[i]);
        }
        
        for (int r = 0; r < aCharac.length; r++) {
            cadenaDos += Character.toString(aCharac[r]);
        }
        
        cadenaFinal = cadenaDos.concat(cadenaUno);
        textComplete = cadenaFinal.toCharArray();
        
        for (int i = 0; i < textComplete.length; i++) {
            txtCripto.append(Character.toString(textComplete[i]));
        }
    }

    /*--------------------------------------------------------------------------------------------------------*/
    /*-------------------------------------------------PROCESO DE CIFRADO---------------------------------------------*/
    
    String findNumbers(String msj){
        for(int i=0;i<msj.length();i++){
            String cadA;
            String cadB;
           switch(msj.charAt(i)){
               case '0':
                   cadA= msj.substring(0,i);
                   cadB= msj.substring(i+1,msj.length());
                   msj = cadA.concat("cero"+cadB); break; 
               case '1': 
                   cadA= msj.substring(0,i);
                   cadB= msj.substring(i+1,msj.length());
                   msj = cadA.concat("uno"+cadB); break; 
               case '2':
                   cadA= msj.substring(0,i);
                   cadB= msj.substring(i+1,msj.length());
                   msj = cadA.concat("dos"+cadB); break; 
               case '3':
                   cadA= msj.substring(0,i);
                   cadB= msj.substring(i+1,msj.length());
                   msj = cadA.concat("tres"+cadB); break; 
               case '4':
                   cadA= msj.substring(0,i);
                   cadB= msj.substring(i+1,msj.length());
                   msj = cadA.concat("cuatro"+cadB); break; 
               case '5':
                   cadA= msj.substring(0,i);
                   cadB= msj.substring(i+1,msj.length());
                   msj = cadA.concat("cinco"+cadB); break; 
               case '6':
                   cadA= msj.substring(0,i);
                   cadB= msj.substring(i+1,msj.length());
                   msj = cadA.concat("seis"+cadB); break; 
               case '7':
                   cadA= msj.substring(0,i);
                   cadB= msj.substring(i+1,msj.length());
                   msj = cadA.concat("siete"+cadB); break; 
               case '8':
                   cadA= msj.substring(0,i);
                   cadB= msj.substring(i+1,msj.length());
                   msj = cadA.concat("ocho"+cadB); break; 
               case '9':
                   cadA= msj.substring(0,i);
                   cadB= msj.substring(i+1,msj.length());
                   msj = cadA.concat("nueve"+cadB); break; 
              
                
               default: System.out.println("no sucedio ningún caso");
               for(int k=0;k<msj.length();k++){
                   System.out.println(msj.charAt(i));
               }
           }
        }
        return msj;  
    }
    
    String getMessage() {
        return txtToEncrypt.getText();
    }
    
    char[] putMessageInArray(String mensaje){
        return mensaje.toCharArray();
    }
    char[] putCriptoInArray() {
        return txtCripto.getText().toCharArray();
    }
    
    void encrypt(char[] mensaje, char[] cripto, char[] llano) {
        
        for (int i = 0; i < mensaje.length; i++) {            
            for (int j = 0; j < llano.length; j++) {                
                if (mensaje[i] == llano[j]) {
                    mensaje[i] = cripto[j];                    
                    j = j + (llano.length - j);                    
                }
            }            
        }        
        for (int k = 0; k < mensaje.length; k++) {
            txtEncrypted.append(Character.toString(mensaje[k]));
        }
    }
    
    char[] getEncripted() {
        return txtToDecrypt.getText().toCharArray();
    }
    
    void decrypt(char[] message, char[] cripto, char[] abc) {
        
        for (int i = 0; i < message.length; i++) {
            for (int j = 0; j < cripto.length; j++) {
                if (message[i] == cripto[j]) {
                    message[i] = abc[j];
                    j = j + (cripto.length - j);
                }
            }
        }
        for (int k = 0; k < message.length; k++) {
            txtDecrypted.append(Character.toString(message[k]));
        }        
    }
    void grabar(){
            FileDialog da;
            da = new FileDialog(this,"Guardar como",FileDialog.SAVE);
            da.show();
            String file;
            String directory;
            file = da.getFile()+".txt";
            directory = da.getDirectory();
            
        try(PrintWriter pw = new PrintWriter( new FileWriter(directory+file))) {
            
            pw.println(txtEncrypted.getText().trim());
            JOptionPane.showInternalMessageDialog(null, "Mensaje Guardado");
        }catch(Exception e){
            
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtKeyWord = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        rdoOrdenado = new javax.swing.JRadioButton();
        rdoInverso = new javax.swing.JRadioButton();
        btnEnviar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtCripto = new javax.swing.JTextArea();
        txtLetter = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        rdoLetter = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        btnEncrypt = new javax.swing.JButton();
        btnCleanDecrypt = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtToEncrypt = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtEncrypted = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        btnDecrypt = new javax.swing.JButton();
        btnLimpiar3 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtToDecrypt = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        txtDecrypted = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(35, 86, 104));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(204, 204, 204), null, null));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Palabra clave");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 80, -1));

        txtKeyWord.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtKeyWordKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtKeyWordKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtKeyWordKeyTyped(evt);
            }
        });
        jPanel1.add(txtKeyWord, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 350, 34));

        jLabel5.setText("Seleccionar tipo de alfabeto");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        rdoOrdenado.setText("Ordenado");
        rdoOrdenado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoOrdenadoActionPerformed(evt);
            }
        });
        jPanel1.add(rdoOrdenado, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, -1, -1));

        rdoInverso.setText("Inverso");
        rdoInverso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoInversoActionPerformed(evt);
            }
        });
        jPanel1.add(rdoInverso, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 110, 70, -1));

        btnEnviar.setText("Enviar");
        btnEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEnviar, new org.netbeans.lib.awtextra.AbsoluteConstraints(76, 140, 90, -1));

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });
        jPanel1.add(btnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 140, 91, -1));

        jLabel2.setText("Cripto");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 20, -1, -1));

        txtCripto.setBackground(new java.awt.Color(204, 204, 204));
        txtCripto.setColumns(20);
        txtCripto.setRows(5);
        jScrollPane3.setViewportView(txtCripto);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 50, 423, 35));
        jPanel1.add(txtLetter, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 100, 50, 30));

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 70, 10, 60));

        rdoLetter.setText("Elegir letra inicial del alfabeto");
        rdoLetter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdoLetterMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                rdoLetterMouseReleased(evt);
            }
        });
        rdoLetter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoLetterActionPerformed(evt);
            }
        });
        jPanel1.add(rdoLetter, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 80, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, 870, 180));

        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(204, 204, 204), null, null));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setText("Mensaje ");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 50, -1));

        btnEncrypt.setText("Enviar");
        btnEncrypt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEncryptActionPerformed(evt);
            }
        });
        jPanel2.add(btnEncrypt, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 120, 113, -1));

        btnCleanDecrypt.setText("Limpiar");
        btnCleanDecrypt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCleanDecryptActionPerformed(evt);
            }
        });
        jPanel2.add(btnCleanDecrypt, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 120, 107, -1));

        txtToEncrypt.setColumns(20);
        txtToEncrypt.setRows(5);
        jScrollPane1.setViewportView(txtToEncrypt);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 426, 58));

        jLabel4.setText("Mensaje Encriptado");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, -1));

        txtEncrypted.setBackground(new java.awt.Color(204, 204, 204));
        txtEncrypted.setColumns(20);
        txtEncrypted.setRows(5);
        jScrollPane2.setViewportView(txtEncrypted);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 426, 90));

        jButton1.setText("Enviar a Descifrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 280, -1, -1));

        btnSave.setText("Guardar");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        jPanel2.add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 280, 100, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, 460, 330));

        jPanel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(204, 204, 204), null, null));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setText("Mensaje");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 52, -1));

        btnDecrypt.setText("Enviar");
        btnDecrypt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDecryptActionPerformed(evt);
            }
        });
        jPanel3.add(btnDecrypt, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 120, 113, -1));

        btnLimpiar3.setText("Limpiar");
        btnLimpiar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiar3ActionPerformed(evt);
            }
        });
        jPanel3.add(btnLimpiar3, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 120, 107, -1));

        txtToDecrypt.setColumns(20);
        txtToDecrypt.setRows(5);
        jScrollPane4.setViewportView(txtToDecrypt);

        jPanel3.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 426, 58));

        jLabel8.setText("Mensaje Desencriptado");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, -1));

        txtDecrypted.setBackground(new java.awt.Color(204, 204, 204));
        txtDecrypted.setColumns(20);
        txtDecrypted.setRows(5);
        jScrollPane5.setViewportView(txtDecrypted);

        jPanel3.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 426, 90));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 210, 460, 330));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarActionPerformed
        
        String keyWord = getKeyWord();//OBTENEMOS LA PALABRA CLAVE
        /*SE ENVIA LA PALABRA CLAVE A METODO QUE LO PONDRÁ EN UN ARRAY DE CARACTERES 
        LUEGO SE GUARDA EL ARREGLO PARA ENVIARLO AL SIGUIENTE MÉTODO*/
        char[] keyWordInArray = putInArray(keyWord);
        char[] finalText = deleteRepeted(keyWordInArray);//BORRAMOS LOS CARACTERES REPETIDOS DE LA PALABRA CLAVE
        char[] textOne = deleteSpaces(finalText);//BORRAR ESPACIOS VACIOS DESPUES DE ELIMINAR LAS REPETICIONES
        String abc = abcInArray();//OBTENEMOS EL ALFABETO
        completarArray(textOne, abc); //INGRESAMOS LOS CARACTERES FALTANTES PARA OBTENER EL CRIPTO       
    }//GEN-LAST:event_btnEnviarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        txtCripto.setText("");
        txtToEncrypt.setText("");
        txtKeyWord.setText("");
        txtLetter.setText("");
        txtKeyWord.requestFocus();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnEncryptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEncryptActionPerformed
        txtEncrypted.setText("");
        String message = getMessage();
        char[] msgInArray = findNumbers(message).toCharArray();
        char[] cripto = putCriptoInArray();
        char[] abc = abcInArray().toCharArray();
        
        encrypt(msgInArray, cripto, abc);
    }//GEN-LAST:event_btnEncryptActionPerformed

    private void btnCleanDecryptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCleanDecryptActionPerformed
        txtToEncrypt.setText("");
        txtEncrypted.setText("");
        txtToEncrypt.requestFocus();
    }//GEN-LAST:event_btnCleanDecryptActionPerformed

    private void rdoOrdenadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoOrdenadoActionPerformed
        rdoInverso.setSelected(false);
    }//GEN-LAST:event_rdoOrdenadoActionPerformed

    private void rdoInversoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoInversoActionPerformed
        rdoOrdenado.setSelected(false);
    }//GEN-LAST:event_rdoInversoActionPerformed

    private void btnDecryptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDecryptActionPerformed
        txtDecrypted.setText("");
        char[] message = getEncripted();
        char[] cripto = putCriptoInArray();
        char[] abc = abcInArray().toCharArray();
        
        decrypt(message, cripto, abc);
    }//GEN-LAST:event_btnDecryptActionPerformed

    private void btnLimpiar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiar3ActionPerformed
        txtToDecrypt.setText("");
        txtDecrypted.setText("");
    }//GEN-LAST:event_btnLimpiar3ActionPerformed

    private void rdoLetterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoLetterActionPerformed
        

    }//GEN-LAST:event_rdoLetterActionPerformed

    private void txtKeyWordKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtKeyWordKeyTyped
        
    }//GEN-LAST:event_txtKeyWordKeyTyped

    private void txtKeyWordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtKeyWordKeyReleased
        btnEnviar.setEnabled(true);
        int longitud = txtKeyWord.getText().length();
        if (longitud == 0) {
            btnEnviar.setEnabled(false);
        }
    }//GEN-LAST:event_txtKeyWordKeyReleased

    private void txtKeyWordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtKeyWordKeyPressed

    }//GEN-LAST:event_txtKeyWordKeyPressed

    private void rdoLetterMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdoLetterMouseReleased
        

    }//GEN-LAST:event_rdoLetterMouseReleased

    private void rdoLetterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdoLetterMouseClicked
        
    }//GEN-LAST:event_rdoLetterMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String mensaje = txtEncrypted.getText();
        txtToDecrypt.setText(mensaje);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        grabar();
    }//GEN-LAST:event_btnSaveActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmPersonalizar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmPersonalizar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmPersonalizar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmPersonalizar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmPersonalizar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCleanDecrypt;
    private javax.swing.JButton btnDecrypt;
    private javax.swing.JButton btnEncrypt;
    private javax.swing.JButton btnEnviar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnLimpiar3;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JRadioButton rdoInverso;
    private javax.swing.JRadioButton rdoLetter;
    private javax.swing.JRadioButton rdoOrdenado;
    private javax.swing.JTextArea txtCripto;
    private javax.swing.JTextArea txtDecrypted;
    private javax.swing.JTextArea txtEncrypted;
    private javax.swing.JTextField txtKeyWord;
    private javax.swing.JTextField txtLetter;
    private javax.swing.JTextArea txtToDecrypt;
    private javax.swing.JTextArea txtToEncrypt;
    // End of variables declaration//GEN-END:variables
}
