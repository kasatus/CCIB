package strings_arrays;

import java.util.Map;
import java.util.TreeMap;

public class FindReplaceString {

	public FindReplaceString() {
		// TODO Auto-generated constructor stub
	}
	public static String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
		TreeMap<Integer, Integer> tr = new TreeMap<Integer, Integer>();
		for (int i = 0; i < indexes.length; i++) {
			tr.put(indexes[i], i);
		}
		
		
		
		StringBuilder sb = new StringBuilder();
		if (S == null || S.isEmpty()) {
			return null;
		}
		if (indexes.length != sources.length) {
			return null;
		}
		int prev = 0;
		boolean flag = false;
		
		for (Map.Entry<Integer, Integer> entry : tr.entrySet()) {
			int i = entry.getValue();
			int ind = entry.getKey();
			String substr = S.substring(ind, ind + sources[i].length());
			String toMatch = sources[i];
			if (substr.equals(toMatch)) {
				flag = true;
				String prevExcerpt = S.substring(prev, ind);
				sb.append(prevExcerpt);
				sb.append(targets[i]);
				prev = ind + sources[i].length();
			} else if (i == indexes.length - 1) {
				String prevExcerpt = S.substring(prev);
				sb.append(prevExcerpt);
			}
		}
		if (prev != S.length()) {
			String prevExcerpt = S.substring(prev);
			sb.append(prevExcerpt);
		}
		if (flag) {
			return sb.toString();
		} else {
			return S;
		}
		
//		for (int i = 0; i < indexes.length; i++) {
//			int ind = indexes[i];
//			if (S.substring(ind, ind + sources[i].length()).equals(sources[i])) {
//				flag = true;
//				String prevExcerpt = S.substring(prev, ind);
//				sb.append(prevExcerpt);
//				sb.append(targets[i]);
//				prev = ind + sources[i].length();
//			} else if (i == indexes.length - 1) {
//				String prevExcerpt = S.substring(prev);
//				sb.append(prevExcerpt);
//			}
//		}
//		if (flag) {
//			return sb.toString();
//		} else {
//			return S;
//		}
	}
	 
	 public static void main(String[] args) {
		/*
		 * 	Input: S = "abcd", indexes = [0,2], sources = ["a","cd"], targets = ["eee","ffff"]
			Output: "eeebffff"
		 */
		 
		 /*
		  * Input: S = "abcd", indexes = [0,2], sources = ["ab","ec"], targets = ["eee","ffff"]
			Output: "eeecd"
		  */
		 
		 /*
		  * "vmokgggqzp"
			[3,5,1]
			["kg","ggq","mo"]
			["s","so","bfr"]
			output: vmosso
		  */
		 
		 /*
		  * "abcd"
			[0, 2]
			["ab","ec"]
			["eee","ffff"]
		  */
		 
		 String S = "vmokgggqzp";
		 int[] indexes = {3,5,1};
		 String[] sources = {"kg","ggq","mo"};
		 String[] targets = {"s","so","bfr"};
		 System.out.println(findReplaceString(S, indexes, sources, targets));
	}

}
