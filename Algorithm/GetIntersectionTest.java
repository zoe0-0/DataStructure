package Algorithm;


// 문제)
// 단방향 linkedlist에서 교차점 찾기
// 5 - 7 - 9 - 10 - 7 - 6
// 6 - 8 - 10 - 7 - 6
// 교차점 10

// 해결포인트)
// 두 리스트의 끝을 맞춘다음 짧은 쪽 리스트의 첫번째를 시작지점으로 맞춰 비교하다가 같은 수가 나오는 노드 리턴


public class GetIntersectionTest {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Node n1 = new Node(5);
		Node n2 = n1.addNext(7);
		Node n3 = n2.addNext(9);
		Node n4 = n3.addNext(10);
		Node n5 = n4.addNext(7);
		Node n6 = n5.addNext(6);
		
		Node m1 = new Node(6);
		Node m2 = m1.addNext(8);
		Node m3 = m2.addNext(n4);
		
		n1.print();
		m1.print();
		
		Node n = getIntersection(n1,m1);
		if(n != null) {
			System.out.println(n.data);
		}else {
			System.out.println("not found");
		}
	}
	
	private static int getListLength(Node l) {
		int total = 0;
		while(l!=null) {
			++total;
			l = l.next;
		}
		return total;
	}

	
	
	private static Node getIntersection(Node l1,Node l2) {
		int len1 = getListLength(l1);
		int len2 = getListLength(l2);
		
		if(len1>len2) {
			l1 = l1.get(len1-len2);
		}else if(len1<len2) {
			l2 = l2.get(len2-len1);
		}
		
		while(l1 != null && l2!=null) {
			if(l1==l2) {
				return l1;
			}
			l1 = l1.next;
			l2 = l2.next;
		}
		
	    return null;
		
	}
	
}


class Node{
	int data;
	Node next = null;
	
	public Node(int data){
		this.data = data;
	}
	
	//index 0부터 시작
	public Node get(int index) {
		Node n = this;
		for(int i=0; i<index; i++) {
			n = n.next;
		}
		return n;
	}
	
	public Node addNext(int data) {
		Node n = new Node(data);
		this.next = n;
		return n;
	}

	public Node addNext(Node n) {
		this.next = n;
		return n;
	}
	
	public void print() {
		Node n = this;
		while(n!=null) {
			System.out.print(n.data+" ");
			n = n.next;
		}
		System.out.println();
	}
}