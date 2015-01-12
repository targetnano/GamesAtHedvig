package games.core;

import games.utils.Pair;

public class LongestPalindromicSubstring 
{

	private static String longestPalindromicSubstring(String str)
	{
	    int maxStart = 0;
	    int maxEnd = 1;
	    int maxLength = 1;
	    int length = str.length();
	    if(length == 0)
	        return "";

	    for(int i = 0; i < length-1; i++)
	    {
	        Pair<Integer,Integer> pair = expandAroundCenter(str, i, i);
	        if( (pair.v() - pair.k()) > maxLength )
	        {
	            maxStart = pair.k();
	            maxEnd = pair.v();
	            maxLength = maxEnd - maxStart;
	        }

	        pair = expandAroundCenter(str, i, i+1);
	        if( (pair.v() - pair.k()) > maxLength )
	        {
	            maxStart = pair.k();
	            maxEnd = pair.v();
	            maxLength = maxEnd - maxStart;
	        }
	    }
	    return str.substring(maxStart,maxEnd);
	}

	private static Pair<Integer,Integer> expandAroundCenter(String str, int c1, int c2)
	{
	    while(c1 >= 0 && c2 < str.length())
	    {
	        if(str.charAt(c1) == str.charAt(c2))
	        {
	            c1--;
	            c2++;
	        }
	        else
	        	break;
	    }
	    return new Pair<Integer,Integer>(c1+1,c2);
	}
	
	public static void main(String[] args)
	{
		System.out.println(longestPalindromicSubstring("abaxyaabaa"));
	}
}
