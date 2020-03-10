package Tree;

public class BinaryTreeTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		
		Tree t = new Tree();
		Node n4 = t.makeNode(4, null, null);
		Node n5 = t.makeNode(5, null, null);
		Node n2 = t.makeNode(2, n4, n5);
		Node n3 = t.makeNode(3,null,null);
		Node n1 = t.makeNode(1, n2, n3);
		t.setRoot(n1);
		t.inorder(t.getRoot());
		System.out.println();
		t.preorder(t.getRoot());
		System.out.println();
		t.postorder(t.getRoot());
	}

	
	
}

class Node{
	int data;
	Node left;
	Node right;
}

class Tree{
	public Node root;
	public void setRoot(Node node) {
		this.root = node;
	}
	public Node getRoot() {
		return root;
	}
	
	public Node makeNode(int data, Node left, Node right) {
		Node node = new Node();
		node.data = data;
		node.right = right;
		node.left = left;
		return node;
	}
	
	//left-root-right
	public void inorder(Node root) {
		if(root!=null) {
			inorder(root.left);
			System.out.print(root.data+" ");
			inorder(root.right);
		}
	}
	
	//root-left-right
	public void preorder(Node root) {
		if(root!=null) {
			System.out.print(root.data+" ");
			preorder(root.left);
			preorder(root.right);
		}
	}
	
	//left-right-root
	public void postorder(Node root) {
		if(root!=null) {
			postorder(root.left);
			postorder(root.right);
			System.out.print(root.data+" ");
		}
	}
}