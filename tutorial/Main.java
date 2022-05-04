public class Main{
	public static void main(String[] args) {
		// System.out.println(mystery(2, 3));
		// System.out.println(mystery(3,2));
		// System.out.println(mystery(0,2));
		// System.out.println(mystery(100, 100));
		int[] A = {67,32,41,35,57};
		System.out.println(smallest2(A,A.length-1));
		System.out.println(recforMax(A,A.length-1));
		// System.out.println(longestCommonPrefixLength2("31242","3142"));
		
	}

	public static int mystery(int a, int b){
		int result = 0, k=a;
		while(k >0){
			k = k-1;
			result = result +b;
		}
		return result;
	}
	public static int longestCommonPrefixLength2(String s1, String s2) {
	    if (s1 == null || s1.length() == 0 || s2 == null || s2.length() == 0) return 0;
	    	int i = 0;
	    for (; i < Math.min(s1.length(), s2.length()) && s1.charAt(i) == s2.charAt(i); i++);
	    return i;
	}


	private static int smallest(int[] array, int from, int to) {
    	if (from == to) {
        	return from;
    	}
    	int middle = from + (to - from) / 2;
    	return Math.min(smallest(array, from, middle), smallest(array, middle + 1, to));
	}

	public static int smallest(int[] array){
    	return smallest(array, 0, array.length - 1);
	}

	static int recforMax(int arr[], int len){
	   int maximum;

	   if (len == 1){
	      return 0;
	   }
	   else{
	      return maximum=len>recforMax(arr,len-1)?len:recforMax(arr,len-1);
	   }
	}


	static int smallest2(int[] arr, int num)
{
    if(num <= 1)
    {
        return 0;  // If we're in the last element, the smallest is the only element
    }
    // More than one element, so find the least element in all the elements
    // past the first element of the array
    // Note: the index returned is offset from our current view of the array,
    //       so add +1 to any returned result so we can index directly from it
    int restOfArraySmallest = smallest(arr, num-1) + 1;

    // Compare the first element in the array to the smallest of the entire rest
    // of the array:
    if(arr[0] < arr[restOfArraySmallest])
    {
        // The first element is smaller, it's the smallest, so return that index
        return 0;
    }
    else
    {
        // The element already found is smaller, so return that index.  It's already
        // correctly offset
        return restOfArraySmallest;
    }
}
}