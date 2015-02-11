package games.core;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MinimumWindowSubstring 
{

	private static int minimumWindowSubstring(String pattern, String str)
	{
	    int minLength = Integer.MAX_VALUE;
	    int left = 0, right = 0;
	    Map<Character, Integer> map = new HashMap<Character, Integer>();
	    Set<Character> set = new HashSet<Character>();
	    for(int i = 0; i < pattern.length(); i++)
	        set.add(pattern.charAt(i));

	    while(left < str.length() && right < str.length())
	    {
	        char ch = str.charAt(right);
	        if(set.contains(ch))
	        {
	            int count = map.containsKey(ch) ? map.get(ch) + 1 : 1;
	            map.put(ch, count);

	            if(map.size() == pattern.length())
	            {
	            	minLength = Math.min(minLength, right-left+1);
	                while(left < right)
	                {
	                    ch = str.charAt(left);
	                    Integer remaining = map.get(ch);
	                    if(remaining != null && remaining == 1)
	                    {
	                        map.remove(ch);
	    	            	minLength = Math.min(minLength, right-left+1);
	                        left++;
	                        break;
	                    }
	                    else if(remaining != null)
	                        map.put(ch, remaining-1);
	                    left++;
	                }
	            }
	        }
	        right++;
	    }
	    return minLength == Integer.MAX_VALUE ? Integer.MAX_VALUE : Math.min(minLength, right-left+1);
	}
	
	private static void test()
	{
		assert(minimumWindowSubstring("ab","acvbsshsaf") == 4);
		assert(minimumWindowSubstring("ab","ab") == 2);
		assert(minimumWindowSubstring("a", "a") == 1);
		assert(minimumWindowSubstring("aprlfhlafh","hla") == Integer.MAX_VALUE);
		assert(minimumWindowSubstring("hla", "aprlfhlafh") == 3);
		System.out.println("PASSED!");
	}
	public static void main(String[] args)
	{
		test();
	}
}
