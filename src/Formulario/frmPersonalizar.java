
package Formulario;

import dialogos.dlgValidaValorSaltos;
import dialogos.dlgSoloLetrasKW;
import dialogos.dlgSaltosNoIngresado;
import dialogos.dlgNoCriptoLlano;
import com.sun.awt.AWTUtilities;
import dialogos.dlgCantLetras;
import dialogos.dlgNoKW;
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
    
    @SuppressWarnings("OverridableMethodCallInConstructor")
    public frmPersonalizar() {
        
        initComponents();
        
        txtKeyWord.requestFocus();//El campo para la palabra clave está seleccionada por defecto       
        txtLlano.setEditable(false);//Deshabilitar la edición del cripto
        txtCoded.setEditable(false);//Deshabilitar la edición del mensaje cifrado
        txtLetter.setEnabled(true);//Esta deshabilitado por defecto. Se activa si se selecciona su boton asociado.(rdoLetter) 
        txtLetter.setEditable(false);
        txtLetter.setBackground(new Color(7,64,77));

        //Deshabilitar botones al iniciar
        btnGenerarCripto.setEnabled(false);
        btnGenerarCripto.setForeground(Color.gray);
        
        btnLimpiar.setEnabled(false);
        btnLimpiar.setForeground(Color.gray);
        
        btnCleanEncoded.setEnabled(false);
        btnCleanEncoded.setForeground(Color.gray);
        
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
        
        btnCleanEncrypt.setEnabled(false);
        btnCleanEncrypt.setForeground(Color.gray);
        
        //Efectos con los paneles
         pnlGenerarCripto.setBackground(null);
         pnlLimpiarCampos.setBackground(null);
         pnlCleanDecoded.setBackground(null);
         pnlCleanEncode.setBackground(null);
         pnlCleanEncoded.setBackground(null);
         pnlCleanDecode.setBackground(null);
         pnlDecode.setBackground(null);
         pnlEncode.setBackground(null);
         pnlSendToDecode.setBackground(null);
         
        
        rdoOrdenado.setSelected(true);//Por defecto se usa el alfabeto ordenado
        rdoLetter.setForeground(Color.gray);
        lbl1.setForeground(Color.gray);
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
            String letter = txtLetter.getText().toLowerCase();//Obtenemos la letra inicial.
            
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
           String keyWord = txtKeyWord.getText().trim().toLowerCase();
           System.out.println(keyWord);
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

    String getJumps(){
        return txtDerecha.getText();
    }

    String valida(){
        if(getJumps().equals(" ")){
            txtDerecha.requestFocus();
            return "Número de Saltos";
        }if(txtKeyWord.getText().equals("")){
            return "Palabra clave";
        }
            return " ";
        
    }
    /*----------------------------------------------------------------------------------------------------------------*/
    /*-------------------------------------------------PROCESO DE CIFRADO---------------------------------------------*/
    
    //Conversión de números y caracteres en cadenas
    String Conversion(String message){
        for(int i=0;i<message.length();i++){
            String cadA;
            String cadB;
           switch(message.charAt(i)){
               case '0':
                   cadA= message.substring(0,i);
                   cadB= message.substring(i+1,message.length());
                   message = cadA.concat("cero"+cadB); break; 
               case '1': 
                   cadA= message.substring(0,i);
                   cadB= message.substring(i+1,message.length());
                   message = cadA.concat("uno"+cadB); break; 
               case '2':
                   cadA= message.substring(0,i);
                   cadB= message.substring(i+1,message.length());
                   message = cadA.concat("dos"+cadB); break; 
               case '3':
                   cadA= message.substring(0,i);
                   cadB= message.substring(i+1,message.length());
                   message = cadA.concat("tres"+cadB); break; 
               case '4':
                   cadA= message.substring(0,i);
                   cadB= message.substring(i+1,message.length());
                   message = cadA.concat("cuatro"+cadB); break; 
               case '5':
                   cadA= message.substring(0,i);
                   cadB= message.substring(i+1,message.length());
                   message = cadA.concat("cinco"+cadB); break; 
               case '6':
                   cadA= message.substring(0,i);
                   cadB= message.substring(i+1,message.length());
                   message = cadA.concat("seis"+cadB); break; 
               case '7':
                   cadA= message.substring(0,i);
                   cadB= message.substring(i+1,message.length());
                   message = cadA.concat("siete"+cadB); break; 
               case '8':
                   cadA= message.substring(0,i);
                   cadB= message.substring(i+1,message.length());
                   message = cadA.concat("ocho"+cadB); break; 
               case '9':
                   cadA= message.substring(0,i);
                   cadB= message.substring(i+1,message.length());
                   message = cadA.concat("nueve"+cadB); break;
               case '@':
                   cadA= message.substring(0,i);
                   cadB= message.substring(i+1,message.length());
                   message = cadA.concat("arroba"+cadB); break;
               case '.':
                   cadA= message.substring(0,i);
                   cadB= message.substring(i+1,message.length());
                   message = cadA.concat("punto"+cadB); break;
               case ',':
                   cadA= message.substring(0,i);
                   cadB= message.substring(i+1,message.length());
                   message = cadA.concat("coma"+cadB); break;
               case ';':
                   cadA= message.substring(0,i);
                   cadB= message.substring(i+1,message.length());
                   message = cadA.concat("punto y coma"+cadB); break;
               case '-':
                   cadA= message.substring(0,i);
                   cadB= message.substring(i+1,message.length());
                   message = cadA.concat("guion"+cadB); break;
               case ':':
                   cadA= message.substring(0,i);
                   cadB= message.substring(i+1,message.length());
                   message = cadA.concat("dospuntos"+cadB); break;
    
           }
        }
        return message;  
    }
    
    //Obtenemos el mensaje a encriptar.
    String getMessage() {
        String message = txtToEncode.getText();
       return message; 
    }
    
    char[] putCriptoInArray() {
        return txtCripto.getText().toCharArray();
    }
    
   /* String encrypt(char[] mensaje, char[] cripto, char[] llano) {
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
    }*/
   String encrypt(char[] mensaje, char[] cripto, char[] abc) {
        String msgEncrypted="";
        for (int i = 0; i < abc.length; i++) {            
            for (int j = 0; j < cripto.length; j++) {
                     if(abc[i] == 'a' && cripto[j] == 't'){
                        int pos = j;    
                         for(int m = 0; m<mensaje.length;m++ ){
                             for (int a = 0;a<abc.length;a++){
                                 if(pos>=cripto.length){
                                         pos=0;
                                  }if(Character.isUpperCase(mensaje[m])){
                                      if((Character.toString(mensaje[m]).equalsIgnoreCase(Character.toString(abc[a])) && ((a+pos)>=cripto.length))){
                                           mensaje[m] = Character.toUpperCase(cripto[(a+pos)-cripto.length]);
                                           pos++;
                                           a=30;
                                      }else if((Character.toString(mensaje[m]).equalsIgnoreCase(Character.toString(abc[a])) && ((a+pos) < cripto.length))){
                                           mensaje[m] = Character.toUpperCase(cripto[a+pos]);
                                           pos++;
                                           a=30;
                                      }
                                  }else if(mensaje[m] == abc[a] && (a+pos)>=cripto.length){
                                     mensaje[m] = cripto[(a+pos)-cripto.length];
                                     pos++;
                                     a=30;
                                 }else if(mensaje[m] == abc[a] && (a+pos)< cripto.length){
                                     mensaje[m] = cripto[a+pos];
                                     pos++;
                                     a=30;
                                 }
                             }
                         }   
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
        return txtToDecode.getText().toCharArray();
    }
    //Método para descifrar el mensaje.
    /*String decrypt(char[] message, char[] cripto, char[] abc) {
        
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
    }*/
    
    String decrypt(char[] message, char[] cripto, char[] abc) {
        
        String msgDecrypted="";
                            
            for (int i = 0; i < abc.length; i++) {            
            for (int j = 0; j < cripto.length; j++) {
                     if(abc[i] == 'a' && cripto[j] == 't'){
                        int pos = j;    
                         for(int m = 0; m<message.length;m++ ){
                             for (int c = 0;c<cripto.length;c++){
                                 if(pos>=cripto.length){
                                         pos=0;
                                  }
                                 if(Character.isUpperCase(message[m])){
                                     if((Character.toString(message[m]).equalsIgnoreCase(Character.toString(cripto[c]))) && ( pos<=c) ){
                                         message[m] = Character.toUpperCase(abc[c-pos]);
                                         pos++;
                                         c=30;   
                                     }else if((Character.toString(message[m]).equalsIgnoreCase(Character.toString(cripto[c]))) && (pos>c)){
                                         message[m] = Character.toUpperCase(abc[(cripto.length+c)-pos]);
                                         pos++;
                                         c=30;
                                     }
                                 }else if(message[m] == cripto[c] && pos<=c){
                                     message[m] = abc[c-pos];
                                     pos++;
                                     c=30;
                                 }else if(message[m] == cripto[c] && pos > c){
                                     message[m] = abc[(cripto.length+c)-pos];
                                     pos++;
                                     c=30;
                                 }
                             }
                         }   
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
            
            pw.println(txtCoded.getText().replace("\n", "\r\n"));
            JOptionPane.showMessageDialog(null, "Mensaje Guardado");
        }catch(Exception e){
            
        }
    }

    void grabarDecrypted(){
            FileDialog da;
            da = new FileDialog(this,"Guardar como",FileDialog.SAVE);
            da.show();
            String file,directory;
            file = da.getFile(); 
            directory = da.getDirectory();
            
        try(PrintWriter pw = new PrintWriter( new FileWriter(directory+file))) {
            if(file != ""){
                pw.println(txtDecoded.getText().replace("\n", "\r\n"));
                JOptionPane.showMessageDialog(null, "Mensaje Guardado");
                System.out.println(file);
            }else{
                JOptionPane.showMessageDialog(null, "Mensaje No Guardado");
            }
                
        }catch(Exception e){
            
        }
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        rdoOrdenado = new javax.swing.JRadioButton();
        rdoInverso = new javax.swing.JRadioButton();
        txtLetter = new javax.swing.JTextField();
        rdoLetter = new javax.swing.JRadioButton();
        txtDerecha = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lbl1 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtToDecode = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        txtDecoded = new javax.swing.JTextArea();
        pnlDecode = new javax.swing.JPanel();
        btnDecrypt = new javax.swing.JButton();
        pnlCleanDecode = new javax.swing.JPanel();
        btnCleanDecrypt = new javax.swing.JButton();
        pnlCleanDecoded = new javax.swing.JPanel();
        btnCleanDecrypted = new javax.swing.JButton();
        btnVolverP = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        pnlCerrar = new javax.swing.JPanel();
        btnCerrar = new javax.swing.JButton();
        pnlMin = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        btnMinimizar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtCoded = new javax.swing.JTextArea();
        jScrollPane6 = new javax.swing.JScrollPane();
        txtToEncode = new javax.swing.JTextArea();
        jLabel10 = new javax.swing.JLabel();
        pnlEncode = new javax.swing.JPanel();
        btnEncrypt = new javax.swing.JButton();
        pnlCleanEncode = new javax.swing.JPanel();
        btnCleanEncrypt = new javax.swing.JButton();
        pnlSendToDecode = new javax.swing.JPanel();
        btnSendToDecrypt = new javax.swing.JButton();
        pnlCleanEncoded = new javax.swing.JPanel();
        btnCleanEncoded = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        lblVolver = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtKeyWord = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        txtCripto = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtLlano = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        pnlGenerarCripto = new javax.swing.JPanel();
        btnGenerarCripto = new javax.swing.JButton();
        pnlLimpiarCampos = new javax.swing.JPanel();
        btnLimpiar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Personalizar");
        setBackground(new java.awt.Color(35, 86, 104));
        setName("Personalizar"); // NOI18N
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(7, 64, 77));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 75, 91));
        jPanel1.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 13)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Seleccionar tipo de alfabeto");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, -1, 30));

        rdoOrdenado.setBackground(new java.awt.Color(102, 102, 102));
        rdoOrdenado.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 12)); // NOI18N
        rdoOrdenado.setForeground(new java.awt.Color(255, 255, 255));
        rdoOrdenado.setText("Ordenado");
        rdoOrdenado.setContentAreaFilled(false);
        rdoOrdenado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoOrdenadoActionPerformed(evt);
            }
        });
        jPanel1.add(rdoOrdenado, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 160, 90, 30));

        rdoInverso.setBackground(new java.awt.Color(102, 102, 102));
        rdoInverso.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 12)); // NOI18N
        rdoInverso.setForeground(new java.awt.Color(255, 255, 255));
        rdoInverso.setText("Inverso");
        rdoInverso.setContentAreaFilled(false);
        rdoInverso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoInversoActionPerformed(evt);
            }
        });
        jPanel1.add(rdoInverso, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 160, 80, 30));

        txtLetter.setEditable(false);
        txtLetter.setBackground(new java.awt.Color(7, 64, 77));
        txtLetter.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 13)); // NOI18N
        txtLetter.setForeground(new java.awt.Color(204, 204, 204));
        txtLetter.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtLetter.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 51)));
        txtLetter.setCaretColor(new java.awt.Color(0, 204, 255));
        txtLetter.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtLetterKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtLetterKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtLetterKeyTyped(evt);
            }
        });
        jPanel1.add(txtLetter, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 60, 50, 30));

        rdoLetter.setBackground(new java.awt.Color(102, 102, 102));
        rdoLetter.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 13)); // NOI18N
        rdoLetter.setForeground(new java.awt.Color(255, 255, 255));
        rdoLetter.setText("Letra inicial para el alfabeto y llano ");
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
        jPanel1.add(rdoLetter, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, 30));

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
        jPanel1.add(txtDerecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 110, 50, 30));

        jLabel12.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 13)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Número de saltos a la derecha ");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 190, 30));

        jLabel1.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Parámetros para generar el cripto y llano");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 300, 30));

        lbl1.setFont(new java.awt.Font("Microsoft JhengHei UI", 2, 13)); // NOI18N
        lbl1.setForeground(new java.awt.Color(255, 255, 255));
        lbl1.setText("(opcional)");
        jPanel1.add(lbl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 60, 60, 30));

        jLabel18.setFont(new java.awt.Font("Microsoft JhengHei UI", 2, 13)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("(obligatorio)");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 110, 80, 30));

        jPanel4.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 460, 210));

        jPanel3.setBackground(new java.awt.Color(0, 75, 91));
        jPanel3.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 13)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Ingrese el mensaje que desea descifrar");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 230, 30));

        txtToDecode.setBackground(new java.awt.Color(7, 64, 77));
        txtToDecode.setColumns(20);
        txtToDecode.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 11)); // NOI18N
        txtToDecode.setForeground(new java.awt.Color(204, 204, 204));
        txtToDecode.setRows(5);
        txtToDecode.setCaretColor(new java.awt.Color(0, 204, 255));
        txtToDecode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtToDecodeKeyReleased(evt);
            }
        });
        jScrollPane4.setViewportView(txtToDecode);

        jPanel3.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, 400, 100));

        jLabel8.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 13)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Este es su mensaje descifrado");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 180, 30));

        txtDecoded.setEditable(false);
        txtDecoded.setBackground(new java.awt.Color(7, 64, 77));
        txtDecoded.setColumns(20);
        txtDecoded.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 11)); // NOI18N
        txtDecoded.setForeground(new java.awt.Color(204, 204, 204));
        txtDecoded.setRows(5);
        txtDecoded.setCaretColor(new java.awt.Color(0, 204, 204));
        jScrollPane5.setViewportView(txtDecoded);

        jPanel3.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 210, 400, 100));

        pnlDecode.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnDecrypt.setBackground(new java.awt.Color(0, 51, 51));
        btnDecrypt.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 11)); // NOI18N
        btnDecrypt.setForeground(new java.awt.Color(255, 255, 255));
        btnDecrypt.setText("Descifrar");
        btnDecrypt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(10, 121, 143)));
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
        pnlDecode.add(btnDecrypt, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 130, 30));

        jPanel3.add(pnlDecode, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 150, 130, 30));

        pnlCleanDecode.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnCleanDecrypt.setBackground(new java.awt.Color(0, 51, 51));
        btnCleanDecrypt.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 11)); // NOI18N
        btnCleanDecrypt.setForeground(new java.awt.Color(255, 255, 255));
        btnCleanDecrypt.setText("Limpiar campo");
        btnCleanDecrypt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(10, 121, 143)));
        btnCleanDecrypt.setContentAreaFilled(false);
        btnCleanDecrypt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCleanDecryptMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCleanDecryptMouseExited(evt);
            }
        });
        btnCleanDecrypt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCleanDecryptActionPerformed(evt);
            }
        });
        pnlCleanDecode.add(btnCleanDecrypt, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 130, 30));

        jPanel3.add(pnlCleanDecode, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 150, 130, 30));

        pnlCleanDecoded.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnCleanDecrypted.setBackground(new java.awt.Color(0, 51, 51));
        btnCleanDecrypted.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 11)); // NOI18N
        btnCleanDecrypted.setForeground(new java.awt.Color(255, 255, 255));
        btnCleanDecrypted.setText("Limpiar campo");
        btnCleanDecrypted.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(10, 121, 143)));
        btnCleanDecrypted.setContentAreaFilled(false);
        btnCleanDecrypted.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCleanDecryptedMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCleanDecryptedMouseExited(evt);
            }
        });
        btnCleanDecrypted.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCleanDecryptedActionPerformed(evt);
            }
        });
        pnlCleanDecoded.add(btnCleanDecrypted, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 140, 30));

        jPanel3.add(pnlCleanDecoded, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 320, 140, 30));

        jPanel4.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 390, 520, 370));

        btnVolverP.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 11)); // NOI18N
        btnVolverP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/if_Left_arrow_2202280.png"))); // NOI18N
        btnVolverP.setBorder(null);
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

        jPanel5.setBackground(new java.awt.Color(0, 55, 59));
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

        jLabel9.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 10)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("PERSONALIZAR");
        jPanel5.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1210, 30));

        jPanel4.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1210, 30));

        jPanel2.setBackground(new java.awt.Color(0, 75, 91));
        jPanel2.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 13)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Ingrese el mensaje que desea cifrar");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 220, 30));

        jLabel4.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 13)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Este es su mensaje cifrado");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 160, 30));

        txtCoded.setEditable(false);
        txtCoded.setBackground(new java.awt.Color(7, 64, 77));
        txtCoded.setColumns(20);
        txtCoded.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 11)); // NOI18N
        txtCoded.setForeground(new java.awt.Color(204, 204, 204));
        txtCoded.setRows(5);
        txtCoded.setCaretColor(new java.awt.Color(0, 204, 204));
        txtCoded.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCodedKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(txtCoded);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, 420, 100));

        txtToEncode.setBackground(new java.awt.Color(7, 64, 77));
        txtToEncode.setColumns(20);
        txtToEncode.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 11)); // NOI18N
        txtToEncode.setForeground(new java.awt.Color(204, 204, 204));
        txtToEncode.setRows(3);
        txtToEncode.setBorder(null);
        txtToEncode.setCaretColor(new java.awt.Color(0, 204, 255));
        txtToEncode.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtToEncode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtToEncodeKeyReleased(evt);
            }
        });
        jScrollPane6.setViewportView(txtToEncode);

        jPanel2.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, 410, 100));

        jLabel10.setText("jLabel10");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, -220, -1, -1));

        pnlEncode.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnEncrypt.setBackground(new java.awt.Color(0, 51, 51));
        btnEncrypt.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 11)); // NOI18N
        btnEncrypt.setForeground(new java.awt.Color(255, 255, 255));
        btnEncrypt.setText("Cifrar");
        btnEncrypt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(10, 121, 143)));
        btnEncrypt.setContentAreaFilled(false);
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
        pnlEncode.add(btnEncrypt, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 130, 30));

        jPanel2.add(pnlEncode, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 150, 130, 30));

        pnlCleanEncode.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnCleanEncrypt.setBackground(new java.awt.Color(0, 51, 51));
        btnCleanEncrypt.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 11)); // NOI18N
        btnCleanEncrypt.setForeground(new java.awt.Color(255, 255, 255));
        btnCleanEncrypt.setText("Limpiar campo");
        btnCleanEncrypt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(10, 121, 143)));
        btnCleanEncrypt.setContentAreaFilled(false);
        btnCleanEncrypt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCleanEncryptMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCleanEncryptMouseExited(evt);
            }
        });
        btnCleanEncrypt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCleanEncryptActionPerformed(evt);
            }
        });
        pnlCleanEncode.add(btnCleanEncrypt, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 130, 30));

        jPanel2.add(pnlCleanEncode, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 150, 130, 30));

        pnlSendToDecode.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnlSendToDecodeMouseEntered(evt);
            }
        });
        pnlSendToDecode.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnSendToDecrypt.setBackground(new java.awt.Color(0, 51, 51));
        btnSendToDecrypt.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 11)); // NOI18N
        btnSendToDecrypt.setForeground(new java.awt.Color(255, 255, 255));
        btnSendToDecrypt.setText("Enviar mensaje a Descifrar");
        btnSendToDecrypt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(10, 121, 143)));
        btnSendToDecrypt.setContentAreaFilled(false);
        btnSendToDecrypt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSendToDecryptMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSendToDecryptMouseExited(evt);
            }
        });
        btnSendToDecrypt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendToDecryptActionPerformed(evt);
            }
        });
        pnlSendToDecode.add(btnSendToDecrypt, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 30));

        jPanel2.add(pnlSendToDecode, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 320, 150, 30));

        pnlCleanEncoded.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnCleanEncoded.setBackground(new java.awt.Color(0, 51, 51));
        btnCleanEncoded.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 11)); // NOI18N
        btnCleanEncoded.setForeground(new java.awt.Color(255, 255, 255));
        btnCleanEncoded.setText("Limpiar campo");
        btnCleanEncoded.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(10, 121, 143)));
        btnCleanEncoded.setContentAreaFilled(false);
        btnCleanEncoded.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnCleanEncodedMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnCleanEncodedMouseExited(evt);
            }
        });
        btnCleanEncoded.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCleanEncodedActionPerformed(evt);
            }
        });
        pnlCleanEncoded.add(btnCleanEncoded, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 130, 30));

        jPanel2.add(pnlCleanEncoded, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 320, 130, 30));

        jPanel4.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 390, 520, 370));

        jLabel11.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("DESCIFRAR");
        jPanel4.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 360, 80, 30));

        jSeparator2.setOpaque(true);
        jPanel4.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 322, 1080, 0));

        lblVolver.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 13)); // NOI18N
        lblVolver.setForeground(new java.awt.Color(204, 204, 204));
        lblVolver.setText("Ir a principal");
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
        jPanel4.add(lblVolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 80, 30));

        jLabel13.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("CIFRAR");
        jPanel4.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 360, 50, 30));

        txtKeyWord.setBackground(new java.awt.Color(0, 75, 91));
        txtKeyWord.setColumns(2);
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
        jPanel4.add(txtKeyWord, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 50, 380, 34));

        jPanel7.setBackground(new java.awt.Color(0, 75, 91));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel16.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 13)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Cripto");
        jPanel7.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 50, 30));

        txtCripto.setEditable(false);
        txtCripto.setBackground(new java.awt.Color(7, 64, 77));
        txtCripto.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 13)); // NOI18N
        txtCripto.setForeground(new java.awt.Color(204, 204, 204));
        txtCripto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCripto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 51)));
        jPanel7.add(txtCripto, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, 330, 30));

        jLabel2.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 13)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Llano");
        jPanel7.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 50, 30));

        txtLlano.setBackground(new java.awt.Color(7, 64, 77));
        txtLlano.setColumns(2);
        txtLlano.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 13)); // NOI18N
        txtLlano.setForeground(new java.awt.Color(204, 204, 204));
        txtLlano.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtLlano.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 51)));
        jPanel7.add(txtLlano, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 120, 330, 30));

        jPanel4.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 110, 460, 210));

        jLabel15.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 13)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Ingrese la palabra clave");
        jPanel4.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 50, 160, 30));

        pnlGenerarCripto.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnGenerarCripto.setBackground(new java.awt.Color(0, 51, 51));
        btnGenerarCripto.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 11)); // NOI18N
        btnGenerarCripto.setForeground(new java.awt.Color(255, 255, 255));
        btnGenerarCripto.setText("Generar cripto");
        btnGenerarCripto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(10, 121, 143)));
        btnGenerarCripto.setContentAreaFilled(false);
        btnGenerarCripto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnGenerarCriptoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnGenerarCriptoMouseExited(evt);
            }
        });
        btnGenerarCripto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarCriptoActionPerformed(evt);
            }
        });
        pnlGenerarCripto.add(btnGenerarCripto, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 30));

        jPanel4.add(pnlGenerarCripto, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 170, 120, 30));

        pnlLimpiarCampos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnLimpiar.setBackground(new java.awt.Color(0, 51, 51));
        btnLimpiar.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 11)); // NOI18N
        btnLimpiar.setForeground(new java.awt.Color(255, 255, 255));
        btnLimpiar.setText("Limpiar campos");
        btnLimpiar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(10, 121, 143)));
        btnLimpiar.setContentAreaFilled(false);
        btnLimpiar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnLimpiarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnLimpiarMouseExited(evt);
            }
        });
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });
        pnlLimpiarCampos.add(btnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 120, 30));

        jPanel4.add(pnlLimpiarCampos, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 250, 120, 30));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1210, 780));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnGenerarCriptoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarCriptoActionPerformed
           if(getJumps().equals("")){
               dlgSaltosNoIngresado v = new dlgSaltosNoIngresado(this,true);
               v.setVisible(true);
               txtDerecha.requestFocus();
          }else if(txtKeyWord.getText().equals("")){
               dlgNoKW noKW = new dlgNoKW(this, true);
               noKW.setVisible(true);
          }else{
            txtCripto.setText("");
            char[] keyWordInArray = getKeyWord();//Obtenemos la palabra clave para ponerla en un arreglo.   
            char[] finalText = deleteRepeted(keyWordInArray);//Se eliminan las letras repetidas de la palabra clave.
            char[] keyWord = deleteSpaces(finalText);//Se eliminan los espacios vacios de la palabra clave.
            String abc = alphabet();//La estructura del alfabeto se almacena en la variable abc.
            String nAlf = randomJumps(abc, Integer.parseInt(txtDerecha.getText()));//Aplicamos saltos al alfabeto.
            completarArray(keyWord, nAlf); //Generamos el cripto.
          }    
    }//GEN-LAST:event_btnGenerarCriptoActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        txtLlano.setText("");
        txtKeyWord.setText("");
        txtLetter.setText("");
        txtCripto.setText("");
        txtKeyWord.requestFocus();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnEncryptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEncryptActionPerformed
        if(txtCripto.getText().equals("") && txtLlano.getText().equals("")){
            dlgNoCriptoLlano np = new dlgNoCriptoLlano(this, true);
            np.setVisible(true);
            txtKeyWord.requestFocus();
        }else{
            txtCoded.setText("");
            String message = getMessage();
            char[] msgInArray = Conversion(message).toCharArray();
            char[] cripto = putCriptoInArray();
            char[] abc = alphabet().toCharArray();

            String encrypted = encrypt(msgInArray, cripto, abc);
            txtCoded.setText(encrypted);
            btnSendToDecrypt.setEnabled(true);
            btnSendToDecrypt.setForeground(Color.white);
            btnCleanEncoded.setEnabled(true);
            btnCleanEncoded.setForeground(Color.white);
        }
    }//GEN-LAST:event_btnEncryptActionPerformed

    private void rdoOrdenadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoOrdenadoActionPerformed
        rdoInverso.setSelected(false);
    }//GEN-LAST:event_rdoOrdenadoActionPerformed

    private void rdoInversoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoInversoActionPerformed
        rdoOrdenado.setSelected(false);
    }//GEN-LAST:event_rdoInversoActionPerformed

    private void btnDecryptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDecryptActionPerformed
        if(txtCripto.getText().equals("") && txtLlano.getText().equals("")){
            dlgNoCriptoLlano np = new dlgNoCriptoLlano(this, true);
            np.setVisible(true);
            txtKeyWord.requestFocus();
        }else{
            txtDecoded.setText("");
            char[] message = getEncripted();
            char[] cripto = putCriptoInArray();
            char[] abc = alphabet().toCharArray();
        
            String msgDecoded = decrypt(message, cripto, abc);
            txtDecoded.setText(msgDecoded);
        
            btnCleanDecrypted.setEnabled(true);
            btnCleanDecrypted.setForeground(Color.white);
      }
    }//GEN-LAST:event_btnDecryptActionPerformed

    private void btnCleanDecryptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCleanDecryptActionPerformed
        txtToDecode.setText("");
        txtToDecode.requestFocus();
        btnDecrypt.setEnabled(false);
        btnDecrypt.setForeground(Color.gray);
        btnCleanDecrypt.setEnabled(false);
        btnCleanDecrypt.setForeground(Color.gray);
        btnCleanDecrypted.setEnabled(true);
        btnCleanDecrypted.setForeground(Color.white);
    }//GEN-LAST:event_btnCleanDecryptActionPerformed

    private void rdoLetterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoLetterActionPerformed
        if(rdoLetter.isSelected()){
            txtLetter.setEditable(true);
            rdoLetter.setForeground(Color.white);
            lbl1.setForeground(Color.white);
        }else{
            txtLetter.setEditable(false);
            rdoLetter.setForeground(Color.gray);
            lbl1.setForeground(Color.gray);
        }
    }//GEN-LAST:event_rdoLetterActionPerformed

    private void txtKeyWordKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtKeyWordKeyTyped
        char letra = evt.getKeyChar();
        if((letra < 'A' || letra > 'Z') &&(letra < 'a' || letra > 'z') && (letra != '\b')){
        evt.consume();
        dlgSoloLetrasKW w = new dlgSoloLetrasKW(this,true);
        w.setVisible(true);  
        
    }
        
    }//GEN-LAST:event_txtKeyWordKeyTyped

    private void txtKeyWordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtKeyWordKeyReleased
        btnGenerarCripto.setEnabled(true);
        btnGenerarCripto.setForeground(Color.white);
        btnLimpiar.setEnabled(true);
        btnLimpiar.setForeground(Color.white);
        int longitud = txtKeyWord.getText().length();
        if (longitud == 0) {
            btnGenerarCripto.setEnabled(false);
            btnGenerarCripto.setForeground(Color.gray);
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
        String mensaje = txtCoded.getText();
        txtToDecode.setText(mensaje);
        btnDecrypt.setEnabled(true);
        btnDecrypt.setForeground(Color.white);
        btnCleanDecrypt.setEnabled(true);
        btnCleanDecrypt.setForeground(Color.white);   
    }//GEN-LAST:event_btnSendToDecryptActionPerformed

    private void btnCleanDecryptedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCleanDecryptedActionPerformed
        txtDecoded.setText("");
        btnCleanDecrypted.setEnabled(false);
        btnCleanDecrypted.setForeground(Color.gray);
    }//GEN-LAST:event_btnCleanDecryptedActionPerformed

    private void txtToEncodeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtToEncodeKeyReleased
        btnEncrypt.setEnabled(true);
        btnEncrypt.setForeground(Color.white);
        btnCleanEncrypt.setEnabled(true);
        btnCleanEncrypt.setForeground(Color.white);
        int longitud = txtToEncode.getText().length();
        if (longitud == 0) {
            btnEncrypt.setEnabled(false);
            btnEncrypt.setForeground(Color.gray);
            btnCleanEncrypt.setEnabled(false);
            btnCleanEncrypt.setForeground(Color.gray);
        }
    }//GEN-LAST:event_txtToEncodeKeyReleased

    private void txtToDecodeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtToDecodeKeyReleased
        int longitud = txtToDecode.getText().length();
        if(evt.getKeyChar()!= ' '){
            btnDecrypt.setEnabled(true);
            btnDecrypt.setForeground(Color.white);
            btnCleanDecrypt.setEnabled(true);
            btnCleanDecrypt.setForeground(Color.white);
        }if (longitud == 0) {
            btnDecrypt.setEnabled(false);
            btnDecrypt.setForeground(Color.gray);
            btnCleanDecrypt.setEnabled(false);
            btnCleanDecrypt.setForeground(Color.gray);
        }
    }//GEN-LAST:event_txtToDecodeKeyReleased

    private void btnCleanEncodedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCleanEncodedActionPerformed
        txtToEncode.setText("");
        txtCoded.setText("");
        txtToEncode.requestFocus();
        btnSendToDecrypt.setForeground(Color.gray);
        btnEncrypt.setEnabled(false);
        btnEncrypt.setForeground(Color.gray);
        btnCleanEncoded.setEnabled(false);
        btnCleanEncoded.setForeground(Color.gray);
    }//GEN-LAST:event_btnCleanEncodedActionPerformed

    private void txtCodedKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodedKeyReleased
       //btnEnviar.setEnabled(true);
       //btnEnviar.setForeground(Color.white);
       
        int longitud = txtToDecode.getText().length();
        if (longitud == 0) {
            btnDecrypt.setEnabled(false);
            
            
        }
    }//GEN-LAST:event_txtCodedKeyReleased

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
        if((num < '1' || num > '9') && (num != '\b')) {
        evt.consume();
        dlgValidaValorSaltos vs = new dlgValidaValorSaltos(this, true);
        vs.setVisible(true);
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

    private void btnGenerarCriptoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGenerarCriptoMouseEntered
        pnlGenerarCripto.setBackground(new Color(7, 97, 104));
    }//GEN-LAST:event_btnGenerarCriptoMouseEntered

    private void txtLetterKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLetterKeyTyped
        char let = evt.getKeyChar();
        if((let < 'a' || let > 'z') && (let < 'A' || let > 'Z') && (let != '\b')) {
        evt.consume();
        dlgSoloLetrasKW w = new dlgSoloLetrasKW(this, true);
        w.setVisible(true);
        } 
        int l = 0;
        if(rdoLetter.isSelected()&& txtLetter.getText().length()>l){
            dlgCantLetras cant = new dlgCantLetras(this, true);
            cant.setVisible(true);
            evt.consume();
            /*String cad = Character.toString(txtLetter.getText().charAt(0));
            System.out.println(cad);
            //cad = cad.replace(cad, Character.toString(cad.charAt(0)));
            txtLetter.setText("");
            dlgCantLetras cant = new dlgCantLetras(this, true);
            cant.setVisible(true);
            System.out.println(cad);
            txtLetter.setText(cad);*/
        }
    }//GEN-LAST:event_txtLetterKeyTyped

    private void btnCleanEncryptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCleanEncryptActionPerformed
        txtToEncode.setText("");
        txtCoded.setText("");
        txtToEncode.requestFocus();
        btnSendToDecrypt.setForeground(Color.gray);
        btnEncrypt.setEnabled(false);
        btnEncrypt.setForeground(Color.gray);
        btnCleanEncoded.setEnabled(false);
        btnCleanEncoded.setForeground(Color.gray);
    }//GEN-LAST:event_btnCleanEncryptActionPerformed

    
    private void btnLimpiarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLimpiarMouseEntered
        pnlLimpiarCampos.setBackground(new Color(7, 97, 104));
    }//GEN-LAST:event_btnLimpiarMouseEntered

    private void btnEncryptMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEncryptMouseEntered
        pnlEncode.setBackground(new Color(7, 97, 104));
    }//GEN-LAST:event_btnEncryptMouseEntered

    private void btnCleanEncryptMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCleanEncryptMouseEntered
        pnlCleanEncode.setBackground(new Color(7, 97, 104));
    }//GEN-LAST:event_btnCleanEncryptMouseEntered

    private void pnlSendToDecodeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlSendToDecodeMouseEntered
        
    }//GEN-LAST:event_pnlSendToDecodeMouseEntered

    private void btnDecryptMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDecryptMouseEntered
        pnlDecode.setBackground(new Color(7, 97, 104));
    }//GEN-LAST:event_btnDecryptMouseEntered

    private void btnCleanDecryptMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCleanDecryptMouseEntered
        pnlCleanDecode.setBackground(new Color(7, 97, 104));
    }//GEN-LAST:event_btnCleanDecryptMouseEntered

    private void btnCleanEncodedMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCleanEncodedMouseEntered
        pnlCleanEncoded.setBackground(new Color(7, 97, 104));
    }//GEN-LAST:event_btnCleanEncodedMouseEntered

    private void btnCleanDecryptedMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCleanDecryptedMouseEntered
        pnlCleanDecoded.setBackground(new Color(7, 97, 104));
    }//GEN-LAST:event_btnCleanDecryptedMouseEntered

    private void btnGenerarCriptoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGenerarCriptoMouseExited
        pnlGenerarCripto.setBackground(null);
    }//GEN-LAST:event_btnGenerarCriptoMouseExited

    private void btnLimpiarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLimpiarMouseExited
        pnlLimpiarCampos.setBackground(null);
    }//GEN-LAST:event_btnLimpiarMouseExited

    private void btnEncryptMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEncryptMouseExited
        pnlEncode.setBackground(null);
    }//GEN-LAST:event_btnEncryptMouseExited

    private void btnCleanEncryptMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCleanEncryptMouseExited
        pnlCleanEncode.setBackground(null);
    }//GEN-LAST:event_btnCleanEncryptMouseExited

    private void btnSendToDecryptMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSendToDecryptMouseEntered
        pnlSendToDecode.setBackground(new Color(7, 97, 104));
    }//GEN-LAST:event_btnSendToDecryptMouseEntered

    private void btnSendToDecryptMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSendToDecryptMouseExited
        pnlSendToDecode.setBackground(null);
    }//GEN-LAST:event_btnSendToDecryptMouseExited

    private void btnDecryptMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDecryptMouseExited
        pnlDecode.setBackground(null);
    }//GEN-LAST:event_btnDecryptMouseExited

    private void btnCleanDecryptMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCleanDecryptMouseExited
        pnlCleanDecode.setBackground(null);
    }//GEN-LAST:event_btnCleanDecryptMouseExited

    private void btnCleanDecryptedMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCleanDecryptedMouseExited
        pnlCleanDecoded.setBackground(null);
    }//GEN-LAST:event_btnCleanDecryptedMouseExited

    private void btnCleanEncodedMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCleanEncodedMouseExited
        pnlCleanEncoded.setBackground(null);
    }//GEN-LAST:event_btnCleanEncodedMouseExited

    private void txtLetterKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLetterKeyPressed
       /*    char let = evt.getKeyChar();
        if((let < 'a' || let > 'z') && (let < 'A' || let > 'Z') && (let != '\b')) {
        evt.consume();
        dlgSoloLetrasKW w = new dlgSoloLetrasKW(this, true);
        w.setVisible(true);
        } 
        int l = txtLetter.getText().length();
        if(rdoLetter.isSelected()&& l>=1){
            dlgCantLetras cant = new dlgCantLetras(this, true);
            cant.setVisible(true);
            System.out.println(l);
            String cad = Character.toString(txtLetter.getText().charAt(0));
            System.out.println(cad);
            txtLetter.setText("");
            System.out.println(cad);
            txtLetter.setText(cad);
        }    */
    }//GEN-LAST:event_txtLetterKeyPressed

    private void txtLetterKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLetterKeyReleased
        
    }//GEN-LAST:event_txtLetterKeyReleased

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
    private javax.swing.JButton btnCleanEncoded;
    private javax.swing.JButton btnCleanEncrypt;
    private javax.swing.JButton btnDecrypt;
    private javax.swing.JButton btnEncrypt;
    private javax.swing.JButton btnGenerarCripto;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnMinimizar;
    private javax.swing.JButton btnSendToDecrypt;
    private javax.swing.JButton btnVolverP;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
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
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lbl1;
    private javax.swing.JLabel lblVolver;
    private javax.swing.JPanel pnlCerrar;
    private javax.swing.JPanel pnlCleanDecode;
    private javax.swing.JPanel pnlCleanDecoded;
    private javax.swing.JPanel pnlCleanEncode;
    private javax.swing.JPanel pnlCleanEncoded;
    private javax.swing.JPanel pnlDecode;
    private javax.swing.JPanel pnlEncode;
    private javax.swing.JPanel pnlGenerarCripto;
    private javax.swing.JPanel pnlLimpiarCampos;
    private javax.swing.JPanel pnlMin;
    private javax.swing.JPanel pnlSendToDecode;
    private javax.swing.JRadioButton rdoInverso;
    private javax.swing.JRadioButton rdoLetter;
    private javax.swing.JRadioButton rdoOrdenado;
    private javax.swing.JTextArea txtCoded;
    private javax.swing.JTextField txtCripto;
    private javax.swing.JTextArea txtDecoded;
    private javax.swing.JTextField txtDerecha;
    private javax.swing.JTextField txtKeyWord;
    private javax.swing.JTextField txtLetter;
    private javax.swing.JTextField txtLlano;
    private javax.swing.JTextArea txtToDecode;
    private javax.swing.JTextArea txtToEncode;
    // End of variables declaration//GEN-END:variables
}
