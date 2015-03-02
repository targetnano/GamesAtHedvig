package games.core;

import java.util.Random;

/*
 	Given an array of integers, sort the array into a wave like array, namely
 	a1 >= a2 <= a3 >= a4 <= a5.....
 */
public class WaveTransform 
{

	private static int getPartitionIndex(int start, int end, int pivot, int[] array)
	{
	    int i = start;
	    while(i < end)
	    {
	        int x = array[i];
	        if(x == pivot)
	            i++;
	        else if(x > pivot)
	        {
	            int temp = array[end];
	            array[end] = x;
	            array[i] = temp;
	            end--;
	        }
	        else
	        {
	            int temp = array[start];
	            array[start] = array[i];
	            array[i] = temp;
	            start++;
	            i++;
	        }
	    }
	    return i;
	}

	private static void waveTransform(int[] array)
	{
	    if(array == null || array.length == 0)
	        return;
	 
	    Random rand = new Random();   
	    int medianIdx = array.length/2;
	    int start = 0;
	    int end = array.length - 1;
	    while(start < end)
	    {
	        int pivot = rand.nextInt(end-start) + start;
	        int partitionIdx = getPartitionIndex(start, end, array[pivot], array);
	        if(partitionIdx == medianIdx)
	            break;
	        else if(partitionIdx > medianIdx)
	            end = partitionIdx-1;
	        else
	            start = partitionIdx+1;
	    }
	    int numSwaps = array.length/2;
	    int lower = 0;
	    int higher = medianIdx;
	    while(numSwaps > 0)
	    {
	        int temp = array[lower];
	        array[lower] = array[higher];
	        array[higher] = temp;
	        higher++;
	        lower += 2;
	        numSwaps--;
	    }
	}
	
	public static void main(String[] args)
	{
		int[] a = {1,2,3};
		waveTransform(a);
		for(int x : a)
			System.out.print(x + " ");
	}
}
