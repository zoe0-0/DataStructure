package Algorithm;


//주어진 트리가 이진검색트리인지 확인하는 알고리즘

public class IsValidateBSTTest {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		//solution1) using inorder
		Tree t =new Tree(10);
		System.out.println("Solution1 - using inorder: "+t.isValidateBST1());
		//이 방법의 문제점 : 크기 n만큼의 배열을 만들기 때문에 n만큼의 공간이 필요한다.
		
		
		System.out.println("Solution1 - using inorder: "+t.isValidateBST2());
		
		
	}
	
	
	static class Tree{
		static class Node{
			int data;
			Node left;
			Node right;
			Node(int data){
				this.data = data;
			}
		}
		Node root;
		int size;
		Tree(int size){
			this.size = size;
			root = makeBST(0,size-1);
			root.right.right.right.left = new Node(10);
			this.size++;
		}
		
		Node makeBST(int start, int end) {
			if(start>end) return null;
			int mid = (start+end)/2;
			Node node = new Node(mid);
			node.left  = makeBST(start,mid-1);
			node.right = makeBST(mid+1,end);
			return node;
		}
		
		
		//solution1. - 크기 n 만큼의 공간(배열) 추가적으로 필요
		boolean isValidateBST1() {
			int[] array = new int[size];
			inorder(root,array);
			for(int i=1; i<array.length; i++) {
				if(array[i] < array[i-1]) {
					return false;
				}
			}
			return true;
		}
		
		//배열에서 몇번째 방까지 담았는지 기억하기 위해
		int index = 0;
		void inorder(Node root,int[] array) {
			if(root==null) return;
			inorder(root.left,array);
			array[index++] = root.data;
			inorder(root.right,array);
		}
		
		
		boolean isValidateBST2() {
			return isValidateBST2(root);
		}
		
		Integer last_printed = null;
		boolean isValidateBST2(Node n) {
			if(n==null)return true;
			if(!isValidateBST2(n.left)) return false;
			if(last_printed!=null && last_printed > n.data) return false;
			last_printed = n.data;
			if(!isValidateBST2(n.right)) return false;
			return true;
		}
		

		
		 
	}

	

}


