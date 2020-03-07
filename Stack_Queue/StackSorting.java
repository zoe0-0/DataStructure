package Stack_Queue;

public class StackSorting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	    Stack<Integer> s1 = new Stack<>();
	    s1.push(3);
	    s1.push(5);
	    s1.push(1);
	    s1.push(6);
	    sort(s1);
	    System.out.println(s1.pop());
	    System.out.println(s1.pop());
	    System.out.println(s1.pop());
	    System.out.println(s1.pop());

		
	}

	private static void sort(Stack<Integer> s1) {
		Stack<Integer> s2 = new Stack<>();
		while(!s1.isEmpty()) {
			int tmp = s1.pop();
			while(!s2.isEmpty() && s2.peek() > tmp) {
				s1.push(s2.pop());
			}
			s2.push(tmp);
		}
		
		//다시 s1으로 부어준다.s1에서 pop 하면 오름차순
		while(!s2.isEmpty()) {
			s1.push(s2.pop());
		}
		
	}
	
	
	
}
