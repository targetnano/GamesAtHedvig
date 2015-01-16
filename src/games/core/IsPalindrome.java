package games.core;

public class IsPalindrome 
{

	private static boolean isPalindromeNumber(int number)
	{
	    int numDigits = 0;
	    int temp = number;

	    while(temp != 0)
	    {
	        numDigits++;
	        temp = temp / 10;
	    }

	    int high = numDigits-1;
	    while(high > 0)
	    {
	        int up = number / ((int) Math.pow(10, high));
	        int low = number % 10;

	        if(up != low)
	            return false;
	        number = number -  (up * ((int) Math.pow(10, high)));
	        number = number / 10;
	        high = high - 2;
	    }
	    return true;
	}
	
	public static void main(String[] args)
	{
		System.out.println(isPalindromeNumber(1992));
	}
}
