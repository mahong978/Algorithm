package algorithm;

public class Fibonacci {
	public static void main(String[] args) {
		fibonacciByLoop(10);
		System.out.println();
		System.out.println(fibonacciByRecursion(10));
	}
	
	public static void fibonacciByLoop(int k) {
		int i = 0;
		int j = 1;
		int count = 0;
		while(count < k) {
			System.out.print(i + " ");
			
			int temp = i;
			i = j;
			j += temp;
			count++;
		}
	}
	
	public static int fibonacciByRecursion(int k) {
		if (k == 0) return k;
		if (k == 1) return k;
		
		return fibonacciByRecursion(k-1) + fibonacciByRecursion(k-2);
	}
}
