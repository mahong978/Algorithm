package algorithm;

public class CountOnes {
	public static void main(String[] args) {
		System.out.println(countOnes(0x80000000));
		System.out.println(countOnesAdvance(0x80000000));
	}
	
	private static int countOnes(int n) {
		int count = 0;
		int flag = 1;
		while (flag != 0) {
			if ((flag & n) != 0) {
				count ++;
			}
			flag <<= 1;
		}
		
		return count;
	}
	
	private static int countOnesAdvance(int n) {
		int count = 0;
		while (n != 0) {
			count ++;
			
			n = (n-1) & n;
		}
		
		return count;
	}
}
