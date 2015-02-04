package games.core;

public class MinInsertionsToPalindrome 
{

	private static int minInsertions(String str)
	{
		int[][] cache = new int[str.length()][str.length()];

		for(int gap = 1; gap < str.length(); gap++)
		{
			for(int i = 0; i < str.length() - gap; i++)
			{
				int j = i+gap;
				if(str.charAt(i) == str.charAt(j))
					cache[i][j] = cache[i+1][j-1];
				else
					cache[i][j] = 1 + Math.min(cache[i+1][j], cache[i][j-1]);
			}
		}
		return cache[0][str.length()-1];
	}

	private static void test()
	{
		assert(minInsertions("ab") == 1);
		assert(minInsertions("sbxs") == 1);
		assert(minInsertions("hjfdbfxyqh") == 5);
		System.out.println("PASSED!");
	}
	
	public static void main(String[] args)
	{
		test();
	}
}
