package games.core;
import java.util.Arrays;


public class LongestNonRepeating {

	private static int longestNonRepeating(String str)
	{
	    if(str == null || str.length() == 0)
	        return 0;

	    int curMax = 1;
	    int globalMax = 1;
	    int[] prevIndices = new int[256];
	    Arrays.fill(prevIndices, -1);

	    for(int i = 0; i < str.length(); i++)
	    {
	        char ch = str.charAt(i);
	        int prevIndex = prevIndices[ch];
	        // If the character was not already visited,
	        // add to the current length, mark the visited
	        // index and continue.
	        if(prevIndex == -1)
	            curMax++;

	        else
	        {
	            // If the character was visited even before
	            // the current length is calculated, just
	            // move as though nothing happened. We dont
	            // care about this case.
	            if( prevIndex < (i - curMax) )
	                curMax++;
	            else
	            {
	                // Recalculate global max and recalculate
	                // current length once we encounter a
	                // repitition.
	            	
	            	// BUG: SHOULD CALCULATE THIS GLOBALMAX ONLY
	            	// AFTER RECALCULATING CURMAX
	                curMax = i - prevIndex;
	                globalMax = Math.max(curMax, globalMax);
	            }
	        }
	        // Mark the current character visited
	        // and track the index
	        prevIndices[ch] = i;
	    }
	    globalMax = Math.max(curMax, globalMax);
	    return globalMax;
	}
	
	public static void main(String[] args)
	{
		System.out.println(longestNonRepeating("atabbdt"));
	}
}
