package strings_and_arrays;

public class URLify {

	public URLify() {
		// TODO Auto-generated constructor stub
	}
	private static final String repl = "%20";
	public static String replaceSpaces(String str, int len) { // O(N)
		StringBuilder sb = new StringBuilder();
		for (char c : str.toCharArray()) {
			if (len != 0) {
				if (c != ' ') {
					sb.append(c);
					len--;
				} else {
					sb.append("%20");
					len -= repl.length();
				}
			} else {
				break;
			}
		}
		return sb.toString();
	}
	public static void main(String[] args) {
		String s = "";
		System.out.println(replaceSpaces(s, s.length()));
	}

}
