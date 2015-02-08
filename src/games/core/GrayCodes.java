package games.core;

public class GrayCodes 
{

	private static int[][] getGrayCodes(int n)
	{
	    int numRows = (int) Math.pow(2,n);
	    int[][] grayCodes = new int[numRows][n];
	    getGrayCodes(n, n-1, 0, 0, 1, grayCodes);
	    return grayCodes;
	}

	/**
	 * Algorithm as in http://fenghaolw.blogspot.com/2013/01/gray-code.html?view=sidebar
	 * @param n
	 * @param bufIndex
	 * @param start
	 * @param mid
	 * @param end
	 * @param grayCodes
	 */
	private static void getGrayCodes(int n, int bufIndex, int start, int mid, int end, int[][] grayCodes)
	{
	    if(n == 0) return;
	    
	    // Fill 0's for this level
	    for(int i = start; i <= mid; i++)
	        grayCodes[i][bufIndex] = 0;
	    
	    // Fill 1's for this level
	    for(int i = mid+1; i <= end; i++)
	        grayCodes[i][bufIndex] = 1;
	    
	    if(n > 1)
	    {
	        int newEnd = ((end+1) * 2) - 1;
	        int oldEnd = end;

	        // Copy top n rows when we pass on to next level
	        for(int i = end+1; i <= newEnd; i++)
	        {
	        	for(int j = bufIndex; j < grayCodes[0].length; j++)
	        		grayCodes[i][j] = grayCodes[oldEnd][j];
	        	oldEnd--;
	        }
	        getGrayCodes(n-1, bufIndex-1, 0, end, newEnd, grayCodes);
	    }
	}
	
	public static void main(String[] args)
	{
		int n = 10;
		int[][] codes = getGrayCodes(n);
		for(int i = 0; i < codes.length; i++)
		{
			for(int j = 0; j < codes[0].length; j++)
				System.out.print(codes[i][j]);
			System.out.println("");
		}
	}
}
