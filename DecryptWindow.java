


import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;

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
import javax.crypto.spec.SecretKeySpec;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;



public class DecryptWindow extends javax.swing.JFrame {

    /**
     * Creates new form DecryptWindow
     */
    
    String Encrypted_File_Path = "";
    String  Key_Path = "";
    static String Keys_Folder_Path = "";
    
    
    public DecryptWindow(String Keys_Folder_Path) {
        initComponents();
        this.Keys_Folder_Path = Keys_Folder_Path;
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        Cipher_btn = new javax.swing.JButton();
        Private_btn = new javax.swing.JButton();
        Cippher_Label = new javax.swing.JLabel();
        private_label = new javax.swing.JLabel();
        Decrypt_btn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Decrypt Window");

        Cipher_btn.setText("Cipher File");
        Cipher_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cipher_btnActionPerformed(evt);
            }
        });

        Private_btn.setText("Private Key");
        Private_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Private_btnActionPerformed(evt);
            }
        });

        Cippher_Label.setText("Path :");

        private_label.setText("Path :");

        Decrypt_btn.setText("Decrypt");
        Decrypt_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Decrypt_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(142, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(156, 156, 156))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(Decrypt_btn)
                        .addGap(110, 110, 110))))
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Cippher_Label)
                    .addComponent(Private_btn)
                    .addComponent(Cipher_btn)
                    .addComponent(private_label))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(51, 51, 51)
                .addComponent(Cipher_btn)
                .addGap(18, 18, 18)
                .addComponent(Cippher_Label)
                .addGap(41, 41, 41)
                .addComponent(Private_btn)
                .addGap(27, 27, 27)
                .addComponent(private_label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Decrypt_btn)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Cipher_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cipher_btnActionPerformed

//select encrypted key using AES// 

   JFileChooser j = new JFileChooser(FileSystemView.getFileSystemView());
        
        int r = j.showOpenDialog(null);

        if (r == JFileChooser.APPROVE_OPTION) {
            Encrypted_File_Path = j.getSelectedFile().getAbsolutePath();
            Cippher_Label.setText(Encrypted_File_Path);
        } else {
            Cippher_Label.setText("No File selected.. ");

        }




    }//GEN-LAST:event_Cipher_btnActionPerformed

    private void Private_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Private_btnActionPerformed
        // TODO add your handling code here:
        
        //selected receiver private key 
        
         JFileChooser j = new JFileChooser(FileSystemView.getFileSystemView());
        
        int r = j.showOpenDialog(null);

        if (r == JFileChooser.APPROVE_OPTION) {
            Key_Path = j.getSelectedFile().getAbsolutePath();
            private_label.setText(Key_Path);
        } else {
            private_label.setText("No File selected.. ");

        }

        
        
    }//GEN-LAST:event_Private_btnActionPerformed

    private void Decrypt_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Decrypt_btnActionPerformed
        // TODO add your handling code here:
        
        //1.decrypt AES key using receiver private key 
        try{
        RSA.rsaDecrypt(Keys_Folder_Path+"AES_encrypted.key",Keys_Folder_Path+"AES_decrypted.key",Key_Path);
        
        //2.read AES key ... 
        SecretKey AESKey = readAESKey(Keys_Folder_Path+"AES_decrypted.key");
        
        //3.read encrypted file key 
        byte[] EncryptedFile = readEncryptedFile(Encrypted_File_Path);
        
        //4.start AES decryption process 
        byte[] decryptedString = AES.decrypt(EncryptedFile, new String (AESKey.getEncoded()));
        
        //5.print the result 
            System.out.println("Decrypted Text: "+ new String (decryptedString));
        
        
    }//GEN-LAST:event_Decrypt_btnActionPerformed
         catch (Exception ex){
            ex.printStackTrace();
        }
    }
    /**
     * @param args the command line arguments
     */
    
    public static SecretKey readAESKey(String AESKeyPath) throws Exception {
 
        File file = new File(AESKeyPath);
        byte filePlainContent[] = new byte[(int) file.length()];
        FileInputStream fin = null;
        SecretKey originalKey = null;

 try {
 // create FileInputStream object
 fin = new FileInputStream(AESKeyPath);
 // Reads up to certain bytes of data from this input stream into an array of bytes.
 fin.read(filePlainContent);
 
 originalKey = new SecretKeySpec(filePlainContent, 0, filePlainContent.length, "AES"); 
 System.out.println("AES File content: " + filePlainContent.length);
 
 }
 catch (FileNotFoundException e) {
 System.out.println("AES File not found" + e);
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
    return originalKey;
 }//end readAESKey
    
    
     public static byte[] readEncryptedFile(String plainPath) throws Exception {
 File file = new File(plainPath);
 byte filePlainContent[] = new byte[(int) file.length()];
 FileInputStream fin = null;
 try {
 // create FileInputStream object
 fin = new FileInputStream(plainPath);
 // Reads up to certain bytes of data from this input stream into an array of bytes.
 fin.read(filePlainContent);
 fin.close();
 //create string from byte array
 String s = new String(filePlainContent);
 System.out.println("Read Encrypted File: " + s);

 } catch (FileNotFoundException e) {
 System.out.println(" File not found" + e);
 } catch (IOException ioe) {
 System.out.println("Exception while reading file " + ioe);
 } finally {
 // close the streams using close method
 try {
 if (fin != null) {
 fin.close();
 }
 } catch (IOException ioe) {
 System.out.println("Error while closing stream: " + ioe);
 }
 }
 return filePlainContent;
 }

    
    
    
    
    
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
            java.util.logging.Logger.getLogger(DecryptWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DecryptWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DecryptWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DecryptWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DecryptWindow(Keys_Folder_Path).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Cipher_btn;
    private javax.swing.JLabel Cippher_Label;
    private javax.swing.JButton Decrypt_btn;
    private javax.swing.JButton Private_btn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel private_label;
    // End of variables declaration//GEN-END:variables
}
