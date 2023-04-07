import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Random;

public class gen {
	// Generate a number between 100 and 1000
	BigInteger generate() {
		Random r = new Random();
		int Low = 1000;
		int High = 100000;
		return BigInteger.valueOf(r.nextInt(High - Low) + Low);

	}
}