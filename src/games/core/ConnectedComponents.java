package games.core;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ConnectedComponents 
{
	static long totalComponents = 0;
	
	private static void combine(int nextIndex, int bufIndex, long[] input, long[] buffer)
	{
	    if(nextIndex == input.length)
	        return;
	    for(int i = nextIndex; i < input.length; i++)
	    {
	        buffer[bufIndex] = input[i];
	        addComponentsForSet(buffer, bufIndex);
	        combine(i+1, bufIndex+1, input, buffer);
	    }
	}
	
	private static void combine(long[] input)
	{
	    int nextIndex = 0;
	    int bufIndex = 0;
	    long[] buffer = new long[input.length];
	    combine(nextIndex, bufIndex, input, buffer);
	}
	
	private static void addComponentsForSet(long[] buffer, int bufIndex)
	{		
		List<Long> connected = new ArrayList<Long>();
		connected.add(buffer[0]);
		Set<Integer> overlaps = new HashSet<Integer>();

		for(int i = 1; i <= bufIndex; i++) {
			long next = buffer[i];
			overlaps.clear();
			for(int j = 0; j < connected.size(); j++)
				if( (connected.get(j) & next) != 0) overlaps.add(j);

			Iterator<Long> it = connected.iterator();
			int idx = 0;
			while(it.hasNext()) {
				long component = it.next();
				if(overlaps.contains(idx)) {
					it.remove();
					next = next | component;
				}
			}
			connected.add(next);
		}

		totalComponents += 64;
		for(Long component : connected) {
			int ones = getNumOnes(component);
			if(ones > 1)
				totalComponents = totalComponents - ones +1;
		}
	}
	
	private static int getNumOnes(long n) {
        int numOnes = 0;
        for(int i = 0; i <= 63; i++) {
        	if((n >> i) == 0) return numOnes;
        	if( ((n >> i) & 1) == 1)
        		numOnes++;
        }
        return numOnes;
	}
	
	public static void main(String[] args)
	{
		System.out.println(Double.parseDouble("15592857103441304995"));
		//long[] array = {0,15592857103441304995};
		//totalComponents += 64;
		//combine(array);
		//System.out.println(totalComponents);
		/*double x = 5;
		long xl = Double.doubleToLongBits(x);
		getNumOnes(xl);*/
	}
	
	private static long getSmallestNumber(long zeros)
	{		
        if (zeros == 1) return 5;
		long start = 5L;
		long end = Long.MAX_VALUE;
		while((end-start) > 1)
		{
			long mid = start + (end - start) / 2;
			long numZeros = numZeros(mid);
			if (numZeros < zeros)
				start = mid;
			else
				end = mid;
		}
		return end;
	}
	
	static long numZeros(long  n)
	{
	    long count = 0;
	 
	    for (int i=5; n/i>=1; i *= 5)
	          count += n/i;
	 
	    return count;
	}
	 
	
	
}
