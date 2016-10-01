package dataStructure.tree;

import java.util.LinkedList;

import util.Node.BinaryNode;

public class PrintBinaryTree {
	public static void main(String[] args) {
		BinaryNode root = new BinaryNode.Builder(10)
				.addChild(4, 16)
				.addChild(2, 7)
				.addChild(15, 20)
				.build();
		print(root);
	}
	
	public static void print(BinaryNode root) {
		LinkedList<BinaryNode> list = new LinkedList<>();
		list.add(root);
		
		while(!list.isEmpty()) {
			BinaryNode node = list.poll();
			if (node == null) continue;
			
			System.out.print(node + " ");
			list.add(node.left);
			list.add(node.right);
		}
	}
}
