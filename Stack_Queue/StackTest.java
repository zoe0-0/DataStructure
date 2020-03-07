package Stack_Queue;

import java.util.EmptyStackException;

public class StackTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Stack<Integer> s = new Stack<>();
		s.push(1);
		s.push(2);
		s.push(3);
		s.push(4);
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.peek());
		System.out.println(s.pop());
		System.out.println(s.isEmpty());
		
		
	}

}


class Stack<T>{
	class Node<T>{
		private T data;
		private Node<T> next;
		public Node(T data) {
			this.data = data;
		}
	}
	private Node<T> top;
	private int size=0;
	
	public T pop() {
		if(top==null) {
			throw new EmptyStackException();
		}
		
		T item = top.data;
		top = top.next;
		--size;
		return item;
	}
	
	public void push(T item) {
		Node<T> t = new Node<>(item);
		t.next = top;
		top = t;
		++size;
	}
	
	
	public T peek() {
		if(top==null) {
			throw new EmptyStackException();
		}
		return top.data;
	}
	
	public boolean isEmpty() {
		return top==null;
	}
	
	public int size() {
		return size;
	}
	
}