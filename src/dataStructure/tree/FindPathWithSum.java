package dataStructure.tree;

import java.util.Iterator;
import java.util.LinkedList;

import util.Node.BinaryNode;

public class FindPathWithSum {
	public static void main(String[] args) {
		BinaryNode head = new BinaryNode.Builder(10)
				.addChild(5, 12)
				.addChild(4, 7)
				.build();
		findPath(head, 22);
	}
	
	public static void findPath(BinaryNode head, int sum) {
		checkNode(head, new LinkedList<>(), 0, sum);
	}
	
	public static void checkNode(BinaryNode node, LinkedList<Integer> list, int currSum, int sum) {
		currSum += node.value;
		list.add(node.value);
		if (currSum == sum) {
			Iterator<Integer> it = list.iterator();
			while(it.hasNext())
				System.out.print(it.next() + " ");
			System.out.println();
		} else {
			if (node.left != null)
				checkNode(node.left, list, currSum, sum);
			if (node.right != null)
				checkNode(node.right, list, currSum, sum);
		}
		
		list.removeLast();
		currSum -= node.value;
	}
}
