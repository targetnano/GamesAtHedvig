package games.core;

public class LongestPalindromicSubsequence 
{

	private static int longestPalindromicSubsequence(String str)
	{
		int[][] cache = new int[str.length()][str.length()];
		for(int i = 0; i < str.length(); i++)
			cache[i][i] = 1;

		for(int gap = 1; gap < str.length(); gap++)
		{
			for(int i = 0; i < str.length() - gap; i++)
			{
				int j = i+gap;
				if(str.charAt(i) == str.charAt(j))
					cache[i][j] = (i + 1 == j) ? 2: 2 + cache[i+1][j-1];
				else
					cache[i][j] = Math.max(cache[i+1][j], cache[i][j-1]);
			}
		}
		return cache[0][str.length()-1];
	}
	
	public static void test()
	{
		assert(longestPalindromicSubsequence("abxyba") == 5);
		assert(longestPalindromicSubsequence("aaaa") == 4);
		assert(longestPalindromicSubsequence("pqabcoxq") == 3);
		System.out.println("PASSED!");
	}
	
	public static void main(String args[])
	{
		test();
	}
}
