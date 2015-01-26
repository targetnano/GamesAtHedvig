package games.core;

public class MaximumProductSubarray 
{

	private static void maxProductSubArray(int[] array)
	{
	    int maxEndingHere = 1;
	    int minEndingHere = 1;
	    int maxSoFar = 1;

	    for(int x : array)
	    {
	    	// If 0, reset the products
	        if(x == 0)
	        {
	            maxEndingHere = 1;
	            minEndingHere = 1;
	        }
	        else if(x > 0)
	        {
	        	// If +ve, just multiply to maximum
	            maxEndingHere = maxEndingHere * x;
	            minEndingHere = Math.min(minEndingHere*x, 1);
	        }
	        else
	        {
	        	// Handling -ve. Awesome!
	            int temp = maxEndingHere;
	            maxEndingHere = Math.max(minEndingHere*x, 1);
	            minEndingHere = temp * x;
	        }
	        maxSoFar = Math.max(maxEndingHere, maxSoFar);
	    }
	    System.out.println(maxSoFar);
	}
	
	public static void main(String[] args)
	{
		int[] a = {6, -3, -10, 0, 2};
		maxProductSubArray(a);
		int[] b = {-1, -3, -10, 0, 60};
		maxProductSubArray(b);
		int[] c = {-2, -3, 0, -2, -40};
		maxProductSubArray(c);
	}
}
