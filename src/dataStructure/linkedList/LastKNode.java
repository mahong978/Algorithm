package dataStructure.linkedList;

import util.Node.SingleNode;

public class LastKNode {
	public static void main(String[] args) {
		SingleNode head = LinkedListBuilder.convert(1, 2, 3, 4, 5, 6, 7, 8);
		System.out.println(find(head, 4));
	}
	
	public static SingleNode find(SingleNode head, int k) {
		if (head == null) return null;
		
		SingleNode p1 = head;
		SingleNode p2 = head;
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
