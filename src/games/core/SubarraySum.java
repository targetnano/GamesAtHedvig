package games.core;

public class SubarraySum 
{

	public static boolean isSumPossible(int[] a, int k) 
	{
	    int start = 0;
	    int end = a.length - 1;
	    int curSum = 0;
	    
	    for(int i = 0; i <= end; i++)
	    {
	        curSum += a[i];
	        	        
	        while(start < i && curSum > k)
	        {
	            curSum -= a[start++];
	        }
	        
	        if(curSum == k)
	            return true;
	    }
	    return false;
	}

	public static void main(String[] args)
	{
		int[] a = {14,2,3,1};
		System.out.println(isSumPossible(a,5));
	}
}
