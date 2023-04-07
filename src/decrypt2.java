import java.math.BigInteger;
import java.util.ArrayList;

public class decrypt2 {

	BigInteger e = BigInteger.valueOf(65537);
	BigInteger n;
	String[] m;

	decrypt2(BigInteger n, String[] m) {
		this.n = n;
		this.m = m;
	}

	void en() {
		ArrayList<BigInteger> decrypt = new ArrayList<>();
		// Bit calculation for decryption
		for (String s : m) {
			BigInteger alpha = new BigInteger(s);
			// Using e for decryption of message with n
			decrypt.add(alpha.modPow(this.e, this.n));
		}

		// Printing every calculation for ASCII code and give the character corresponding to ASCII code
		for (BigInteger bigInteger : decrypt) {
			int b = bigInteger.intValue();
			char dec = (char) b;
			System.out.print(dec);
		}

	}
}
