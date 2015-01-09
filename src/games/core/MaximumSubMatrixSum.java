package games.core;

import games.utils.Pair;

public class MaximumSubMatrixSum 
{

	private static int kadane(int[] buffer)
	{
	    int max_so_far = buffer[0];
	    int max_ending_here = buffer[0];

	    for(int i = 1; i < buffer.length; i++)
	    {
	        max_ending_here += buffer[i];
	        if(max_ending_here < buffer[i])
	            max_ending_here = buffer[i];
	        if(max_ending_here > max_so_far)
	            max_so_far = max_ending_here;
	    }
	    return max_so_far;
	}
	
	private static Pair<Integer, Pair<Integer,Integer>> kadaneReturnFriendly(int[] buffer)
	{
		int globalMax = Integer.MIN_VALUE, curMax = 0;
		int start = -1, end = -1;
		
		int i = 0;
		for(int x : buffer)
		{
			curMax += x;
			if(curMax < 0)
			{
				curMax = 0;
				start = i+1;
			}
			else if(curMax > globalMax)
			{
				end = i;
				globalMax = curMax;
			}
			i++;
		}
		
		if(end != -1)
		{
			Pair<Integer,Integer> pair = new Pair<Integer,Integer>(start, end);
			Pair<Integer, Pair<Integer,Integer>> result = new Pair<Integer, Pair<Integer, Integer>>(globalMax, pair);
			return result;
		}
		
		for(i = 0; i < buffer.length; i++)
		{
			if(buffer[i] > globalMax)
			{
				globalMax = buffer[i];
				start = i;
				end = i;
			}
		}
		Pair<Integer,Integer> pair = new Pair<Integer,Integer>(start, end);
		Pair<Integer, Pair<Integer,Integer>> result = new Pair<Integer, Pair<Integer, Integer>>(globalMax, pair);
		return result;
	}

	private static int largestSubmatrixSum(int[][] matrix)
	{
	    int max = Integer.MIN_VALUE;
	    int rows = matrix.length;
	    int columns = matrix[0].length;
	    int left = -1, right = -1;

	    // Uber point: Apply kadane to all cumulative
	    // columns to n, from 0 to n.
	    for(int i = 0; i < columns; i++)
	    {
	        int[] buffer = new int[rows];
	        for(int j = i; j < columns; j++)
	        {
	            for(int k = 0; k < rows; k++)
	                buffer[k] += matrix[k][j];

	            int curMax = kadane(buffer);
	            if(curMax > max)
	            {
	                max = curMax;
	                left = i;
	                right = j;
	            }
	        }
	    }
	    return max;
	}

	public static void main(String[] args)
	{
		int[][] matrix = {
				{0,-2,-7,0},
				{9,2,-6,2},
				{-4,1,-4,1},
				{-1,8,0,-2}
		};
		// Ans: 15
		System.out.println(largestSubmatrixSum(matrix));
	}
}
