package algorithm;

public class BitOperation {
	public static void main(String[] args) {
		System.out.println(divide(100, 3));
	}
	
	public static int add(int multiplicand, int op2) {
		int sum = multiplicand;
		int carry = op2;
		while(carry != 0) {
			int temp = sum;
			
			sum = sum ^ carry;
			carry = (temp & carry) << 1;
		}
		
		return sum;
	}
	
	public static int substract(int op1, int op2) {
		int opposite = add(~op2, 1);
		
		return add(op1, opposite);
	}
	
	public static int multiply(int op1, int op2) {
		int multiplicand = op1 >= 0 ? op1 : add(~op1, 1);
		int multiplier = op2 >= 0 ? op2 : add(~op2, 1);
		
		int result = 0;
		int i = 0;
		while(multiplicand != 0) {
			if ((multiplicand & 1) != 0)
				result = add(result, multiplier << i);
			
			i++;
			multiplicand >>= 1;
		}
		
		if ((op1 ^ op2) < 0)
			result = add(~result, 1);
		
		return result;
	}
	
	public static int divide(int op1, int op2) {
		int dividend = op1 >= 0 ? op1 : add(~op1, 1);
		int divisor = op2 >= 0 ? op2 : add(~op2, 1);
		
		int reverse = 2;
		while(dividend != 0) {
			reverse |= dividend & 1;
			reverse <<= 1;
			dividend >>= 1;
		}
		
		int quotient = 0;
		int remainder = 0;
		while(reverse > 1) {
			remainder <<= 1;
			remainder |= reverse & 1;
			reverse >>= 1;
			quotient <<= 1;
			
			if(remainder >= divisor) {
				quotient |= 1;
				remainder = substract(remainder, divisor);
			}
		}
		
		if ((op1 ^ op2) < 0)
			quotient = add(~quotient, 1);
		
		return quotient;
	}
}
