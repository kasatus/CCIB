package strings_and_arrays;
// Check Permutation: Given two strings, write a method to decide if one is a permutation of the other.
public class PermutationChecker {

	public PermutationChecker() {
		
	}
	private static boolean permChecker(String str1, String str2) {
		if (str1 == null || str1.isEmpty()) {
			return false;
		}
		if (str2 == null && str2.isEmpty()) {
			return false;
		}
		if (str1.length() != str2.length()) {
			return false;
		}
		int[] checker = new int[128];
		for (int i = 0; i < str1.length(); i++) {
			checker[str1.charAt(i)]++;
			checker[str2.charAt(i)]--;
		}
		for (int i = 0; i < 128; i++) {
			if (checker[i] != 0) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		System.out.println(permChecker("aba", "aba"));
	}

}
