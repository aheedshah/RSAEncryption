import java.math.BigInteger;
import java.util.Scanner;

public class menu4 {
	void Menu4() {
		System.out.println("Communication Simulation");

		Scanner scan = new Scanner(System.in);
		BigInteger palicem4;
		BigInteger qalicem4;
		generator algenerator1 = new generator();
		generator algenerator2 = new generator();
		palicem4 = algenerator1.generate();
		qalicem4 = algenerator2.generate();

		// Create public and private keys
		key alkey = new key(palicem4, qalicem4);
		System.out.println("Alice Key: ");
		alkey.keys();

		BigInteger pbobm4;
		BigInteger qbobm4;
		generator bgenerator1 = new generator();
		generator bgenerator2 = new generator();

		pbobm4 = bgenerator1.generate();
		qbobm4 = bgenerator2.generate();

		// Create public and private keys
		key bkey = new key(pbobm4, qbobm4);
		System.out.println("Bob Key: ");
		bkey.keys();
		System.out.println();

		// Alice to Bob

		System.out.println("*************** Alice ***************");
		System.out.println("Input Alice Message: ");
		String encryptalicemess1 = scan.nextLine();

		encryption encryptmess1 = new encryption(bkey.n, encryptalicemess1);
		encryptmess1.en();
		System.out.println();

		// Interception by Charlie
		System.out.println("Charlie intercepts length of message: " + encryptmess1.message.size() + " characters.");

		// Decryption by Bob
		System.out.println();
		System.out.println("*************** Bob ***************");
		System.out.println("Bob gets encrypted message: ");
		encryptmess1.messageEncrypted();
		System.out.println("Copy and Paste the encrypted message received by Bob: ");
		String encryptedm1 = scan.nextLine();
		String[] decryptionm1 = encryptedm1.split(" ");
		decryption decryptmess1 = new decryption(bkey.d, bkey.n, decryptionm1);

		decryptmess1.en();
		System.out.println();

		// Bob's message to Alice

		System.out.println("Response to Alice: ");

		String encryptbobmess2 = scan.nextLine();
		encryption encryptmess2 = new encryption(alkey.n, encryptbobmess2);
		encryptmess2.en();
		System.out.println();

		// Interception bu Charlie
		System.out.println("Charlie intercepts length of message: " + encryptmess2.message.size() + " characters.");

		// Decryption by Alice

		System.out.println();
		System.out.println("*************** Alice ***************");
		System.out.println("Alice gets an encrypted message: ");
		encryptmess2.messageEncrypted();
		System.out.println("Copy and Paste the enrypted message sent by Bob: ");
		String encryptedm2 = scan.nextLine();
		String[] decryptionm2 = encryptedm2.split(" ");
		decryption decryptmess2 = new decryption(alkey.d, alkey.n, decryptionm2);

		decryptmess2.en();
		System.out.println();

		// Alice response to Bob

		System.out.println("Response to Bob: ");

		String encryptbobmess3 = scan.nextLine();
		encryption encryptmess3 = new encryption(bkey.n, encryptbobmess3);
		encryptmess3.en();
		System.out.println();

		// Interception by Charlie
		System.out.println("Charlie intercepts length of message: " + encryptmess3.message.size() + " characters.");

		// Bob Decrypts Alice Message

		System.out.println();
		System.out.println("*************** Bob ***************");
		System.out.println("Bob gets encrypted message: ");
		System.out.println("Copy and Paste the encrypted message received by Bob: ");
		String encryptedm4 = scan.nextLine();
		String[] decryptionm4 = encryptedm4.split(" ");
		decryption decryptmess4 = new decryption(bkey.d, bkey.n, decryptionm4);

		decryptmess4.en();
		System.out.println();

		System.out.println("*************** Information Charlie Has ***************");
		System.out.println("Public Key of Alice");
		System.out.println("Public Key of Bob");
		System.out.println("Length of the messages");
		System.out.println("Number of characters that are identical");
		System.out.println(
				"Charlie can guess most identical characters and verify using the ASCII codes and public key.");
	}
}
