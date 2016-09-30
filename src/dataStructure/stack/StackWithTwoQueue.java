package dataStructure.stack;

import java.util.LinkedList;

public class StackWithTwoQueue<T> {
	LinkedList<T> list1 = new LinkedList<>();
	LinkedList<T> list2 = new LinkedList<>();
	boolean inList2;
	
	public void push(T element) {
		if (inList2)
			list2.add(element);
		else
			list1.add(element);
	}
	
	public T pop() {
		LinkedList<T> oldList = inList2 ? list2 : list1;
		LinkedList<T> newList = inList2 ? list1 : list2;
		inList2 ^= true;
		
		T result = null;
		while (!oldList.isEmpty()) {
			T element = oldList.poll();
			if (oldList.isEmpty()) {
				result = element;
			}
			else newList.add(element);
		}
		return result;
	}
	
	public static void main(String[] args) {
		StackWithTwoQueue<Integer> stack = new StackWithTwoQueue<>();
		stack.push(0);
		stack.push(1);
		System.out.println(stack.pop());
		stack.push(2);
		stack.push(3);
		System.out.println(stack.pop());
	}
}
