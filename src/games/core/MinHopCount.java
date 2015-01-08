package games.core;

/*
 * Given an array of integers where each element represents the max number of 
 * steps that can be made forward from that element. Write a function to return 
 * the minimum number of jumps to reach the end of the array (starting from the first element). 
 * If an element is 0, then cannot move through that element.
 */
public class MinHopCount 
{
	private static int minHopCount(int[] a)
	{
	    int len = a.length-1;
	    int[] minHops = new int[a.length];
	    minHops[a.length-1] = 0;
	    for(int i = a.length-2; i >= 0; i--)
	    {
	        int steps = a[i];
	        // If we could reach the end, keep the count 1
	        if( (i+steps) >= len )
	        {
	            minHops[i] = 1;
	            continue;
	        }
	        else
	        {
	            minHops[i] = Integer.MAX_VALUE;
	            for(int j = i+1; j <= (i+steps); j++)
	                minHops[i] = Math.min(minHops[i], minHops[j]);

	            // We add later to avoid INTEGER OVERFLOW
	            if(minHops[i] != Integer.MAX_VALUE)
	                minHops[i]++;
	        }
	    }
	    return minHops[0];
	}
	
	public static void main(String[] args)
	{
		int[] a = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
		System.out.println(minHopCount(a));
	}
}
