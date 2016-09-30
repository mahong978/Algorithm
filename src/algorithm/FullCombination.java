package algorithm;

import java.util.Scanner;

public class FullCombination {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String s = scanner.nextLine();
		scanner.close();
		
		char[] arr = s.toCharArray();
		pickAndPrint(arr);
	}
	
	private static void pickAndPrint(char[] arr) {
		int upper = 1 << arr.length;
		for (int i = 1; i < upper; i++) {
			int count = 0;
			int temp = 1 << count;
			while(temp <= i) {
				if ((temp & i) != 0) {
					System.out.print(arr[count]);
				}
				temp <<= 1;
				count ++;
			}
			System.out.println();
		}
	}
}
