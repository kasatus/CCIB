package strings_and_arrays;

public class StringCompression {

	public StringCompression() {
		// TODO Auto-generated constructor stub
	}
	
//	private static String strCompression(String str) {
//		StringBuilder sb = new StringBuilder();
//		if (str == null || str.isEmpty()) {
//			return null;
//		}
//		int len = str.length();
//		if (len <= 2) {
//			return str;
//		}
//		int cnt = 1;
//		int i = 0;
//		// aabcc
//		// abbc
//		while (i < len - 1) {
//			while (i < len - 1 && str.charAt(i) == str.charAt(i + 1)) {
//				cnt++;
//				i++;
//			}
//			sb.append(str.charAt(i));
//			sb.append(cnt);
//			if (i == len - 2) {
//				if (cnt > 1) {
//					sb.append(str.charAt(i + 1));
//					sb.append(1);
//				}
//			}
//			cnt = 1;
//			i++;
//		}
//		System.out.println("sb: " + sb.toString());
//		if (sb.length() < str.length()) {
//			return sb.toString();
//		} else {
//			return str;
//		}
//	}
	
	public static String strCompression(String str) {
		if (str == null || str.isEmpty()) {
			return null;
		}
		StringBuilder sb = new StringBuilder();
		char prev = str.charAt(0);
		int cnt = 1;
		for (int i = 1; i < str.length(); i++) {
			if (prev == str.charAt(i)) {
				cnt++;
			} else {
				sb.append(prev);
				sb.append(cnt);
				cnt = 1;
				prev = str.charAt(i);
			}
		}
		sb.append(prev);
		sb.append(cnt);
		if (sb.length() < str.length()) {
			return sb.toString();
		} else {
			return str;
		}
	}
	
	public static void main(String[] args) {
		String str = "abbbb";
		System.out.println(strCompression(str));
	}

}
