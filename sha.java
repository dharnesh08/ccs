import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException; import java.util.Scanner;

public class SHA1Hash {
    public static String calculateSHA1(String text) { try {
    MessageDigest md = MessageDigest.getInstance("SHA-1"); byte[] messageDigest = md.digest(text.getBytes()); StringBuilder hexString = new StringBuilder();
    for (byte b : messageDigest) { hexString.append(String.format("%02x", b));
    }
    return hexString.toString();
    } catch (NoSuchAlgorithmException e) {
    throw new RuntimeException("SHA-1 Algorithm not found!", e);
    }
    }
    public static void main(String[] args) { Scanner sc = new Scanner(System.in); System.out.print("Enter text to hash: "); String text = sc.nextLine();
    String sha1Hash = calculateSHA1(text); System.out.println("SHA-1 Hash: " + sha1Hash); sc.close();
    }
    }
