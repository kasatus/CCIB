package strings_and_arrays;

//Is Unique: Implement an algorithm to determine if a string has all unique characters. What if you cannot use additional data structures?


public class isUnique {

	public isUnique() {
		
	}
	private final static int ASCII_LIMIT = 128;
	private static boolean isUniqueString1(String str) throws Exception {
		if (str == null || str.isEmpty()) {
			throw new Exception ("Empty string");
		}
		boolean[] arr = new boolean[ASCII_LIMIT];
		for (int i = 0; i < str.length(); i++) {
			int shift = str.charAt(i) - 'a';
			if (!arr[shift]) {
				arr[shift] = true;
			} else {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) throws Exception {
		System.out.println(isUniqueString1("aa"));
	}

}
