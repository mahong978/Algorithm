package algorithm;

public class ReverseWords {
	public static void main(String[] args) {
		String s = "i am ma hongqin";
		System.out.println(reverse(s));
	}
	
	public static String reverse(String sentence) {
		if (sentence == null || sentence.isEmpty()) return sentence;
		
		StringBuilder sb = new StringBuilder(sentence);
		int start = 0;
		int end = sb.length() - 1;
		reverseInterval(sb, start, end);
		
		start = 0;
		for (int k = 0; k < sb.length(); k++) {
			if (sb.charAt(k) == ' ') {
				end = k-1;
				reverseInterval(sb, start, end);
				start = k+1;
			}
		}
		return sb.toString();
	}
	
	public static void reverseInterval(StringBuilder sb, int start, int end) {
		while(start <= end) {
			char temp = sb.charAt(start);
			sb.setCharAt(start, sb.charAt(end));
			sb.setCharAt(end, temp);
			start++;
			end--;
		}
	}
}
