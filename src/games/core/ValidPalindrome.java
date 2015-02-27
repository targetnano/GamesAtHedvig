package games.core;

public class ValidPalindrome 
{

	private static boolean isPalindrome(String s)
	{
	    if(s == null || s.length() <= 1)
	        return true;
	    
	    int start = 0;
	    int end = s.length()-1;
	    while(end > start)
	    {
	        while(!validChar(s, start) && start < end)
	            start++;
	        
	        while(!validChar(s, end) && start < end)
	            end--;
	            
	        if(toLowerCase(s, start) != toLowerCase(s,end))
	            return false;
	        
	        start++;
	        end--;
	    }
	    return true;
	}

	private static char toLowerCase(String s, int i)
	{
	    char ch = s.charAt(i);
	    if(ch >= 'A' && ch <= 'Z')
	    {
	        return (char)(ch+32);
	    }
	    return ch;
	}

	private static boolean validChar(String s, int i)
	{
	    char ch = s.charAt(i);
	    if( (ch >= '0' && ch <= '9') || (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') )
	        return true;
	    return false;
	}
	
	public static void main(String[] args)
	{
		System.out.println(isPalindrome("Programcreek is awesome"));
	}
}
