import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException; import java.util.Scanner;
public class MD5Hashing {
    public static String getMD5Hash(String input) { try {
        MessageDigest md = MessageDigest.getInstance("MD5"); byte[] messageDigest = md.digest(input.getBytes()); StringBuilder hexString = new StringBuilder();
        for (byte b : messageDigest) { hexString.append(String.format("%02x", b));
        }
        return hexString.toString();
        } catch (NoSuchAlgorithmException e) { throw new RuntimeException(e);
    }
    }
    public static void main(String[] args) { Scanner scanner = new Scanner(System.in);
    System.out.print("Enter text to hash using MD5: "); String text = scanner.nextLine();
    scanner.close();
    String hash = getMD5Hash(text); System.out.println("MD5 Hash: " + hash);
    }
    }
