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
	
	public static void test()
	{
		assert(bitWiseAddition(5,9) == 14);
		assert(bitWiseAddition(-3,-2) == -5);
		assert(bitWiseAddition(5,0) == 5);
		assert(bitWiseAddition(10,-2) == 8);
		System.out.println("PASSED!");
	}
	
	public static void main(String[] args)
	{
		test();
	}
}
