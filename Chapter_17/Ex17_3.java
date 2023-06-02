/* Name: Paul Helske
 * Date: 05/25/2023
 */

package practice3;

import java.io.*; 

public class Ex17_3 {
	public static void main(String[] args) throws IOException {

		createFile();
		sumFile();

	}
	public static void createFile() throws IOException {
		int p = 0;
		try (
				DataOutputStream output = new DataOutputStream (new FileOutputStream("Exercise17_03.dat", true)
						)) {

			for (int i = 1; i <= 100; i++) {
				p = (int) (Math.random() * 100);
				output.writeInt(p);
			}
		} 
	}

	public static void sumFile() throws IOException {
		try (
				DataInputStream input = new DataInputStream (new FileInputStream ("Exercise17_03.dat"));
				) {
			int value;
			int sum = 0;
			while ((value = input.read()) != -1) {
				System.out.print(value + " ");
				sum += value; 
			}
			System.out.println("\n" + sum);
		}
	}
}