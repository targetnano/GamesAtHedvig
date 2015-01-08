package games.core;
import java.util.HashSet;
import java.util.Set;

/**
 * Word break problem:
 * Given a string of characters without spaces, is there a way to break the string into valid words without leftover characters?
 * @author Kavi
 *
 */
public class WordBreak 
{

	private static String wordBreak(String rest, Set<String> dict)
	{
	    if(dict.contains(rest))
	        return rest;
	    else
	    {
	        for(int i = 0; i < rest.length(); i++)
	        {
	            String prefix = rest.substring(0,i);
	            if(dict.contains(prefix))
	            {
	            	// BUG: Was rest.substring(i+1);
	                String suffix = rest.substring(i);
	                
	                // BUG: Was returning prefix+suffix 
	                // instead of prefix+result
	                String result = wordBreak(suffix, dict);
	                if(result != null)
	                    return prefix + " " + result;
	            }
	        }
	    }
	    return null;
	}
	
	public static void main(String args[])
	{
		Set<String> dict = new HashSet<String>();
		dict.add("ab");
		dict.add("c");
		dict.add("d");
		System.out.println(wordBreak("cdab", dict));
	}
}
