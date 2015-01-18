package games.core;

public class CountAndSay 
{

	private static String countAndSay(int n)
	{
	    StringBuilder sb = new StringBuilder("1");

	    for(int i = 1; i < n; i++)
	    {
	        StringBuilder next = new StringBuilder();
	        int count = 1;
	        int j = 1;
	        for(; j < sb.length(); j++)
	        {
	            if(sb.charAt(j-1) == sb.charAt(j))
	                count++;
	            else
	            {
	                next.append(count);
	                next.append(sb.charAt(j-1));
	                count = 1;
	            }
	        }
	        next.append(count);
	        next.append(sb.charAt(j-1));
	        sb = next;
	    }
	    return sb.toString();
	}
	
	public static void main(String[] args)
	{
		System.out.println(countAndSay(5));
	}
}
