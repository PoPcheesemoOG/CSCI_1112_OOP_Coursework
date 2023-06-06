/* Name: Paul Helske
 * Date: 6/6/2023
 */
import java.util.*;

public class Ex18_3 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int m = 1;
		int n = 1;
		System.out.println("Please enter two integers to find out the GCD: ");
		System.out.println("If you wish to exit, enter 0 and 0.");
		
		while (m != 0 || n != 0) {
			System.out.println("\nIntegers : ");
			m = input.nextInt();
			n = input.nextInt();

			gcd(m, n);
		}
	}
	public static int gcd(int m, int n) {
		// base case
		if (m % n == 0) {
			System.out.println("\nGreatest Common Divisor is " + n);
			return n;
		}
		else {
			System.out.println("m is now " + n + " and n is now " + (m % n));
			return gcd(n, (m % n));
		}
		//return 0;
	}

}
