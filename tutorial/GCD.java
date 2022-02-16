public class GCD{
	public static void main(String[] args) {
		System.out.println(GCDEuclid(8,15));
		System.out.println(GCDEuclid(6,3));
	}

	public static int GCDEuclid(int a, int b){
		if(b == 0){
			return a;
		}
		return GCDEuclid(b, a % b);
	}
}