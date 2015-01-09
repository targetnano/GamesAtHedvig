package games.core;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveNumber 
{

	private static void longestConsecutiveRange(int[] array)
	{
	    int left = 0, right = 0, longest = 1;
	    Set<Integer> set = new HashSet<Integer>();
	    for(int x : array)
	        set.add(x);

	    int curLength = 0;
	    for(int i = 0; i < array.length; i++)
	    {
	        if(!set.contains(array[i]))
	            continue;
	        else
	        {
	            curLength = 1;
	            int temp = array[i] - 1;
	            int curLeft = array[i], curRight = array[i];
	            while(set.contains(temp))
	            {
	                curLeft = temp;
	                curLength++;
	                set.remove(temp);
	                temp--;
	            }
	            temp = array[i] + 1;
	            while(set.contains(temp))
	            {
	                curRight = temp;
	                curLength++;
	                set.remove(temp);
	                temp++;
	            }
	            if(curLength > longest)
	            {
	                longest = curLength;
	                left = curLeft;
	                right = curRight;
	            }
	        }
	    }
	    System.out.println("Range: " + left + "-" + right);
	}
	
	public static void main(String[] args)
	{
		int[] buffer = {2,6,3,9,4,8,13,7};
		longestConsecutiveRange(buffer);
	}
}
