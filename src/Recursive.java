import java.util.Arrays;
import java.util.Scanner;

/**
 * Recursive Class
 * @author Arjun Bott
 * @author David Smirnov
 */
public class Recursive {
	/** attributes
	 * @author: David Smirnov
	 */
	private static IllegalArgumentException NOT_ODD = new IllegalArgumentException("You may only enter odd");
	private int[] binaryNumber;

	/** constructor
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

		// calls the recursive method
		this.onion();
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

	/** getter method
	 * @author: Arjun Bott
	 * method used to receieve this class's attribute
	 */
	public int[] getBinaryNumber() {
		return this.binaryNumber;
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
			int halfIndex = (int) ((index + 1) / 2);

			if ((2 * index - 1 >= binaryNumber.length) || (binaryNumber.length == 1)) { // base case
				binaryNumber[halfIndex] = binaryNumber[halfIndex] == 0 ? 1 : 0;
				return binaryNumber;
			} else { // recursive case
				binaryNumber[index] = binaryNumber[index] == 0 ? 1 : 0;
				binaryNumber[binaryNumber.length - index - 1] = binaryNumber[binaryNumber.length - index - 1] == 0 ? 1 : 0;
				return onion(index + 1);
			}
		}
	}
	// @author: David Smirnov
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Recursive recursive = (Recursive) o;
		return Arrays.equals(binaryNumber, recursive.binaryNumber);
	}
	// @author: Arjun Bott
	@Override
	public String toString() {
		return "Recursive{" +
				"binaryNumber=" + Arrays.toString(binaryNumber);
	}

}
