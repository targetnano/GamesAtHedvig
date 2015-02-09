package games.core;

import java.util.Arrays;

public class Candy 
{

	/**
	 * Ref: http://yucoding.blogspot.com/2014/02/leetcode-question-candy.html
	 * 
	 * @param ratings
	 * @return
	 */
	private static int getMinCandies(int[] ratings)
	{
	    int[] leftToRight = new int[ratings.length];
	    int[] rightToLeft = new int[ratings.length];
	    Arrays.fill(leftToRight, 1);
	    Arrays.fill(rightToLeft, 1);
	    
	    for(int i = 1; i < ratings.length; i++)
	    {
	        if(ratings[i] > ratings[i-1])
	            leftToRight[i] = 1 + leftToRight[i-1];
	    }
	    
	    for(int i = ratings.length-2; i >= 0; i--)
	    {
	        if(ratings[i] > ratings[i+1])
	            rightToLeft[i] = 1 + rightToLeft[i+1];
	    }
	    int result = 0;
	    for(int i = 0; i < ratings.length; i++)
	        result += Math.max(leftToRight[i], rightToLeft[i]);
	    
	    return result;
	}
	
	public static void main(String[] args)
	{
		// Ans: 208
		int[] ratings = {58,21,72,77,48,9,38,71,68,77,82,47,25,94,89,54,26,54,54,99,64,71,76,63,81,82,60,64,29,51,87,87,72,12,16,20,21,54,43,41,83,77,41,61,72,82,15,50,36,69,49,53,92,77,16,73,12,28,37,41,79,25,80,3,37,48,23,10,55,19,51,38,96,92,99,68,75,14,18,63,35,19,68,28,49,36,53,61,64,91,2,43,68,34,46,57,82,22,67,89};
		System.out.println(getMinCandies(ratings));
	}
}
