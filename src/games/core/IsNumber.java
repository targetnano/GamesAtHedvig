package games.core;

public class IsNumber 
{

	private static boolean isNumber(String number)
	{
	    int numDots = 0;

	    for(int i = 0; i < number.length(); i++)
	    {
	        char ch = number.charAt(i);
	        if(ch == '.' && numDots != 0)
	            return false;
	        if( ch >= '0' && ch <= '9')
	            continue;
	        else if(ch == '-')
	        {
	        	if(i != 0)
	        		return false;
	        }
	        else if(ch == '.')
	        {
	            numDots++;
	            if(i == 1 && number.charAt(0) == '-')
	                return false;
	        }
	        else 
	        	return false;
	    }
	    return true;
	}
	
	public static void main(String[] args)
	{
		System.out.println(isNumber("00.7676"));
	}
}
