package dataStructure.linkedList;

import util.Node.SingleNode;

public class LinkedListBuilder {
	public static SingleNode convert(int... value) {
		if (value.length == 0) return null;
		
		SingleNode head = new SingleNode(value[0]);
		SingleNode curr = head;
		for (int i = 1; i < value.length; i++) {
			SingleNode temp = new SingleNode(value[i]);
			curr.next = temp;
			curr = temp;
		}
		return head;
	}
}
