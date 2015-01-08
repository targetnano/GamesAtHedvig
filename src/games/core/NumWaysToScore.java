package games.core;
/**
 * Given a set of scores and a final score, it finds
 * the number of ways the team could get to that score.
 * 
 * @author Kavi
 */
public class NumWaysToScore {

	private static int numWaysToScore(int[] scores, int targetScore)
	{
	    int[] numWays = new int[targetScore+1];
	    numWays[0] = 1;
	    for(int score : scores)
	    {
	        for(int i = score; i <= targetScore; i++)
	        {
	            numWays[i] += numWays[i-score];
	        }
	    }
	    return numWays[targetScore];
	}
	
	public static void main(String[] args)
	{
		int[] scores = {2,3,7};
		System.out.println(numWaysToScore(scores, 8));
	}
}
