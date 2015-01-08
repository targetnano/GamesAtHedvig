package games.core;

public class LongestCommonSubstring 
{
	private static int longestCommonSubstring(String a, String b)
	{
	    if(a == null || b == null || a.length() == 0 || b.length() == 0)
	        return 0;

	    int longestCommonSubstring = 0;
	    
	    // commonSuffixLengths[i][j] indicates the longest common suffix
	    // length for a.substring(0,i+1) and b.substring(0,j+1)
	    int[][] commonSuffixLengths = new int[a.length()+1][b.length()+1];
	    for(int i = 0; i <= a.length(); i++)
	    {
	        for(int j = 0; j <= b.length(); j++)
	        {
	            if(i==0 || j==0)
	            {
	                commonSuffixLengths[i][j] = 0;
	                continue;
	            }
	            
	            // If the character is not equal, then there
	            // is no common suffix in the substrings
	            if(a.charAt(i-1) != b.charAt(j-1))
	                commonSuffixLengths[i][j] = 0;

	            else
	            {
	            	// If the characters are equal, then inherit
	                commonSuffixLengths[i][j] = 1 + commonSuffixLengths[i-1][j-1];
	                longestCommonSubstring = Math.max(longestCommonSubstring, commonSuffixLengths[i][j]);
	            }
	        }
	    }
	    return longestCommonSubstring;
	}
	
	private static int lcsRec(int i, int j, int curLen, String a, String b)
	{
		if(i == 0 || j == 0)
			return curLen;
		
		
		if(a.charAt(i-1) == b.charAt(j-1))
			return lcsRec(i-1, j-1, 1+curLen, a, b);
		else
		{
			int newLen = Math.max(lcsRec(i-1, j, 0, a, b) , lcsRec(i, j-1, 0, a, b));
			return Math.max(newLen, curLen);
		}
	}
	
	public static void main(String[] args)
	{
		//System.out.println(lcsRec(5, 5, 0, "sabxc", "xabdc"));
		System.out.println(lcsRec(7, 9, 0, "xabcxxd", "kkkabczzd"));
	}
}
