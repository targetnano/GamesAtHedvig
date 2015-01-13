package games.core;

public class PrefixSuffixMultiply 
{

	private static void printProducts(int[] array)
	{
	    int[] prefix = new int[array.length];
	    int[] suffix = new int[array.length];
	    prefix[0] = 1;
	    for(int i = 1; i < array.length; i++)
	        prefix[i] = prefix[i-1] * array[i-1];

	    suffix[array.length-1] = 1;
	    for(int i = array.length-2; i >= 0; i--)
	        suffix[i] = suffix[i+1] * array[i+1];

	    for(int  i = 0; i < array.length; i++)
	        System.out.print(" " + suffix[i] * prefix[i]);
	}
	
	public static void main(String[] args)
	{
		int[] array = {4,2,3};
		printProducts(array);
	}
}
