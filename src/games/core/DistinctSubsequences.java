package games.core;

public class DistinctSubsequences 
{

	private static int distinctSubsequences(String s1, String s2)
	{
	    int s1Len = s1.length();
	    int s2Len = s2.length();

	    int[][] count = new int[s1Len][s2Len];
	    count[0][0] = ( s1.charAt(0) == s2.charAt(0) ) ? 1 : 0;
	    for(int i = 1; i < s1Len; i++)
	    {
	        for(int j = 0; j < s2Len; j++)
	        {
	            count[i][j] = count[i-1][j];
	            if(s1.charAt(i) == s2.charAt(j))
	                if(j >= 1)
	                    count[i][j] += count[i-1][j-1];
	        }
	    }
	    return count[s1Len-1][s2Len-1];
	}
	
	public static void main(String[] args)
	{
		System.out.println(distinctSubsequences("abccdde", "abcde"));
	}
}
