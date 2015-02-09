package games.core;

/**
 * Ref: http://n00tc0d3r.blogspot.com/2013/04/longest-valid-parentheses.html
 * @author Kavi
 *
 */
public class LongestValidParenthesis 
{

	private static int longestValidLength(String str, char ch, int start, int end, int step)
	{
	    int len = 0, maxLen = 0, count = 0;
	    for(int i = start; i != end; i += step)
	    {
	        if(str.charAt(i) == ch)
	            count++;
	        else
	        {
	            if(count > 0)
	            {
	                count--;
	                len += 2;
	                if(count == 0) maxLen = Math.max(maxLen, len);
	            }
	            else
	                len = 0;
	        }
	    }
	    return maxLen;
	}

	/**
	 * Same counter approach. Find the longest valid from left to right
	 * and the longest from right to left. Return the maximum
	 * @param str
	 * @return
	 */
	private static int getLongestValidParenthesis(String str)
	{
	    return Math.max(longestValidLength(str, '(', 0, str.length(), 1), 
	                    longestValidLength(str, ')', str.length()-1,-1,-1));
	}
	
	public static void main(String[] args)
	{
		System.out.println(getLongestValidParenthesis("((()())()(("));
	}
}
