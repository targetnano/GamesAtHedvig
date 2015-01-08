package games.core;
import java.util.ArrayList;
import java.util.List;


public class PrintBrackets 
{
	// open = close = total number of bracket sets need to be printed
	private static void printBrackets(int open, int closed, List<Character> brackets)
	{
		// Base case: If everything has been added, print
	    if(open == 0 && closed == 0)
	    {
	        for(Character ch : brackets)
	            System.out.print(ch);
	        System.out.println("");
	        return;
	    }

	    // Open brackets have no dependency. So print as long as
	    // atleast something is remaining.
	    if(open > 0)
	    {
	        brackets.add('{');
	        printBrackets(open-1, closed, brackets);
	        brackets.remove(brackets.size()-1);
	    }

	    // Close brackets have dependency with open brackets.
	    // So we can print close brackets only if more number
	    // of open brackets are printed than the number of
	    // close brackets that need to be printed.
	    if(closed > open)
	    {
	        brackets.add('}');
	        printBrackets(open, closed-1, brackets);
	        brackets.remove(brackets.size()-1);
	    }

	}
	
	public static void main(String[] args)
	{
		printBrackets(3,3,new ArrayList<Character>());
	}
}
