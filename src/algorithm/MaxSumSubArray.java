package algorithm;

public class MaxSumSubArray {
	public static void main(String[] args) {
		System.out.println(getMaxSum(new int[]{1, -2, 3, 10, -4, 7, 2, -5}));
	}
	
	public static int getMaxSum(int[] arr) {
		if (arr.length == 0) return 0;
		
		int maxSum = arr[0];
		for (int i=1; i<arr.length; i++) {
			if (maxSum < 0)
				maxSum = arr[i];
			else if (arr[i] < 0 && i == arr.length-1)
				break;
			else
				maxSum += arr[i];
		}
		
		return maxSum;
	}
}
