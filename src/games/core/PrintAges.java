package games.core;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 	You have a sorted array containing the age of every person on Earth. 
	[0, 0, 0, 0, ..., 1, 1, ..., 28, 28, ..., 110, ...] 
	Find out how many people have each age.

 * @author Kavi
 *
 */
public class PrintAges 
{

	private static int getLastIndex(int age, int startIndex, int[] ages)
	{
		int inc = 2;
		int lastIndex = startIndex;
		while(true)
		{
			int nextIndex = lastIndex + inc;
			if(nextIndex >= ages.length-1)
			{
				lastIndex = ages.length-1;
				break;
			}
			if(ages[nextIndex] != age)
			{
				lastIndex = nextIndex;
				break;
			}
			inc *= 2;
		}
		lastIndex = binarySearchLastIndex(age, lastIndex-inc, lastIndex, ages);
		return lastIndex;
	}

	private static int binarySearchLastIndex(int age, int start, int end, int[] ages)
	{
		if(ages[end] == age)
			return end;

		while(end-start > 1)
		{
			int mid = start + (end-start)/2;
			if(ages[mid] > age)
				end = mid;
			else
				start = mid;
		}
		return start;
	}

	private static void printAges(int[] ages)
	{
		if(ages == null || ages.length == 0)
			return;

		Map<Integer,Integer> map = new LinkedHashMap<Integer,Integer>();
		int i = 0;
		while(i < ages.length)
		{
			int lastIndex = getLastIndex(ages[i], i, ages);
			map.put(ages[i], lastIndex-i+1);
			i = lastIndex+1;
		}
		for(Integer age : map.keySet())
			System.out.println(age + " : " + map.get(age));
	}
}
