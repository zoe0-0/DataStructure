package Algorithm;


//이진검색트리에서 주어진 노드의 다음노드를 찾는 함수
public class FindNextNodeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
  
		Tree t = new Tree(10);
		
		//3의 다음 노드는 ?
		t.findNext(t.root.left.right.right);
		//1의 다음 노드는 ?
		t.findNext(t.root.left);
		
		t.findNext(t.root);
		
		t.findNext(t.root.right.right);
		
	}

	
	
	static class Tree{
		static class Node{
			int data;
			Node left;
			Node right;
			Node parent;
			Node(int data){
				this.data = data;
			}
		}
		
		Node root;
		Tree(int size){
			root = makeBST(0,size-1,null);
		}
		
		Node makeBST(int start, int end, Node parent) {
			if(start>end) return null;
			int mid = (start+end)/2;
			Node node = new Node(mid);
			node.left  = makeBST(start,mid-1,node);
			node.right = makeBST(mid+1,end,node);
			node.parent = parent;
			return node;
		}
		
		
		void findNext(Node node) {
			if(node.right == null) { //above
				System.out.println(findAbove(node.parent, node).data);
			}else {  // below
				System.out.println(findBelow(node.right).data);
			}
		}
		
		//node.right==null
		Node findAbove(Node root, Node child) {
			if(root==null)  return null;
			if(root.left == child) return root;
			return findAbove(root.parent,root);
		}
		
		//node.right!=null
		Node findBelow(Node root) {
			if(root.left==null) return root;
			return findBelow(root.left);
		}
		
		
		
	}//tree
	
	

}

