package games.core;

public class MaxDiff 
{

	private static int maxDiff(int[] array)
	{
	    int maxDiff = 0;
	    int min = Integer.MAX_VALUE;

	    for(int x : array)
	    {
	        min = Math.min(x, min);
	        maxDiff = Math.max(maxDiff, (x - min));
	    }
	    return maxDiff;
	}
	
	public static void main(String[] args)
	{
		int[] array = {5,3,4,2,7,9};
		System.out.println(maxDiff(array));
	}
}
