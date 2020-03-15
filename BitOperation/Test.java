package BitOperation;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getBit(9,3));
		System.out.println(getBit(5,3));
		System.out.println(setBit(5,3));
		System.out.println(clearBit(9,3));
		System.out.println(clearLeftBits(169,3));
		System.out.println(clearRightBits(169,3));
		System.out.println(updateBit(169,3,false));
	}
	
	static boolean getBit(int num, int i) {
		 return ((1<<i) & num) != 0; 
	}
	
	static int setBit(int num, int i) {
		return (1<<i) | num;
	}

	static int clearBit(int num, int i) {
		return ~(1<<i) & num;
	}
	
	static int clearLeftBits(int num, int i) {
		return num & ((1<<i)-1);
	}
	
	static int clearRightBits(int num, int i) {
		return (-1<<(i+1)) & num;
	}
	
	static int updateBit(int num, int i, boolean val) {
		return (num & ~(1<<i)) | ((val?1:0)<<i) ;
	}
	
}
