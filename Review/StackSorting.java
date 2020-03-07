package Review;


//스택 정렬함수 작성하기 -> 오름차순정렬
//하나의 스택 추가만 가능
//배열 등 다른 자료구조 사용불가

public class StackSorting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<Integer> s1 = new Stack<>();
	    s1.push(3);
	    s1.push(5);
	    s1.push(1);
	    s1.push(6);
	    Stack<Integer> s2 = sort(s1);
	    System.out.println(s2.pop());
	    System.out.println(s2.pop());
	    System.out.println(s2.pop());
	    System.out.println(s2.pop());
	}

	private static Stack<Integer> sort(Stack<Integer> s1) {
		Stack<Integer> s2 = new Stack<>();
		
		while(!s1.isEmpty()) {
			int tmp = s1.pop();
			while(!s2.isEmpty() && s2.peek()<tmp) {
				s1.push(s2.pop());
			}
			s2.push(tmp);
		}
		
		return s2;
	}
	
	
}
