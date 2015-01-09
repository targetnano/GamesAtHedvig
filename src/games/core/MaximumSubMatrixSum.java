package games.core;

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

	private static int largestSubmatrixSum(int[][] matrix)
	{
	    int max = Integer.MIN_VALUE;
	    int rows = matrix.length;
	    int columns = matrix[0].length;

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
	                max = curMax;
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
