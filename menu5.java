
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

public class menu5 {
	void Menu5() {
		System.out.println("Needham Schroeader Protocol");

		// Creating Alice Key as Primes
		BigInteger alicep;
		BigInteger aliceq;

		// Enumerate public and private keys
		generator aliceGenerator1 = new generator();
		generator aliceGenerator2 = new generator();
		alicep = aliceGenerator1.generate();
		aliceq = aliceGenerator2.generate();
		key alicekey = new key(alicep, aliceq);

		System.out.println("Alice Key: ");
		alicekey.keys();
		System.out.println();

		// Creating Server Key as Primes
		BigInteger serverp;
		BigInteger serverq;

		// Enumerate public and private keys
		generator serverGenerator1 = new generator();
		generator serverGenerator2 = new generator();
		serverp = serverGenerator1.generate();
		serverq = serverGenerator2.generate();
		key serverkey = new key(serverp, serverq);

		System.out.println("Servers Key: ");
		serverkey.keys();
		System.out.println();

		// Creating Bob Key as Primes
		BigInteger bobp;
		BigInteger bobq;

		// Enumerate public and private keys
		generator bobGenerator1 = new generator();
		generator bobGenerator2 = new generator();
		bobp = bobGenerator1.generate();
		bobq = bobGenerator2.generate();
		key bobkey = new key(bobp, bobq);

		System.out.println("Bob Key: ");
		bobkey.keys();
		System.out.println();

		System.out.println("*************** Server Screen ***************");
		System.out.println("Alice requests Bobs public key from server.");
		System.out.println();

		System.out.println("*************** Alice Screen ***************");
		System.out.println("Alice received an encrypted message.");
		String serverAmessage = "Server sends Bob public key: " + bobkey.n.toString()
				+ " signed by server.";

		// Encryption of Servers message
		encrypt2 Serverencrypt2 = new encrypt2(serverkey.d, serverkey.n, serverAmessage);
		Serverencrypt2.en();

		System.out.println("Alice, Decrypt servers message using the public key of server.");

		System.out.println("Enter the encrypted message received: ");
		Scanner scan = new Scanner(System.in);
		String serverEncrypted = scan.nextLine();
		String[] serverParts = serverEncrypted.split(" ");

		System.out.println("Public key of server: ");
		serverkey.keys();

		System.out.println("Enter Servers public key: ");
		System.out.println();
		BigInteger serverPublicK = scan.nextBigInteger();
		decrypt2 serverdecrypt2 = new decrypt2(serverPublicK, serverParts);

		serverdecrypt2.en();
		System.out.println(" ");

		System.out.println("--------------------------------------------------------------");
		System.out.println("Alice has Bob key.");
		System.out.println("Assuming Alice uses Bob Public Key for sending message to Bob.");
		System.out.println("Enter message that needs to be sent to Bob: ");
		Scanner scan2 = new Scanner(System.in);

		// Message sent to Alice as input from user
		String aliceMessage;
		aliceMessage = scan2.nextLine();

		// Encrypting using the public key of Bob
		encryption bobEncrypt = new encryption(bobkey.n, aliceMessage);
		System.out.println();

		System.out.println("*************** Bob Screen ***************");
		System.out.println("Bob received an encrypted message.");

		bobEncrypt.en();
		System.out.println("");

		// Print encrypted Alice message using Bob Public Key
		System.out.println("--------------------------------------------------------------");
		System.out.println("BOB! Decrypt message using your Private Key.");
		System.out.println("Input encrypted message ");

		String AliceEncrypted;
		AliceEncrypted = scan2.nextLine();
		String[] AliceParts = AliceEncrypted.split(" ");
		System.out.println("here: " + AliceParts[0]);

		System.out.println("Bob Keys: ");
		bobkey.keys();

		System.out.println("Enter Bob Public Key: ");
		BigInteger bobPublic = scan.nextBigInteger();
		System.out.println("Enter Bob Private Key: ");
		BigInteger bobPrivate = scan.nextBigInteger();

		// Decrypting message through Alice Parts using Public and Private Keys
		decryption bob2decrypt = new decryption(bobPrivate, bobPublic, AliceParts);
		bob2decrypt.en();
		System.out.println(" ");
		System.out.println("*************** Server Screen ***************");
		System.out.println("Bob requesting Alice public key from Server.");
		System.out.println(" ");

		System.out.println("*************** Bob Screen ***************");
		System.out.println("Bob received an encrypted message.");
		String serverBmessage = "Server sending Alice Public Key: " + alicekey.n.toString()
				+ " signed by server.";


		// Encryption of message through server message using keys of server
		encrypt2 ServerBencrypt2 = new encrypt2(serverkey.d, serverkey.n, serverBmessage);
		ServerBencrypt2.en();

		System.out.println("BOB! Decrypt servers message using the public key of server.");

		System.out.println("Input Encrypted message received. ");
		Scanner scan3 = new Scanner(System.in);
		String ServerBencrypted = scan3.nextLine();

		String[] serverBparts = ServerBencrypted.split(" ");
		serverkey.publicKeys();

		System.out.println("Enter public key of Server. ");
		BigInteger serverBpublicK = scan.nextBigInteger();

		// Decryption of message using servers keys
		decrypt2 serverBdecrypt2 = new decrypt2(serverBpublicK, serverBparts);
		serverBdecrypt2.en();
		System.out.println(" ");

		System.out.println("--------------------------------------------------------------");
		System.out.println("Bob has Alice Key.");
		System.out.println("Assume Bob uses Alice Public Key for sending Alice a message.");
		System.out.println("Enter message to be sent to Alice.");

		Scanner scan4 = new Scanner(System.in);
		String bobmessage;
		bobmessage = scan4.nextLine();

		// Encrypt using Alice Public Key
		encryption alice3encrypt = new encryption(alicekey.n, bobmessage);

		System.out.println("*************** Alice Screen ***************");
		System.out.println("Alice got an encrypted message.");

		alice3encrypt.en();
		System.out.println("");

		System.out.println("Input the encrypted message received to decrypt: ");

		Scanner scan5 = new Scanner(System.in);
		String bob4encrypted = scan5.nextLine();
		String[] bobparts = bob4encrypted.split(" ");

		System.out.println("Own Keys: ");
		alicekey.keys();

		System.out.println("Enter your Public Key: ");
		BigInteger AprivK = scan.nextBigInteger();
		System.out.println("Enter your Private Key: ");
		BigInteger ApubK = scan.nextBigInteger();

		// Decryption using Alice Public and Private Keys
		decryption alice4decrypt = new decryption(ApubK, AprivK, bobparts);

		System.out.println("Decrypted Message: ");
		alice4decrypt.en();
		System.out.println(" ");

		System.out.println("Alice, Enter message to be sent to Bob: ");

		String bob2message;
		Scanner scan6 = new Scanner(System.in);
		bob2message = scan6.nextLine();

		// Encryption using Bob Public Key
		encryption bob3encrypt = new encryption(bobkey.n, bob2message);

		System.out.println("*************** Bob Screen ***************");
		System.out.println("Bob gets an encrypted message.");

		bob3encrypt.en();
		System.out.println("");

		System.out.println("--------------------------------------------------------------");
		System.out.println("Bob! Decrypt the message received.");
		System.out.println("Enter the encrypted message obtained: ");

		String bob5encrypted = scan6.nextLine();
		String[] bob5parts = bob5encrypted.split(" ");

		System.out.println("Bob Key: ");
		bobkey.keys();

		System.out.println("Enter your Public Key: ");
		BigInteger BpubK = scan.nextBigInteger();
		System.out.println("Enter your Private Key: ");
		BigInteger BprivK = scan.nextBigInteger();

		// Decryption using Bob Public and Private Keys
		decryption bob5decrypt = new decryption(BprivK, BpubK, bob5parts);

		System.out.println("Decrypted message.");
		bob5decrypt.en();
		System.out.println(" ");

		System.out.println("--------------------------------------------------------------");

	}
}