package games.core;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings 
{

	private static boolean isIsoMorphic(String s1, String s2)
	{
	    if(s1 == null && s2 == null)
	        return true;

	    if(s1 == null || s2 == null)
	        return false;

	    if(s1.length() != s2.length())
	        return false;

	    Map<Character, Character> map1 = new HashMap<Character, Character>();
	    Map<Character, Character> map2 = new HashMap<Character, Character>();

	    for(int i = 0; i < s1.length(); i++)
	    {
	        char ch1 = s1.charAt(i);
	        char ch2 = s2.charAt(i);

	        if(map1.containsKey(ch1))
	        {
	        	if(map1.get(ch1) != ch2)
	        		return false;
	        }
	        else if(map2.containsKey(ch2))
	            return false;
	        else
	        {
	            map1.put(ch1,ch2);
	            map2.put(ch2,ch1);
	        }
	    }
	    return true;
	}
	
	public static void main(String[] args)
	{
		System.out.println(isIsoMorphic("constipation", "dpotueqbuepo"));
	}
}
