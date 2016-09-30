package algorithm;

import java.util.Arrays;
import java.util.Random;

public class Sort {
	static private int[] arr;
	static {
		Random random = new Random(123);
		arr = new int[10];
		for (int i=0; i<arr.length; i++) {
			arr[i] = random.nextInt(50);
		}
	}
	
	public static void main(String[] args) {
		bubbleSort(Arrays.copyOf(Sort.arr, Sort.arr.length));
		insertSort(Arrays.copyOf(Sort.arr, Sort.arr.length));
		selectSort(Arrays.copyOf(Sort.arr, Sort.arr.length));
		quickSort(Arrays.copyOf(Sort.arr, Sort.arr.length), 0, Sort.arr.length-1);
		shellSort(Arrays.copyOf(Sort.arr, Sort.arr.length));
		heapSort(Arrays.copyOf(Sort.arr, Sort.arr.length));
	}
	
	private static void bubbleSort(int[] arr) {
		System.out.println(Arrays.toString(arr));
		for (int i=0; i<arr.length; i++) {
			boolean hasSwapped = false;
			for (int j=arr.length-1; j>i; j--) {
				if (arr[j] < arr[j-1]) {
					int temp = arr[j];
					arr[j] = arr[j-1];
					arr[j-1] = temp;
					hasSwapped = true;
				}
			}
			if (!hasSwapped) break;
			System.out.println(Arrays.toString(arr));
		}
	}
	
	private static void insertSort(int[] arr) {
		System.out.println(Arrays.toString(arr));
		
		for (int i=1; i<arr.length; i++) {
			int temp = arr[i];
			int j = i-1;
			while(j>=0 && arr[j]>temp) {
				arr[j+1] = arr[j];
				j--;
			}
			if (j != i-1) arr[j+1] = temp;
			
			System.out.println(Arrays.toString(arr));
		}
	}
	
	private static void selectSort(int[] arr) {
		System.out.println(Arrays.toString(arr));
		
		for (int i=0; i<arr.length; i++) {
			int minIndex = i;
			for (int j=i; j<arr.length; j++) {
				if (arr[j] < arr[minIndex])
					minIndex = j;
			}
			
			int temp = arr[i];
			arr[i] = arr[minIndex];
			arr[minIndex] = temp;
			System.out.println(Arrays.toString(arr));
		}
	}
	
	private static void quickSort(int[] arr, int low, int high) {
		System.out.println(Arrays.toString(arr));
		int pivot = -1;
		
		if (high - low + 1 < 10) {
			insertSort(arr, low, high);
			return;
		}

		while(low < high) {
			pivot = partition(arr, low, high);
			quickSort(arr, low, pivot-1);
			low = pivot + 1;
		}
	}
	private static int partition(int[] arr, int low, int high) {
		int temp = arr[low];
		int left = low;
		int right = high;
		while(left != right) {
			while(left<right && arr[right]>=temp) {
				right--;
			}
			if (left < right) arr[left] = arr[right];
			
			while(left<right && arr[left]<=temp) {
				left++;
			}
			if (left < right) arr[right] = arr[left];
		}
		
		arr[left] = temp;
		return left;
	}
	private static void insertSort(int[] arr, int low, int high) {
		for (int i=low; i<high; i++) {
			int minIndex = i;
			for (int j=i; j<high; j++) {
				if (arr[j] < arr[minIndex])
					minIndex = j;
			}
			
			int temp = arr[i];
			arr[i] = arr[minIndex];
			arr[minIndex] = temp;
		}
	}
	
	private static void shellSort(int[] arr) {
		for (int inc = arr.length/2; inc>0; inc/=2) {
			for (int i=inc; i<arr.length; i++) {
				int temp = arr[i];
				int j = i-inc;
				while(j>=0 && arr[j]>temp) {
					arr[j+inc] = arr[j];
					j -= inc;
				}
				
				if (j != i-inc) arr[j+inc] = temp;
				
				System.out.println(Arrays.toString(arr));
			}
		}
	}

	private static void heapSort(int[] arr) {
		for (int i=arr.length/2-1; i>=0; i--)
			adjustDown(arr, i, arr.length);
		
		for (int i=arr.length-1; i>=0; i--) {
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;
			
			adjustDown(arr, 0, i);
			System.out.println(Arrays.toString(arr));
		}
		
		System.out.println(Arrays.toString(arr));
	}
	private static void adjustDown(int[] arr, int index, int length) {
		int temp = arr[index];
		int lastIndex = index;
		while(index <= (length/2 - 1)) {
			int left = index*2 + 1;
			int right = index*2 + 2;
			if (arr[left] < temp) lastIndex = left;
			if (right < length && arr[right] < arr[left] && arr[right] < temp) lastIndex = right;
			
			if (index != lastIndex) {
				arr[index] = arr[lastIndex];
				index = lastIndex;
			} else
				break;
		}
		arr[lastIndex] = temp;
	}
}
