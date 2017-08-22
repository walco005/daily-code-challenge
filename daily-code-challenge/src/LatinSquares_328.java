import java.util.*;

/**
 * Challenge 328 - Latin Squares
 * https://redd.it/6v29zk
 * 
 * Check whether a given array is a Latin square
 * @author walco005
 *
 */
public class LatinSquares_328 {

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		System.out.println("Enter the dimension: ");
		int n = reader.nextInt();
		reader.nextLine();
		System.out.println("Enter the possible Latin square: ");
		String arg = reader.nextLine();
		String[] arr = arg.split(" ");
		System.out.println(isLatinSquare(n, arr));
		reader.close();
//		String arg1 = "1 2 3 4 5 5 1 2 3 4 4 5 1 2 3 3 4 5 1 2 2 3 4 5 1";
//		String[] arr1 = arg1.split(" ");
//		String arg2 = "1 2 3 4 1 3 2 4 2 3 4 1 4 3 2 1";
//		String[] arr2 = arg2.split(" ");
//		String arg3 = "1 2 2 1";
//		String[] arr3 = arg3.split(" ");
//		System.out.println(isLatinSquare(5, arr1)); TRUE
//		System.out.println(isLatinSquare(4, arr2)); FALSE
//		System.out.println(isLatinSquare(2, arr3)); TRUE
	}
	
	/**
	 * Uses rowCheck and colCheck to make sure each row and column abide by the rules of a Latin square
	 * @param n				Latin square dimension
	 * @param arr			Latin square array
	 * @return boolean		boolean of if arr is a Latin square
	 */
	private static boolean isLatinSquare(int n, String[] arr) {
		return (rowCheck(n, arr) && colCheck(n, arr));
	}
	
	/**
	 * Checks if the rows of an input abide to the rules of a Latin square
	 * @param n				Latin square dimension
	 * @param stringArr		Latin square array
	 * @return				boolean on if it abides to the aforementioned rules
	 */
	private static boolean rowCheck(int n, String[] stringArr) {
		for(int i = 0; i < stringArr.length; i = i + n) {
			Set hs = new HashSet();
			for(int j = i; j < i + n; j++) {
				hs.add(stringArr[j]);
			}
			if(hs.size() != n) return false;
			for(int k = 1; k <= n; k++) {
				if(!hs.contains(Integer.toString(k))) return false;
			}
		}
		return true;
	}
	
	/**
	 * Checks if the columns of an input abide to the rules of a Latin square
	 * @param n				Latin square dimension
	 * @param stringArr		Latin square array
	 * @return				boolean on if it abides to the aforementioned rules
	 */
	private static boolean colCheck(int n, String[] stringArr) {
		for(int i = 0; i < n; i++) {
			Set hs = new HashSet();
			for(int j = i; j < stringArr.length; j = j + n) {
				hs.add(stringArr[j]);
			}
			if(hs.size() != n) return false;
			for(int k = 1; k <= n; k++) {
				if(!hs.contains(Integer.toString(k))) return false;
			}
		}
		return true;
	}
}
