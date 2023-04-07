import java.math.BigInteger;

public class menu3 {
    void Menu3() {
        System.out.println("-------------GENERATING PUBLIC & PRIVATE KEYS-------------");
        System.out.println("");

        BigInteger p;
        BigInteger q;

        generator generator3 = new generator();
        generator generator4 = new generator();

        // Finding next prime
        p = generator3.generate();
        q = generator4.generate();

        // Create random number between 100 and 100
        System.out.println("Generate 1st random: " + generator3.p);
        System.out.println("Generate 2nd random: " + generator4.p);
        System.out.println("");

        // Print prime
        System.out.println("Next prime if 1st random is not prime: " + p);
        System.out.println("Next prime if 2nd random is not prime: " + q);
        System.out.println("");

        // Printing formulae for public and private keys
        System.out.println("Below is the formula used to generate the keys:");
        key key = new key(p, q);
        System.out.println("p = " + p);
        System.out.println("q = " + q);
        System.out.println("n = p*q = " + p + "*" + q + " = " + key.n);
        System.out.println("phi = (p-1)*(q-1) = (" + p + "-1)*(" + q + "-1)=" + key.phi);
        System.out.println("e = " + key.e);
        System.out.println("d = inverse of " + key.e + "mod phi(" + key.phi + ") = " + key.d);
        System.out.println();

        // Calling function for public and private keys
        key.keys();
        System.out.println();
    }
}
