package dataStructure.tree;

import util.Node.BinaryNode;

public class TreeToLinkedList {
	
	static BinaryNode currLast = null;
	
	public static void main(String[] args) {
		BinaryNode head = new BinaryNode.Builder(10)
				.addChild(4, 16)
				.addChild(2, 7)
				.addChild(15, 20)
				.build();
		BinaryNode listHead = convert(head);
		BinaryNode node = listHead;
		while(node != null) {
			System.out.print(node.getValue() + " ");
			node = node.right;
		}
	}
	
	public static BinaryNode convert(BinaryNode head) {
		currLast = null;
		convertNode(head);
		
		BinaryNode listHead = currLast;
		while(listHead != null && listHead.left != null)
			listHead = listHead.left;
		
		return listHead;
	}
	
	public static void convertNode(BinaryNode node) {
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
