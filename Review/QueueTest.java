package Review;

import java.util.NoSuchElementException;


public class QueueTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Queue<Integer> q = new Queue<>();
	    q.add(1);
		q.add(2);
		q.add(3);
		q.add(4);
		System.out.println(q.remove());
		System.out.println(q.remove());
		System.out.println(q.peek());
		System.out.println(q.remove());
		System.out.println(q.isEmpty());
		System.out.println(q.remove());
		System.out.println(q.isEmpty());
		
	}

}


// remove() add() peek() isEmpty()
class Queue<T>{
	class Node<T>{
		private T data;
		private Node<T> next;
		public Node(T data){
			this.data = data;
		}
	}
	
	private Node<T> first;
	private Node<T> last;
	
	public void add(T data) {
		Node<T> t = new Node<>(data);
		if(last!=null) {
			last.next = t;
		}
		last = t;
		if(first == null) {
			first = last;
		}
	}
	
	public T remove() {
		if(first == null) {
			throw new NoSuchElementException();
		}
		T item = first.data;
		first = first.next;
		
		if(first == null) {
			last = null;
		}
		return item;
	}
	
	public T peek() {
		if(first == null) {
			throw new NoSuchElementException();
		}
		return first.data;
	}
	
	public boolean isEmpty() {
		return first==null;
	}
	
}