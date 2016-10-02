package dataStructure.linkedList;

import java.util.LinkedList;

import util.Node.LinkedNode;

public class NearestPublicNode {
	public static void main(String[] args) {
		LinkedNode head1 = LinkedNode.Builder.convert(1,2,3,4,5,6,7);
		LinkedNode head2 = LinkedNode.Builder.convert(10,11,3,4,5,6,7);
		find(head1, head2);
	}
	public static boolean find(LinkedNode head1, LinkedNode head2) {
		int result = 0;
		LinkedList<Integer> list1 = new LinkedList<>();
		LinkedList<Integer> list2 = new LinkedList<>();
		while(head1.next != null) {
			list1.push(head1.getValue());
			head1 = head1.next;
		}
		while(head2.next != null) {
			list2.push(head2.getValue());
			head2 = head2.next;
		}
		
		if (list1.peek() != list2.peek()) return false;
		while(!list1.isEmpty() && !list2.isEmpty()) {
			if (list1.peek() == list2.peek()) {
				result = list1.pop();
				list2.pop();
			} else {
				break;
			}
		}
		System.out.println(result);
		return true;
	}
}
