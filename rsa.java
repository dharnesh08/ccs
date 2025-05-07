import java.security.*; import java.util.Base64; import javax.crypto.Cipher;

public class RSAAlgorithm {
public static void main(String[] args) throws Exception {
KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA"); keyPairGenerator.initialize(2048);
    KeyPair keyPair = keyPairGenerator.generateKeyPair(); 
    PrivateKey privateKey = keyPair.getPrivate(); PublicKey publicKey = keyPair.getPublic();
    String plainText = "Hello, RSA!"; System.out.println("Original Text: " + plainText); Cipher cipher = Cipher.getInstance("RSA"); cipher.init(Cipher.ENCRYPT_MODE, publicKey);
    byte[] encryptedBytes = cipher.doFinal(plainText.getBytes());
    String encryptedText = Base64.getEncoder().encodeToString(encryptedBytes); System.out.println("Encrypted Text: " + encryptedText); cipher.init(Cipher.DECRYPT_MODE, privateKey);
    byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedText)); String decryptedText = new String(decryptedBytes);
    System.out.println("Decrypted Text: " + decryptedText);
    }
}

