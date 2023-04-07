import java.math.BigInteger;
import java.util.ArrayList;

public class encrypt2 {
	BigInteger e = BigInteger.valueOf(65537);
	BigInteger n;
	BigInteger d;
	String m;
	ArrayList<BigInteger> mess;
	int ascii;
	// Input elements: Decrypt, Encrypt & Message
	encrypt2(BigInteger d, BigInteger n, String m) {
		this.n = n;
		this.m = m;
		this.d = d;
	}

	void en() {
		ArrayList<BigInteger> message = new ArrayList<>();
		ArrayList<BigInteger> encrypt = new ArrayList<>();
		// Obtain ASCII for every character and populate in array mess
		for (int i = 0; i < m.length(); i++) {
			ascii = m.charAt(i);
			BigInteger a = BigInteger.valueOf(ascii);
			message.add(a);

		}
		// Run through the mess array.
		// Encrypt ASCII Code.
		for (BigInteger bigInteger : message) {
			encrypt.add(bigInteger.modPow(this.d, this.n));

		}

		for (BigInteger bigInteger : encrypt) {
			System.out.print(bigInteger + " ");
		}

		System.out.println();

	}
}