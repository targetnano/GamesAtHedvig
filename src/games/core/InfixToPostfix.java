package games.core;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;


public class InfixToPostfix {

	private static Map<Character, Integer> precedence_ = new HashMap<Character, Integer>();
	
	private static void setPrecedence()
	{
		precedence_.put('*', 10);
		precedence_.put('/', 10);
		precedence_.put('+', 5);
		precedence_.put('-', 5);
	}
	
	private static int precedence(char ch)
	{
		return precedence_.get(ch);
	}
	
	private static String infixToPostfix(String infix)
	{
	    if(infix == null)
	        return null;

	    StringBuilder postFix = new StringBuilder();
	    Stack<Character> opStack = new Stack<Character>();
	    for(int i = 0; i < infix.length(); i++)
	    {
	        Character ch = infix.charAt(i);
	        
	        // If we read an operand, add it to the output stream
	        if(ch >= '0' && ch <= '9')
	        	postFix.append(ch);

	        // If open brace is encountered, push on to op stack
	        else if(ch == '(')
	            opStack.push(ch);

	        // If close brace is read, pop stack until we see open brace
	        else if(ch == ')')
	        {
	            while( (ch = opStack.pop()) != '(')
	            	postFix.append(ch);
	        }
	        // Do it if this is an operator
	        else
	        {
	            if(opStack.isEmpty())
	                opStack.push(ch);
	            else
	            {
	                char top = opStack.peek();
	                
	                // BUG: Missed to check if the stack top is opening brace
	                // If the operator has more precedence than the top,
	                // push it on to the stack
	                if(top != '(' && precedence(ch) > precedence(top))
	                    opStack.push(ch);
	                
	                // Or, keep popping and add to the output until
	                // we hit an operator with "strictly less" precedence.
	                else
	                {
	                    while(!opStack.isEmpty())
	                    {
	                        top = opStack.peek();
	                        if(top == '(')
	                            break;
	                        if(precedence(top) >= precedence(ch))
	                            postFix.append(opStack.pop());
	                    }
	                    opStack.push(ch);
	                }
	            }
	        }
	    }
	    
	    // BUG: Missed this
	    while(!opStack.isEmpty())
	    	postFix.append(opStack.pop());

	    return postFix.toString();
	}
	
	public static void main(String args[])
	{
		setPrecedence();
		System.out.println(infixToPostfix("(4+8)*(6-5)/((3-2)*(2+2))"));
	}
}
