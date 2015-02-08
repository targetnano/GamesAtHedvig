package games.core;

/*
 * 
Say you have an array for which the i-th element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like 
(i.e., buy one and sell one share of the stock multiple times). However, you may not engage in multiple 
transactions at the same time (i.e., you must sell the stock before you buy again).

Solution:

The maximum profit is always achieved by buying at the lowest points and selling at the highest points. 
In other words, we will buy the stock before the price increases, and sell the stock before the price decreases. 
This could be easily implemented by traversing the array.
 */
public class StockBuySell 
{

	private static int getProfitMultipleTxns(int[] prices, int start, int end)
	{
	    if(end <= start)
	        return 0;
	    int profit = 0;
	    int buy = -1;
	    int sell = -1;
	    int i = start;
	    for(;i < end; i++)
	    {
	        if(prices[i] < prices[i+1])
	        {
	            buy = prices[i++];
	            break;
	        }    
	    }

	    for(; i <= end; i++)
	    {
	    	// Corner case. Happens when buy-sell txn is last two elements.
	        if(i == end || prices[i] > prices[i+1])
	        {
	            sell = prices[i];
	            break;
	        }
	    }
	    
	    if(buy != -1 && sell != -1)
	    {
	        profit += sell - buy;
	        profit += getProfitMultipleTxns(prices, i+1, prices.length-1);
	    }
	    return profit;
	}
	
	public static void main(String[] args)
	{
		int[] prices = {1,1,1,2,2,2,2,1,1,1,2,2,2};
		System.out.println(getProfitMultipleTxns(prices, 0, prices.length-1));
	}
}
