package games.core;

public class Jumpable 
{

	private static boolean jumpable(int[] array)
	{
	    int remainingSteps = array[0];
	    int index = 0;
	    
	    for(int i = 1; i < array.length; i++)
	    {
	        remainingSteps--;
	        remainingSteps = Math.max(remainingSteps, array[i]);
	        if(remainingSteps == 0 && i < array.length-1)
	            break;
	        index++;
	    }
	    return (index >= array.length-1);
	}
	
	private static void test()
	{
		int[] a = {1,1,0};
		assert(jumpable(a));
		
		int[] b = {8,0,0,0,1,1,0,0,0,0,0,0};
		assert(jumpable(b));
		System.out.println("PASSED!");
	}
	
	public static void main(String[] args)
	{
		test();
	}
}
