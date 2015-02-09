package games.core;

public class MinPathSum 
{

	/**
	 * Reference: http://n00tc0d3r.blogspot.com/2013/04/minimum-path-sum.html
	 * @param grid
	 * @return
	 */
	private static int minSumPath(int[][] grid)
	{
	    int rows = grid.length;
	    int cols = grid[0].length;
	    
	    int[][] sumCache = new int[rows][2];
	    // Init the first element to start with
	    sumCache[0][0] = grid[0][0];
	    
	    // Precalculate the first column sums
	    int sumCacheCol = 0;
	    for(int row = 1; row < rows; row++)
	        sumCache[row][sumCacheCol] = grid[row][sumCacheCol] + sumCache[row-1][sumCacheCol];
	    
	    // For each column in the grid
	    for(int col = 1; col < cols; col++)
	    {
	    	// Advance to the next col and calculate all column sums
	        sumCacheCol = 1 - sumCacheCol;
	        sumCache[0][sumCacheCol] = grid[0][col] + sumCache[0][1-sumCacheCol];
	        
	        for(int row = 1; row < rows; row++)
	        {
	            sumCache[row][sumCacheCol] = Math.min(sumCache[row-1][sumCacheCol], sumCache[row][1-sumCacheCol]);
	            sumCache[row][sumCacheCol] += grid[row][col];
	        }
	    }
	    return sumCache[grid.length-1][sumCacheCol];
	}
	
	public static void main(String[] args)
	{
		int[][] grid = { {1,2,3},
						 {4,5,6} };
		System.out.println(minSumPath(grid));
	}
}
