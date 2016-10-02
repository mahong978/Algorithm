package dataStructure.tree;

import util.Node.BinaryNode;

public class IsSubTree {
	public static void main(String[] args) {
		BinaryNode root1 = new BinaryNode.Builder(8)
				.addChild(8, 7)
				.addChild(9, 2)
				.addChild(BinaryNode.Builder.NULL_CHILD, BinaryNode.Builder.NULL_CHILD)
				.addChild(BinaryNode.Builder.NULL_CHILD, BinaryNode.Builder.NULL_CHILD)
				.addChild(4, 7)
				.build();
		BinaryNode root2 = new BinaryNode.Builder(8)
				.addChild(9, 2)
				.build();
		
		System.out.println(isSubTree(root1, root2));
	}
	
	private static boolean isSubTree(BinaryNode root1, BinaryNode root2) {
		boolean result = false;
		
		if (root1 != null && root2 != null) {
			if (root1.compareTo(root2) == 0)
				result = checkIsSub(root1, root2);

			if (!result)
				result = isSubTree(root1.left, root2);
			if (!result)
				result = isSubTree(root1.right, root2);
		}

		return result;
	}
	
	private static boolean checkIsSub(BinaryNode node1, BinaryNode node2) {
		if (node2 == null)
			return true;
		if (node1 == null)
			return false;
		
		if (node1.compareTo(node2) != 0)
			return false;
		else
			return checkIsSub(node1.left, node2.left) &&
					checkIsSub(node1.right, node2.right);
	}
}
