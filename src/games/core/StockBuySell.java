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
	
	/**
	 * http://fenghaolw.blogspot.com/2012/11/best-time-to-buy-and-sell-stock-iii.html?view=sidebar
	 * Similar to trapping rain water
	 * @param prices
	 * @return
	 */
	private static int getProfitFrom2Txns(int[] prices)
	{
	    if(prices == null || prices.length < 2)
	        return 0;
	    
	    int[] leftToRightMax = new int[prices.length];
	    int leftMin = prices[0];
	    for(int i = 1; i < leftToRightMax.length; i++)
	    {
	        leftMin = Math.min(leftMin, prices[i]);
	        leftToRightMax[i] = Math.max(leftToRightMax[i-1], prices[i] - leftMin);
	    }
	    
	    int[] rightToLeftMax = new int[prices.length];
	    int rightMax = prices[prices.length - 1];
	    for(int i = prices.length - 2; i >= 0; i--)
	    {
	        rightMax = Math.max(rightMax, prices[i]);
	        rightToLeftMax[i] = Math.max(rightToLeftMax[i+1], rightMax - prices[i]);
	    }
	    
	    int maxProfit = 0;
	    for(int i = 0; i < prices.length; i++)
	    {
	        maxProfit = Math.max(maxProfit, rightToLeftMax[i]+leftToRightMax[i]);
	    }
	    return maxProfit;
	}
	
	public static void main(String[] args)
	{
		int[] prices = {4,3,1,9,2,11,1,6};
		System.out.println(getProfitFrom2Txns(prices));
	}
}
