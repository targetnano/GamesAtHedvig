package games.core;

public class Combinations 
{

	private static void combine(int nextIndex, int bufIndex, String str, char[] buffer)
	{
	    if(nextIndex == str.length())
	        return;
	    for(int i = nextIndex; i < str.length(); i++)
	    {
	        buffer[bufIndex] = str.charAt(i);
	        for(int j = 0; j <= bufIndex; j++)
	            System.out.print(buffer[j]);
	        System.out.println("");
	        combine(i+1, bufIndex+1, str, buffer);
	    }
	}
	
	private static void combine(String str)
	{
	    int nextIndex = 0;
	    int bufIndex = 0;
	    char[] buffer = new char[str.length()];
	    combine(nextIndex, bufIndex, str, buffer);
	}
	
	public static void main(String[] args)
	{
		String str = "abc";
		combine(str);
	}
}
