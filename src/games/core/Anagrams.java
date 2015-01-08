package games.core;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Anagrams 
{

	private static void printAnagrams(List<String> input)
	{
	    Map<String, List<String>> map = new HashMap<String, List<String>>();
	    for(String str : input)
	    {
	        char[] chars = str.toCharArray();
	        Arrays.sort(chars);
	        String sortedStr = new String(chars);
	        List<String> anagrams = map.get(sortedStr);
	        if(anagrams == null)
	        {
	            anagrams = new ArrayList<String>();
	            map.put(sortedStr, anagrams);
	        }
	        anagrams.add(str);
	    }

	    for(String sortedStr : map.keySet())
	    {
	        List<String> anagrams = map.get(sortedStr);
	        for(String anagram : anagrams)
	            System.out.print(anagram + " ");
	        System.out.println("");
	    }
	}
	
	public static void main(String[] args)
	{
		List<String> input = new ArrayList<String>();
		input.add("fat");
		input.add("bad");
		input.add("taf");
		input.add("dab");
		printAnagrams(input);
	}
}
