package games.core;

import java.util.HashMap;
import java.util.Map;

import games.utils.Pair;

public class MaximumGap 
{

	private static int getMaximumGap(int[] array)
	{
	    int min = array[0];
	    int max = array[0];
	    
	    for(int i = 1; i < array.length; i++)
	    {
	    	min = Math.min(min, array[i]);
	    	max = Math.max(max, array[i]);
	    }
	    
	    int bucketLength = (max-min) / (array.length-1) + 1;
	    int numBuckets = (max-min) / bucketLength;
	    Map<Integer, Pair<Integer,Integer>> bucketToRangeMap = new HashMap<Integer, Pair<Integer,Integer>>();
	    
	    for(int i = 0; i < array.length; i++)
	    {
	        int bucket = (array[i] - min) / bucketLength;
	        if(bucketToRangeMap.containsKey(bucket))
	        {
	            Pair<Integer,Integer> range = bucketToRangeMap.get(bucket);
	            if(range.k() > array[i])
	                range.k(array[i]);
	            if(range.v() < array[i])
	                range.v(array[i]);
	        }
	        else
	        {
	            Pair<Integer,Integer> range = new Pair<Integer,Integer>(array[i], array[i]);
	            bucketToRangeMap.put(bucket, range);
	        }
	    }
	    
	    int maxDiff = 0;
	    int prev = 0;
	    for(int i = 0; i <= numBuckets; i++)
	    {
	    	if(!bucketToRangeMap.containsKey(i))
	    		continue;
	        Pair<Integer,Integer> range = bucketToRangeMap.get(i);
	        maxDiff = Math.max(range.v() - range.k(), maxDiff);
	        if(i != 0)
	            maxDiff = Math.max(range.k() - prev, maxDiff);
	        prev = range.v();
	    }
	    return maxDiff;
	}
	
	public static void main(String[] args)
	{
		int[] a = {7,2,5,12,53,1,76,32,54,67,32,45,98,77,81};
		System.out.println(getMaximumGap(a));
	}
}
