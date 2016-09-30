package dataStructure.linkedList;

import java.util.LinkedList;

public class QueueWithTwoStack<T> {
	LinkedList<T> stack1 = new LinkedList<>();
	LinkedList<T> stack2 = new LinkedList<>();
	boolean inStack2;
	
	public void offer(T element) {
		if (inStack2) {
			while(!stack2.isEmpty()) {
				stack1.push(stack2.pop());
			}
			inStack2 ^= true;
		}
		stack1.push(element);
	}
	
	public T poll() {
		T result = null;
		while(!stack1.isEmpty()) {
			T element = stack1.pop();
			if (stack1.isEmpty()) {
				result = element;
			} else {
				stack2.push(element);
			}
		}
		
		inStack2 ^= true;
		return result;
	}
	
	public static void main(String[] args) {
		QueueWithTwoStack<Integer> queue = new QueueWithTwoStack<>();
		queue.offer(0);
		queue.offer(1);
		System.out.println(queue.poll());
		queue.offer(2);
		queue.offer(3);
		System.out.println(queue.poll());
	}
}
