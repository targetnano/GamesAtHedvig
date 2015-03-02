package games.core;

public class RegularExpressionMatching 
{
	private static boolean isMatch(String text, String pattern)
	{
	    if(pattern.length() == 0)
	        return text.length() == 0;
	    
	    if(pattern.length() == 1 || pattern.charAt(1) != '*')
	    {
	        if(text.length() == 0)
	            return false;
	        else if(pattern.charAt(0) != text.charAt(0) && pattern.charAt(0) != '.')
	            return false;
	        else
	            return isMatch(text.substring(1), pattern.substring(1));
	    }
	    else
	    {
	        if(isMatch(text, pattern.substring(2)))
	            return true;
	        
	        int i = 0;
	        while( i < text.length() && (pattern.charAt(0) == '.' || pattern.charAt(0) == text.charAt(i)) )
	        {
	            if(isMatch(text.substring(i+1), pattern.substring(2)))
	                return true;
	            i++;
	        }
	        return false;
	    }
	}
	
	public static void main(String[] args)
	{
		System.out.println(isMatch("aab",".*"));
	}
}
