
public class EditDistance 
{

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
	
	public static void main(String[] args)
	{
		System.out.print(isOneEditApart("xyz", "xy"));
	}
}
