import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class menu {
	public static void main(String[] args) {
		int menu = 0;
		// Menu
		Scanner sc = new Scanner(System.in);
		System.out.println("1 --> Encrypt the message");
		System.out.println("2 --> Decrypt the message");
		System.out.println("3 --> Generate public and private keys");
		System.out.println("4 --> Simulation of communication among Alice and Bob");
		System.out.println("5 --> Protocol");
		System.out.println("");

		while (menu < 1 || menu > 7) {
			System.out.println("Select a number from the menu.");
			menu = Integer.parseInt(sc.next());
			switch (menu) {
				case 1 -> {
					menu1 menu1 = new menu1();
					menu1.Menu1();
					menu = 0;
				}
				case 2 -> {
					menu2 menu2 = new menu2();
					menu2.Menu2();
					menu = 0;
				}
				case 3 -> {
					menu3 menu3 = new menu3();
					menu3.Menu3();
					menu = 0;
				}
				case 4 -> {
					menu4 menu4 = new menu4();
					menu4.Menu4();
					menu = 0;
				}
				case 5 -> {
					menu5 menu5 = new menu5();
					menu5.Menu5();
					menu = 0;
				}
				default -> {
					System.out.println("Incorrect Selection!");
					menu = 0;
				}
			}
		}
	}
}