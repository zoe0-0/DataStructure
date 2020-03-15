package LinearList;

import LinearList.LinkedList.Node;

public class KthData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	  LinkedList ll = new LinkedList();
	  ll.append(2);
	  ll.append(3);
	  ll.append(1);
	  ll.append(4);
	  int k = 3;
	  //Node kth = kthToLast1(ll.getFirst(),k);
	  //System.out.println(kth.data); 
	  
	 //kthToLast2(ll.getFirst(),k);
	 //Reference r = new Reference();
	 //Node found = kthToLast3(ll.getFirst(),k,r);
	 //System.out.println(found.data);
	  
	   Node found =  kthToLast4(ll.getFirst(),k);
	   System.out.println(found.data);
	}
	
	
	private static Node kthToLast1(Node first, int k) {
		Node n = first;
	    int total = 1;
	    while(n.next!=null) {
	    	++total;
	    	n = n.next;
	    }
	    n = first;
	    for(int i=1; i<total-k+1; i++) {
	    	n=n.next;
	    }
	    return n;
	}
	
	
	
	//count를 리턴하도록 함
	private static int kthToLast2(Node n, int k) {
		if(n==null) {
			return 0;
		}
		int count = kthToLast2(n.next,k) +1;
		if(count==k) {
			System.out.println(k+"th to Last node is "+n.data);
		}
		return count;
	}

	

	
	//k번째의 노드 자체를 리턴
	private static Node kthToLast3(Node n, int k, Reference r) {
		if(n==null) {
			return null;
		}
		Node found = kthToLast3(n.next, k, r);
		r.count++; 
		if(r.count==k) {
			return n;
		}
		return found;
	}

	
	//k번째의 노드 자체를 리턴
	private static Node kthToLast4(Node first, int k) {
		Node p1 = first;
		Node p2 = p1;
		for(int i=1; i<=k; i++) {
			//
		    if(p2==null) return null;
			p2=p2.next;
		}
		
		while(p2!=null) {
			p1 = p1.next;
			p2 = p2.next;
		}
		
		 return p1;
		
	}
	
}



class Reference{
	public int count;
}
