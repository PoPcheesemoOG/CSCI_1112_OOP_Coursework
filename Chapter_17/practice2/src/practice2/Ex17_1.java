/* Name: Paul Helske
 * Date: 05/25/2023
 */

package practice2;

import java.io.*; 

public class Ex17_1 {
	public static void main(String[] args) throws IOException {

		int p = 0;
		try (
				FileOutputStream output = new FileOutputStream("Exercise17_01.txt", true)
				) {
			
			for (int i = 1; i <= 100; i++) {
				p = (int) (Math.random() * 100);
				output.write(p);
			}

			try (
					FileInputStream input = new FileInputStream("Exercise17_01.txt");
					) {
				int value;
				while ((value = input.read()) != -1)
					System.out.print(value + " ");
			}
		}
	}
}