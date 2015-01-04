
public class Interleavings 
{

	/**
	 * Prints all possible interleavings of two given strings
	 * @param a
	 * @param b
	 */
	private static void printInterLeavings(String a, String b)
	{
	    int interLength = a.length() + b.length();
	    char[] buffer = new char[interLength];
	    interleave(0, a, 0, b, 0, buffer);
	}

	private static void interleave(int aIdx, String a, int bIdx, String b, int bufIdx, char[] buffer)
	{
		// Bug 1: Was [ bufIdx == buffer.length - 1 ]
	    if(bufIdx == buffer.length)
	    {
	        for(int i = 0; i <= bufIdx - 1; i++)
	        {
	            System.out.print(buffer[i]);
	        }
	        System.out.println("");
	        // Bug 2: Missed return
	        return;
	    }
	    if(aIdx < a.length())
	    {
	        buffer[aIdx+bIdx] = a.charAt(aIdx);
	        interleave(aIdx+1, a, bIdx, b, bufIdx+1, buffer);
	    }
	    if(bIdx < b.length())
	    {
	        buffer[aIdx+bIdx] = b.charAt(bIdx);
	        interleave(aIdx, a, bIdx+1, b, bufIdx+1, buffer);
	    }
	}
	
	/**
	 * Checks if the given string is interleaved of two other strings
	 * 
	 * @param a
	 * @param b
	 * @param c
	 * @return
	 */
	private static boolean isInterleaved(String a, String b, String c)
	{
	    boolean[][] matrix = new boolean[a.length()+1][b.length()+1];
	    // Base case
	    matrix[0][0] = true;
	    
	    //BUG: Had these two loops inside which broke some boundary cases.
	    for(int j = 1; j <= b.length(); j++)
	    {
	    	if(b.charAt(j-1) == c.charAt(j-1))
	    		matrix[0][j] = matrix[0][j-1];
	    }
	    for(int i = 1; i <= a.length(); i++ )
	    {
	    	if(a.charAt(i-1) == c.charAt(i-1))
	    		matrix[i][0] = matrix[i-1][0];
	    }
	    for(int i = 1; i <= a.length(); i++)
	    {
	        for(int j = 1; j <= b.length(); j++)
	        {
	            if(a.charAt(i-1) == c.charAt(i+j-1) && b.charAt(j-1) != c.charAt(i+j-1))
	                matrix[i][j] = matrix[i-1][j];

	            else if(a.charAt(i-1) != c.charAt(i+j-1) && b.charAt(j-1) == c.charAt(i+j-1))
	                matrix[i][j] = matrix[i][j-1];

	            else if(a.charAt(i-1) == c.charAt(i+j-1) && b.charAt(j-1) == c.charAt(i+j-1))
	                matrix[i][j] = matrix[i-1][j] || matrix[i][j-1];
	        }
	    }
	    System.out.println(matrix[a.length()][b.length()]);
	    return matrix[a.length()][b.length()];
	}
	
	public static void main(String[] args)
	{
		String a = "abc";
		String b = "xyz";
		String c = "axbycz";
		isInterleaved(a,b,c);
		//printInterLeavings(a,b);
	}
}
