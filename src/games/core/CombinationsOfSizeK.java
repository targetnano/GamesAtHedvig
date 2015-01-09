package games.core;

public class CombinationsOfSizeK 
{

	private static void combineK(int k, String str)
	{
	    int nextIndex = 0;
	    int bufIndex = 0;
	    char[] buffer = new char[k];
	    combineK(nextIndex, bufIndex, buffer, str);
	}

	private static void combineK(int nextIndex, int bufIndex, char[] buffer, String str)
	{
	    if(bufIndex == buffer.length)
	    {
	        System.out.println(new String(buffer));
	        return;
	    }

	    for(int i = nextIndex; i < str.length(); i++)
	    {
	        buffer[bufIndex] = str.charAt(i);
	        combineK(i+1, bufIndex+1, buffer, str);
	    }
	}
	
	public static void main(String[] args)
	{
		combineK(3,"abcd");
	}
}
