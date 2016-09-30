package dataStructure.tree;

import util.Node.DoubleNode;

public class LongestDistance {
	
	private static int shortest = 0;
	private static int longest = 0;
	
	public static void main(String[] args) {
		DoubleNode root = new BinaryTreeBuilder(10)
				.addChild(5, 12)
				.addChild(4, 7)
				.build();
		scan(root, 0);
		System.out.println(shortest + longest);
	}
	
	public static void scan(DoubleNode root, int path) {
		if (root.left == null && root.right == null) {
			if (shortest == 0 || shortest > path) shortest = path;
			if (longest < path) longest = path;
		}
		
		if (root.left != null)
			scan(root.left, path+1);
		if (root.right != null)
			scan(root.right, path+1);
	}
}
