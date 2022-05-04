import java.util.Scanner;
public class GCD{
	public static void main(String[] args) {
		System.out.print("Enter a and b to find GCD(a,b): ");
		Scanner in = new Scanner(System.in);
		int a = in.nextInt();
		int b = in.nextInt();
		System.out.println(GCDEuclid(a,b));

		for(int i=1; i<3744; i++){
			if((i*199) % 3744 == 1)
				System.out.println(i);
		}
	}

	public static int GCDEuclid(int a, int b){
		if(b == 0){
			return a;
		}
		return GCDEuclid(b, a % b);
	}
}