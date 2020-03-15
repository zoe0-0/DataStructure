package Review;

import java.util.LinkedList;


//key-value값으로 데이터를 저장
//key는 중복 불가능 
//이미 key값이 존재할 경우. 새로운 value값으로 덮어씌움
//key->hashcode->index의 과정을 거쳐 index값을 구함
//이 인덱스 위치에 key-value값을 테이블에 저장.

//key로 value를 찾고자 할 경우 key->hashcode->index과정을 거쳐 index찾은 후 index위치에 있는 데이터들 중에서 key을 찾아서 value 리턴
//위의 경우 빠르면 0(1)만큼의 속도. 인덱스 값으로 바로 접근 가능하기 때문. 
//하지만, 만약 index내에 여러 값이 체이닝 되어있을 경우 하나씩 접근하면서 찾아야하기 때문에 최악의 경우 0(n)


public class HashTableTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		HashTable h = new HashTable(3);
		h.put("dahye", "developer");
		h.put("duohui", "student");
		h.put("amy","teacher");
		h.put("jung", "homebody");
		System.out.println(h.get("dahye"));
		System.out.println(h.get("duohui"));
		System.out.println(h.get("amy"));
		System.out.println(h.get("jay"));
		System.out.println(h.get("eun") );
		
	}

}


class HashTable{
	
	//key-value값으로 구성된 노드
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
	
	//다른 key값이지만 해시함수에서 같은 hashcode를 반환할 경우
	//다른 hashcode이지만 같은 index 값으로 변환된 경우
	//위와 같은 두가지 경우의 collision이 발생할 경우
	//한 인덱스의 여러개의 key-value값을 chaining
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
	
	
	//해당 리스트에서 key값으로 저장된 값이 있는지 찾아서 리턴
	Node searchKey(LinkedList<Node> list, String key) {
		if(list==null) return null;
		for(Node node : list) {
			if(node.key.equals(key)) {
				return node;
			}
		}
		return null;
	}
		 
	//key-value 값 넣기. 만약 key값이 중복 될 경우 value만 새로 덮어쓰기
	void put(String key, String value) {
	    int index = convertToIndex(getHashCode(key));
	    LinkedList<Node> list = data[index];
	    if(list==null) {
	    	list = new LinkedList<>();
	    	data[index] = list;
	    }
	    Node node = searchKey(list,key);
	    if(node==null) list.addLast(new Node(key,value));
	    else node.value(value);
	}
	
	//key 값을 넣어서 value값 찾기
	String get(String key) {
	    int index = convertToIndex(getHashCode(key));
	    LinkedList<Node> list = data[index];
	    Node node = searchKey(list,key);
	    return node==null?"Not found":node.value;
	}
	
}