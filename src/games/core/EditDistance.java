package games.core;

public class EditDistance 
{

	/**
	 * Given two strings, it returns true is the strings are one edit away
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	private static boolean isOneEditAway(String s1, String s2)
	{
	    if(Math.abs(s1.length() - s2.length()) > 1)
	        return false;

	    for(int i = 0; i < s2.length() && i < s1.length(); i++)
	    {
	        if(s1.charAt(i) != s2.charAt(i))
	        {
	        	if(s1.length() > s2.length())
	        		return s1.substring(i+1).equals(s2.substring(i));
	        	else
	        		return s1.substring(i+1).equals(s2.substring(i+1));
	        }
	    }
	    return s1.length() != s2.length();
	}
	
	/**
	 * Given two strings, it determines the minimum number of edits
	 * to transform the string into another.
	 * @param a
	 * @param b
	 * @return
	 */
	private static int minEditDistance(String a, String b)
	{
	    int[][] distances = new int[a.length()+1][b.length()+1];
	    for(int i = 0; i <= a.length(); i++)
	    {
	        for(int j = 0; j <= b.length(); j++)
	        {
	            if(i == 0 && j == 0)
	                distances[0][0] = 0;

	            else if(i == 0 && j > 0)
	                distances[i][j] = 1 + distances[i][j-1];

	            else if(i > 0 && j == 0)
	                distances[i][j] = 1 + distances[i-1][j];
	            else
	            {
	                int subCost = (a.charAt(i-1) == b.charAt(j-1)) ? distances[i-1][j-1] : (1 + distances[i-1][j-1]);
	                distances[i][j] = Math.min(1+distances[i][j-1], 1+distances[i-1][j]);
	                distances[i][j] = Math.min(subCost, distances[i][j]);
	            }
	        }
	    }
	    return distances[a.length()][b.length()];
	}
	
	public static void main(String[] args)
	{
		System.out.print(isOneEditAway("baa", "baaa"));
	}
}
