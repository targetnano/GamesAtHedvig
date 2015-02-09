package games.core;

public class RotatedSortedArray 
{
	/**
	 * Ref: http://n00tc0d3r.blogspot.com/2013/05/search-in-rotated-sorted-array.html
	 * 
	 * Works only if the array doesn't have duplicates.
	 * @param array
	 * @param k
	 * @return
	 */
	private static int findInRotatedSortedArray(int[] array, int k)
	{
	    int lo = 0;
	    int hi = array.length - 1;
	    
	    if(array[lo] == k)
	    	return lo;
	    
	    while( hi > lo+1 )
	    {
	        int mid = lo + (hi-lo)/2;
	        if(array[mid] == k)
	            return mid;
	            
	        if(array[lo] <= array[mid])
	        {
	            if( array[lo] <= k && k <= array[mid] )
	                hi = mid;
	            else
	                lo = mid;
	        }
	        else if(array[mid] <= array[hi])
	        {
	            if(array[mid] <= k && k <= array[hi])
	                lo = mid;
	            else
	                hi = mid;
	        }
	    }
	    if(array[hi] != k)
	        return -1;
	    return hi;
	}
	
	/**
	 * Returns min element index in the rotated sorted array
	 * @param array
	 * @return
	 */
	private static int findMinInRotatedSortedArray(int[] array)
	{
	    int lo = 0;
	    int hi = array.length - 1;
	    
	    while( hi > lo+1 )
	    {
	        int mid = lo + (hi-lo)/2;
	        if(array[lo] <= array[mid])
	        {
	            if(array[hi] <= array[lo])
	                lo = mid;
	            else
	                hi = mid;
	        }
	        else if(array[mid] <= array[hi])
	        {
	            if(array[lo] >= array[hi])
	                hi = mid;
	            else
	                lo = mid;
	        }
	    }
	    return array[lo] > array[hi] ? hi : lo;
	}
	
	public static void main(String[] args)
	{
		int[] a = {7,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
		System.out.println(findInRotatedSortedArray(a,1));
	}
}
