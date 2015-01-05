
public class EditDistance 
{

	/**
	 * Given two strings, it returns true is the strings are one edit away
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	private static boolean isOneEditApart(String a, String b)
	{
	    if(Math.abs(a.length() - b.length()) > 1)
	        return false;
	    String longer = a;
	    String shorter = b;
	    boolean lenUnequal = false;
	    if(a.length() != b.length())
	    {
	        lenUnequal = true;
	        longer = (a.length() > b.length()) ? a : b;
	        shorter = a.length() < b.length() ? a : b;
	    }
	    for(int i = 0; i < shorter.length(); i++)
	    {
	        if(longer.charAt(i) != shorter.charAt(i))
	        {
	            return lenUnequal ? longer.substring(i+1).equals(shorter.substring(i))
	                              : longer.substring(i+1).equals(shorter.substring(i+1));
	        }
	    }
	    return lenUnequal ? true : false;
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
		System.out.print(minEditDistance("xyz", "yxz"));
	}
}
