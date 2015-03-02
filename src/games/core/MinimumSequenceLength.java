package games.core;

/*
 	Determine minimum sequence of adjacent values in the input parameter array that is greater than input parameter sum.
 */
public class MinimumSequenceLength 
{

	private static int getMinSequenceLength(int sum, int[] array)
	{
	    int lo = 0;
	    int hi = 0;
	    
	    int curSum = 0;
	    int minLength = Integer.MAX_VALUE;
	    while(hi < array.length)
	    {
	        curSum += array[hi];
	        if(curSum > sum)
	        {
	            int curLength = hi-lo+1;
	            minLength = Math.min(curLength, minLength);
	            while(lo < hi)
	            {
	                curSum -= array[lo++];
	                if(curSum < sum)
	                    break;
	            }
	        }
	        hi++;
	    }
        int curLength = hi-lo+1;
        minLength = Math.min(curLength, minLength);
	    return minLength;
	}
	
	public static void main(String[] args)
	{
		int[] a = {1,2,3,1,1,2};
		System.out.println(getMinSequenceLength(5,a));
	}
}
