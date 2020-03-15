package HashTable;

import java.util.LinkedList;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
 
		HashTable h = new HashTable(3);
		h.put("dahye", "developer");
		h.put("duohui", "chef");
		h.put("amy","teacher");
		h.put("jung", "homebody");
		System.out.println(h.get("dahye"));
		System.out.println(h.get("duohui"));
		System.out.println(h.get("amy"));
		System.out.println(h.get("jung"));
		System.out.println(h.get("eun") );

	}

}


class HashTable{
	class Node{
		String key;
		String value;
		Node(String key, String value){
			this.key = key;
			this.value = value;
		}
		String value() {
			return value;
		}
		void value(String value) {
			this.value = value;
		}
	}
	
	LinkedList<Node>[] data;
	HashTable(int size){
		this.data = new LinkedList[size];
	}
	
	int getHashCode(String key) {
		int hashcode = 0;
		for(char c : key.toCharArray()) {
			hashcode+=c;
		}
		return hashcode;
	}
	
	int convertToIndex(int hashcode) {
		return hashcode % data.length;
	}
	
	
	Node searchKey(LinkedList<Node> list, String key) {
		if(list==null) return null;
		for(Node node : list) {
			if(node.key.equals(key)) {
				return node;
			}
		}
		return null;
	}
	 
	void put(String key, String value) {
		int hashcode = getHashCode(key);
		int index = convertToIndex(hashcode);
		LinkedList<Node> list = data[index];
		if(list == null) {
			list = new LinkedList<>();
			data[index] = list;
		}
		Node node = searchKey(list,key);
		if(node == null) {
			 list.addLast(new Node(key,value));
		}else {
			node.value(value);
		}
	}
	
	String get(String key) {
		int hashcode = getHashCode(key);
		int index = convertToIndex(hashcode);
		LinkedList<Node> list = data[index];
		Node node = searchKey(list,key);
		return node==null? "not found" : node.value();
	}
	
}