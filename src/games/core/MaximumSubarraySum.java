package games.core;

public class MaximumSubarraySum 
{

	private static int maxSubarraySum(int[] array)
	{
	    int totalMax = 0, maxHere = 0;
	    for(int x : array)
	    {
	        maxHere += x;
	        if(maxHere < 0)
	            maxHere = 0;

	        if(maxHere > totalMax)
	            totalMax = maxHere;        
	    }
	    return totalMax;
	}

	private static int maxSubarraySum2(int[] array)
	{
	    int totalMax = array[0];
	    int maxHere = array[0];
	    
	    for(int i = 1; i < array.length; i++)
	    {
	        maxHere += array[i];
	        if(maxHere < array[i])
	            maxHere = array[i];
	        if(maxHere > totalMax)
	            totalMax = maxHere;
	    }
	    return totalMax;
	}
	
	public static void main(String[] args)
	{
		int[] array = {-2,-3,-2,-1,3,-2};
		System.out.println(maxSubarraySum2(array));
	}
}
