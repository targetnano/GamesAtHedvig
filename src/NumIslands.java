
public class NumIslands 
{

	private static int getNumIslands(char[][] grid)
	{
		// X - Land, O - Water
	    boolean[][] visited = new boolean[grid.length][grid[0].length];
	    int numIslands = 0;
	    for(int i = 0; i < grid.length; i++)
	    {
	        for(int j = 0; j < grid[0].length; j++)
	        {
	            if(grid[i][j] == 'X' && !visited[i][j])
	            {
	            	visitIsland(i, j, grid, visited);
	                numIslands++;
	            }
	        }
	    }
	    return numIslands;
	}

	private static void visitIsland(int x, int y, char[][] grid, boolean[][] visited)
	{
	    if(x < 0 || y < 0 || x >= grid.length || y >= grid[0].length)
	        return;
	    // BUG: Forgot to check this water check
	    if(visited[x][y] || grid[x][y] == 'O')
	        return;

	    visited[x][y] = true;
	    visitIsland(x-1, y, grid, visited);
	    visitIsland(x+1, y, grid, visited);
	    visitIsland(x, y-1, grid, visited);
	    visitIsland(x, y+1, grid, visited);
	}
	
	public static void main(String[] args)
	{
		char[][] grid = { {'X','X','X'},
						  {'X','O','X'},
						  {'O','X','O'}};
		System.out.println(getNumIslands(grid));
	}
}
