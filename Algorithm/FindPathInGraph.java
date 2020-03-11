package Algorithm;

import java.util.LinkedList;
import java.util.Queue;


public class FindPathInGraph {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Graph g = new Graph(9);
		g.addEdge(0, 1);
		g.addEdge(1, 2);
		//g.addEdge(1, 3);
		//g.addEdge(2, 3);
		//g.addEdge(2, 4);
		g.addEdge(3, 4);
		g.addEdge(3, 5);
		g.addEdge(5, 6);
		g.addEdge(5, 7);
		g.addEdge(6, 8);
		
		System.out.println(g.search(1, 8));
		
		
		
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
			nodes[i] = new Node(i);  //index와 같은 번호의 data를 가진 노드를 배열에 저장
		}
	}
	
	
	void addEdge(int i1, int i2) {
		Node n1 = nodes[i1];
		Node n2 = nodes[i2];
		if(!n1.adjacent.contains(n2))
			n1.adjacent.add(n2);
		if(!n2.adjacent.contains(n1))
			n2.adjacent.add(n1);
	}
	
	void initMarks() {
		for(Node n : nodes) {
			n.marked = false;
		}
	}
	
	boolean search(int i1, int i2) {
		Node n1 = nodes[i1];
		Node n2 = nodes[i2];
		return search(n1,n2);
	}
	
	void visit(Node n) {
		System.out.print(n.data+" ");
	}
	
	//두 노드 사이에 경로가 존재하는지 리턴
	boolean search(Node start, Node end) {
		initMarks();
		Queue<Node> q = new LinkedList<>();
		q.add(start);
		start.marked = true;
		while(!q.isEmpty()) {
			Node r = q.remove();
			if(r == end) {
				return true;
			}
			for(Node n : r.adjacent) {
				if(n.marked==false) {
					n.marked = true;
					q.add(n);
				}
			}
		}
		return false;
	}
}
