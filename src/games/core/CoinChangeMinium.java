package games.core;

public class CoinChangeMinium {

	private static int minCoinChange(int[] coins, int sum)
	{
	    if(sum == 0)
	        return 0;
	    else if(sum < 0)
	        return Integer.MAX_VALUE - 1;

	    int min = Integer.MAX_VALUE - 1;
	    for(int i = 0; i < coins.length; i++)
	    {
	        int newMin = 1 + minCoinChange(coins, sum - coins[i]);
	        min = Math.min(min, newMin);
	    }
	    return min;
	}
	
	public static void main(String[] args)
	{
		int[] coins = {6,3};
		System.out.println(minCoinChange(coins, 5));
	}
}
