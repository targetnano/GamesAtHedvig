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
	
	private static boolean isBreakable(String input, Set<String> dict)
	{
	    boolean[] breakable = new boolean[input.length()];
	    if(input.length() == 0)
	        return false;

	    for(int i = 0; i < input.length(); i++)
	    {
	        if( breakable[i] || dict.contains(input.substring(0,i+1)) )
	        {
	            breakable[i] = true;
	            for(int j = i+1; j < input.length(); j++)
	                breakable[j] = breakable[j] || dict.contains(input.substring(i+1, j+1));
	        }
	    }
	    return breakable[input.length()-1];
	}
	
	private static boolean wordBreak2(String str, Set<String> dict)
	{
	    boolean[] breakable = new boolean[str.length()+1];
	    breakable[0] = true;
	    
	    for(int i = 0; i <= str.length(); i++)
	    {
	        if(!breakable[i])
	            continue;
	        
	        for(String dictWord : dict)
	        {
	            int curEnd = i + dictWord.length();
	            if(curEnd > str.length())
	                continue;
	            
	            if(str.substring(i,curEnd).equals(dictWord))
	                breakable[curEnd] = true;
	            if(breakable[str.length()])
	                break;
	        }
	    }
	    return breakable[str.length()];
	}
	public static void main(String args[])
	{
		Set<String> dict = new HashSet<String>();
		dict.add("ab");
		dict.add("c");
		dict.add("d");
		System.out.println(wordBreak2("cdabab", dict));
	}
}
