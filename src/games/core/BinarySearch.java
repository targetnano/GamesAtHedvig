package games.core;

public class BinarySearch 
{

	private static int findFirstOccurence(int[] array, int k)
	{
		int lo = 0;
		int hi = array.length-1;

		if(array[lo] == k)
			return lo;

		while( (hi - lo) > 1)
		{
			int mid = lo + (hi-lo)/2;
			if(array[mid] < k)
				lo = mid;
			else
				hi = mid;
		}
		if(array[hi] != k)
			return -1;
		return hi;
	}
	
	private static int findLastOccurrence(int[] array, int k)
	{
	    int lo = 0;
	    int hi = array.length - 1;
	    
	    if(array[hi] == k)
	        return hi;
	        
	    while( (hi-lo) > 1)
	    {
	        int mid = lo + (hi-lo)/2;
	        if(array[mid] > k)
	            hi = mid;
	        else
	            lo = mid;
	    }
	    
	    if(array[lo] !=k)
	        return -1;
	    return lo;
	}
	
	private static int binarySearch(int[] array, int k)
	{
	    int lo = 0;
	    int hi = array.length - 1;
	    
	    if(k > array[hi] || k < array[lo])
	        return -1;
	        
	    while( hi > lo )
	    {
	        int mid = lo + (hi-lo)/2;
	        if(array[mid] < k)
	            lo = mid+1;
	        else if(array[mid] > k)
	            hi = mid-1;
	        else
	            return mid;
	    }
	    if(array[lo] != k)
	    	return -1;
	    return lo;
	}
	
	public static void main (String[] args) throws java.lang.Exception
	{
		int[] array = {1,2,3,4,6};
		System.out.println(binarySearch(array, 4));
	}

}
