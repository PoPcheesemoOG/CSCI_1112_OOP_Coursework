/* Name: Paul Helske
 * Date: 5/30/2023
 */
package practice;

import java.io.*;

public class Ex17_7 {

	public static void main(String[] args) throws ClassNotFoundException, IOException {
		Loan loan1 = new Loan();
		Loan loan2 = new Loan(1.8, 10, 10000);
		try (
				ObjectOutputStream output = new ObjectOutputStream(new
						FileOutputStream("Exercise17_07.dat"));
				) {
			output.writeObject(loan1);
			output.writeObject(loan2);
		}
		catch (IOException ex) {
			System.out.println("File could not be opened");
		}
		outputData();
	}
	public static void outputData() throws IOException, ClassNotFoundException {
		Loan loan = null;
		FileInputStream fileIn = new FileInputStream("/Users/student/eclipse-workspace/practice/Exercise17_07.dat");
		ObjectInputStream in = new ObjectInputStream(fileIn);
		try {
			while (true) {
			loan = (Loan) in.readObject();
			System.out.println(loan.getLoanAmount());
			}
		}
		catch (EOFException ex) {
			System.out.println("End of file reached");
			in.close();
			fileIn.close();
			System.out.println("The file has been closed.");
		}
	}
}