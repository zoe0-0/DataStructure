package Stack_Queue;

//두개의 스택으로 큐 만들기

public class StackQueue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MyQueue<Integer> q = new MyQueue<>();
		q.add(1);
		q.add(2);
		q.add(3);
		System.out.println(q.remove());
		System.out.println(q.remove());
		System.out.println(q.remove());

		
	}

}

class MyQueue<T>{
	Stack<T> stackNewest, stackOldest;
	MyQueue(){
		stackNewest = new Stack<T>();
		stackOldest = new Stack<T>();
	}
	public int size() {
		return stackNewest.size() + stackOldest.size();
	}
	
	public void add(T value) {
		 stackNewest.push(value);
	}
	
	public void shiftStack() {
		if(stackOldest.isEmpty()) {
			while(!stackNewest.isEmpty()) {
				stackOldest.push(stackNewest.pop() );
			}
		}
	}
	
	public T peek() {
		shiftStack();
		return stackOldest.peek();
	}
	
	public T remove() {
		shiftStack();
		return stackOldest.pop();
	}
	
}