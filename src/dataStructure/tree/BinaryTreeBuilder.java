package dataStructure.tree;

import java.util.LinkedList;

import util.Node.DoubleNode;

public class BinaryTreeBuilder {
	private DoubleNode head;
	private DoubleNode currParent;
	private LinkedList<DoubleNode> list;
	public static int NULL_CHILD = Integer.MAX_VALUE;
	public BinaryTreeBuilder(int value) {
		head = new DoubleNode(value);
		list = new LinkedList<>();
		
		list.offer(head);
		currParent = list.poll();
	}
	public BinaryTreeBuilder addChild(int left, int right) {
		DoubleNode child;
		if (left != NULL_CHILD) {
			child = new DoubleNode(left);
			currParent.left = child;
			list.offer(child);
		}
		else
			currParent.left = null;
		
		if (right != NULL_CHILD) {
			child = new DoubleNode(right);
			currParent.right = child;
			list.offer(child);
		}
		else
			currParent.right = null;
		
		currParent = list.poll();
		return this;
	}
	public DoubleNode build() {
		return head;
	}
}
