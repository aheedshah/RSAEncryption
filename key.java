import java.math.BigInteger;
public class key {
	BigInteger p;
	BigInteger q;
	BigInteger phi;
	BigInteger n;
	BigInteger e = BigInteger.valueOf(65537);
	BigInteger d;
	key(BigInteger p, BigInteger q) {
		this.p = p;
		this.q = q;
		this.n = p.multiply(q);
		this.phi = (p.subtract(BigInteger.valueOf(1)).multiply(q.subtract(BigInteger.valueOf(1))));
		this.d = e.modInverse(this.phi);
	}

	void keys() {
		System.out.println("Public Key(" + n + "," + e + ")");
		System.out.println("Private Key(" + n + "," + d + ")");
	}

	void publicKeys() {
		System.out.println("Public Key(" + n + "," + e + ")");
	}
}