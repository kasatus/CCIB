package strings_and_arrays;

public class IsPalidrome {

	public IsPalidrome() {
		// TODO Auto-generated constructor stub
	}
	public static boolean isPalindrome(String str) {
		if (str == null || str.isEmpty()) {
			return false;
		}
		int[] checker = new int[128];
		for (char c : str.toCharArray()) {
			if (c != ' ') {
				checker[c]++;
			}
		}
		boolean flag = false;
		for (int i = 0; i < checker.length; i++) {
			if (checker[i] % 2 == 0) {
				continue;
			} else if (!flag) {
				flag = true;
			} else {
				return false;
			}
		}
		return true;
	}
	
	public static boolean isPalindrome2(String str) {
		// 128 characters
		if (str == null || str.isEmpty()) {
			return false;
		}
		int checker = 0;
		for (char c : str.toCharArray()) {
			if (c < 'a') continue;
			if ((checker & (1 << c)) == 0) {
				checker |= (1 << c);
			} else {
				checker &= ~(1 << c);
			}
		}
		if (checker == 0) {
			return true;
		} else if ((checker & (checker - 1)) == 0) {
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
//		System.out.println(isPalindrome("aca"));
		System.out.println(isPalindrome2("aaccv v   llppi"));
	}

}
