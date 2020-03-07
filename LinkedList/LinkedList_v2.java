package LinkedList;

public class LinkedList_v2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LinkedList ll = new LinkedList();
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
	Node header;
	
	static class Node{
		int data;
		Node next = null;
	}
	
	LinkedList(){
		header = new Node();
	}
	

	Node getFirst() {
		return header.next;
	}
	
	//새로운 노드 추가
	void append(int d) {
	    Node n = header;
	    
		Node end = new Node();
	    end.data = d;
	    
	    while(n.next != null) {
	    	n = n.next;
	    }
	    n.next = end;
	}
	
	//특정 data 값을 가지 노드 삭제
	void delete(int d){
		Node n = header;
		while(n.next != null) {
		   if(n.next.data == d) {
			    n.next = n.next.next;
		   }else {
			   n = n.next;   
		   }
		}	
	}
	
	void retrieve() {
		Node n = header;
		while(n.next != null) {
		     System.out.print(n.next.data+" ");
		     n = n.next;
		}
		System.out.println();
	}
	
	
	//별도의 공간을 선언하지 않고(버퍼없이) 중복값 제거하기
	void removeDups() {
		Node n = header;
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
		
	}//remove
	
}