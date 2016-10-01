package dataStructure.tree;

import util.Node.BinaryNode;

public class RebuildBinaryTree {
	public static void main(String[] args) {
		int[] preOrder = {1, 2, 4, 7, 3, 5, 6, 8};
		int[] inOrder = {4, 7, 2, 1, 5, 3, 8, 6};
		BinaryNode head = rebuild(preOrder, inOrder, 0, 7, 0, 7);
		PrintBinaryTree.print(head);
	}
	
	private static BinaryNode rebuild(int[] preOrder, int[] inOrder,
			int preStart, int preEnd,
			int inStart, int inEnd) {
		if (preStart > preEnd || inStart > inEnd) return null;
		
		int head = preOrder[preStart];
		int index;
		for (index = inStart; index <= inEnd; index++) {
			if (inOrder[index] == head)
				break;
		}
		int leftPreEnd = preStart+index-inStart;
		
		BinaryNode root = new BinaryNode(head);
		root.left = rebuild(preOrder, inOrder, preStart+1, leftPreEnd, inStart, index-1);
		root.right = rebuild(preOrder, inOrder, leftPreEnd+1, preEnd, index+1, inEnd);
		
		return root;
	}
}
