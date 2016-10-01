package dataStructure.tree;

import util.Node.BinaryNode;

public class Traverse {
	public static void main(String[] args) {
		BinaryNode head = new BinaryNode.Builder(10)
				.addChild(4, 16)
				.addChild(2, 7)
				.addChild(15, 20)
				.build();
		preorder(head);
		System.out.println();
		inorder(head);
		System.out.println();
		postorder(head);
		System.out.println();
	}
	
	public static void preorder(BinaryNode parent) {
		System.out.print(parent.value + " ");
		
		if (parent.left != null)
			preorder((BinaryNode)parent.left);
		
		if (parent.right != null)
			preorder((BinaryNode)parent.right);
	}
	
	public static void inorder(BinaryNode parent) {
		if (parent.left != null)
			preorder((BinaryNode)parent.left);
		
		System.out.print(parent.value + " ");
		
		if (parent.right != null)
			preorder((BinaryNode)parent.right);
	}
	
	public static void postorder(BinaryNode parent) {
		if (parent.left != null)
			preorder((BinaryNode)parent.left);
		
		if (parent.right != null)
			preorder((BinaryNode)parent.right);
		
		System.out.print(parent.value + " ");
	}
}
