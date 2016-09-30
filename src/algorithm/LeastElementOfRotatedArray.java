package algorithm;

public class LeastElementOfRotatedArray {
	public static void main(String[] args) {
		int[] arr = {1, 0, 1, 1, 1};
		System.out.println(arr[find(arr)]);
	}
	
	private static int find(int[] arr) {
		int start = 0;
		int end = arr.length-1;
		int result = 0;
		while(arr[start] >= arr[end]) {
			if (end - start == 1) {
				result = end;
				break;
			}
			
			int mid = (start + end) / 2;
			if (arr[mid] == arr[start] && arr[mid] == arr[end]) {
				int min = arr[start];
				result = start;
				for (int i = start+1; i <= end; i++) {
					if (arr[i] < min) {
						min = arr[i];
						result = i;
					}
				}
				break;
			} else if (arr[mid] >= arr[start]) {
				start = mid;
			} else if (arr[mid] <= arr[end]) {
				end = mid;
			}
		}
		
		return result;
	}
}
