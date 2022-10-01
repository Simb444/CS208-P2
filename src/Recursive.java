/**
 * Recursive Class
 * @author Arjun Bott
 * @author David Smirnov
 */
import java.util.Scanner;

public class Recursive {
	/** attributes
	 * @author: David Smirnov
	 */
	private static IllegalArgumentException NOT_ODD = new IllegalArgumentException("You may only enter odd");
	private int[] binaryNumber;

	/**
	 * @author: David Smirnov
	 * default constructor
	 */
	public Recursive() {

	}

	/** custom constructor
	 * @author: David Smirnov
	 */
	public Recursive(String input) {
		Scanner scan = new Scanner(prepare_input(input));

		{ // local scope
			int i;
			for (i = 0; scan.hasNext(); i++) {
				try {
					Integer.parseInt(scan.next());
				} catch (NumberFormatException e) {
					i--;
				}
			}

			if (i % 2 == 0) {
				throw NOT_ODD;
			}

			binaryNumber = new int[i];
		}

		scan = new Scanner(prepare_input(input));
		for (int i = 0; scan.hasNext(); i++) {
			binaryNumber[i] = Integer.parseInt(scan.next());
		}
	}

	/** helper method
	 * @author: Arjun Bott
	 * method used to seperate bits in the input
	 */
	private static String prepare_input(String input) {
		String output = "";

		for (int i = 0; i < input.length(); i++) {
			output += input.charAt(i) + " ";
		}

		return output.trim();
	}

	/**
	 * overload for recursive method
	 * @author: David Smirnov
	 *  calls itself by passing the original attribute and sets index to 0 by default
	 */
	public int[] onion() {
		return onion(0);
	}

	/**
	 * overloaded Recursive method
	 * @author: Arjun Bott
	 * receives int as index value
	 */
	public int[] onion(int index) {
		if (binaryNumber.length % 2 == 0) { // check binaryNumber for odd or even value
			throw NOT_ODD;
		} else {
			if (2 * index - 1 >= binaryNumber.length) { // base case
				binaryNumber[(int) ((index + 1) / 2)] = binaryNumber[(int) ((index + 1) / 2)] == 0 ? 1 : 0;
				return binaryNumber;
			} else { // recursive case
				binaryNumber[index] = binaryNumber[index] == 0 ? 1 : 0;
				binaryNumber[binaryNumber.length - 1 - index] = binaryNumber[binaryNumber.length - 1 - index] == 0 ? 1 : 0;
				return onion(index + 1);
			}
		}
	}
}
