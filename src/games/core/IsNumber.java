package games.core;

/**
 * http://fenghaolw.blogspot.com/2013/03/valid-number.html?view=sidebar
 * 
 * @author Kavi
 *
 */
public class IsNumber 
{

	private static boolean isNumber(String number)
	{
	    int numDots = 0;
	    int es = 0;

	    for(int i = 0; i < number.length(); i++)
	    {
	        char ch = number.charAt(i);
	        if(ch == '.' && numDots != 0)
	            return false;
	        if( ch >= '0' && ch <= '9')
	            continue;
	        else if(ch == '-' || ch == '+')
	        {
	        	if(i != 0 && number.charAt(i-1) != 'e')
	        		return false;
	        }
	        else if(ch == '.')
	        {
	            numDots++;
	            if(i == 1 && number.charAt(0) == '-')
	                return false;
	        }
	        else if(ch == 'e')
	        {
	        	es++;
	        	if(es > 1) return false;
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
