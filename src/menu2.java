import java.math.BigInteger;
import java.util.Scanner;

public class menu2 {
	void Menu2() {
		System.out.println("Enter the encrypted message below:");
		System.out.println();
		System.out.println("An example of a encrypted message is:");
		System.out.println("2285 50838 45775 45775 67893 33483 48715 30145 33483 27066 16600 49867");
		System.out.println(" ");
		System.out.println("Please the encrypted message generated or your own one.");
		System.out.println("Spaces between messages should remain.");
		System.out.println();
		System.out.println("----------INPUT BELOW THIS LINE----------");

		Scanner scan = new Scanner(System.in);
		String encrypted = scan.nextLine();
		String[] parts = encrypted.split(" ");

		System.out.println("Enter Private Key: ");
		BigInteger privateK = scan.nextBigInteger();
		System.out.println("Enter Public Key: ");

		BigInteger publicK = scan.nextBigInteger();
		decryption decrypt = new decryption(privateK, publicK, parts);
		decrypt.en();
	}
}
