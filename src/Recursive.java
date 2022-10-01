/**
 * Recursive Class
 * @author Arjun Bott
 * @author David Smirnov
 */
import java.util.Scanner;

public class Recursive {
	/* attributes
   * @author: David Smirnov
	// default constructor

	/* custom constructor
   * @author: David Smirnov
	/**
		* default Recursive method
		* @author: David Smirnov
		* receives the original binary number stored as our attribute,
		* calls itself by passing the original attribute and sets index to 0 by default
		*/
	private String str = "4576576";
	private int[] input = new int[str.length()];
	private Scanner n = new Scanner(str);
	private static int[] onion(int[] input){
		return onion(input, 0);
	}

	/**
	 * overloaded Recursive method
	 * @author: Arjun Bott
	 * receives both int[] and int as index value
	 */
	private static int[] onion(int[] input, int index){
		//public recursive(String input) {
		if (str.length() % 2 == 0) {
			throw new IllegalArgumentException("You may only enter odd");
		} else {//converts string in to int array
			for (int i = 0; n.hasNextInt() ; i++) {
				input[i] = n.nextInt();
			}
			input[index] = input[index] == 0 ? 1 : 0;
			input[input.length - 1 - index] = input[input.length - 1 - index] == 0 ? 1 : 0;
		}
