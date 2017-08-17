
package Formulario;


import dialogos.dlgValidaValorSaltos;
import dialogos.dlgSoloLetrasKW;
import dialogos.dlgSaltosNoIngresado;
import com.sun.awt.AWTUtilities;
import dialogos.dlgCantLetras;
import dialogos.dlgNoKW;
import dialogos.dlgParametrosCambiados;
import java.awt.Color;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.Shape;
import java.awt.Toolkit;
import java.awt.geom.RoundRectangle2D;


public class frmPersonalizar extends javax.swing.JFrame {
    
    @SuppressWarnings("OverridableMethodCallInConstructor")
    public frmPersonalizar() {
        
        initComponents();
        
        txtKeyWord.requestFocus();//Ubicar el cursor en el campo de la palabra clave
        txtLlano.setEditable(false);//Deshabilitar la edición del LLANO
        txtCripto.setEditable(false);//Deshabilitar la edición del CRIPTO       
        txtLetter.setBackground(new Color(7,64,77));//color de fondo del campo de texto
        rdoOrdenado.setSelected(true);//Por defecto se usa el alfabeto ordenado
        
        //personalización de la apariencia del boton ASIGNAR CONFIGURACIÓN AL SISTEMA
        pnlUsarAsDefault.setBackground(null);//sin color de fondo
        btnSetConfig.setContentAreaFilled(false);//boton transparente
        btnSetConfig.enable(false);//deshabilitado al inicio
        btnSetConfig.setForeground(Color.gray);//color de fuente por defecto
        
        //Personalización de la apariencia del botón GENERAR CRIPTO Y LLANO
        btnGenerarCripto.setEnabled(false);//deshabilitado por defecto
        btnGenerarCripto.setForeground(Color.gray);//color del texto por defecto 
        pnlGenerarCripto.setBackground(null);//panel transparente al inicio
        
        //Personalización de la apariencia del botón LIMPIAR CAMPOS
        btnLimpiar.setEnabled(false);//deshabilitado por defecto
        btnLimpiar.setForeground(Color.gray);//color del texto por defecto
        pnlLimpiarCampos.setBackground(null);//panel transparente al inicio
        
        //Personalización inicial del botón CERRAR y MINIMIZAR
        btnMinimizar.setContentAreaFilled(false);//boton transparente
        pnlMin.setBackground(null);//panel transparente 
        btnCerrar.setContentAreaFilled(false);//boton transparente
        pnlCerrar.setBackground(null);//panel transparente
        
        //acceso directo IR A INICIO 
        lblIrAInicio.setForeground(Color.gray);//color de la fuente
        btnIrAInicio.setContentAreaFilled(false);//boton transparente
       
        //Ventanas con bordes redondeados 
        @SuppressWarnings("OverridableMethodCallInConstructor")
        Shape forma = new RoundRectangle2D.Double(0, 0, this.getBounds().width, this.getBounds().height, 15,15);
        AWTUtilities.setWindowShape(this,forma);
        
        //Icono de las ventanas.
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagenes/Neptune.png"));
        setIconImage(icon); 
        }
    
        /*-------DEFINICION DE VARIABLES ----------------------*/
            char[] criptoFinal = new char[27]; //Arreglo donde se guardará el cripto.
            String abc = ""; //Cadena donde se guardará el alfabeto.
        
