package algorithm;

public class YoungMatrixSearch {
	public static void main(String[] args) {
		int[][] matrix = {
				{1, 2, 8, 9},
				{2, 4, 9, 12},
				{4, 7, 10, 13},
				{6, 8, 11, 15}
		};
		search(matrix, 7, 4, 4);
	}
	
	private static boolean search(int[][] matrix, int target, int column, int row) {
		int currCol = column-1;
		int currRow = 0;
		while(currCol >= 0 && currRow < row) {
			if (matrix[currRow][currCol] > target) {
				currCol--;
			} else if (matrix[currRow][currCol] < target) {
				currRow++;
			} else {
				System.out.println(currRow + " " + currCol);
				return true;
			}
		}
		return false;
	}
}
