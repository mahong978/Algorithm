package algorithm;

import java.util.Arrays;

public class KLeastElements {
	public static void main(String[] args) {
		int[] test = new int[]{ 5, 6, 7, 8, 1, 2, 3, 4 };
		System.out.println(Arrays.toString(getKLeast(test, 4)));
	}
	public static int[] getKLeast(int[] arr, int k) {
		int[] result = new int[k];
		int i = 0;
		for (; i<k && i<arr.length; i++) {
			result[i] = arr[i];
			adjustUp(result, i);
		}
		
		for (; i<arr.length; i++) {
			if (arr[i] < result[0]) {
				result[0] = result[k-1];
				adjustDown(result, k-1);
				
				result[k-1] = arr[i];
				adjustUp(result, k-1);
			}
		}
		
		return result;
	}
	
	public static void adjustUp(int[] arr, int i) {
		int j = (i-1) / 2;
		int temp = arr[i];
		while(j >= 0 && i != 0) {
			if (arr[j] > temp)
				break;
			
			arr[i] = arr[j];
			i = j;
			j = (i-1) / 2;
		}
		arr[i] = temp;
	}
	
	public static void adjustDown(int[] arr, int length) {
		int temp = arr[0];
		int index = 0;
		int nextIndex = 0;
		while(index <= length/2 - 1) {
			int left = index*2 + 1;
			int right = index*2 + 2;
			if (arr[left] > temp)
				nextIndex = left;
			if (right < length && arr[right] > arr[left] && arr[right] > temp)
				nextIndex = right;
			
			if (index != nextIndex) {
				arr[index] = arr[nextIndex];
				index = nextIndex;
			}
		}
		arr[nextIndex] = temp;
	}
}
