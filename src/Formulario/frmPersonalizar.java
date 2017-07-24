
package Formulario;

import com.sun.awt.AWTUtilities;
import java.awt.Color;
import java.awt.FileDialog;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.Shape;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.geom.RoundRectangle2D;
import java.io.FileWriter;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

public class frmPersonalizar extends javax.swing.JFrame {
    
    @SuppressWarnings("OverridableMethodCallInConstructor")
    public frmPersonalizar() {
        
        initComponents();
        
        txtKeyWord.requestFocus();//El campo para la palabra clave está seleccionada por defecto       
        txtLlano.setEditable(false);//Deshabilitar la edición del cripto
        txtEncrypted.setEditable(false);//Deshabilitar la edición del mensaje cifrado
        txtLetter.setEnabled(false);//Esta deshabilitado por defecto. Se activa si se selecciona su boton asociado.(rdoLetter)       
        
        //Deshabilitar botones al iniciar
        btnEnviar.setEnabled(false);
        btnEnviar.setForeground(Color.gray);
        
        btnLimpiar.setEnabled(false);
        btnLimpiar.setForeground(Color.gray);
        
        btnCleanEncrypt.setEnabled(false);
        btnCleanEncrypt.setForeground(Color.gray);
        
        btnCleanDecrypt.setEnabled(false);
        btnCleanDecrypt.setForeground(Color.gray);
        
        btnCleanDecrypted.setEnabled(false);
        btnCleanDecrypted.setForeground(Color.gray);
        
        btnEncrypt.setEnabled(false);
        btnEncrypt.setForeground(Color.gray);
        
        btnDecrypt.setEnabled(false);
        btnDecrypt.setForeground(Color.gray);
        
        btnSendToDecrypt.setEnabled(false);
        btnSendToDecrypt.setForeground(Color.gray);
        
        btnSaveDecrypted.setEnabled(false);
        btnSaveDecrypted.setForeground(Color.gray);
        
        btnSaveEncrypted.setEnabled(false);
        btnSaveEncrypted.setForeground(Color.gray);
        
        rdoOrdenado.setSelected(true);//Por defecto se usa el alfabeto ordenado
        
        //Transparencia en los botones y paneles
        btnMinimizar.setContentAreaFilled(false);
        btnCerrar.setContentAreaFilled(false);
        pnlCerrar.setBackground(null);
        pnlMin.setBackground(null);
        lblVolver.setForeground(Color.gray);
       
        //Ventanas con bordes redondeados 
        @SuppressWarnings("OverridableMethodCallInConstructor")
        Shape forma = new RoundRectangle2D.Double(0, 0, this.getBounds().width, this.getBounds().height, 15,15);
        AWTUtilities.setWindowShape(this,forma);
        
        //Icono de las ventanas.
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagenes/Neptune.png"));
        setIconImage(icon); 
        }
    
        char[] textComplete = new char[27]; //Arreglo donde se guardará el cripto.
        String abc = ""; //Cadena donde se guardará el alfabeto.
        //A través de este método se determina el tipo de alfabeto.
        String alphabet(){
            String cadena1,cadena2;
            String letter = txtLetter.getText();//Obtenemos la letra inicial.
            
        //Si el albafeto es ordenado y empieza por una letra en específico.
            if (rdoOrdenado.isSelected() && rdoLetter.isSelected()) {
            abc = "abcdefghijklmnñopqrstuvwxyz";
             for (int i = 0; i < abc.length(); i++) {
                if (letter.equals(Character.toString(abc.charAt(i)))) {
                    cadena1 = abc.substring(i, abc.length());
                    cadena2 = abc.substring(0, i);
                    abc = cadena1.concat(cadena2);
                }
              }            
            } //Si el albafeto es inverso y empieza por una letra en específico.
          else if (rdoInverso.isSelected() && rdoLetter.isSelected()) {
            abc = "zyxwvutsrqpoñnmlkjihgfedcba";
            for (int j = 0; j < abc.length(); j++) {
                if (letter.equals(Character.toString(abc.charAt(j)))) {
                    cadena1 = abc.substring(j, abc.length());
                    cadena2 = abc.substring(0, j);
                    abc = cadena1.concat(cadena2);
                  }
               }
            }//Si solo se elige un alfabeto ordenado.
          else if (rdoOrdenado.isSelected()) {
                   abc = "abcdefghijklmnñopqrstuvwxyz";
           }//Si solo se elige un alfabeto inverso.
           else {
                   abc = "zyxwvutsrqpoñnmlkjihgfedcba";
                }
            txtLlano.setText(abc);
            return abc;
        
    }
               
