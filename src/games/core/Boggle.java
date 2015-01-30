package games.core;

public class Boggle 
{

	private static int[] dx = {-1,1,0,0,1,1,-1,-1};
	private static int[] dy = {0,0,-1,1,1,-1,1,-1};

	private static boolean boggle(String word, char[][] grid, boolean[][] visited)
	{
	    for(int i = 0; i < grid.length; i++)
	    {
	        for(int j = 0; j < grid[0].length; j++)
	        {
	            if(grid[i][j] == word.charAt(0)) {
	                if(boggle(i,j,0,word, grid, visited))
	                    return true;
	            }
	        }
	    }
	    return false;
	}

	private static boolean boggle(int x, int y, int wordIdx, String word, char[][] grid, boolean[][] visited)
	{
	    if(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length)
	        return false;
	        
	    if(wordIdx == word.length())
	        return true;    
	    if(visited[x][y] || word.charAt(wordIdx) != grid[x][y])
	        return false;
	        
	    visited[x][y] = true;
	    
	    for(int i = 0; i < dx.length; i++) {
	        if( boggle(x+dx[i], y+dy[i], wordIdx+1, word, grid, visited) )
	            return true;
	    }
	    visited[x][y] = false;
	    return false;
	}
	
	public static void main(String[] args) {
		char[][] grid = { {'c','f','s','t'},
						  {'g','h','s','o'},
						  {'a','p','y','e'},
						  {'h','i','w','b'}
						};
		boolean[][] visited = new boolean[grid.length][grid[0].length];
		System.out.println(boggle("bespi", grid, visited));
	}
}
