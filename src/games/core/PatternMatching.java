package games.core;

import java.util.HashMap;
import java.util.Map;

public class PatternMatching 
{

	private static boolean matchPattern(String input, String pattern)
	{
	    if(input.length() < pattern.length())
	        return false;
	    return matchPattern(0, input, 0, pattern, new HashMap<Character,String>());
	}

	private static boolean matchPattern(int iIndex, String input, int pIndex, String pattern, Map<Character, String> map)
	{
	    if(iIndex == input.length() && pIndex == pattern.length())
	        return true;
	    
	    if(iIndex == input.length() || pIndex == pattern.length())
	        return false;
	    
	    char ch = pattern.charAt(pIndex);
	    if(map.containsKey(ch))
	    {
	        String codeString = map.get(ch);
	        if( (iIndex + codeString.length()-1) >= input.length() )
	            return false;
	        if(!input.substring(iIndex, iIndex + codeString.length()).equals(codeString))
	            return false;
	        return matchPattern(iIndex+codeString.length(), input, pIndex+1, pattern, map);
	    }
	    else
	    {
	        for(int i = iIndex; i < input.length(); i++)
	        {
	            String codeString = input.substring(iIndex,i+1);
	            map.put(ch, codeString);
	            if(matchPattern(i+1, input, pIndex+1, pattern, map))
	                return true;
	            map.remove(ch);
	        }
	    }
	    return false;
	}
	
	public static void main(String[] args)
	{
		System.out.println(matchPattern("redblueredblue", "abba"));
	}
}
