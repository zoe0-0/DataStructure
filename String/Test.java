package String;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


	
		MyNode node1 = new MyNode(1);
		MyNode node2 = new MyNode(2);
		MyNode node3 = new MyNode(3);
		MyNode[] data1 = {node1,node2,node3};
		MyNode[] data2 = new MyNode[3];
		
		for(int i=0; i<3; i++) {
			data2[i] = data1[i];
		}
		
		
		node1.data = 100000;
		System.out.println(data2[0].data);
		
		
		
	}

}


class MyNode{
	int data;
	MyNode(int data){
		this.data = data;
	}
}