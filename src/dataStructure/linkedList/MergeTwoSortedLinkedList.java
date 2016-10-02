package dataStructure.linkedList;

import util.Node.LinkedNode;

public class MergeTwoSortedLinkedList {
	public static void main(String[] args) {
		LinkedNode head1 = LinkedNode.Builder.convert(1, 2, 3, 9);
		LinkedNode head2 = LinkedNode.Builder.convert(5, 6 ,7, 8);
		System.out.println(merge(head1, head2).printAll());
	}
	
	private static LinkedNode merge(LinkedNode head1, LinkedNode head2) {
		LinkedNode result = null;
		LinkedNode curr = null;
		while (head1 != null && head2 != null) {
			LinkedNode temp;
			if (head1.compareTo(head2) < 0) {
				temp = head1;
				head1 = head1.next;
			} else {
				temp = head2;
				head2 = head2.next;
			}
			
			if (curr == null) {
				curr = temp;
				result = temp;
			} else {
				curr.next = temp;
				curr = temp;
			}
		}
		
		if (head1 != null)
			curr.next = head1;
		else if (head2 != null)
			curr.next = head2;
		
		return result;
	}
}
