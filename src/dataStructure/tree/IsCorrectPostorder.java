package dataStructure.tree;

public class IsCorrectPostorder {
	public static void main(String[] args) {
		int[] arr = new int[]{ 4, 2, 16, 15, 7, 20, 10};
		arr = new int[]{ 7, 4, 6, 5 };
		System.out.println(isCorrect(arr, 0, arr.length-1));
	}
	
	public static boolean isCorrect(int[] arr, int start, int end) {
		if (start >= end) return true;
		
		int root = arr[end];
		int i = start;
		while(i < end && arr[i] < root)
			i++;
		
		for (int j=i; j<end; j++) {
			if (arr[j] < root) return false;
		}
		
		return isCorrect(arr, start, i-1) && isCorrect(arr, i, end-1);
	}
}