        //A través de este método se determina el tipo de alfabeto.
        String alphabet(){
            String cadena1,cadena2;
            String letter = txtLetter.getText().toLowerCase();//Obtenemos la letra inicial.
            
        //Si el albafeto es ordenado y empieza por una letra en específico.
            if (rdoOrdenado.isSelected() && (!" ".equals(txtLetter.getText()))) {
            abc = "abcdefghijklmnñopqrstuvwxyz";
             for (int i = 0; i < abc.length(); i++) {
                if (letter.equals(Character.toString(abc.charAt(i)))) {
                    cadena1 = abc.substring(i, abc.length());
                    cadena2 = abc.substring(0, i);
                    abc = cadena1.concat(cadena2);
                }
              }            
            } //Si el albafeto es inverso y empieza por una letra en específico.
          else if (rdoInverso.isSelected() && (!" ".equals(txtLetter.getText()))) {
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
        //Método para desordenar el cripto mediante saltos aleatorios       
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
        criptoFinal = crypt.toCharArray();
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
   /* String getMessage() {
        //String message = txtToEncode.getText();
       return message; 
    }*/
    char[] putCriptoInArray() {
        return txtCripto.getText().toCharArray();
    }
    /*------------------------CIFRADO POR SUSTITUCIÓN--------------------------------*/
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
    /*-------------------------------------------------------------------------------*/
   String encrypt(char[] mensaje, char[] cripto, char[] abc) {
        String msgEncrypted=""; //definimos la varible para almacenar el mensaje cifrado.
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
    /*--------------------------DESCIFRADO POR SUSTITUCIÓN-------------------------*/
    //Obtenemos el mensaje cifrado.
    /*char[] getEncripted() {
        return txtToDecode.getText().toCharArray();
    }*/
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
    /*-----------------------------------------------------------------------------------*/
    
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
   /* void grabarEncrypted(){
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
    }*/

   /* void grabarDecrypted(){
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
    }*/
    
    //public boolean pDefault=false;
    //public String criptoDefault = null;
    //public String llanoDefault = null;
    
    
    /*String setCripto(){

        if(pDefault==true){
           criptoDefault = "juancrloshikmñpqtvwxyzbdefg";
        }else{                
           criptoDefault = txtCripto.getText();
        }
        return criptoDefault;
    }
    
    String setLlano(){

        if(pDefault==true){
           llanoDefault = "hijklmnñopqrstuvwxyzabcdefg";
        }else{                
            llanoDefault = txtLlano.getText();
        }
        return llanoDefault;
    }
*/
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        rdoOrdenado = new javax.swing.JRadioButton();
        rdoInverso = new javax.swing.JRadioButton();
        txtLetter = new javax.swing.JTextField();
        txtDerecha = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        pnlGenerarCripto = new javax.swing.JPanel();
        btnGenerarCripto = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        btnIrAInicio = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        pnlMin = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        btnMinimizar = new javax.swing.JButton();
        pnlCerrar = new javax.swing.JPanel();
        btnCerrar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        lblIrAInicio = new javax.swing.JLabel();
        txtKeyWord = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        txtCripto = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtLlano = new javax.swing.JTextField();
        pnlUsarAsDefault = new javax.swing.JPanel();
        btnSetConfig = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
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
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 51, 51), 1, true));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 13)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Seleccionar tipo de alfabeto");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 170, 240, 30));

        rdoOrdenado.setBackground(new java.awt.Color(102, 102, 102));
        rdoOrdenado.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 12)); // NOI18N
        rdoOrdenado.setForeground(new java.awt.Color(255, 255, 255));
        rdoOrdenado.setText("Ordenado");
        rdoOrdenado.setContentAreaFilled(false);
        rdoOrdenado.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        rdoOrdenado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoOrdenadoActionPerformed(evt);
            }
        });
        jPanel1.add(rdoOrdenado, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 170, 90, 40));

        rdoInverso.setBackground(new java.awt.Color(102, 102, 102));
        rdoInverso.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 12)); // NOI18N
        rdoInverso.setForeground(new java.awt.Color(255, 255, 255));
        rdoInverso.setText("Inverso");
        rdoInverso.setContentAreaFilled(false);
        rdoInverso.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        rdoInverso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoInversoActionPerformed(evt);
            }
        });
        jPanel1.add(rdoInverso, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 170, 100, 40));

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
        jPanel1.add(txtLetter, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 70, 50, 30));

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
        jPanel1.add(txtDerecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 120, 50, 30));

        jLabel12.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 13)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Letra inicial para el alfabeto y llano");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 310, 30));

        pnlGenerarCripto.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnGenerarCripto.setBackground(new java.awt.Color(0, 51, 51));
        btnGenerarCripto.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 1, 13)); // NOI18N
        btnGenerarCripto.setForeground(new java.awt.Color(255, 255, 255));
        btnGenerarCripto.setText("GENERAR CRIPTO Y LLANO");
        btnGenerarCripto.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(10, 121, 143), 2, true));
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
        pnlGenerarCripto.add(btnGenerarCripto, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 260, 40));

        jPanel1.add(pnlGenerarCripto, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 220, 260, 40));

        jLabel1.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("PARÁMETROS PARA GENERAR EL CRIPTO Y LLANO");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 590, 60));

        jLabel13.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 13)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Número de saltos a la derecha ");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, 310, 30));

        jPanel4.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 140, 590, 280));

        btnIrAInicio.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 11)); // NOI18N
        btnIrAInicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/if_Right_arrow_2202241.png"))); // NOI18N
        btnIrAInicio.setBorder(null);
        btnIrAInicio.setContentAreaFilled(false);
        btnIrAInicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnIrAInicioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnIrAInicioMouseExited(evt);
            }
        });
        btnIrAInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIrAInicioActionPerformed(evt);
            }
        });
        jPanel4.add(btnIrAInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 40, 40, 30));

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

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Mercury.png"))); // NOI18N
        jPanel5.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 30, 30));

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

        jPanel5.add(pnlMin, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 0, 50, 30));

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

        jPanel5.add(pnlCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 0, 50, 30));

        jLabel9.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 13)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Personalizar");
        jPanel5.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1020, 30));

        jPanel4.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1020, 30));

        jSeparator2.setOpaque(true);
        jPanel4.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 322, 1080, 0));

        lblIrAInicio.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 13)); // NOI18N
        lblIrAInicio.setForeground(new java.awt.Color(204, 204, 204));
        lblIrAInicio.setText("Ir a principal");
        lblIrAInicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblIrAInicioMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblIrAInicioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblIrAInicioMouseExited(evt);
            }
        });
        jPanel4.add(lblIrAInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 40, 80, 30));

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
        jPanel4.add(txtKeyWord, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 80, 390, 34));

        jPanel7.setBackground(new java.awt.Color(0, 75, 91));
        jPanel7.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 51, 51), 1, true));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel16.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 13)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Cripto");
        jPanel7.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, 90, 30));

        txtCripto.setBackground(new java.awt.Color(7, 64, 77));
        txtCripto.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 13)); // NOI18N
        txtCripto.setForeground(new java.awt.Color(204, 204, 204));
        txtCripto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCripto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 51)));
        jPanel7.add(txtCripto, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 40, 330, 30));

        jLabel2.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 13)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Llano");
        jPanel7.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, 90, 30));

        txtLlano.setBackground(new java.awt.Color(7, 64, 77));
        txtLlano.setColumns(2);
        txtLlano.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 13)); // NOI18N
        txtLlano.setForeground(new java.awt.Color(204, 204, 204));
        txtLlano.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtLlano.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 51, 51)));
        jPanel7.add(txtLlano, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, 330, 30));

        pnlUsarAsDefault.setBackground(new java.awt.Color(102, 0, 0));
        pnlUsarAsDefault.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnSetConfig.setBackground(new java.awt.Color(0, 51, 51));
        btnSetConfig.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 1, 11)); // NOI18N
        btnSetConfig.setForeground(new java.awt.Color(255, 255, 255));
        btnSetConfig.setText("ASINGNAR CONFIGURACIÓN AL SISTEMA");
        btnSetConfig.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 0, 0), 2, true));
        btnSetConfig.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSetConfigMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSetConfigMouseExited(evt);
            }
        });
        btnSetConfig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSetConfigActionPerformed(evt);
            }
        });
        pnlUsarAsDefault.add(btnSetConfig, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 260, 40));

        jPanel7.add(pnlUsarAsDefault, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 160, 260, 40));

        jPanel4.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 450, 590, 220));

        jLabel15.setFont(new java.awt.Font("Microsoft JhengHei UI", 0, 15)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(204, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("INGRESE LA PALABRA CLAVE");
        jPanel4.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 1020, 50));

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
        pnlLimpiarCampos.add(btnLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 140, 30));

        jPanel4.add(pnlLimpiarCampos, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 640, 140, 30));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1020, 690));

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
               txtKeyWord.requestFocus();
          }else{
            txtCripto.setText("");
            char[] keyWordInArray = getKeyWord();//Obtenemos la palabra clave para ponerla en un arreglo.   
            char[] finalText = deleteRepeted(keyWordInArray);//Se eliminan las letras repetidas de la palabra clave.
            char[] keyWord = deleteSpaces(finalText);//Se eliminan los espacios vacios de la palabra clave.
            String abc = alphabet();//La estructura del alfabeto se almacena en la variable abc.
            String nAlf = randomJumps(abc, Integer.parseInt(txtDerecha.getText()));//Aplicamos saltos al alfabeto.
            completarArray(keyWord, nAlf); //Generamos el cripto.
            btnSetConfig.enable(true);
            btnSetConfig.setForeground(Color.white);
          }
           
    }//GEN-LAST:event_btnGenerarCriptoActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        txtLlano.setText("");
        txtKeyWord.setText("");
        txtLetter.setText("");
        txtCripto.setText("");
        txtDerecha.setText("");
        btnSetConfig.enable(true);
        btnGenerarCripto.setForeground(Color.gray);
        if(txtCripto.getText().equals("") || txtLlano.getText().equals("")){
            btnSetConfig.setForeground(Color.gray);
        }else{
            pnlUsarAsDefault.setBackground(new Color(102,0,0));
            btnSetConfig.setForeground(Color.white);
        }
        txtKeyWord.requestFocus();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void rdoOrdenadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoOrdenadoActionPerformed
        rdoInverso.setSelected(false);
        rdoOrdenado.setSelected(true);
    }//GEN-LAST:event_rdoOrdenadoActionPerformed

    private void rdoInversoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoInversoActionPerformed
        rdoOrdenado.setSelected(false);
        rdoInverso.setSelected(true);
    }//GEN-LAST:event_rdoInversoActionPerformed

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

    private void btnIrAInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIrAInicioActionPerformed
        Principal prin = new Principal();
        prin.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_btnIrAInicioActionPerformed

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

    private void lblIrAInicioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblIrAInicioMouseClicked
        Principal prin = new Principal();
        prin.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblIrAInicioMouseClicked

    private void btnIrAInicioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnIrAInicioMouseEntered
        lblIrAInicio.setForeground(Color.white);
    }//GEN-LAST:event_btnIrAInicioMouseEntered

    private void btnIrAInicioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnIrAInicioMouseExited
        lblIrAInicio.setForeground(Color.gray);
    }//GEN-LAST:event_btnIrAInicioMouseExited

    private void lblIrAInicioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblIrAInicioMouseEntered
        lblIrAInicio.setForeground(Color.white);
    }//GEN-LAST:event_lblIrAInicioMouseEntered

    private void lblIrAInicioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblIrAInicioMouseExited
        lblIrAInicio.setForeground(Color.gray);
    }//GEN-LAST:event_lblIrAInicioMouseExited

    private void btnGenerarCriptoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGenerarCriptoMouseEntered
        
        if(!("").equals(txtKeyWord.getText())||(!("").equals(txtKeyWord.getText()))){
            pnlGenerarCripto.setBackground(new Color(10, 121, 143));
            btnGenerarCripto.setForeground(Color.white);
        }
        
    }//GEN-LAST:event_btnGenerarCriptoMouseEntered

    private void txtLetterKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLetterKeyTyped
        char let = evt.getKeyChar();
        if((let < 'a' || let > 'z') && (let < 'A' || let > 'Z') && (let != '\b')) {
        evt.consume();
        dlgSoloLetrasKW w = new dlgSoloLetrasKW(this, true);
        w.setVisible(true);
        } 
        int l = 0;
        if(txtLetter.getText().length()>l){
            dlgCantLetras cant = new dlgCantLetras(this, true);
            cant.setVisible(true);
            evt.consume();
        }
    }//GEN-LAST:event_txtLetterKeyTyped

    
    private void btnLimpiarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLimpiarMouseEntered
        pnlLimpiarCampos.setBackground(new Color(7, 97, 104));
    }//GEN-LAST:event_btnLimpiarMouseEntered

    private void btnGenerarCriptoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGenerarCriptoMouseExited
        pnlGenerarCripto.setBackground(null);
    }//GEN-LAST:event_btnGenerarCriptoMouseExited

    private void btnLimpiarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLimpiarMouseExited
        pnlLimpiarCampos.setBackground(null);
    }//GEN-LAST:event_btnLimpiarMouseExited

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

    private void btnSetConfigMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSetConfigMouseEntered
        if(txtCripto.getText().equals("") || txtLlano.getText().equals("")){
            btnSetConfig.setForeground(Color.gray);
        }else{
        pnlUsarAsDefault.setBackground(new Color(102,0,0));
        btnSetConfig.setForeground(Color.white);
        }
    }//GEN-LAST:event_btnSetConfigMouseEntered

    private void btnSetConfigMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSetConfigMouseExited
        pnlUsarAsDefault.setBackground(null);
    }//GEN-LAST:event_btnSetConfigMouseExited

    private void btnSetConfigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSetConfigActionPerformed

        frmCifrar c = new frmCifrar();
        frmDescifrar d = new frmDescifrar();

        if((!"".equals(txtCripto.getText()))|| (!"".equals(txtLlano.getText()))){
              c.criptoCustom=txtCripto.getText();
              c.llanoCustom=txtLlano.getText();
              c.defaultP=true;
        
              d.criptoCustom=txtCripto.getText();
              d.llanoCustom=txtLlano.getText();
              d.defaultP=true;
            
            dlgParametrosCambiados pc = new dlgParametrosCambiados(this, true);
            pc.setVisible(true); 
            txtKeyWord.requestFocus();
        }
        
        

    }//GEN-LAST:event_btnSetConfigActionPerformed

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
    private javax.swing.JButton btnGenerarCripto;
    private javax.swing.JButton btnIrAInicio;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnMinimizar;
    private javax.swing.JButton btnSetConfig;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblIrAInicio;
    private javax.swing.JPanel pnlCerrar;
    private javax.swing.JPanel pnlGenerarCripto;
    private javax.swing.JPanel pnlLimpiarCampos;
    private javax.swing.JPanel pnlMin;
    private javax.swing.JPanel pnlUsarAsDefault;
    private javax.swing.JRadioButton rdoInverso;
    private javax.swing.JRadioButton rdoOrdenado;
    private javax.swing.JTextField txtCripto;
    private javax.swing.JTextField txtDerecha;
    private javax.swing.JTextField txtKeyWord;
    private javax.swing.JTextField txtLetter;
    private javax.swing.JTextField txtLlano;
    // End of variables declaration//GEN-END:variables
}
