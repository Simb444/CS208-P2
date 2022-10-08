import java.util.Scanner;

/**
 * Tester class
 * @author: Arjun bott
 * @author: David Smirnov
 */
public class Tester {
	public static void main(String[] args) {
		// David
		Scanner scan = new Scanner(System.in);
		int numTrials;
		System.out.println("How many binary numbers do you want to flip?");
		numTrials = scan.nextInt();
		scan.nextLine();
		System.out.println();

		// Arjun
		System.out.println("numTrials: " + numTrials);

		for (int i = 0; i < numTrials; i++) {
			System.out.println("Enter a binary number: ");
			Recursive onion = new Recursive(scan.nextLine());
			int[] binaryNumber = onion.getBinaryNumber();

			System.out.println("binaryNumber length: " + binaryNumber.length);

			for (int j = 0; j < binaryNumber.length; j++) {
				System.out.print(binaryNumber[j]);
			}

			System.out.println();
		}
	}
}
