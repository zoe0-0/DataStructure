package String;

//StringBuilder로 String을 append할 경우에는
//StringBuilder클래스 내에 있는 배열에 추가할 문자열을 붙이기만 하면 됨
//반면 StringBuilder를 사용하지 않고 String sentence = word1+word2; 이런식일 경우에는
//내부적으로 word1+word2길이만큼 새로운 공간을 만들어서 word1과 word2의 모든 단어들을 하나씩 담아주는 방식

public class StringBuilderTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		StringBuilder sb = new StringBuilder();
		sb.append("dahye");
		sb.append(" is");
		sb.append(" korean");
		System.out.println(sb.toString());
		
	}

}

class StringBuilder{
	 private char[] value;
	 private int size;
	 private int index;
	 StringBuilder(){
		 size =1;
		 value = new char[size];
		 index = 0;
	 }
	 public void append(String str) {
		 if(str==null) str = "null";
		 int len = str.length();
		 
		 //일단 배열방 value가 이 문자열을 담기에 넉넉한지 확인한 후, 부족할 경우 늘려주기
		 ensureCapacity(len);
		 
		 for(int i=0; i<len; i++) {
			 value[index++] = str.charAt(i);
		 }
		 
		 System.out.println(size+" , "+index);
	 }
	 
	 //현재 배열방에 len만큼의 문자를 넣을 수 있는지 확인해서 안될 경우에는 배열방 크기 늘리기
	 private void ensureCapacity(int len) {
		 if(index+len>size) {
			 size = (size+len)*2;
			 char[] newValue = new char[size];
			 for(int i=0; i<value.length; i++) {
				 newValue[i] = value[i];
			 }
			 value = newValue;
			 System.out.println("*** "+size+" , "+index);
		 }
	 }
	 
	 public String toString() {
		  return new String(value,0,index);
	 }
}