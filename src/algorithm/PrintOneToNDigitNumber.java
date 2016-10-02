package algorithm;

public class PrintOneToNDigitNumber {
	public static void main(String[] args) {
		int n = 32;
		char[] arr = new char[n];
		for (int i=0; i<n; i++) {
			arr[i] = '0';
		}
		
		printByRecursion(arr, 0);
	}
	private static void printByRecursion(char[] arr, int index) {
		if (index == arr.length) {
			print(arr);
			return;
		}
		
		for (int i=0; i<10; i++) {
			arr[index] = (char)('0' + i);
			printByRecursion(arr, index+1);
		}
	}
	private static void print(char[] arr) {
		int i = 0;
		while (i < arr.length && arr[i] == '0') i++;
		
		if (i == arr.length)
			System.out.println('0');
		else {
			for (; i<arr.length; i++) {
				System.out.print(arr[i]);
			}
			System.out.println();
		}
	}
}
