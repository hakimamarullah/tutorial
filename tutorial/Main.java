public class Main{
	public static void main(String[] args) {
		System.out.println(mystery(2, 3));
		System.out.println(mystery(3,2));
		System.out.println(mystery(0,2));
		System.out.println(mystery(100, 100));
		
	}

	public static int mystery(int a, int b){
		int result = 0, k=a;
		while(k >0){
			k = k-1;
			result = result +b;
		}
		return result;
	}
}