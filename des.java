import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator; 
import javax.crypto.SecretKey;

public class DESAlgorithm {
    public static void main(String[] args) throws Exception { KeyGenerator keyGenerator = KeyGenerator.getInstance("DES"); SecretKey secretKey = keyGenerator.generateKey();
    Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding"); String plainText = "Hello, World!";
    System.out.println("Original Text: " + plainText);
    cipher.init(Cipher.ENCRYPT_MODE, secretKey);
    byte[] encryptedBytes = cipher.doFinal(plainText.getBytes());
    String encryptedText = Base64.getEncoder().encodeToString(encryptedBytes); System.out.println("Encrypted Text: " + encryptedText); cipher.init(Cipher.DECRYPT_MODE, secretKey);
    byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedText)); String decryptedText = new String(decryptedBytes);
    System.out.println("Decrypted Text: " + decryptedText);
    }
}

