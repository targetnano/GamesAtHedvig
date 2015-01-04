import java.util.Stack;

/**
 * Evaluate postfix expression
 * 
 * @author Kavi
 *
 */
public class Postfix 
{

	private static int evaluatePostfix(String exp)
	{
	    Stack<Integer> stack = new Stack<Integer>();
	    for(int i = 0 ; i < exp.length(); i++)
	    {
	        Character ch = exp.charAt(i);
	        if(ch >= '0' && ch <= '9')
	        {
	            int operand = Integer.parseInt(ch.toString());
	            stack.push(operand);
	            continue;
	        }
	        else if(ch == '+')
	            stack.push(stack.pop() + stack.pop());
	        else if(ch == '-')
	        {
	            int rhs = stack.pop();
	            int lhs = stack.pop();
	            stack.push(lhs-rhs);
	        }
	        else if(ch == '*')
	            stack.push(stack.pop() * stack.pop());
	        else if(ch == '/')
	        {
	            int rhs = stack.pop();
	            int lhs = stack.pop();
	            stack.push(lhs/rhs);
	        }
	    }
	    return stack.pop();
	}
	
	public static void main(String[] args)
	{
		System.out.println(evaluatePostfix("512+4*+3-"));
	}
}
