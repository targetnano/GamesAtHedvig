package games.core;

import java.util.Stack;

public class NextLargerInArray 
{

	private static void printNextLarger(int[] array)
	{
	    Stack<Integer> stack = new Stack<Integer>();
	    for(int x : array)
	    {
	        if(stack.isEmpty() || stack.peek() >= x)
	            stack.push(x);
	        else
	        {
	            while(!stack.isEmpty() && stack.peek() < x)
	            {
	                System.out.println(stack.pop() + " -> " + x);
	            }
	            stack.push(x);
	        }
	    }
	    while(!stack.isEmpty())
	    {
	        System.out.println(stack.pop() + " -> " + "-1");
	    }
	}
	
	public static void main (String[] args)
	{
		int[] a = {7,4,2,3,5,6};
		printNextLarger(a);
	}
}
