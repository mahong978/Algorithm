package dataStructure.tree;

import java.util.LinkedList;

import util.Node.DoubleNode;

public class PrintTree {
	public static void main(String[] args) {
		DoubleNode root = new BinaryTreeBuilder(10)
				.addChild(4, 16)
				.addChild(2, 7)
				.addChild(15, 20)
				.build();
		print(root);
	}
	
	public static void print(DoubleNode root) {
		LinkedList<DoubleNode> list = new LinkedList<>();
		list.add(root);
		
		while(!list.isEmpty()) {
			DoubleNode node = list.poll();
			if (node == null) continue;
			
			System.out.print(node + " ");
			list.add(node.left);
			list.add(node.right);
		}
	}
}
