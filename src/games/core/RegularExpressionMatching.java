package games.core;

public class RegularExpressionMatching 
{

	private static boolean match(int strIdx, String str, int regexIdx, String regex)
	{
		// If we are at the end of both strings, it means all the chars
		// have been successfully matched so far. Return TRUE
	    if(strIdx == str.length() && regexIdx == regex.length())
	        return true;

	    // The regex string is fully matched, but there are still chars
	    // left in the main string unmatched. Return FALSE 
	    if(regexIdx == regex.length())
	    	return false;

	    // We are done processing whole string. This can happen only when 
	    // we have '*' or '+' as the final char. So, if it the case,
	    // Return TRUE. Otherwise, Return FALSE.
	    if(strIdx == str.length())
	    {
	    	if(regex.charAt(regexIdx) == '*' || regex.charAt(regexIdx) == '+')
	    		return regexIdx+1 == regex.length();
	    	else
	    		return false;
	    }
	    
	    // All these are straight-forward cases
	    if(regex.charAt(regexIdx) == '+')
	    {
	    	if(regex.charAt(regexIdx-1) == str.charAt(strIdx))
	    		return match(strIdx+1, str, regexIdx, regex);
	    	else
	    		return match(strIdx, str, regexIdx+1, regex);
	    }
	    if(regex.charAt(regexIdx) == '?' || regex.charAt(regexIdx) == str.charAt(strIdx))
	        return match(strIdx+1, str, regexIdx+1, regex);

	    if(regex.charAt(regexIdx) == '*')
	    {
	        return match(strIdx+1, str, regexIdx, regex) ||
	                match(strIdx, str, regexIdx+1, regex);
	    }
	    return false;
	}
	
	public static void main(String[] args)
	{
		System.out.println(match(0, "aa", 0, "?a+"));
	}
}
