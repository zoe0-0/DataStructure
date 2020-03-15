package String;

import java.util.HashMap;

//입력받은 문자열의 문자들이 중복 없이 고유한 값인지 확인하는 문제
public class Algorithm1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(isUnique2("abcdefgghijk"));
		System.out.println(isUnique2("abcdefghijk"));
		
	}
	
	public static boolean isUnique(String str) {
		//아스키코드의 갯수(0~127)128개 이상의 길이면 무조건 중복
		if(str.length()>128) return false;
		boolean[] char_set = new boolean[128];
		for(int i=0; i<str.length(); i++) {
			int val = str.charAt(i);
			if(char_set[val]) {
				return false;
			}
			char_set[val] = true;
		}
		return true;
	}
	
	
	public static boolean isUnique2(String str) {
		HashMap<Integer,Boolean> hashmap = new HashMap<>();
		for(int i=0; i<str.length(); i++) {
			int c = str.charAt(i);
			if(hashmap.containsKey(c)) {
				return false;
			}
			hashmap.put(c,true);
		}
		return true;
	}
	
	//입력받은 str이 소문자로만 이루어져 있다는 가정 - 비트연산자 
	public static boolean isUnique3(String str) {
		
	}

}
