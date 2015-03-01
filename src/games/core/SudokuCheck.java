package games.core;

public class SudokuCheck 
{

	private static boolean isValid(int srcRow, int srcCol, int destRow, int destCol, int[][] sudoku)
	{
	    boolean[] found = new boolean[10];
	    for(int r = srcRow; r <= destRow; r++)
	    {
	        for(int c = srcCol; c <= destCol; c++)
	        {
	            int x = sudoku[r][c];
	            if(found[x])
	                return false;
	            else
	                found[x] = true;
	        }
	    }
	    return true;
	}

	private static boolean isValidSudoku(int[][] sudoku)
	{
	    for(int r = 0; r <= 8; r++)
	    {
	        if(!isValid(r, 0, r, 8, sudoku))
	            return false;
	    }
	    
	    for(int c = 0; c <= 8; c++)
	    {
	        if(!isValid(0, c, 8, c, sudoku))
	            return false;
	    }
	    
	    for(int r = 0; r < 8; r += 3)
	    {
	        for(int c = 0; c < 8; c += 3)
	        {
	            if(!isValid(r, c, r+2, c+2, sudoku))
	                return false;
	        }
	    }
	    return true;
	}
	
	public static void main(String[] args)
	{
		int[][] sudoku = { 	{6,3,2,7,8,1,9,4,5},
							{4,8,7,5,9,6,2,1,3},
							{5,1,9,2,4,3,8,7,6},
							{8,6,4,3,5,2,7,9,1},
							{7,5,1,9,6,8,3,2,4},
							{2,9,3,1,7,4,6,5,8},
							{9,4,5,6,3,7,1,8,2},
							{1,7,6,8,2,5,4,3,9},
							{3,2,8,4,1,9,5,6,7}
							};
		System.out.println(isValidSudoku(sudoku));
	}
}
