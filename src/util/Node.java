package util;

import java.util.LinkedList;

public class Node implements Comparable<Node>{
	protected int value;
	
	public Node(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
	
	@Override
	public String toString() {
		return "" + value;
	}
	
	public static class LinkedNode extends Node {
		public LinkedNode next;
		
		public LinkedNode(int value) {
			super(value);
		}
		public static void connect(LinkedNode n1, LinkedNode n2) {
			while(n1.next != null)
				n1 = n1.next;
			
			n1.next = n2;
		}
		public String printAll() {
			LinkedNode temp = this;
			StringBuilder sb = new StringBuilder();
			while(temp != null) {
				sb.append(temp.value);
				temp = temp.next;
			}
			
			return sb.toString();
		}
		
		public static class Builder {
			public static LinkedNode convert(int... value) {
				if (value.length == 0) return null;
				
				LinkedNode head = new LinkedNode(value[0]);
				LinkedNode curr = head;
				for (int i = 1; i < value.length; i++) {
					LinkedNode temp = new LinkedNode(value[i]);
					curr.next = temp;
					curr = temp;
				}
				return head;
			}
		}
	}

	public static class BinaryNode extends Node{
		public BinaryNode left;
		public BinaryNode right;
		
		public BinaryNode(int value) {
			super(value);
		}
		public BinaryNode(int value, BinaryNode left, BinaryNode right) {
			super(value);
			this.left = left;
			this.right = right;
		}
		
		public static class Builder {
			private BinaryNode head;
			private BinaryNode currParent;
			private LinkedList<BinaryNode> list;
			public static int NULL_CHILD = Integer.MAX_VALUE;
			public Builder(int value) {
				head = new BinaryNode(value);
				list = new LinkedList<>();
				
				list.offer(head);
				currParent = list.poll();
			}
			public Builder addChild(int left, int right) {
				BinaryNode child;
				if (left != NULL_CHILD) {
					child = new BinaryNode(left);
					currParent.left = child;
					list.offer(child);
				}
				else
					currParent.left = null;
				
				if (right != NULL_CHILD) {
					child = new BinaryNode(right);
					currParent.right = child;
					list.offer(child);
				}
				else
					currParent.right = null;
				
				currParent = list.poll();
				return this;
			}
			public BinaryNode build() {
				return head;
			}
		}
	}

	@Override
	public int compareTo(Node o) {
		if (value < o.value)
			return -1;
		else if (value > o.value)
			return 1;
		else
			return 0;
	}
}


