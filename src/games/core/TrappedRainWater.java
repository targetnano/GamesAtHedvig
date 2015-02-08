package games.core;

/**
 * http://fenghaolw.blogspot.com/2012/11/trapping-rain-water.html?view=sidebar
 * @author Kavi
 *
 */
public class TrappedRainWater 
{

	private static int trappdRainWaterArea(int[] heights)
	{
	    int totalArea = 0;
	  
	    int[] leftToRightMax = new int[heights.length];
	    leftToRightMax[0] = heights[0];
	    for(int i = 1; i < leftToRightMax.length; i++)
	        leftToRightMax[i] = Math.max(heights[i], leftToRightMax[i-1]);
	    
	    int[] rightToLeftMax = new int[heights.length];
	    rightToLeftMax[heights.length-1] = heights[heights.length-1];
	    for(int i = rightToLeftMax.length-2; i >= 0; i--)
	        rightToLeftMax[i] = Math.max(heights[i], rightToLeftMax[i+1]);
	    
	    int[] waterLevels = new int[heights.length];
	    for(int i = 0; i < waterLevels.length; i++)
	    {
	        waterLevels[i] = Math.min(rightToLeftMax[i], leftToRightMax[i]);
	        waterLevels[i] = waterLevels[i] - heights[i];
	        totalArea += waterLevels[i];
	    }	    
	    return totalArea;
	}
	
	public static void main(String[] args)
	{
		// Ans: 6
		int[] heights = {0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.println(trappdRainWaterArea(heights));
	}
}
