package games.core;

import games.utils.Pair;

public class SearchSortedMatrix 
{

	private static Pair<Integer,Integer> findNumber(int[][] grid, int k)
	{
	    int i = 0;
	    int j = grid[0].length-1;
	    Pair<Integer,Integer> pair = new Pair<Integer,Integer>();
	    
	    while(i < grid.length && i >= 0 && j >= 0 && j < grid[0].length)
	    {
	        if(grid[i][j] < k)
	            i++;
	        else if(grid[i][j] > k)
	            j--;
	        else
	        {
	            pair.k(i);
	            pair.v(j);
	            return pair;
	        }
	    }
	    return null;
	}
	
	public static void main(String[] args)
	{
		int[][] grid = { {1,2,3},
				         {4,5,6},
				         {7,8,9}
						};
		System.out.println(findNumber(grid, 10));
	}
}
