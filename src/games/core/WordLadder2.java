package games.core;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class WordLadder2 
{

	private static void printPath(String source, String target, Set<String> dict)
	{
	    Stack<String> stack = getPath(source, target, dict);
	    if(stack == null)
	    {
	        System.out.println("Path not found!");
	        return;
	    }   
	    while(!stack.isEmpty())
	    {
	        String str = stack.pop();
	        System.out.print(str);
	        if(!str.equals(target))
	            System.out.print(" => ");
	    }
	}

	private static Stack<String> getPath(String source, String target, Set<String> dictionary)
	{
	    Map<String, String> reverseMap = new HashMap<String, String>();
	    Set<String> visitedSet = new HashSet<String>();
	    Queue<String> bfsQ = new LinkedList<String>();
	    bfsQ.add(source);
	    
	    while(!bfsQ.isEmpty())
	    {
	        String src = bfsQ.remove();
	        if(visitedSet.contains(src))
	        	continue;
	        for(String next : nextLevelWords(src, visitedSet, dictionary))
	        {
	            if(visitedSet.contains(next))
	                continue;
	            
	            if(next.equals(target))
	            {
	                Stack<String> stack = new Stack<String>();
	                stack.push(target);
	                stack.push(src);
	                while(reverseMap.containsKey(src))
	                {
	                    stack.push(reverseMap.get(src));
	                    src = reverseMap.get(src);
	                }
	                return stack;
	            }
	            else
	            {
	                visitedSet.add(src);
	                if(dictionary.contains(next))
	                {
	                	bfsQ.add(next);
	                	reverseMap.put(next, src);
	                }
	            }
	        }
	    }
	    return null;
	}

	private static Set<String> nextLevelWords(String source, Set<String> visitedSet, Set<String> dict)
	{
	    Set<String> nextLevel = new HashSet<String>();
	    for(int i = 0; i < source.length(); i++)
	    {
		    char[] chArray = source.toCharArray();
	        for(char ch = 'a'; ch <= 'z'; ch++)
	        {
	            if(source.charAt(i) == ch)
	                continue;
	            chArray[i] = ch;
	            String str = new String(chArray);
	            if(!visitedSet.contains(str))
	            {
	                nextLevel.add(str);
	            }
	        }
	    }
	    return nextLevel;
	}
	
	public static void main(String[] args)
	{
		Set<String> dict = new HashSet<String>();
		dict.add("dig");
		dict.add("cog");
		dict.add("dot");
		dict.add("cot");
		printPath("dog", "cat", dict);
	}
}
