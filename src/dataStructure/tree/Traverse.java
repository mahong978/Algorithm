package dataStructure.tree;

import util.Node.DoubleNode;

public class Traverse {
	public static void main(String[] args) {
		DoubleNode head = new BinaryTreeBuilder(10)
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
	
	public static void preorder(DoubleNode parent) {
		System.out.print(parent.value + " ");
		
		if (parent.left != null)
			preorder((DoubleNode)parent.left);
		
		if (parent.right != null)
			preorder((DoubleNode)parent.right);
	}
	
	public static void inorder(DoubleNode parent) {
		if (parent.left != null)
			preorder((DoubleNode)parent.left);
		
		System.out.print(parent.value + " ");
		
		if (parent.right != null)
			preorder((DoubleNode)parent.right);
	}
	
	public static void postorder(DoubleNode parent) {
		if (parent.left != null)
			preorder((DoubleNode)parent.left);
		
		if (parent.right != null)
			preorder((DoubleNode)parent.right);
		
		System.out.print(parent.value + " ");
	}
}
