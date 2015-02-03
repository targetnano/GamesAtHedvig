package games.core;

public class OptimalStrategyForAGame 
{

	private static int getMaximumWins(int[] array)
	{
	    int[][] cache = new int[array.length][array.length];
	    
	    for(int gap = 0; gap < array.length; gap++)
	    {
	        for(int i = 0; i < array.length - gap; i++)
	        {
	            int j = i + gap;
	            //[i+2][j]
	            int pos1 = (i+2) <= j ? cache[i+2][j] : 0;
	            // [i+1][j-1]
	            int pos2 = (i+1) <= (j-1) ? cache[i+1][j-1] : 0;
	            // [i][j-2]
	            int pos3 = (i <= (j-2)) ? cache[i][j-2] : 0;
	            
	            cache[i][j] = Math.max(array[i]+Math.min(pos1,pos2), array[j]+Math.min(pos2,pos3));
	        }
	    }
	    return cache[0][array.length-1];
	}
	
	private static void test()
	{
		int[] a = {3,2,1};
		assert(getMaximumWins(a) == 4);
		
		int[] b = {1,4,2,5,3,6};
		assert(getMaximumWins(b) == 15);
		
		int[] c = {5, 3, 7, 10 };
		assert(getMaximumWins(c) == 15);
		
		int[] d = {8, 15, 3, 7};
		assert(getMaximumWins(d) == 22);
		
		int[] e = {20, 30, 2, 2, 2, 10};
		assert(getMaximumWins(e) == 42);
		System.out.println("PASSED!");
	}
	
	public static void main(String[] args)
	{
		test();
	}
}
