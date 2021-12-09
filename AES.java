import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.io.BufferedInputStream; 
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.Key;
import java.security.KeyFactory; 
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey; 
import java.security.PublicKey;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec; 
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream; 
import javax.crypto.CipherOutputStream ;


public class AES {
private static SecretKeySpec secretKey;
private static byte[] key;
private static String Path = "E:\\project\\";
public static void setKey(String myKey) {
    
    try {
key = myKey.getBytes("UTF-8");
key = Arrays.copyOf(key, 16);
secretKey = new SecretKeySpec(key, "AES");
}
    catch (UnsupportedEncodingException e) { e.printStackTrace();
}
}

public static byte[] encrypt(byte[] strToEncrypt, String secret) {
    
    try {
setKey(secret);
Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding"); 
cipher.init(Cipher.ENCRYPT_MODE, secretKey);
byte[] cipherText = cipher.doFinal(strToEncrypt);

//Save Encrypted File..
FileOutputStream fileOut = new FileOutputStream(Path+"cipher.enc");
try { 
    fileOut.write(cipherText);
    fileOut.flush();
}


    
 catch (Exception e) {
throw new IOException("Unexpected error");
} 
    finally {
fileOut.close(); 
System.out.println("Closed writing file.");
}
    
    return cipherText; 
}

catch (Exception e) {
System.out.println("Error while encrypting: " + e.toString());
}
return null; 

}

public static byte[] decrypt(byte[] strToDecrypt, String secret) throws IOException {
FileOutputStream fileOut = null; 
try{
setKey(secret);
Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING"); 
cipher.init(Cipher.DECRYPT_MODE, secretKey);
byte[] Decrypt_str = cipher.doFinal(strToDecrypt);

//Save Encrypted File..
fileOut = new FileOutputStream(Path+"AES_encrypted.key");
fileOut.write(Decrypt_str);
fileOut.flush();
return Decrypt_str ;
}
catch (Exception e) {
System.out.println("Error while decrypting: " + e.toString());
fileOut.close(); 
}
return null;
}

}





   
