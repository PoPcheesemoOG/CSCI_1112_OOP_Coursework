/* Name: Paul Helske
 * Date: 05/30/2023
 */
package practice;

import java.io.*;
import java.util.*;

public class Ex17_14 {
	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) throws IOException {

		encryptFile();
		decryptFile();

	}
	public static void encryptFile() throws IOException {
		String inFileName = inputfilename();
		String outFileName = outputfilename();
		FileOutputStream fOutput = new FileOutputStream(outFileName);
		ObjectOutputStream output = new ObjectOutputStream(fOutput);		
		for (int i = 0; i < inFileName.length(); i++) {
			char q = inFileName.charAt(i);
			q += 5;
			output.writeChar(q);
			System.out.println(q + " ");
		}
		output.close();
	}

	public static void decryptFile() throws IOException, EOFException {
		try {
			String inFileName = inputfilename();
			String outFileName = outputfilename();

			FileInputStream fInput = new FileInputStream(inFileName);
			ObjectInputStream oInput = new ObjectInputStream(fInput);

			FileOutputStream fOutput = new FileOutputStream(outFileName);
			ObjectOutputStream output = new ObjectOutputStream(fOutput);	

			while (true) {
				char q = oInput.readChar();
				q -= 5;
				System.out.println(q + " ");
				output.writeChar(q);
			}
		}
		catch (EOFException ex){
			System.out.println("End of file reached");
		}
	}
	public static String inputfilename() {
		String fileName = "";

		System.out.println("Please enter an input file name: ");
		fileName = input.nextLine();

		return fileName;
	}
	public static String outputfilename() {
		String fileName = "";

		System.out.println("Please enter an output file name: ");
		fileName = input.nextLine();

		return fileName;
	}
}