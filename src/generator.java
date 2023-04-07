import java.math.BigInteger;
import java.util.ArrayList;

public class generator {
	public BigInteger p;
	public int a;
	public int b;
	ArrayList<BigInteger> al = new ArrayList<>();
	gen g = new gen();
	BigInteger rand1 = g.generate();
	public BigInteger generate() {
		al.clear();
		this.p = rand1;
		int count = 0;
		BigInteger one = BigInteger.valueOf(1);
		// Begin from random number until random number + 1000
		for (BigInteger i = p; i.compareTo((p.add(BigInteger.valueOf(1000)))) < 0; i = i.add(one)) {
			// Divisor begins from 1 until random
			for (BigInteger j = BigInteger.valueOf(1); j.compareTo(i) < 0; j = j.add(one)) {
				if (i.mod(j).equals(BigInteger.valueOf(0))) {
					count++;
				}
				// Higher than 2 factors. Break the loop.
				if (count > 2)
					break;
			}
			// Maximum factors are 2. Add it to list
			if (count <= 2) {
				al.add(i);
			}
			// Since only one prime is required, break the loop.
			if (al.size() == 1) {
				break;
			}
			count = 0;
		}
		return al.get(0);
	}
}