package strings_and_arrays;

public class OneWay {
// There are three types of edits that can be performed on strings: insert a character, remove a character, or replace a character. 
// Given two strings, write a function to check if they are one edit (or zero edits) away.
// p ale, p le -> true 
// pales, pale -> true 
// pale, bale -> true 
// pale, bae -> false
	public OneWay() {
		
	}
	public static boolean oneEdit(String str1, String str2) {
		if (str1 == null || str1.isEmpty()) {
			return false;
		}
		if (str2 == null || str2.isEmpty()) {
			return false;
		}
		int len1 = str1.length();
		int len2 = str2.length();
		if (Math.abs(len1 - len2) > 1) {
			return false;
		}
		if (len1 == len2) {
			// check if one or none characters were modified
			return charMod(str1, str2);
		} else {
			return charAdd(str1, str2);
		}
	}
	
	private static boolean charAdd(String str1, String str2) {
		String shortest = str1.length() > str2.length() ? str2 : str1;
		String longest = str1.length() > str2.length() ? str1 : str2;
		int len1 = shortest.length();
		int len2 = longest.length();
		boolean foundChar = false;
		for (int i = 0, k = 0; i < len1 && k < len2;) {
			char shChar = shortest.charAt(i);
			char lgChar = longest.charAt(k);
			if (shChar == lgChar) {
				i++;
				k++;
			} else {
				if (!foundChar) {
					foundChar = true;
				} else {
					return false;
				}
				k++;
			}
		}
		return true;
	}
	
	
	private static boolean charMod(String str1, String str2) {
		boolean modified = false;
		for (int i = 0; i < str1.length(); i++) {
			if (str1.charAt(i) != str2.charAt(i)) {
				if (!modified) {
					modified = true;
				} else {
					return false;
				}
			}
		}
		return true;
	}
	
	// pale, ple -> true 
	// pales, pale -> true 
	// pale, bale -> true 
	// pale, bae -> false
	public static void main(String[] args) {
		System.out.println(oneEdit("", "b"));
	}

}
