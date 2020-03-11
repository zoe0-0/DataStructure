package Graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class GraphSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Graph g = new Graph(9);
		g.addEdge(0, 1);
		g.addEdge(1, 2);
		g.addEdge(1, 3);
		g.addEdge(2, 3);
		g.addEdge(2, 4);
		g.addEdge(3, 4);
		g.addEdge(3, 5);
		g.addEdge(5, 6);
		g.addEdge(5, 7);
		g.addEdge(6, 8);
		
		//g.dfs();
 		//g.bfs();
		g.dfsR();
		
	}

}


class Graph{
	class Node{
		int data;
		LinkedList<Node> adjacent;
		boolean marked;
		Node(int data){
			this.data = data;
			marked = false;
			adjacent = new LinkedList<>();
		}
	}
	
	Node[] nodes;
	
	Graph(int size){
		nodes = new Node[size];
		for(int i=0; i<size; i++) {
			nodes[i] = new Node(i);  //인덱스와 노드의 데이터가 동일함
		}
	}
	
	
	
	void addEdge(int i1, int i2) {
		Node n1 = nodes[i1];
		Node n2 = nodes[i2];
		if(!n1.adjacent.contains(n2)) {
			n1.adjacent.add(n2);
		}
		if(!n2.adjacent.contains(n1)) {
			n2.adjacent.add(n1);
		}
	}
	
	
	void dfs() {
		dfs(0);
	}
	
	void dfs(int index) {
		Node root = nodes[index];
		Stack<Node> stack = new Stack<>();
		stack.push(root);
		root.marked = true;
		while(!stack.isEmpty()) {
			Node r = stack.pop();
			//자식 노드 스택에 넣기, marked = true;
			for(Node n : r.adjacent) {
				if(!n.marked) {
					n.marked = true;
					stack.push(n);
				}
			}
			visit(r);
		}
	}
	
	void dfsR(Node r) {
		if(r==null) return;
		r.marked = true;
		visit(r);
		for(Node n : r.adjacent) {
		    if(!n.marked) {
		    	dfsR(n);
		    }
		}
	}
	
	void dfsR(int index) {
		Node r = nodes[index];
		dfsR(r);
	}
	
	void dfsR() {
		dfsR(0);
	}
	
	void bfs() {
		bfs(0);
	}
	
	void bfs(int index) {
		Node root = nodes[index];
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		root.marked = true;
		while(!q.isEmpty()) {
			Node r = q.remove();
			for(Node n : r.adjacent) {
				if(!n.marked) {
					n.marked = true;
					q.add(n);
				}
			}
			visit(r);
		}
		
	}
	
	void visit(Node n) {
		System.out.print(n.data+" ");
	}
}