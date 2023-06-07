/* Name: Paul Helske
 * Date: 6/6/2023
 */
import java.util.*;

public class Ex18_9 {
	static String S1 = "";

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a string to be reversed: ");
		String S = input.nextLine();
		input.close();
		reverseDisplay(S);
	}
	public static void reverseDisplay(String S) {
		int i = S.length() - 1;
		if (i < 0) {
			System.out.println(S1);
		}
		if (i >= 0) {
			char c = S.charAt(i);
			S1 += c;
			S = S.substring(0, i);
			reverseDisplay(S);
		}		
	}
}