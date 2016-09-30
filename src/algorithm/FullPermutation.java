package algorithm;

import java.util.Scanner;

public class FullPermutation {
	public static void main(String[] args) {
		String s;
		Scanner scanner = new Scanner(System.in);
		s = scanner.next();
		scanner.close();
		
		char[] arr = s.toCharArray();
		swapAndPrint(arr, 0);
	}
	
	private static void swapAndPrint(char[] arr, int k) {
		if (k == arr.length-1) {
			System.out.println(arr);
			return;
		}
		
		for (int i = k; i < arr.length; i++) {
			swap(arr, k, i);
			swapAndPrint(arr, k+1);
			swapback(arr, k, i);
		}
	}
	
	private static void swap(char[] arr, int i, int j) {
		char temp = arr[j];
		for (int k = j; k > i; k--) {
			arr[k] = arr[k-1];
		}
		arr[i] = temp;
	}
	
	private static void swapback(char[] arr, int i, int j) {
		char temp = arr[i];
		for (int k = i; k < j; k++) {
			arr[k] = arr[k+1];
		}
		arr[j] = temp;
	}
}
