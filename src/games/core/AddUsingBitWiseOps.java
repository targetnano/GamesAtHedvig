package games.core;

public class AddUsingBitWiseOps 
{

	private static int bitWiseAddition(int a, int b)
	{
	    while(b != 0)
	    {
	        int carry = a & b;
	        a = a ^ b;
	        b = carry << 1;
	    }
	    return a;
	}
	
	public static void main(String[] args)
	{
		System.out.println(bitWiseAddition(5,9));
	}
}
