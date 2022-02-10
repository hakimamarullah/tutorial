public class RussianMul{
	public static void main(String[] args) {
		int x = Integer.valueOf(args[0]);
		int y = Integer.valueOf(args[1]);

		int total =0;
		while(x > 0){
			if(x % 2 ==1)
				total += y;
			x /= 2;
			y 	+= y;
		}
		System.out.println(total);

	}
}