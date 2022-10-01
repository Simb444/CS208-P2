/**
 * Recursive Class
 * @author Arjun Bott
 * @author David Smirnov
 */
import java.util.Scanner;

public class Recursive {
	/* attributes
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
		Scanner scan = new Scanner(input);

		{ // local scope
			int i;
			for (i = 0; scan.hasNextInt(); i++) {
				scan.nextInt();
			}

			if (i % 2 == 0) {
				throw NOT_ODD;
			}

			binaryNumber = new int[i];
		}

		scan = new Scanner(input);
		for (int i = 0; scan.hasNextInt(); i++) {
			binaryNumber[i] = scan.nextInt();
		}
	}

	/**
	 * overload for recursive method
	 * @author: David Smirnov
	 * receives the original binary number stored as our attribute,
	 *  calls itself by passing the original attribute and sets index to 0 by default
	 */
	private static int[] onion(int[] input){
		return onion(input, 0);
	}

	/**
	 * overloaded Recursive method
	 * @author: Arjun Bott
	 * receives both int[] and int as index value
	 */
	private static int[] onion(int[] input, int index){
		if (input.length % 2 == 0) {
			throw NOT_ODD;
		} else {
			input[index] = input[index] == 0 ? 1 : 0;
			input[input.length - 1 - index] = input[input.length - 1 - index] == 0 ? 1 : 0;
		}
	}
}
