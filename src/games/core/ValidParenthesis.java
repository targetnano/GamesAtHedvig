package games.core;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParenthesis 
{

	/**
	 * http://www.programcreek.com/2012/12/leetcode-valid-parentheses-java/
	 * 
	 * @param str
	 * @return
	 */
	private static boolean isValidParenthesis(String str)
	{
	    if(str == null || str.length() < 2)
	        return false;
	    
	    Map<Character, Character> map = new HashMap<Character, Character>();
	    map.put('(', ')');
	    map.put('{', '}');
	    map.put('[', ']');
	    Stack<Character> stack = new Stack<Character>();
	    
	    for(int i = 0; i < str.length(); i++)
	    {
	        char ch = str.charAt(i);
	        if(map.containsKey(ch))
	            stack.push(ch);
	        else if(map.values().contains(ch))
	        {
	            if(!stack.isEmpty() && ch == map.get(stack.peek()))
	                stack.pop();
	            else
	                return false;
	        }
	    }
	    return stack.isEmpty();
	}
	
	public static void main(String[] args)
	{
		System.out.println(isValidParenthesis("{]"));
	}
}
