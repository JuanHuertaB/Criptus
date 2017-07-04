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

public class frmPersonalizar extends javax.swing.JFrame {
    
    public frmPersonalizar() {
        
        initComponents();
        txtKeyWord.requestFocus();
        txtCripto.setEditable(false);
        txtEncrypted.setEditable(false);        
        rdoOrdenado.setSelected(true);        
        btnEnviar.setEnabled(false);
        btnCleanEncrypt.setEnabled(false);
        btnLimpiar.setEnabled(false);
        btnCleanDecrypt.setEnabled(false);
        btnDecrypt.setEnabled(false);
        btnSave.setEnabled(false);
        btnSendToDecrypt.setEnabled(false);
        btnEncrypt.setEnabled(false);
        txtLetter.setEnabled(false);
        btnSendToDecrypt.setEnabled(false);
        btnSaveDecrypted.setEnabled(false);
        btnCleanDecrypted.setEnabled(false);
        
        btnMinimizar.setContentAreaFilled(false);
        btnCerrar.setContentAreaFilled(false);
        pnlCerrar.setBackground(new Color(42,0,0));
        pnlMin.setBackground(null);
       
        Shape forma = new RoundRectangle2D.Double(0, 0, this.getBounds().width, this.getBounds().height, 15,15);
        AWTUtilities.setWindowShape(this,forma);
        
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagenes/Neptune.png"));
        setIconImage(icon);
        
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

    /*----------------------------------------------------------------------------------------------------------------*/
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
               case '@':
                   cadA= msj.substring(0,i);
                   cadB= msj.substring(i+1,msj.length());
                   msj = cadA.concat("arroba"+cadB); break;
               case '.':
                   cadA= msj.substring(0,i);
                   cadB= msj.substring(i+1,msj.length());
                   msj = cadA.concat("punto"+cadB); break;
               case ',':
                   cadA= msj.substring(0,i);
                   cadB= msj.substring(i+1,msj.length());
                   msj = cadA.concat("coma"+cadB); break;
               case ';':
                   cadA= msj.substring(0,i);
                   cadB= msj.substring(i+1,msj.length());
                   msj = cadA.concat("punto y coma"+cadB); break;
    
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
            String file,directory;
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

        jPanel4 = new javax.swing.JPanel();
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
        btnCleanEncrypt = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtToEncrypt = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtEncrypted = new javax.swing.JTextArea();
        btnSendToDecrypt = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        btnDecrypt = new javax.swing.JButton();
        btnCleanDecrypt = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtToDecrypt = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        txtDecrypted = new javax.swing.JTextArea();
        btnSaveDecrypted = new javax.swing.JButton();
        btnCleanDecrypted = new javax.swing.JButton();
        btnVolverP = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        pnlMin = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        btnMinimizar = new javax.swing.JButton();
        pnlCerrar = new javax.swing.JPanel();
        btnCerrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Personalizar");
        setBackground(new java.awt.Color(35, 86, 104));
        setName("Personalizar"); // NOI18N
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(7, 64, 77));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 54, 67));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
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

        jLabel5.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Seleccionar tipo de alfabeto");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        rdoOrdenado.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 11)); // NOI18N
        rdoOrdenado.setForeground(new java.awt.Color(255, 255, 255));
        rdoOrdenado.setText("Ordenado");
        rdoOrdenado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoOrdenadoActionPerformed(evt);
            }
        });
        jPanel1.add(rdoOrdenado, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, -1, -1));

        rdoInverso.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 11)); // NOI18N
        rdoInverso.setForeground(new java.awt.Color(255, 255, 255));
        rdoInverso.setText("Inverso");
        rdoInverso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoInversoActionPerformed(evt);
            }
        });
        jPanel1.add(rdoInverso, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 110, 70, -1));

        btnEnviar.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 11)); // NOI18N
        btnEnviar.setText("Enviar");
        btnEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEnviar, new org.netbeans.lib.awtextra.AbsoluteConstraints(76, 140, 90, -1));

        btnLimpiar.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 11)); // NOI18N
        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });
        jPanel1.add(btnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 140, 91, -1));

        jLabel2.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
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

        rdoLetter.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 11)); // NOI18N
        rdoLetter.setForeground(new java.awt.Color(255, 255, 255));
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

        jPanel4.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 50, 850, 190));

        jPanel2.setBackground(new java.awt.Color(0, 54, 67));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Mensaje ");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 50, -1));

        btnEncrypt.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 11)); // NOI18N
        btnEncrypt.setText("Enviar");
        btnEncrypt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEncryptActionPerformed(evt);
            }
        });
        jPanel2.add(btnEncrypt, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 120, 113, -1));

        btnCleanEncrypt.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 11)); // NOI18N
        btnCleanEncrypt.setText("Limpiar");
        btnCleanEncrypt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCleanEncryptActionPerformed(evt);
            }
        });
        jPanel2.add(btnCleanEncrypt, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 120, 107, -1));

        txtToEncrypt.setColumns(20);
        txtToEncrypt.setRows(5);
        txtToEncrypt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtToEncryptKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(txtToEncrypt);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 426, 58));

        jLabel4.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Mensaje Encriptado");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, -1));

        txtEncrypted.setBackground(new java.awt.Color(204, 204, 204));
        txtEncrypted.setColumns(20);
        txtEncrypted.setRows(5);
        txtEncrypted.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtEncryptedKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(txtEncrypted);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 180, 410, 90));

        btnSendToDecrypt.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 11)); // NOI18N
        btnSendToDecrypt.setText("Enviar a Descifrar");
        btnSendToDecrypt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendToDecryptActionPerformed(evt);
            }
        });
        jPanel2.add(btnSendToDecrypt, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 280, -1, -1));

        btnSave.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 11)); // NOI18N
        btnSave.setText("Guardar texto");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        jPanel2.add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 280, 110, -1));

        jPanel4.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, 480, 320));

        jPanel3.setBackground(new java.awt.Color(0, 54, 67));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 11)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Mensaje Encriptado");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 100, -1));

        btnDecrypt.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 11)); // NOI18N
        btnDecrypt.setText("Enviar");
        btnDecrypt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDecryptActionPerformed(evt);
            }
        });
        jPanel3.add(btnDecrypt, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 120, 113, -1));

        btnCleanDecrypt.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 11)); // NOI18N
        btnCleanDecrypt.setText("Limpiar");
        btnCleanDecrypt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCleanDecryptActionPerformed(evt);
            }
        });
        jPanel3.add(btnCleanDecrypt, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 120, 107, -1));

        txtToDecrypt.setColumns(20);
        txtToDecrypt.setRows(5);
        txtToDecrypt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtToDecryptKeyReleased(evt);
            }
        });
        jScrollPane4.setViewportView(txtToDecrypt);

        jPanel3.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 426, 58));

        jLabel8.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 11)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Mensaje Desencriptado");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, -1));

        txtDecrypted.setBackground(new java.awt.Color(204, 204, 204));
        txtDecrypted.setColumns(20);
        txtDecrypted.setRows(5);
        jScrollPane5.setViewportView(txtDecrypted);

        jPanel3.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 426, 90));

        btnSaveDecrypted.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 11)); // NOI18N
        btnSaveDecrypted.setText("Guardar texto");
        btnSaveDecrypted.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveDecryptedActionPerformed(evt);
            }
        });
        jPanel3.add(btnSaveDecrypted, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 280, 110, -1));

        btnCleanDecrypted.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 11)); // NOI18N
        btnCleanDecrypted.setText("Limpiar");
        btnCleanDecrypted.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCleanDecryptedActionPerformed(evt);
            }
        });
        jPanel3.add(btnCleanDecrypted, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 280, 100, -1));

        jPanel4.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 260, 480, 320));

        btnVolverP.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 11)); // NOI18N
        btnVolverP.setText("Volver");
        btnVolverP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverPActionPerformed(evt);
            }
        });
        jPanel4.add(btnVolverP, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        jPanel5.setBackground(new java.awt.Color(24, 51, 55));
        jPanel5.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel5MouseDragged(evt);
            }
        });
        jPanel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel5MousePressed(evt);
            }
        });
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Neptune.png"))); // NOI18N
        jPanel5.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 20, 30));

        jLabel9.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 10)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(153, 153, 153));
        jLabel9.setText("CRIPTO - CIFRAR");
        jPanel5.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 10, 80, 16));

        pnlMin.setBackground(new java.awt.Color(204, 204, 204));
        pnlMin.setLayout(null);

        jPanel6.setBackground(new java.awt.Color(204, 204, 204));
        jPanel6.setLayout(null);
        pnlMin.add(jPanel6);
        jPanel6.setBounds(660, 0, 50, 30);

        btnMinimizar.setBackground(new java.awt.Color(12, 23, 30));
        btnMinimizar.setFont(new java.awt.Font("Eras Medium ITC", 0, 40)); // NOI18N
        btnMinimizar.setForeground(new java.awt.Color(255, 255, 255));
        btnMinimizar.setText("-");
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

        jPanel5.add(pnlMin, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 0, 50, 30));

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
        btnCerrar.setFont(new java.awt.Font("Eras Light ITC", 1, 24)); // NOI18N
        btnCerrar.setForeground(new java.awt.Color(255, 255, 255));
        btnCerrar.setText("X");
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

        jPanel5.add(pnlCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 0, 50, 30));

        jPanel4.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1060, 30));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1060, 590));

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
        
        btnSendToDecrypt.setEnabled(true);
        btnSave.setEnabled(true);
    }//GEN-LAST:event_btnEncryptActionPerformed

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
        
        btnSaveDecrypted.setEnabled(true);
    }//GEN-LAST:event_btnDecryptActionPerformed

    private void btnCleanDecryptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCleanDecryptActionPerformed
        txtToDecrypt.setText("");
        btnDecrypt.setEnabled(false);
    }//GEN-LAST:event_btnCleanDecryptActionPerformed

    private void rdoLetterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoLetterActionPerformed
        if(rdoLetter.isSelected()){
            txtLetter.setEnabled(true);
        }else{
            txtLetter.setEnabled(false);
        }

    }//GEN-LAST:event_rdoLetterActionPerformed

    private void txtKeyWordKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtKeyWordKeyTyped
        
    }//GEN-LAST:event_txtKeyWordKeyTyped

    private void txtKeyWordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtKeyWordKeyReleased
        btnEnviar.setEnabled(true);
        btnLimpiar.setEnabled(true);
        int longitud = txtKeyWord.getText().length();
        if (longitud == 0) {
            btnEnviar.setEnabled(false);
            btnLimpiar.setEnabled(false);
        }
    }//GEN-LAST:event_txtKeyWordKeyReleased

    private void txtKeyWordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtKeyWordKeyPressed

    }//GEN-LAST:event_txtKeyWordKeyPressed

    private void rdoLetterMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdoLetterMouseReleased
        

    }//GEN-LAST:event_rdoLetterMouseReleased

    private void rdoLetterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdoLetterMouseClicked
        
    }//GEN-LAST:event_rdoLetterMouseClicked

    private void btnSendToDecryptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendToDecryptActionPerformed
        String mensaje = txtEncrypted.getText();
        txtToDecrypt.setText(mensaje);
        btnDecrypt.setEnabled(true);
    }//GEN-LAST:event_btnSendToDecryptActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        grabar();
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnSaveDecryptedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveDecryptedActionPerformed
        grabar();
    }//GEN-LAST:event_btnSaveDecryptedActionPerformed

    private void btnCleanDecryptedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCleanDecryptedActionPerformed
        txtDecrypted.setText("");
        btnSaveDecrypted.setEnabled(false);
    }//GEN-LAST:event_btnCleanDecryptedActionPerformed

    private void txtToEncryptKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtToEncryptKeyReleased
        btnEncrypt.setEnabled(true);
        btnCleanEncrypt.setEnabled(true);
        int longitud = txtToEncrypt.getText().length();
        if (longitud == 0) {
            btnEncrypt.setEnabled(false);
            btnCleanEncrypt.setEnabled(false);
        }
    }//GEN-LAST:event_txtToEncryptKeyReleased

    private void txtToDecryptKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtToDecryptKeyReleased
        btnEnviar.setEnabled(true);
        int longitud = txtToDecrypt.getText().length();
        if (longitud == 0) {
            btnDecrypt.setEnabled(false);
        }
    }//GEN-LAST:event_txtToDecryptKeyReleased

    private void btnCleanEncryptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCleanEncryptActionPerformed
        txtToEncrypt.setText("");
        txtEncrypted.setText("");
        txtToEncrypt.requestFocus();
    }//GEN-LAST:event_btnCleanEncryptActionPerformed

    private void txtEncryptedKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEncryptedKeyReleased
       btnEnviar.setEnabled(true);
       
        int longitud = txtToDecrypt.getText().length();
        if (longitud == 0) {
            btnDecrypt.setEnabled(false);
            
        }
    }//GEN-LAST:event_txtEncryptedKeyReleased

    private void btnVolverPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverPActionPerformed
        Principal prin = new Principal();
        prin.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_btnVolverPActionPerformed

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

    private void btnMinimizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMinimizarActionPerformed
        this.setExtendedState(ICONIFIED); //Minimizar ventana
    }//GEN-LAST:event_btnMinimizarActionPerformed

    private void btnCerrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCerrarMouseEntered
        pnlCerrar.setVisible(true);
        pnlCerrar.setBackground(Color.red);
    }//GEN-LAST:event_btnCerrarMouseEntered

    private void btnCerrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCerrarMouseExited
        pnlCerrar.setBackground(new Color(42,0,0));
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
        private int x;
        private int y;
        
    private void jPanel5MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MouseDragged
        //MODIFICAR LA POSICION DEL FRAME
        java.awt.Point point = MouseInfo.getPointerInfo().getLocation();
        setLocation(point.x - x , point.y-y);
    }//GEN-LAST:event_jPanel5MouseDragged

    private void jPanel5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel5MousePressed
        //OBTENER LA POSICIÓN DEL FRAME
        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_jPanel5MousePressed

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
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnCleanDecrypt;
    private javax.swing.JButton btnCleanDecrypted;
    private javax.swing.JButton btnCleanEncrypt;
    private javax.swing.JButton btnDecrypt;
    private javax.swing.JButton btnEncrypt;
    private javax.swing.JButton btnEnviar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnMinimizar;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSaveDecrypted;
    private javax.swing.JButton btnSendToDecrypt;
    private javax.swing.JButton btnVolverP;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel pnlCerrar;
    private javax.swing.JPanel pnlMin;
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
