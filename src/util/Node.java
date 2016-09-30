package util;

public class Node {
	public int value;
	
	public Node(int value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return "" + value;
	}
	
	public static class SingleNode extends Node {
		public SingleNode next;
		
		public SingleNode(int value) {
			super(value);
		}
		public static void connect(SingleNode n1, SingleNode n2) {
			while(n1.next != null)
				n1 = n1.next;
			
			n1.next = n2;
		}
	}

	public static class DoubleNode extends Node{
		public DoubleNode left;
		public DoubleNode right;
		public DoubleNode(int value) {
			super(value);
		}
		public DoubleNode(int value, DoubleNode left, DoubleNode right) {
			super(value);
			this.left = left;
			this.right = right;
		}
	}
}


