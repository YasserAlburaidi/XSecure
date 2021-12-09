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

public class RSA {
    
    // Return the saved key
static Key readKeyFromFile(String keyFileName) throws IOException {
InputStream in = new FileInputStream(keyFileName);
ObjectInputStream oin = new ObjectInputStream(new BufferedInputStream(in));

try {
BigInteger m = (BigInteger) oin.readObject(); 
BigInteger e = (BigInteger) oin.readObject(); 
KeyFactory fact = KeyFactory.getInstance("RSA");

if (keyFileName.substring(keyFileName.length()-10).equals("public.key")) 
    return fact.generatePublic(new RSAPublicKeySpec(m, e));
else
return fact.generatePrivate(new RSAPrivateKeySpec(m, e));
}
catch (Exception e) {
throw new RuntimeException("Error", e); } 
finally {
oin.close();
System.out.println("Closed reading RSA Key file.");
   } 
}

    
// Use this PublicKey object to initialize a Cipher and encrypt some data
public static void rsaEncrypt(String file_loc, String file_des, String Key_Path)
throws Exception {
FileReader file = new FileReader(file_loc);//AES Key
BufferedReader reader = new BufferedReader(file);
String text = "";
String line = reader.readLine();
while (line != null) {
text += line;
line = reader.readLine(); }


reader.close();
File file2 = new File(file_loc);

byte[] data = new byte[(int) file2.length()]; 
int i;
System.out.println("start RSA encyption"); Key pubKey = readKeyFromFile(Key_Path); 
Cipher cipher = Cipher.getInstance("RSA");
cipher.init(Cipher.ENCRYPT_MODE, pubKey);

FileInputStream fileIn = new FileInputStream(file_loc);
FileOutputStream fileOut = new FileOutputStream(file_des); 
CipherOutputStream cipherOut = new CipherOutputStream(fileOut, cipher);
// Read in the data from the file and encrypt it 
while ((i = fileIn.read(data)) != -1) {
cipherOut.write(data, 0, i); }


// Close the encrypted file 
cipherOut.close(); 
fileIn.close();
System.out.println("encrypted file created"); }

// Use this PublicKey object to initialize a Cipher and decrypt some data 
public static void rsaDecrypt(String file_loc, String file_des, String Key_Path)
throws Exception {
File file2 = new File(file_loc);
byte[] data = new byte[(int) file2.length()];
int i;
System.out.println("start RSA decyption");

Key priKey = readKeyFromFile(Key_Path); Cipher cipher = Cipher.getInstance("RSA");
cipher.init(Cipher.DECRYPT_MODE, priKey);
FileInputStream fileIn = new FileInputStream(file_loc); 
CipherInputStream cipherIn = new CipherInputStream(fileIn, cipher); 
FileOutputStream fileOut = new FileOutputStream(file_des);

// Write data to new file
while ((i = cipherIn.read()) != -1) {
fileOut.write(i); }

// Close the file
fileIn.close();
cipherIn.close();
fileOut.close(); System.out.println("decrypted file created");
} 





}
