package algorithm;

import java.util.List;
import java.util.ArrayList;

public class FindTheTwoSingle {
	public static void main(String[] args) {
		find(new int[]{ 2, 4, 5, 3, 4, 6, 6, 2, 3, 10 });
	}
	
	public static void find(int[] arr) {
		int differ = findDiffer(arr);
		int j = 1;
		while((j & differ) != 1) j <<= 1;
		
		ArrayList<Integer> list1 = new ArrayList<>();
		ArrayList<Integer> list2 = new ArrayList<>();
		for (int i=0; i<arr.length; i++) {
			if ((j & arr[i]) == 0)
				list1.add(arr[i]);
			else
				list2.add(arr[i]);
		}
		
		System.out.println(findDiffer(list1) + " " + findDiffer(list2));
	}
	
	public static int findDiffer(int[] arr) {
		int result = 0;
		for (int i=0; i<arr.length; i++) {
			result ^= arr[i];
		}
		return result;
	}
	
	public static int findDiffer(List<Integer> arr) {
		int result = 0;
		for (int i=0; i<arr.size(); i++) {
			result ^= arr.get(i);
		}
		return result;
	}
}
