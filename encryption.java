import java.math.BigInteger;
import java.util.ArrayList;

public class encryption {
	BigInteger e = BigInteger.valueOf(65537);
	BigInteger n;
	String m;
	ArrayList<BigInteger> mess;
	int ascii;
	ArrayList<BigInteger> message = new ArrayList<>();
	ArrayList<BigInteger> encrypt = new ArrayList<>();
	encryption(BigInteger n, String m) {
		this.n = n;
		this.m = m;
	}
	void en() {
		// Obtain ASCII for every char and populate in array mess.
		for (int i = 0; i < m.length(); i++) {
			ascii = m.charAt(i);
			BigInteger a = BigInteger.valueOf(ascii);
			message.add(a);
		}

		// Run through array mess.
		// Encrypt ASCII code.
		for (BigInteger bigInteger : message) {
			encrypt.add(bigInteger.modPow(this.e, this.n));
		}
		System.out.println();
		System.out.println("Message has been encrypted: ");
		for (BigInteger bigInteger : encrypt) {
			System.out.print(bigInteger + " ");
		}
		System.out.println();

	}

	void messageEncrypted() {
		for (BigInteger bigInteger : encrypt) {
			System.out.print(bigInteger + " ");
		}
		System.out.println();

	}

	void printDetails() {
		for (int j = 0; j < message.size(); j++) {
			encrypt.add(message.get(j).modPow(this.e, this.n));
			System.out.println(m.charAt(j) + " : ASCII----> " + message.get(j) + " encrypt -----> (" + message.get(j) + "^"
					+ this.e + ") mod " + n + "=" + message.get(j).modPow(this.e, this.n));

		}
		System.out.println();
		System.out.println();
		System.out.println();

	}
}