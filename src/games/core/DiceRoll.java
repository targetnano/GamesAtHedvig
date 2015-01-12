package games.core;

public class DiceRoll 
{

	private static int numWaysToGetSum(int n, int f, int sum)
	{
	    int[][] matrix = new int[n+1][sum+1];

	    // BUG: Set each item to 'i'.
	    for(int i = 1; i <= sum && i <= f; i++)
	        matrix[1][i] = 1;

	    // For each number of dices
	    for(int i = 2; i <= n; i++)
	    {
	    	// For each sum
	        for(int j = 1; j <= sum; j++)
	            {
	        		// This dice rolled 'k'. How many ways to get sum (j-k)
	        		// with (i-1) dices rolled? Add it.
	                for(int k = 1; k <= f && k <= j; k++)
	                    matrix[i][j] += matrix[i-1][j-k];
	            }
	    }
	    return matrix[n][sum];
	}
	
	public static void main(String[] args)
	{
		System.out.println(numWaysToGetSum(2, 4, 4));
	}
}
