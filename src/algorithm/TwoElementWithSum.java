package algorithm;

import java.util.HashMap;

public class TwoElementWithSum {
	public static void main(String[] args) {
		int[] arr = new int[]{ 2, 20, 4, 55, 13, 19 };
		find(arr, 17);
	}
	
	public static void find(int[] arr, int sum) {
		HashMap<Integer, Integer> map = new HashMap<>();
		
		for (int e : arr) {
			if (!map.containsKey(e))
				map.put(sum-e, e);
			else
				System.out.println(map.get(e) + " " + e);
		}
	}
}
