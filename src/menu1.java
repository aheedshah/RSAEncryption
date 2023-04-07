import java.math.BigInteger;
import java.util.Scanner;

public class menu1 {
	// Encryption of message using public and private keys
	void Menu1() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Below are the keys generated:");
		// Create public and private keys
		generator generator = new generator();
		generator generator2 = new generator();
		BigInteger pbis = generator.generate(), qbis = generator2.generate();
		key key = new key(pbis, qbis);
		key.keys();
		// Printing that encryption will be done using the generated key.
		System.out.println();
		System.out.println();
		System.out.println(" Enter the message for encryption using the key and press Enter Key: ");
		System.out.println("--------------------------------------------------------------");
		// Message is entered that is to be encrypted
		String message = sc.nextLine();
		// Object is created to call encryption method
		encryption encrypt = new encryption(key.n, message);
		encrypt.en();
		encrypt.printDetails();
	}
}
