# XSecure
secure file-sharing application.

# Introduction 
XSecure application is designed to secure file-sharing that software to encrypt the file and send it over the internet using both symmetric and asymmetric key approaches. to implement an AES encryption/decryption first, then use RSA to encrypt/decrypt the symmetric key.

# Tools and Technologies
we used [Java](https://www.oracle.com/java/) programming language, to writing Java applications needs development tools like the JDK. The JDK includes the Java Runtime Environment, the Java compiler and the Java APIs. [Visual Studio Code](https://code.visualstudio.com) to write the programming code. 
# Graphic user interface 
Login, Encrypt and Decrypt   

#  The specifications the application 

1.	A GUI application where a user have to login with a user name and password. the application store the password securely.
2.	the application has different menus for different operations.
3.	Each user generates their pair of private and public key. the public key is Published and keep the private key a secret.
4.	the application is Generate a symmetric-key to use in the encryption of the file using AES.
5.	the application it Use the RSA algorithm to encrypt the symmetric-key used in step 2 using the receiver’s public key.
6.	The receiver uses its own private key to decrypt the symmetric key, and then uses that symmetric key to decrypt the file.
7.	The private key is stored securely in a protected file.

# Scenario Example 

•	Bob wants to send Alice a file securely.

•	Bob must log into the application with his username and password if registered. If not, Bob must create a username and password.

•	If registered for the first time, Bob must generate the pair of key’s (Public key and Private key). Publish the public key and keep the private key secret.

•	To send the file to Alice, Bob generates a random key from the application to use in the encryption process of the file using AES. After the file encryption is done, Bob uses Alice’s Published public key to encrypt the key using RSA and sends the file with the encrypted key.

•	When Alice receives the file, she must log into the application and uses her stored private key to decrypt the RSA encrypted key. After that she uses the decrypted key to decrypt the file.

# Detailed description of application design and implementation 

* Overview of the app design
 
 AES : create Encrypt and decrypt keys.
 
 RSA : create public and Private keys.
 
 Login window : login users.
 
 Encrypt the massage by AES algorithm with Alice public key. 
 
 Decryption window: decrypt the massage by AES algorithm with Alice private key.
 
 
<img width="800" alt="Picture0" src="https://user-images.githubusercontent.com/86910279/145344098-4c9f2bcb-00c1-4124-85e0-67bcf75517ec.png">


# Approach and steps to implementation 

* Login window : create public and private keys for user.

<img width="542" alt="Picture1" src="https://user-images.githubusercontent.com/86910279/145344760-db3a936b-4dec-4ae7-aed7-4d7e5a77f167.png">


* Encrypt window :
1. .generate AES Encryption key to be shared between sender and receiver.
2. read the plain text .
3. encrypt plain text using AES key.
4. encrypt AES key using public key of Alice.
<img width="542" alt="Picture2" src="https://user-images.githubusercontent.com/86910279/145344955-6cc7b508-a268-486f-a9d5-bba4478438ed.png">


* Decrypt window :
1. decrypt AES key using receiver private key.
2. read AES key.
3. read cipher text.
4. start AES decryption process.
5. Print the result.
<img width="542" alt="Picture3" src="https://user-images.githubusercontent.com/86910279/145345363-a1598bab-851f-41d3-a627-1f9e18bb9359.png">


* The private key is stored securely in a protected file.
<img width="542" alt="Picture4" src="https://user-images.githubusercontent.com/86910279/145346590-85485484-d1e9-4887-9a0b-5b9fd27bc56c.png">

# Challenges
* Store byte Array in file RSA,AES.
* Use big integer.
* Arrange steps for encryption and decryption.


