package games.core;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class Infix 
{

	private static int evaluateInfix(String infix)
	{
	    Map<Character, Integer> map = new HashMap<Character, Integer>();
	    map.put('-',1);
	    map.put('+',1);
	    map.put('*',2);
	    map.put('/',2);
	    map.put('^',3);
	    
	    // Operator and operand stack
	    Stack<Integer> operands = new Stack<Integer>();
	    Stack<Character> operators = new Stack<Character>();
	    
	    Scanner scanner = new Scanner(infix);
	    while(scanner.hasNext())
	    {
	    	// Push operands on stack
	        if(scanner.hasNextInt())
	            operands.push(scanner.nextInt());
	        else
	        {
	            char ch = scanner.next().charAt(0);
	            if(operators.isEmpty() || ch == '(')
	                operators.push(ch);
	            
	            else if(ch == ')')
	            {
	                while( !operators.isEmpty() && (ch = operators.pop()) != '(' )
	                {
	                     int op2 = operands.pop();
	                     int op1 = operands.pop();
	                     operands.push(calc(op1, op2, ch));       
	                }
	            }
	            else
	            {
	                int myPriority = map.get(ch);
	                while(!operators.isEmpty())
	                {
	                    if(operators.peek() == '(' || map.get(operators.peek()) < myPriority)
	                        break;
	                     
	                     int op2 = operands.pop();
	                     int op1 = operands.pop();
	                     operands.push(calc(op1, op2, operators.pop()));       
	                }
	                operators.push(ch);
	            }
	        }
	    }
	    // IMPORTANT: Don't forget to replay remaining operators and
	    // operands from two stacks.
	    while(!operators.isEmpty())
	    {
            int op2 = operands.pop();
            int op1 = operands.pop();
            operands.push(calc(op1, op2, operators.pop()));
	    }
	    scanner.close();
	    return operands.pop();
	}

	private static int calc(int op1, int op2, char op)
	{
	    int result = 0;
	    
	    if(op == '+')
	        result = op1+op2;
	    else if(op == '-')
	        result = op1-op2;
	    else if(op == '*')
	        result = op1*op2;
	    else if(op == '/')
	        result = op1/op2;
	    else if(op == '^')
	        result = (int) (Math.pow(op1,op2));
	    return result;
	}
	
	public static void main(String[] args)
	{
		System.out.println(evaluateInfix("11 - 2 * ( 3 + 4 / 3 ) - 1"));
	}
}
