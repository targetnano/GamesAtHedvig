package games.core;

public class TrianglePathSum 
{

	private static int minTrianglePathSum(int[][] triangle, int r, int c)
	{
	    if(r >= triangle.length)
	        return 0;

	    int leftSum = minTrianglePathSum(triangle, r+1, c);
	    int rightSum = minTrianglePathSum(triangle, r+1, c+1);
	    return triangle[r][c] + Math.min(leftSum, rightSum);
	}
	
	public static void main(String[] args)
	{
		/*
		 * [
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
		 */
		int[][] array = { {2,0,0,0}, {3,4,0,0}, {6,5,7,0}, {4,1,8,3} };
		System.out.println(minTrianglePathSum(array, 0, 0));
	}
}
