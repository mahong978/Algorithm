package algorithm;

public class FindTheSingle {
	public static void main(String[] args) {
		System.out.println(find(new int[]{ 2, 4, 5, 3, 4, 6, 6, 2, 3 }));
	}
	
	public static int find(int[] arr) {
		int result = 0;
		for (int i=0; i<arr.length; i++) {
			result ^= arr[i];
		}
		
		return result;
	}
}
