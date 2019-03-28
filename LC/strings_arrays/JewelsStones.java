package strings_arrays;

import java.util.HashMap;

//You're given strings J representing the types of stones that are jewels, and S representing the stones you have.  Each character in S is a type of stone you have.  You want to know how many of the stones you have are also jewels.
//The letters in J are guaranteed distinct, and all characters in J and S are letters. Letters are case sensitive, so "a" is considered a different type of stone from "A".
//
//Example 1:
//
//Input: J = "aA", S = "aAAbbbb"
//Output: 3
//Example 2:
//
//Input: J = "z", S = "ZZ"
//Output: 0

public class JewelsStones {

	public JewelsStones() {
		// TODO Auto-generated constructor stub
	}
	public static HashMap<Character, Integer> getHashMap(String str) {
		if (str == null || str.isEmpty()) {
			return null;
		}
		HashMap<Character, Integer> result = new HashMap<Character, Integer>();
		for (char c : str.toCharArray()) {
			if (result.containsKey(c)) {
				result.put(c, result.get(c) + 1);
			} else {
				result.put(c, 1);
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		String j = "aA";
		String s = "aAAbbbb";
		HashMap<Character, Integer> hm = getHashMap(s);
		int total = 0;
		if (j != null) {
			for (char c : j.toCharArray()) {
				if (hm.containsKey(c)) {
					total += hm.get(c);
				}
			}
		}
		System.out.println(total);
		
	}

}
