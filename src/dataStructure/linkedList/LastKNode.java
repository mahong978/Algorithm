package dataStructure.linkedList;

import util.Node.LinkedNode;

public class LastKNode {
	public static void main(String[] args) {
		LinkedNode head = LinkedNode.Builder.convert(1, 2, 3, 4, 5, 6, 7, 8);
		System.out.println(find(head, 4));
	}
	
	public static LinkedNode find(LinkedNode head, int k) {
		if (head == null) return null;
		
		LinkedNode p1 = head;
		LinkedNode p2 = head;
		int count = 0;
		while(head.next != null && count < k) {
			p2 = p2.next;
			count++;
		}
		if (count != k)
			return null;
		
		while(p2 != null) {
			p1 = p1.next;
			p2 = p2.next;
		}
		return p1;
	}
}
