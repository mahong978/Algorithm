package dataStructure.stack;

import java.util.LinkedList;

public class StackWithMin<T> {
	private LinkedList<T> container;
	private LinkedList<T> assist;
	public StackWithMin() {
		container = new LinkedList<>();
		assist = new LinkedList<>();
	}
	
	@SuppressWarnings("unchecked")
	public void push(T value) {
		container.push(value);
		Comparable<T> com1 = (Comparable<T>) value;
		
		T temp;
		if (assist.size() > 0) {
			if (com1.compareTo(assist.peek()) < 0)
				temp = value;
			else 
				temp = assist.peek();
		} else {
			temp = value;
		}
		assist.push(temp);
	}
	public T pop() {
		if (assist.size() > 0) assist.pop();
		if (container.size() > 0)
			return container.pop();
		else 
			return null;
	}
	public T min() {
		return assist.peek();
	}
	
	public static void main(String[] args) {
		StackWithMin<Integer> stack = new StackWithMin<>();
		stack.push(4);
		stack.push(2);
		stack.push(3);
		
		do {
			System.out.println(stack.min());
		} while(stack.pop() != null);
	}
}
