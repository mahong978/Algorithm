package dataStructure.tree;

import java.util.LinkedList;

import util.Node.DoubleNode;

public class MirrorTree {
	public static void main(String[] args) {
		DoubleNode root = new BinaryTreeBuilder(10)
				.addChild(4, 16)
				.addChild(2, 7)
				.addChild(15, 20)
				.build();
		convert(root);
	}
	
	public static void convert(DoubleNode head) {
		LinkedList<DoubleNode> list = new LinkedList<>();
		list.add(head);
		
		while(!list.isEmpty()) {
			DoubleNode node = list.pop();
			DoubleNode left = node.left;
			DoubleNode right = node.right;
			node.left = right;
			node.right = left;
			list.add(left);
			list.add(right);
		}
	}
}
