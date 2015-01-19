package games.core;

import java.util.Stack;

public class LargestRectangleInHistogram 
{

	private static int getLargestArea(int[] hist)
	{
	    int maxArea = 0;
	    int i = 0;
	    Stack<Integer> stack = new Stack<Integer>();

	    while(i < hist.length)
	    {
	        if(stack.isEmpty() || hist[i] >= hist[stack.peek()])
	            stack.push(i++);
	        else
	        {
	            int topIndex = stack.pop();
	            
	            // It should be (i - stack.peek() - 1), and not (topIndex - 1).
	            // This is because in case of ascending histogram, it would calculate only 
	            // the area of two consecutive bars.
	            int area = hist[topIndex] * ( stack.isEmpty() ? i : i - stack.peek() - 1);

	            if(area > maxArea)
	                maxArea = area;
	        }
	    }

	    // It should not be (i < hist.length).
	    // 'i' is already at the end. So don't increment anymore.
	    while(!stack.isEmpty())
	    {
	        int topIndex = stack.pop();
	        int area = hist[topIndex] * ( stack.isEmpty() ? i : i - stack.peek() - 1);
	        maxArea = Math.max(area, maxArea);
	    }

	    return maxArea;
	}
	
	public static void main(String[] args)
	{
		int[] array = {2,1,5,6,2,3};
		System.out.println(getLargestArea(array));
	}
}
