package dataStructure.tree;

import util.Node.DoubleNode;

public class TreeToLinkedList {
	
	static DoubleNode currLast = null;
	
	public static void main(String[] args) {
		DoubleNode head = new BinaryTreeBuilder(10)
				.addChild(4, 16)
				.addChild(2, 7)
				.addChild(15, 20)
				.build();
		DoubleNode listHead = convert(head);
		DoubleNode node = listHead;
		while(node != null) {
			System.out.print(node.value + " ");
			node = node.right;
		}
	}
	
	public static DoubleNode convert(DoubleNode head) {
		currLast = null;
		convertNode(head);
		
		DoubleNode listHead = currLast;
		while(listHead != null && listHead.left != null)
			listHead = listHead.left;
		
		return listHead;
	}
	
	public static void convertNode(DoubleNode node) {
		if (node == null) return;
		
		if (node.left != null)
			convertNode(node.left);
		
		node.left = currLast;
		if (currLast != null)
			currLast.right = node;
		currLast = node;
		
		if (node.right != null)
			convertNode(node.right);
	}
}
