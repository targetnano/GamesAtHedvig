package games.core;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class WordLadder 
{

	private static int wordLadder(String src, String dest, Set<String> dict)
	{
	    if(src.equals(dest))
	        return 0;

	    Queue<Integer> lengthQ = new LinkedList<Integer>();
	    Queue<String> wordQ = new LinkedList<String>();

	    wordQ.add(src);
	    lengthQ.add(0);

	    while(!wordQ.isEmpty())
	    {
	        String word = wordQ.remove();
	        int distance = lengthQ.remove();

	        // Make this word visited by removing
	        if(dict.contains(word))
	            dict.remove(word);
	        for(int i = 0; i < word.length(); i++)
	        {
		        char[] chars = word.toCharArray();
	            for(char ch = 'a'; ch < 'z'; ch++)
	            {
	                chars[i] = ch;
	                String neighbor = new String(chars);
	                if(neighbor.equals(dest))
	                    return distance + 1;
	                else if(dict.contains(neighbor))
	                {
	                    wordQ.add(neighbor);
	                    lengthQ.add(distance+1);
	                }
	            }
	        }
	    }
	    return -1;
	}
	
	public static void main(String[] args)
	{
		Set<String> dict = new HashSet<String>();
		dict.add("dog");
		dict.add("dot");
		dict.add("lot");
		dict.add("log");
		dict.add("hot");
		
		System.out.println(wordLadder("hit", "pot", dict));
	}
}
