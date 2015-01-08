package games.core;
import java.util.HashSet;
import java.util.Set;


public class LCS 
{

	private static int[][] getLcsMatrix(String a, String b)
	{
	    int aLen = a.length();
	    int bLen = b.length();
	    int[][] matrix = new int[aLen+1][bLen+1];

	    for(int i = 0; i <= aLen; i++)
	    {
	        for(int j = 0; j <= bLen; j++)
	        {
	            if(i == 0 || j == 0)
	            {
	                matrix[i][j] = 0;
	                continue;
	            }

	            // Committed a bug here:
	            // Was like: a.charAt(i) == b.charAt(j)
	            if(a.charAt(i-1) == b.charAt(j-1))
	            {
	                matrix[i][j] = matrix[i-1][j-1] + 1;
	            }
	            else
	                matrix[i][j] = Math.max(matrix[i-1][j], matrix[i][j-1]);
	        }
	    }
	    return matrix;
	}
	
	private static void printLCS(int aIdx, int bIdx, String a, String b, String lcsString, int[][] matrix, Set<String> set)
	{
		// We need to pass this set to make sure we dont print redundant LCS's.
	    if( matrix[aIdx][bIdx] == 0 || (aIdx == 0 || bIdx == 0) )
	    {
	    	if(lcsString.length() > 0)
	    	{
	    		String lcs = new StringBuilder(lcsString).reverse().toString();
	    		set.add(lcs);
	    		return;
	    	}
	    	else
	    		return;
	    }
	    // Committed a bug here:
	    // Was like: a.chatAt(aIdx)
	    char aChar = a.charAt(aIdx-1);
	    char bChar = b.charAt(bIdx-1);
	    if(aChar == bChar)
	    {
	        printLCS(aIdx-1, bIdx-1, a, b, lcsString + aChar, matrix, set);
	    }
	    else
	    {
	        int len = matrix[aIdx][bIdx];
	        if(matrix[aIdx-1][bIdx] == len)
	            printLCS(aIdx-1, bIdx, a, b, lcsString, matrix, set);
	        if(matrix[aIdx][bIdx-1] == len)
	            printLCS(aIdx, bIdx-1, a, b, lcsString, matrix, set);
	    }
	}
	
	public static void main(String[] args)
	{
		String a = "axbcd";
		String b = "cdafb";
		int[][] matrix = getLcsMatrix(a, b);
		System.out.println(matrix[a.length()] [b.length()]);
		Set<String> set = new HashSet<String>();
		printLCS(a.length(), b.length(), a, b, "", matrix, set);
		for(String str : set)
		{
			System.out.println(str);
		}
	}
}
