package dataStructure.tree;

import java.util.LinkedList;

import util.Node.BinaryNode;

public class MirrorBinaryTree {
	public static void main(String[] args) {
		BinaryNode root = new BinaryNode.Builder(10)
				.addChild(4, 16)
				.addChild(2, 7)
				.addChild(15, 20)
				.build();
		convert(root);
	}
	
	public static void convert(BinaryNode head) {
		LinkedList<BinaryNode> list = new LinkedList<>();
		list.add(head);
		
		while(!list.isEmpty()) {
			BinaryNode node = list.pop();
			BinaryNode left = node.left;
			BinaryNode right = node.right;
			node.left = right;
			node.right = left;
			list.add(left);
			list.add(right);
		}
	}
}