        String randomJumps(String abc,int sDer){
            int cont=0;
            String nAlf="";
            for(int i=0;i<abc.length();i++){
                if(nAlf.length()== 27 ){
                    i=28;
                    continue;
                }
                if(abc.charAt(i) != ' '){
                   cont++;
                } 
                if(cont == sDer){
                    nAlf += abc.charAt(i);
                    abc = abc.replace(abc.charAt(i),' ');
                    cont=0;
                }
                if(i==(abc.length()-1)){
                    i=-1;
                }
            }
            return nAlf;
        }

        //Obtenemos la palabra clave y la ingresa a un arreglo.
    char[] getKeyWord() {
           String keyWord = txtKeyWord.getText().trim();
           char[] kwInArray = keyWord.toCharArray();
         return kwInArray;
        }
    //Borrar letras repetidas de la plabra clave. 
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
    //Borrar espacios vacios de la palabra clave.
    char[] deleteSpaces(char[] keyWord) {
        
        String cadena = "";
        //Convertir la palabra clave en cadena.
        for (int i = 0; i < keyWord.length; i++) {
            cadena += Character.toString(keyWord[i]);
        }
        //Eliminamos los espacios vacios.
        for (int i = 0; i < cadena.length(); i++) {
            cadena = cadena.replace(" ", "");             
        }
        //La palabra clave limpia(sin espacios en blanco) es ingresada a un arreglo.
        char[] keyWordFinal = cadena.toCharArray();
        
       return keyWordFinal;        
    }
   
    //Completar crpto con las letras faltantes.
    void completarArray(char[] keyWord, String abc) {
        //System.arraycopy(aCharac, 0, textComplete, 0, aCharac.length);
            txtCripto.setText("");//Si se genera un nuevo cripto, el anterior es reemplazado.   
        //Reemplaza las repeticiones por espacios vacios en el alfabeto(abc) comparandolo con la palabra clave(keyWord).
            for (int i = 0; i < keyWord.length; i++) {
                for (int j = 0; j < abc.length(); j++) {
                    if (keyWord[i] == abc.charAt(j)) {
                        abc = abc.replace(abc.charAt(j), ' ');
                    }
                }
            }
        //Eliminamos los espacios en vacios del alfabeto 
        char[] abcDE = deleteSpaces(abc.toCharArray());
        
        String crypt; //Cadena donde se almacenará el cripto.
        String strOne = "", strTwo = "";//Cadenas donde se almacenará la palabra clave y el alfabeto limpio(sin repeticiones ni espacios)
        
        //Convertimos el alfabeto limpio en un cadena.
        for (int i = 0; i < keyWord.length; i++) {
            strOne += Character.toString(keyWord[i]);
        }
        //Convertimos la palabra clave en un cadena.
        for (int r = 0; r < abcDE.length; r++) {
            strOne += Character.toString(abcDE[r]);
        }
        //Concatenamos la palabra clave con el alfabeto limpio (sin repeticiones ni espacios).
        crypt = strOne.concat(strTwo);
        txtCripto.setText(crypt);
        textComplete = crypt.toCharArray();
        System.out.println(crypt.length());
        }
    
    

    /*----------------------------------------------------------------------------------------------------------------*/
    /*-------------------------------------------------PROCESO DE CIFRADO---------------------------------------------*/
    
