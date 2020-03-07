package Review;


public class LinkedListTest {

	public static void main(String[] args) {
       // TODO Auto-generated method stub
		
		
		LinkedList ll = new LinkedList();
		
		ll.append(0);
		ll.append(1);
		ll.append(2);
		ll.append(2);
		ll.append(3);
		ll.append(4);
		ll.append(4);
		ll.retrieve();
		
		ll.removeDups();
		ll.retrieve();
			
		
	}
	
	
	
}


class LinkedList{
	class Node{
		int data;
		Node next = null;
	}
	
	Node header;
	
	LinkedList(){
		header = new Node();
	}
	
	void append(int data) {
		Node n = header;
		
		Node end = new Node();
		end.data = data;
		
		while(n.next!=null) {
			n = n.next;
		}
		
		n.next = end;
	}
	
	void delete(int data) {
		Node n = header;
		while(n.next!=null) {
			if(n.next.data == data) {
				n.next = n.next.next;
			}else {
				n = n.next;
			}
		}
	}
	
	void retrieve() {
		Node n = header;
		while(n.next!=null) {
			System.out.print(n.next.data+" ");
			n = n.next;
		}
		System.out.println();
	}
	
	
	//별도의 공간을 선언하지 않고(버퍼없이) 중복값 제거하기
	//두개의 포인터를 사용함 -n,r

		void removeDups() {
			Node n = header.next;
			while(n!=null && n.next!=null) {
				Node r = n;
				while(r.next!=null) {
					if(r.next.data == n.data) {
						r.next = r.next.next;
					}else {
						r = r.next;
					}
				}
				n = n.next;
			}
		}
	
}


//append - 새로운 노드 추가하기
//delete - 특정 data 값을 가지는 노드 삭제
//retrieve - 출력

//별도의 공간을 선언하지 않고(버퍼없이) 중복값 제거하기
//void removeDups()