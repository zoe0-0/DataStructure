package Tree;


//정렬이 되어있는 배열을 이진검색 트리로 구현하시오

public class MakeArrToBSTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] a = new int[10];
		for(int i=0; i<a.length; i++) {
			a[i] = i;
		}
		
		MyTree tree = new MyTree();
		tree.makeTree(a);
		tree.searchBTree(tree.root, 9);
	}

}


class MyTree{
	class Node{
		int data;
		Node left;
		Node right;
		Node(int data){
			this.data = data;
		}
	}
	
	Node root;
	public void makeTree(int[] a) {
		root = makeTreeR(a,0,a.length-1);
	}
	
	public Node makeTreeR(int[] a, int start, int end) {
		if(start>end) {
		     return null;
		}
		
		int mid = (start+end)/2;
		Node node = new Node(a[mid]);
		
		//left
		 node.left = makeTreeR(a,start,mid-1);
		//right
		 node.right = makeTreeR(a,mid+1,end);
		
		return node;
	}
	
	//시작 노드 n / 찾을 데이터 find
	public void searchBTree(Node n, int find ) {
		if(find<n.data) {
			 System.out.println("data is smaller than "+n.data);
			 searchBTree(n.left,find); 
		}else if(find>n.data) {
			System.out.println("data is bigger than "+n.data);
			searchBTree(n.right,find);
		}else {
			System.out.println("data found!");
		}
		
	}
	
}
