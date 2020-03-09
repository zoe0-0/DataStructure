package LinkedList;

import LinkedList.LinkedList.Node;

public class DeleteMidNodeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LinkedList ll = new LinkedList();
		ll.append(1);
		ll.append(2);
		ll.append(3);
		ll.append(4);
		ll.retrieve();
		
		deleteNode(ll.get(3));
		ll.retrieve();
	}

	//삭제 실패했는지 성공헀는지 boolean 타입 리턴
	//처음과 마지막 노드는 지울 수 없다. 
	public static boolean deleteNode(Node n) {
		if(n==null || n.next==null) {
			return false;
		}
		Node next = n.next;
		n.data = next.data;
		n.next = next.next;
		return true;
		
	}
	
}
