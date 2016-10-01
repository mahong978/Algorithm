package dataStructure.tree;

import util.Node.BinaryNode;

public class LongestDistance {
	
	private static int longest1 = 0;
	private static int longest2 = 0;
	
	public static void main(String[] args) {
		BinaryNode root = new BinaryNode.Builder(10)
				.addChild(5, 12)
				.addChild(4, 7)
				.build();
		
		BinaryNode origin = findOrigin(root);
		scan(origin.left, 1, true);
		scan(origin.right, 1, false);
		
		System.out.println(longest1 + longest2);
	}
	
	public static BinaryNode findOrigin(BinaryNode root) {
		BinaryNode result = root;
		while(result != null && (result.left == null || result.right == null)) {
			if (result.left == null)
				result = result.right;
			else if (result.right == null)
				result = result.left;
			else
				break;
		}
		return result;
	}
	
	public static void scan(BinaryNode root, int path, boolean isLeft) {
		if (root.left == null && root.right == null) {
			if (isLeft && longest1 < path) longest1 = path;
			if (!isLeft && longest2 < path) longest2 = path;
		}
		
		if (root.left != null)
			scan(root.left, path+1, isLeft);
		if (root.right != null)
			scan(root.right, path+1, isLeft);
	}
}
