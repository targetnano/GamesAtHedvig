package games.core;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class FindMajority 
{

	private static int findMajority(int[] array)
	{
	    int count = 0;
	    int candidate = -1;

	    for(int x : array)
	    {
	        if(count == 0)
	        {
	            candidate = x;
	            count = 1;
	        }
	        else if(x == candidate)
	            count++;
	        else if(x != candidate)
	            count--;
	    }

	    count = 0;
	    for(int x : array)
	    {
	        if(x == candidate)
	            count++;
	        if(count > (array.length - count))
	            return candidate;
	    }
	    return -1;
	}
	
	private static void findMajorityNK(int k, int[] array)
	{
	    Map<Integer,Integer> countMap = new HashMap<Integer,Integer>();
	    int maxNum = array.length / k;

	    for(int x : array)
	    {
	        if(countMap.containsKey(x))
	        {
	            int oldCount = countMap.get(x);
	            countMap.put(x,oldCount+1);
	        }
	        else if(countMap.size() == maxNum)
	        {
	            Iterator<Entry<Integer,Integer>> it = countMap.entrySet().iterator();
	            while(it.hasNext())
	            {
	                Entry<Integer,Integer> entry = it.next();
	                int value = entry.getValue();
	                if(value == 1)
	                    it.remove();
	                else
	                    entry.setValue(value-1);
	            }
	        }
	        else
	            countMap.put(x,1);
	    }

	    Iterator<Entry<Integer,Integer>> it = countMap.entrySet().iterator();
	    while(it.hasNext())
	    {
	        Entry<Integer,Integer> entry = it.next();
	        entry.setValue(0);
	    }

	    for(int x : array)
	    {
	        Integer count = countMap.get(x);
	        if(count != null)
	        {
	            countMap.put(x, count+1);
	            if(count+1 > maxNum)
	            {
	                System.out.print(x + " ");
	                countMap.remove(x);
	            }
	        }
	    }
	}
	
	public static void main(String[] args)
	{
		int[] array =  { 2, 2, 4, 4, 3, 5, 3, 4, 4, 6, 4, 3, 3, 8 };
		findMajorityNK(4, array);
		//System.out.println(findMajorityNK(2, array));
	}
}
