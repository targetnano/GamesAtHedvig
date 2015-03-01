package games.core;

public class LongestIncreasingSubsequence 
{

	private static int getCeilIndexFromSlotTable(int[] slotTable, int lo, int hi, int key)
	{
	    if(slotTable[lo] == key)
	        return lo;
	    
	    while( (hi-lo) > 1)
	    {
	        int mid = lo + (hi-lo)/2;
	        if(slotTable[mid] >= key)
	            hi = mid;
	        else
	            lo = mid;
	    }
	    return hi;
	}

	private static int getLongestIncSubsequenceLength(int[] array)
	{
	    int[] slotTable = new int[array.length];
	    slotTable[0] = array[0];
	    int len = 1;
	    
	    for(int i = 0; i < array.length; i++)
	    {
	        
	        int x = array[i];
	        if(x < slotTable[0])
	        {
	            slotTable[0] = x;
	        }
	        else if(x > slotTable[len-1])
	        {
	            slotTable[len] = x;
	            len++;
	        }
	        else
	        {
	            int ceilIndex = getCeilIndexFromSlotTable(slotTable, 0, len-1, x);
	            slotTable[ceilIndex] = x;
	        }
	    }
	    return len;
	}
	
	private static int getCeilIndexFromSlotTable(int[] array, int[] slotTable, int lo, int hi, int key)
	{
	    if(array[slotTable[lo]] == key)
	        return lo;
	    
	    while( (hi-lo) > 1 )
	    {
	        int mid = lo + (hi-lo)/2;
	        if(array[slotTable[mid]] >= key)
	            hi = mid;
	        else
	            lo = mid;
	    }
	    return hi;
	}

	private static void printLongestIncSubsequence(int[] array)
	{
	    int[] slotTable = new int[array.length];
	    int[] prevIndex = new int[array.length];
	    slotTable[0] = 0;
	    prevIndex[0] = -1;
	    int len = 1;
	    
	    for(int i = 0; i < array.length; i++)
	    {
	        
	        int x = array[i];
	        if(x < array[slotTable[0]])
	            slotTable[0] = i;
	        else if(x > array[slotTable[len-1]])
	        {
	            prevIndex[i] = slotTable[len-1];
	            slotTable[len] = i;
	            len++;
	        }
	        else
	        {
	            int ceilIndex = getCeilIndexFromSlotTable(array, slotTable, 0, len-1, x);
	            prevIndex[i] = ceilIndex == 0 ? -1 : slotTable[ceilIndex-1];
	            slotTable[ceilIndex] = i;
	        }
	    }
	    
	    for(int i = slotTable[len-1]; i >= 0; i = prevIndex[i])
	        System.out.print(array[i] + " ");
	    System.out.println();
	}
	
	public static void main(String[] args)
	{
		int[] array = {-1,2,100,100,101,3,4,5};
		printLongestIncSubsequence(array);
	}
}
