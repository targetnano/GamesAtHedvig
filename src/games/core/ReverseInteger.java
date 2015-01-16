package games.core;

public class ReverseInteger 
{

	private static int reverseInt(int number)
	{
	    int reverse = 0;
	    while(number != 0)
	    {
	        int mod = number % 10;
	        number = number / 10;
	        reverse = 10 * reverse + mod;
	    }
	    return reverse;
	}
	
	public static void main(String[] args)
	{
		System.out.println(reverseInt(-878));
	}
}
