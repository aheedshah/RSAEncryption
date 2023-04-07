import java.math.BigInteger;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;

public class decryption {
	BigInteger n;
	BigInteger p;
	String[] m;
	ArrayList<Character> mess = new ArrayList<>();
	ArrayList<BigInteger> decrypt = new ArrayList<>();
	int ascii;
	decryption(BigInteger p, BigInteger n, String[] m) {
		this.n = n;
		this.m = m;
		this.p = p;
	}

	void en() {
		// Do calculation for every bit for decryption in ASCII formula
		for (String s : m) {
			BigInteger alpha = new BigInteger(s);
			alpha = alpha.modPow(p, n);
			decrypt.add(alpha);
		}

		// Print every calculation for ASCII code
		// Give character corresponding to the ASCII Code
		for (BigInteger bigInteger : decrypt) {
			int b = bigInteger.intValue();
			char dec = (char) b;
			mess.add(dec);
		}

		System.out.println();
		System.out.println("Message has been decoded:");

		// Printing the decoded message
		for (Character character : mess) {
			System.out.print(character);

		}
		System.out.println();
		System.out.println();
	}
}