
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView; 
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.KeyFactory; 
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey; 
import java.security.PublicKey;
import java.security.spec.RSAPrivateKeySpec; 
import java.security.spec.RSAPublicKeySpec; 
import javax.swing.JFileChooser;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.crypto.SecretKey;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;


public class EncryptWindow extends javax.swing.JFrame {

   static String Keys_Folder_Path = "" ;
   String Plain_File_Path = "";
   String Key_Path = "" ;

    /**
     * Creates new form EncryptWindow
     */
    public EncryptWindow(String Keys_Folder_Path ) {
        this.Keys_Folder_Path = Keys_Folder_Path;
        
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Browse_plain_File = new javax.swing.JButton();
        Public_btn = new javax.swing.JButton();
        Plain_Path_Label = new javax.swing.JLabel();
        Public_Path_Label = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Plain_btn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Browse_plain_File.setText("Select Plain File");
        Browse_plain_File.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Browse_plain_FileActionPerformed(evt);
            }
        });

        Public_btn.setText("Select Public key");
        Public_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Public_btnActionPerformed(evt);
            }
        });

        Plain_Path_Label.setText("Path : ");

        Public_Path_Label.setText("Path :");

        jLabel3.setText("Encrypt Window");

        Plain_btn.setText("Encrypt");
        Plain_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Plain_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Plain_Path_Label)
                                    .addComponent(Public_btn)
                                    .addComponent(Browse_plain_File))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 98, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(Public_Path_Label)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Plain_btn))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)))
                .addGap(124, 124, 124))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(79, 79, 79)
                .addComponent(Browse_plain_File)
                .addGap(18, 18, 18)
                .addComponent(Plain_Path_Label)
                .addGap(26, 26, 26)
                .addComponent(Public_btn)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(Public_Path_Label)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                        .addComponent(Plain_btn)
                        .addGap(24, 24, 24))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Plain_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Plain_btnActionPerformed
       
        //AES part 
        // 1.generate AES Encryption key to be shared between sender and receiver ..
        try{
        SecretKey secKey = getSecretEncryptionKey();
        
        //2.read file plain text ...
        byte[] plainFile = readPlainFile(Plain_File_Path);
        
        //3. encrypt text using AES key ... 
        byte[] encryptedString = AES.encrypt(plainFile, new String (secKey.getEncoded()));
        
        //4.read public key of receiver ... 
        //byte[] publicKey = readPublicKey(Key_Path);
       
        //5.encrypt AES key using public key of receiver ...
           
        RSA.rsaEncrypt(Keys_Folder_Path+"AES.key",Keys_Folder_Path+"AES_encrypted.key",Key_Path);
        
        new DecryptWindow(Keys_Folder_Path).setVisible(true);
    }//GEN-LAST:event_Plain_btnActionPerformed

        catch (Exception ex){
            ex.printStackTrace();
        }
    }
    
    
    
    
    //Generate AES Key//
    
public static SecretKey getSecretEncryptionKey() throws Exception {
KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
keyGenerator.init(128);
SecretKey secKey = keyGenerator.generateKey();

String AES_Path = Keys_Folder_Path+"AES.key"; 

saveAESToFile(AES_Path , secKey.getEncoded());

return secKey;
}//end generate AES Key

//Save AES to file//
public static void saveAESToFile(String fileName, byte[] AESBytes)
throws IOException {
    
FileOutputStream fileOut = new FileOutputStream(fileName);
try { 
    fileOut.write(AESBytes);
    fileOut.flush();
} 
catch (Exception e) {
throw new IOException("Unexpected error");
} 
finally { 
    fileOut.close();
    System.out.println("Closed writing file."); }
}//end save AES file


// Read Plain File data //
public static byte[] readPlainFile(String plainPath) throws Exception {

    File file = new File(plainPath);
    byte filePlainContent[] = new byte[(int) file.length()];
    FileInputStream fin = null;
    
    try {
    // create FileInputStream object // 
    fin = new FileInputStream(plainPath);
    
    // Reads up to certain bytes of data from this input stream into an array of bytes.// 
    fin.read(filePlainContent);
    
    //create string from byte array
    String s = new String(filePlainContent); 
    System.out.println("File content: " + s);
    }
    
    catch (FileNotFoundException e) { 
        System.out.println(" File not found" + e);
    }
    catch (IOException ioe) {
    System.out.println("Exception while reading file " + ioe);
    }
    finally {
    // close the streams using close method 
    try {
    if (fin != null) { 
        fin.close();
    }
}
    catch (IOException ioe) {
            System.out.println("Error while closing stream: " + ioe);
            }
    }
    
    return filePlainContent; 
}

    
    
    
    
    private void Browse_plain_FileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Browse_plain_FileActionPerformed
        // select plain text file ..
        
        JFileChooser j = new JFileChooser(FileSystemView.getFileSystemView());
        
        int r = j.showOpenDialog(null);

        if (r == JFileChooser.APPROVE_OPTION) {
            Plain_File_Path = j.getSelectedFile().getAbsolutePath();
            Plain_Path_Label.setText(Plain_File_Path);
        } else {
            Plain_Path_Label.setText("No File selected.. ");

        }

        
        
    }//GEN-LAST:event_Browse_plain_FileActionPerformed

    private void Public_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Public_btnActionPerformed
           // select public key for receiver to encrypt secret key (AES) 
         
           JFileChooser j = new JFileChooser(FileSystemView.getFileSystemView());
        
        int r = j.showOpenDialog(null);

        if (r == JFileChooser.APPROVE_OPTION) {
            Key_Path = j.getSelectedFile().getAbsolutePath();
            Public_Path_Label.setText(Key_Path);
        } else {
            Public_Path_Label.setText("No File selected.. ");

        }
        
        
    }//GEN-LAST:event_Public_btnActionPerformed

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
            java.util.logging.Logger.getLogger(EncryptWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EncryptWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EncryptWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EncryptWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EncryptWindow(Keys_Folder_Path).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Browse_plain_File;
    private javax.swing.JLabel Plain_Path_Label;
    private javax.swing.JButton Plain_btn;
    private javax.swing.JLabel Public_Path_Label;
    private javax.swing.JButton Public_btn;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
