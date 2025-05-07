import java.security.*; import java.util.Base64;
import javax.crypto.KeyAgreement;
import javax.crypto.interfaces.DHPublicKey; import javax.crypto.spec.DHParameterSpec;

public class DiffieHellmanKeyExchange {
  public static void main(String[] args) throws Exception {
    KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("DH"); keyPairGenerator.initialize(2048);
    KeyPair aliceKeyPair = keyPairGenerator.generateKeyPair();
    DHParameterSpec dhParamSpec = ((DHPublicKey) aliceKeyPair.getPublic()).getParams(); keyPairGenerator.initialize(dhParamSpec);
    KeyPair bobKeyPair = keyPairGenerator.generateKeyPair(); KeyAgreement aliceKeyAgree = KeyAgreement.getInstance("DH"); aliceKeyAgree.init(aliceKeyPair.getPrivate()); aliceKeyAgree.doPhase(bobKeyPair.getPublic(), true);
    byte[] aliceSharedSecret = aliceKeyAgree.generateSecret(); KeyAgreement bobKeyAgree = KeyAgreement.getInstance("DH"); bobKeyAgree.init(bobKeyPair.getPrivate()); bobKeyAgree.doPhase(aliceKeyPair.getPublic(), true);
    byte[] bobSharedSecret = bobKeyAgree.generateSecret(); System.out.println("Alice's Shared Secret: " +
    Base64.getEncoder().encodeToString(aliceSharedSecret)); System.out.println("Bob's Shared Secret: " +
    Base64.getEncoder().encodeToString(bobSharedSecret));
    }
}
