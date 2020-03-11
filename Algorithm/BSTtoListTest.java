package Algorithm;

import java.util.ArrayList;
import java.util.LinkedList;

public class BSTtoListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Tree t = new Tree(10);
		t.printList(t.BSTtoList());
		
	}

}


class Tree{
	class Node{
		int data;
		Node left;
		Node right;
		Node(int data){
			this.data = data;
		}
	}

	Node root;
    Tree(int size){
    	root = makeBST(0,size-1);
    }
    
    Node makeBST(int start, int end) {
    	if(start>end) return null;
    	int mid = (start+end)/2;
    	Node node = new Node(mid);
    	node.left = makeBST(start,mid-1);
    	node.right = makeBST(mid+1,end);
    	return node;
    }
	
    //루트부터 재귀호출할 때 레벨을 함수의 인자로 받는 방법
    ArrayList<LinkedList<Node>> BSTtoList(){
    	ArrayList<LinkedList<Node>> lists = new ArrayList<>();
    	BSTtoList(root,lists,0);
    	return lists;
    }
    
    //이진검색트리의 루트, 결과값을 저장할 리스트, 트리의 레벨
    void BSTtoList(Node root, ArrayList<LinkedList<Node>> lists, int level){
       if(root==null) return;
        
       //1.먼저 현재 노드의 값을 레벨별 링크드리스트에 넣기
       LinkedList<Node> list = null;
       if(lists.size()==level) {
    	   list = new LinkedList<>();
    	   lists.add(list);
       }else {
    	   list = lists.get(level);
       }
       list.add(root);
        
       //2.현재 노드의 자식 호출
       BSTtoList(root.left,lists,level+1);
       BSTtoList(root.right,lists,level+1);
    }
    
    ArrayList<LinkedList<Node>> BSTtoList2(){
    	ArrayList<LinkedList<Node>> result = new ArrayList<>();
    	LinkedList<Node> current = new LinkedList<>();
    	if(root!=null) current.add(root);
    	while(current.size()>0) {
    		result.add(current);
    		LinkedList<Node> parents = current;
    		current = new LinkedList<>();
    		for(Node parent : parents) {
    			if(parent.left!=null) current.add(parent.left);
    			if(parent.right!=null) current.add(parent.right);
    		}
    	} 
    	return result;
    }
    
    void printList(ArrayList<LinkedList<Node>> arr) {
    	for(LinkedList<Node> list : arr) {
    		for(Node node : list) {
    		   System.out.print
    		    (node.data+" ");
    		}
    		System.out.println();
    	}
    }
    
    
}