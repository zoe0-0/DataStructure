package LinearList;

public class LinkedList_v1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Node node = new Node(1);
		node.append(2);
		node.append(3);
		node.append(4);
		node.append(5);
		node.delete(2);
		node.retrieve();
		
	}

}


class Node{
	int data;
	Node next = null;
	Node(int d){
		this.data = d;
	}
	
	
	//새로운 노드 맨뒤에 추가
	void append(int d) {
		Node end = new Node(d);
	    Node n = this;
	    while(n.next != null) {
	    	n = n.next;
	    }
	    n.next = end;
	}
	
	//특정 data 값을 가지 노드 삭제
	void delete(int d){
		Node n = this;
		while(n.next != null) {
		   if(n.next.data == d) {
			    n.next = n.next.next;
		   }else {
			   n = n.next;   
		   }
		}	
	}
	
	void retrieve() {
		Node n = this;
		while(n.next != null) {
		     System.out.println(n.data);
		     n = n.next;
		}
		System.out.println(n.data);
	}
	
	
}