    //Conversión de números y caracteres en cadenas
    String Conversion(String msj){
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
               case '-':
                   cadA= msj.substring(0,i);
                   cadB= msj.substring(i+1,msj.length());
                   msj = cadA.concat("guion"+cadB); break;
    
           }
        }
        return msj;  
    }
    //Obtenemos el mensaje a encriptar.
    String getMessage() {
        String message = txtToEncrypt.getText();
       return message; 
    }
    
    char[] putCriptoInArray() {
        return txtLlano.getText().toCharArray();
    }
    
    String encrypt(char[] mensaje, char[] cripto, char[] llano) {
        String msgEncrypted="";
        for (int i = 0; i < mensaje.length; i++) {            
            for (int j = 0; j < llano.length; j++) {
                //Comprobando si es una letra mayúscula.
                if(Character.isUpperCase(mensaje[i])){
                    //Comprobando si son iguales.
                    if(Character.toString(mensaje[i]).equalsIgnoreCase(Character.toString(llano[j]))){
                        mensaje[i] = Character.toUpperCase(cripto[j]);
                        j = j + (llano.length - j);
                    }
                 //Al no cumplirse la primera condición solo comprobamos si son iguales.   
                }else if (mensaje[i] == llano[j]) {
                    mensaje[i] = cripto[j];
                        //Llevamos el contador al limite para hacer pase a la siguiente letra.                    
                    j = j + (llano.length - j);                    
                }
            }            
        }        
        for (int k = 0; k < mensaje.length; k++) {
            msgEncrypted += Character.toString(mensaje[k]);
        }
       return msgEncrypted;
    }
    
    //Obtenemos el mensaje cifrado.
    char[] getEncripted() {
        return txtToDecrypt.getText().toCharArray();
    }
    //Método para descifrar el mensaje.
    String decrypt(char[] message, char[] cripto, char[] abc) {
        
        String msgDecrypted="";
        for (int i = 0; i < message.length; i++) {
            for (int j = 0; j < cripto.length; j++) {
                //Comprueba si es una letra mayúscula.
                if(Character.isUpperCase(message[i])){
                    //Verifica si son iguales.
                    if (Character.toString(message[i]).equalsIgnoreCase(Character.toString(cripto[j]))){
                        //Si son iguales, se reemplaza el caracter del mensaje por su correspondiente en el cripto pero en mayúscula.
                        message[i] = Character.toUpperCase(abc[j]);
                    j = j + (cripto.length - j);
                    }
                    //Si no se cumple la condición anterior solo verifica si son iguales.
                }else if(message[i] == cripto[j]){
                        message[i] = abc[j];
                        //Llevamos el contador al limite para hacer pase a la siguiente letra.
                        j = j + (cripto.length - j);
                }  
            }
        }
        for (int k = 0; k < message.length; k++) {
            msgDecrypted += Character.toString(message[k]);
        }
        return msgDecrypted;
    }
    //Método para guardar el mensaje cifrado.
    void grabarEncrypted(){
            FileDialog da;
            da = new FileDialog(this,"Guardar como",FileDialog.SAVE);
            da.show();
            String file,directory;
            file = da.getFile()+".txt"; 
            directory = da.getDirectory();
            
        try(PrintWriter pw = new PrintWriter( new FileWriter(directory+file))) {
            
            pw.println(txtEncrypted.getText().trim());
            JOptionPane.showMessageDialog(null, "Mensaje Guardado");
        }catch(Exception e){
            
        }
    }
    void grabarDecrypted(){
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
        txtLetter = new javax.swing.JTextField();
        rdoLetter = new javax.swing.JRadioButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtDerecha = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        btnEnviar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        btnDecrypt = new javax.swing.JButton();
        btnCleanDecrypt = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtToDecrypt = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        txtDecoded = new javax.swing.JTextArea();
        btnSaveDecrypted = new javax.swing.JButton();
        btnCleanDecrypted = new javax.swing.JButton();
        btnVolverP = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        pnlCerrar = new javax.swing.JPanel();
        btnCerrar = new javax.swing.JButton();
        pnlMin = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        btnMinimizar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        btnEncrypt = new javax.swing.JButton();
        btnCleanEncrypt = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtEncrypted = new javax.swing.JTextArea();
        btnSendToDecrypt = new javax.swing.JButton();
        btnSaveEncrypted = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        txtToEncrypt = new javax.swing.JTextArea();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        lblVolver = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtCripto = new javax.swing.JTextField();
        txtLlano = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Personalizar");
        setBackground(new java.awt.Color(35, 86, 104));
        setName("Personalizar"); // NOI18N
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(7, 64, 77));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 75, 91));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 13)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Ingrese la palabra clave");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 150, 30));

        txtKeyWord.setBackground(new java.awt.Color(7, 64, 77));
        txtKeyWord.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 13)); // NOI18N
        txtKeyWord.setForeground(new java.awt.Color(204, 204, 204));
        txtKeyWord.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtKeyWord.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 51)));
        txtKeyWord.setCaretColor(new java.awt.Color(0, 204, 255));
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
        jPanel1.add(txtKeyWord, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 380, 34));

        jLabel5.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Seleccionar tipo de alfabeto");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 117, -1, 30));

        rdoOrdenado.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 11)); // NOI18N
        rdoOrdenado.setForeground(new java.awt.Color(255, 255, 255));
        rdoOrdenado.setText("Ordenado");
        rdoOrdenado.setContentAreaFilled(false);
        rdoOrdenado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoOrdenadoActionPerformed(evt);
            }
        });
        jPanel1.add(rdoOrdenado, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 120, 80, -1));

        rdoInverso.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 11)); // NOI18N
        rdoInverso.setForeground(new java.awt.Color(255, 255, 255));
        rdoInverso.setText("Inverso");
        rdoInverso.setContentAreaFilled(false);
        rdoInverso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoInversoActionPerformed(evt);
            }
        });
        jPanel1.add(rdoInverso, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 120, 80, -1));

        txtLetter.setBackground(new java.awt.Color(7, 64, 77));
        txtLetter.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 13)); // NOI18N
        txtLetter.setForeground(new java.awt.Color(204, 204, 204));
        txtLetter.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtLetter.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 51)));
        txtLetter.setCaretColor(new java.awt.Color(0, 204, 255));
        jPanel1.add(txtLetter, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 30, 50, 30));

        rdoLetter.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 12)); // NOI18N
        rdoLetter.setForeground(new java.awt.Color(255, 255, 255));
        rdoLetter.setText("Letra inicial para el alfabeto y llano (opcional)");
        rdoLetter.setContentAreaFilled(false);
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
        jPanel1.add(rdoLetter, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 30, -1, 30));
        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(423, 210, 230, 150));

        txtDerecha.setBackground(new java.awt.Color(7, 64, 77));
        txtDerecha.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 13)); // NOI18N
        txtDerecha.setForeground(new java.awt.Color(255, 255, 255));
        txtDerecha.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtDerecha.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 51)));
        txtDerecha.setCaretColor(new java.awt.Color(0, 204, 255));
        txtDerecha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDerechaKeyTyped(evt);
            }
        });
        jPanel1.add(txtDerecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 70, 50, 30));

        jLabel14.setFont(new java.awt.Font("Microsoft JhengHei", 2, 11)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("*Solo minusculas");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 90, 30));

        jLabel12.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Número de saltos a la derecha (obligatorio)");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 70, 260, 30));

        btnEnviar.setBackground(new java.awt.Color(0, 51, 51));
        btnEnviar.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 11)); // NOI18N
        btnEnviar.setForeground(new java.awt.Color(255, 255, 255));
        btnEnviar.setText("Generar cripto");
        btnEnviar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(10, 121, 143)));
        btnEnviar.setContentAreaFilled(false);
        btnEnviar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEnviarMouseEntered(evt);
            }
        });
        btnEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEnviar, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 150, 110, 30));

        btnLimpiar.setBackground(new java.awt.Color(0, 51, 51));
        btnLimpiar.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 11)); // NOI18N
        btnLimpiar.setForeground(new java.awt.Color(255, 255, 255));
        btnLimpiar.setText("Limpiar campos");
        btnLimpiar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(10, 121, 143)));
        btnLimpiar.setContentAreaFilled(false);
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });
        jPanel1.add(btnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 150, 110, 30));

        jPanel4.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, 970, 200));

        jPanel3.setBackground(new java.awt.Color(0, 75, 91));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 13)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Ingrese el mensaje que desea descifrar");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 230, 30));

        btnDecrypt.setBackground(new java.awt.Color(0, 51, 51));
        btnDecrypt.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 11)); // NOI18N
        btnDecrypt.setForeground(new java.awt.Color(255, 255, 255));
        btnDecrypt.setText("Descifrar");
        btnDecrypt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(10, 121, 143)));
        btnDecrypt.setContentAreaFilled(false);
        btnDecrypt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDecryptActionPerformed(evt);
            }
        });
        jPanel3.add(btnDecrypt, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 150, 130, 30));

        btnCleanDecrypt.setBackground(new java.awt.Color(0, 51, 51));
        btnCleanDecrypt.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 11)); // NOI18N
        btnCleanDecrypt.setForeground(new java.awt.Color(255, 255, 255));
        btnCleanDecrypt.setText("Limpiar");
        btnCleanDecrypt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(10, 121, 143)));
        btnCleanDecrypt.setContentAreaFilled(false);
        btnCleanDecrypt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCleanDecryptActionPerformed(evt);
            }
        });
        jPanel3.add(btnCleanDecrypt, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 150, 107, 30));

        txtToDecrypt.setBackground(new java.awt.Color(7, 64, 77));
        txtToDecrypt.setColumns(20);
        txtToDecrypt.setForeground(new java.awt.Color(204, 204, 204));
        txtToDecrypt.setRows(5);
        txtToDecrypt.setCaretColor(new java.awt.Color(0, 204, 255));
        txtToDecrypt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtToDecryptKeyReleased(evt);
            }
        });
        jScrollPane4.setViewportView(txtToDecrypt);

        jPanel3.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 430, 100));

        jLabel8.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 13)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Este es su mensaje descifrado");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 180, 30));

        txtDecoded.setBackground(new java.awt.Color(7, 64, 77));
        txtDecoded.setColumns(20);
        txtDecoded.setForeground(new java.awt.Color(204, 204, 204));
        txtDecoded.setRows(5);
        txtDecoded.setCaretColor(new java.awt.Color(0, 204, 204));
        txtDecoded.setEnabled(false);
        jScrollPane5.setViewportView(txtDecoded);

        jPanel3.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 426, 100));

        btnSaveDecrypted.setBackground(new java.awt.Color(0, 51, 51));
        btnSaveDecrypted.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 11)); // NOI18N
        btnSaveDecrypted.setForeground(new java.awt.Color(255, 255, 255));
        btnSaveDecrypted.setText("Guardar mensaje");
        btnSaveDecrypted.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(10, 121, 143)));
        btnSaveDecrypted.setContentAreaFilled(false);
        btnSaveDecrypted.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveDecryptedActionPerformed(evt);
            }
        });
        jPanel3.add(btnSaveDecrypted, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 320, 130, 30));

        btnCleanDecrypted.setBackground(new java.awt.Color(0, 51, 51));
        btnCleanDecrypted.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 11)); // NOI18N
        btnCleanDecrypted.setForeground(new java.awt.Color(255, 255, 255));
        btnCleanDecrypted.setText("Limpiar");
        btnCleanDecrypted.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(10, 121, 143)));
        btnCleanDecrypted.setContentAreaFilled(false);
        btnCleanDecrypted.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCleanDecryptedActionPerformed(evt);
            }
        });
        jPanel3.add(btnCleanDecrypted, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 320, 100, 30));

        jPanel4.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 380, 480, 370));

        btnVolverP.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 11)); // NOI18N
        btnVolverP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/1499157285_Left_arrow.png"))); // NOI18N
        btnVolverP.setContentAreaFilled(false);
        btnVolverP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnVolverPMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnVolverPMouseExited(evt);
            }
        });
        btnVolverP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverPActionPerformed(evt);
            }
        });
        jPanel4.add(btnVolverP, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 50, 30));

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
        jLabel9.setText("PERSONALIZAR");
        jPanel5.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 10, 80, 16));

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
        btnCerrar.setFont(new java.awt.Font("Microsoft JhengHei", 1, 16)); // NOI18N
        btnCerrar.setForeground(new java.awt.Color(255, 255, 255));
        btnCerrar.setText("X");
        btnCerrar.setToolTipText("Cerrar");
        btnCerrar.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 39, 60), 0, true));
        btnCerrar.setName(""); // NOI18N
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

        jPanel5.add(pnlCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 0, 50, 30));

        pnlMin.setBackground(new java.awt.Color(204, 204, 204));
        pnlMin.setLayout(null);

        jPanel6.setBackground(new java.awt.Color(204, 204, 204));
        jPanel6.setLayout(null);
        pnlMin.add(jPanel6);
        jPanel6.setBounds(660, 0, 50, 30);

        btnMinimizar.setBackground(new java.awt.Color(12, 23, 30));
        btnMinimizar.setFont(new java.awt.Font("Microsoft JhengHei", 0, 36)); // NOI18N
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

        jPanel5.add(pnlMin, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 0, 50, 30));

        jPanel4.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1210, 30));

        jLabel2.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Llano");
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 260, 50, 30));

        jPanel2.setBackground(new java.awt.Color(0, 75, 91));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 13)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Ingrese el mensaje que desea cifrar");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 220, 30));

        btnEncrypt.setBackground(new java.awt.Color(0, 51, 51));
        btnEncrypt.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 11)); // NOI18N
        btnEncrypt.setForeground(new java.awt.Color(255, 255, 255));
        btnEncrypt.setText("Cifrar");
        btnEncrypt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(10, 121, 143)));
        btnEncrypt.setContentAreaFilled(false);
        btnEncrypt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEncryptActionPerformed(evt);
            }
        });
        jPanel2.add(btnEncrypt, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 150, 113, 30));

        btnCleanEncrypt.setBackground(new java.awt.Color(0, 51, 51));
        btnCleanEncrypt.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 11)); // NOI18N
        btnCleanEncrypt.setForeground(new java.awt.Color(255, 255, 255));
        btnCleanEncrypt.setText("Limpiar Mensaje");
        btnCleanEncrypt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(10, 121, 143)));
        btnCleanEncrypt.setContentAreaFilled(false);
        btnCleanEncrypt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCleanEncryptActionPerformed(evt);
            }
        });
        jPanel2.add(btnCleanEncrypt, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 150, 130, 30));

        jLabel4.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 13)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Este es su mensaje cifrado");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 160, 30));

        txtEncrypted.setBackground(new java.awt.Color(7, 64, 77));
        txtEncrypted.setColumns(20);
        txtEncrypted.setForeground(new java.awt.Color(204, 204, 204));
        txtEncrypted.setRows(5);
        txtEncrypted.setCaretColor(new java.awt.Color(0, 204, 204));
        txtEncrypted.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtEncryptedKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(txtEncrypted);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 440, 100));

        btnSendToDecrypt.setBackground(new java.awt.Color(0, 51, 51));
        btnSendToDecrypt.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 11)); // NOI18N
        btnSendToDecrypt.setForeground(new java.awt.Color(255, 255, 255));
        btnSendToDecrypt.setText("Enviar a Descifrar");
        btnSendToDecrypt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(10, 121, 143)));
        btnSendToDecrypt.setContentAreaFilled(false);
        btnSendToDecrypt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendToDecryptActionPerformed(evt);
            }
        });
        jPanel2.add(btnSendToDecrypt, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 320, 130, 30));

        btnSaveEncrypted.setBackground(new java.awt.Color(0, 51, 51));
        btnSaveEncrypted.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 11)); // NOI18N
        btnSaveEncrypted.setForeground(new java.awt.Color(255, 255, 255));
        btnSaveEncrypted.setText("Guardar texto");
        btnSaveEncrypted.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(10, 121, 143)));
        btnSaveEncrypted.setContentAreaFilled(false);
        btnSaveEncrypted.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveEncryptedActionPerformed(evt);
            }
        });
        jPanel2.add(btnSaveEncrypted, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 320, 120, 30));

        txtToEncrypt.setBackground(new java.awt.Color(7, 64, 77));
        txtToEncrypt.setColumns(20);
        txtToEncrypt.setForeground(new java.awt.Color(204, 204, 204));
        txtToEncrypt.setRows(5);
        txtToEncrypt.setBorder(null);
        txtToEncrypt.setCaretColor(new java.awt.Color(0, 204, 255));
        txtToEncrypt.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtToEncrypt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtToEncryptKeyReleased(evt);
            }
        });
        jScrollPane6.setViewportView(txtToEncrypt);

        jPanel2.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 440, 100));

        jLabel10.setText("jLabel10");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, -220, -1, -1));

        jPanel4.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 380, 490, 370));

        jLabel11.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("DESCIFRAR");
        jPanel4.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 340, 80, 30));

        jSeparator2.setOpaque(true);
        jPanel4.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 322, 1080, 0));

        lblVolver.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 13)); // NOI18N
        lblVolver.setForeground(new java.awt.Color(204, 204, 204));
        lblVolver.setText("Volver");
        lblVolver.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblVolverMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblVolverMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblVolverMouseExited(evt);
            }
        });
        jPanel4.add(lblVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 40, 30));

        jLabel13.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("CIFRAR");
        jPanel4.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 340, 50, 30));

        jLabel16.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Cripto");
        jPanel4.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 260, 50, 30));

        txtCripto.setBackground(new java.awt.Color(0, 75, 91));
        txtCripto.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 13)); // NOI18N
        txtCripto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 51)));
        jPanel4.add(txtCripto, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 260, 370, 30));

        txtLlano.setBackground(new java.awt.Color(0, 75, 91));
        txtLlano.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 13)); // NOI18N
        txtLlano.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 51)));
        jPanel4.add(txtLlano, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 260, 420, 30));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1210, 780));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarActionPerformed
        txtCripto.setText("");
        char[] keyWordInArray = getKeyWord();//Obtenemos la palabra clave para ponerla en un arreglo.   
        char[] finalText = deleteRepeted(keyWordInArray);//Se eliminan las letras repetidas de la palabra clave.
        char[] keyWord = deleteSpaces(finalText);//Se eliminan los espacios vacios de la palabra clave.
        String abc = alphabet();//La estructura del alfabeto se almacena en la variable abc.
        String nAlf = randomJumps(abc, Integer.parseInt(txtDerecha.getText()));//Aplicamos saltos al alfabeto.
        completarArray(keyWord, nAlf); //Generamos el cripto.

 
    }//GEN-LAST:event_btnEnviarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        txtLlano.setText("");
        txtToEncrypt.setText("");
        txtKeyWord.setText("");
        txtLetter.setText("");
        txtKeyWord.requestFocus();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnEncryptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEncryptActionPerformed
        txtEncrypted.setText("");
        String message = getMessage();
        char[] msgInArray = Conversion(message).toCharArray();
        char[] cripto = putCriptoInArray();
        char[] abc = alphabet().toCharArray();

        String encrypted = encrypt(msgInArray, cripto, abc);
        txtEncrypted.setText(encrypted);
        
        
        
        
        
        
        
        btnSendToDecrypt.setEnabled(true);
        btnSendToDecrypt.setForeground(Color.white);
        btnSaveEncrypted.setEnabled(true);
        btnSaveEncrypted.setForeground(Color.white);
    }//GEN-LAST:event_btnEncryptActionPerformed

    private void rdoOrdenadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoOrdenadoActionPerformed
        rdoInverso.setSelected(false);
    }//GEN-LAST:event_rdoOrdenadoActionPerformed

    private void rdoInversoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoInversoActionPerformed
        rdoOrdenado.setSelected(false);
    }//GEN-LAST:event_rdoInversoActionPerformed

    private void btnDecryptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDecryptActionPerformed
        txtDecoded.setText("");
        char[] message = getEncripted();
        char[] cripto = putCriptoInArray();
        char[] abc = alphabet().toCharArray();
        
        String msgDecoded = decrypt(message, cripto, abc);
        txtDecoded.setText(msgDecoded);
        
        btnSaveDecrypted.setEnabled(true);
        btnSaveDecrypted.setForeground(Color.white);
        btnCleanDecrypted.setEnabled(true);
        btnCleanDecrypted.setForeground(Color.white);
    }//GEN-LAST:event_btnDecryptActionPerformed

    private void btnCleanDecryptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCleanDecryptActionPerformed
        txtToDecrypt.setText("");
        txtToDecrypt.requestFocus();
        btnDecrypt.setEnabled(false);
        btnDecrypt.setForeground(Color.gray);
        btnCleanDecrypt.setEnabled(false);
        btnCleanDecrypt.setForeground(Color.gray);
        
        btnSaveDecrypted.setEnabled(true);
        btnSaveDecrypted.setForeground(Color.white);
        
        btnCleanDecrypted.setEnabled(true);
        btnCleanDecrypted.setForeground(Color.white);
    }//GEN-LAST:event_btnCleanDecryptActionPerformed

    private void rdoLetterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoLetterActionPerformed
        if(rdoLetter.isSelected()){
            txtLetter.setEnabled(true);
        }else{
            txtLetter.setEnabled(false);
        }

    }//GEN-LAST:event_rdoLetterActionPerformed

    private void txtKeyWordKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtKeyWordKeyTyped
        char letra = evt.getKeyChar();
        if((letra < 'a' || letra > 'z') && (letra != '\b') && (letra !=(char)KeyEvent.VK_SPACE)){
        evt.consume();
        JOptionPane.showMessageDialog(rootPane, "Solo se admiten letras en minúsculas");
    }
        
    }//GEN-LAST:event_txtKeyWordKeyTyped

    private void txtKeyWordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtKeyWordKeyReleased
        btnEnviar.setEnabled(true);
        btnEnviar.setForeground(Color.white);
        btnLimpiar.setEnabled(true);
        btnLimpiar.setForeground(Color.white);
        int longitud = txtKeyWord.getText().length();
        if (longitud == 0) {
            btnEnviar.setEnabled(false);
            btnEnviar.setForeground(Color.gray);
            btnLimpiar.setEnabled(false);
            btnLimpiar.setForeground(Color.gray);
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
        btnDecrypt.setForeground(Color.white);
        btnCleanDecrypt.setEnabled(true);
        btnCleanDecrypt.setForeground(Color.white);
        
        
    }//GEN-LAST:event_btnSendToDecryptActionPerformed

    private void btnSaveEncryptedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveEncryptedActionPerformed
        grabarEncrypted();
    }//GEN-LAST:event_btnSaveEncryptedActionPerformed

    private void btnSaveDecryptedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveDecryptedActionPerformed
        grabarDecrypted();
    }//GEN-LAST:event_btnSaveDecryptedActionPerformed

    private void btnCleanDecryptedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCleanDecryptedActionPerformed
        txtDecoded.setText("");
        btnSaveDecrypted.setEnabled(false);
        btnSaveDecrypted.setForeground(Color.gray);
        btnCleanDecrypted.setEnabled(false);
        btnCleanDecrypted.setForeground(Color.gray);
    }//GEN-LAST:event_btnCleanDecryptedActionPerformed

    private void txtToEncryptKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtToEncryptKeyReleased
        btnEncrypt.setEnabled(true);
        btnEncrypt.setForeground(Color.white);
        btnCleanEncrypt.setEnabled(true);
        btnCleanEncrypt.setForeground(Color.white);
        int longitud = txtToEncrypt.getText().length();
        if (longitud == 0) {
            btnEncrypt.setEnabled(false);
            btnEncrypt.setForeground(Color.gray);
            btnCleanEncrypt.setEnabled(false);
            btnCleanEncrypt.setForeground(Color.gray);
        }
    }//GEN-LAST:event_txtToEncryptKeyReleased

    private void txtToDecryptKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtToDecryptKeyReleased
        btnEnviar.setEnabled(true);
        int longitud = txtToDecrypt.getText().length();
        if (longitud == 0) {
            btnDecrypt.setEnabled(false);
            btnDecrypt.setForeground(Color.gray);
            btnCleanDecrypt.setEnabled(false);
            btnCleanDecrypt.setForeground(Color.gray);
        }
    }//GEN-LAST:event_txtToDecryptKeyReleased

    private void btnCleanEncryptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCleanEncryptActionPerformed
        txtToEncrypt.setText("");
        txtEncrypted.setText("");
        txtToEncrypt.requestFocus();
        btnSaveEncrypted.setEnabled(false);
        btnSaveEncrypted.setForeground(Color.gray);
        btnSendToDecrypt.setForeground(Color.gray);
        btnEncrypt.setEnabled(false);
        btnEncrypt.setForeground(Color.gray);
        btnCleanEncrypt.setEnabled(false);
        btnCleanEncrypt.setForeground(Color.gray);
    }//GEN-LAST:event_btnCleanEncryptActionPerformed

    private void txtEncryptedKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEncryptedKeyReleased
       btnEnviar.setEnabled(true);
       btnEnviar.setForeground(Color.white);
       btnSaveEncrypted.setEnabled(true);
       btnSaveEncrypted.setForeground(Color.white);
       
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

    private void txtDerechaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDerechaKeyTyped
        char num = evt.getKeyChar();
        if((num < '0' || num > '9') && (num != '\b')) {
        evt.consume();
        JOptionPane.showMessageDialog(rootPane, "Solo se admite datos numéricos");
        } 
    }//GEN-LAST:event_txtDerechaKeyTyped

    private void lblVolverMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblVolverMouseClicked
        Principal prin = new Principal();
        prin.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblVolverMouseClicked

    private void btnVolverPMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVolverPMouseEntered
        lblVolver.setForeground(Color.white);
    }//GEN-LAST:event_btnVolverPMouseEntered

    private void btnVolverPMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVolverPMouseExited
        lblVolver.setForeground(Color.gray);
    }//GEN-LAST:event_btnVolverPMouseExited

    private void lblVolverMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblVolverMouseEntered
        lblVolver.setForeground(Color.white);
    }//GEN-LAST:event_lblVolverMouseEntered

    private void lblVolverMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblVolverMouseExited
        lblVolver.setForeground(Color.gray);
    }//GEN-LAST:event_lblVolverMouseExited

    private void btnEnviarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEnviarMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEnviarMouseEntered

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
    private javax.swing.JButton btnSaveDecrypted;
    private javax.swing.JButton btnSaveEncrypted;
    private javax.swing.JButton btnSendToDecrypt;
    private javax.swing.JButton btnVolverP;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
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
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblVolver;
    private javax.swing.JPanel pnlCerrar;
    private javax.swing.JPanel pnlMin;
    private javax.swing.JRadioButton rdoInverso;
    private javax.swing.JRadioButton rdoLetter;
    private javax.swing.JRadioButton rdoOrdenado;
    private javax.swing.JTextField txtCripto;
    private javax.swing.JTextArea txtDecoded;
    private javax.swing.JTextField txtDerecha;
    private javax.swing.JTextArea txtEncrypted;
    private javax.swing.JTextField txtKeyWord;
    private javax.swing.JTextField txtLetter;
    private javax.swing.JTextField txtLlano;
    private javax.swing.JTextArea txtToDecrypt;
    private javax.swing.JTextArea txtToEncrypt;
    // End of variables declaration//GEN-END:variables
}
