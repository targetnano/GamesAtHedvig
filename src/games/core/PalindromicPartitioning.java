package games.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PalindromicPartitioning 
{

	private static boolean[][] getPalindromeTable(String str)
	{
	    boolean[][] table = new boolean[str.length()][str.length()];
	    
	    for(int gap = 0; gap <= str.length()-1; gap++)
	    {
	    	for(int i = 0; i < str.length()-gap; i++)
	    	{
	    		int j = i+gap;
	    		if(gap <= 1)
	    			table[i][j] = str.charAt(i) == str.charAt(j);
	    		else if(str.charAt(i) == str.charAt(j) && table[i+1][j-1])
	    			table[i][j] = true;
	    	}
	    }
	    return table;
	}

	/**
	 * Recursive version
	 * 
	 * @param str
	 * @param table
	 * @param index
	 * @param result
	 */
	private static void getAllPartitions(String str, boolean[][] table, int index, ArrayList<ArrayList<String>> result)
	{
	    if(index >= str.length())
	        result.add(new ArrayList<String>());
	    for(int i = index; i < str.length(); i++)
	    {
	        if(table[index][i])
	        {
	        	ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
	            getAllPartitions(str, table, i+1, res);
	            for(ArrayList<String> partition : res)
	                partition.add(0, str.substring(index, i+1));
	            result.addAll(res);
	        }
	    }
	}

	/**
	 * This one is an optimization to avoid recalculating partitions for 
	 * same substrings
	 * 
	 * @param str
	 * @return
	 */
	private static ArrayList<ArrayList<String>> getAllPartitionsItr(String str)
	{
	    Map<Integer, ArrayList<ArrayList<String>>> map = new HashMap<Integer, ArrayList<ArrayList<String>>>();
	    boolean[][] table = getPalindromeTable(str);
	    
	    for(int i = str.length()-1; i >= 0; i--)
	    {
	        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
	        for(int j = i; j < str.length(); j++)
	        {
	            if(table[i][j])
	            {
	                if(j == str.length()-1)
	                {
	                    ArrayList<String> curPartition = new ArrayList<String>();
	                    curPartition.add(str.substring(i,j+1));
	                    result.add(curPartition);
	                }
	                else
	                {
	                    ArrayList<ArrayList<String>> cachedResult = map.get(j+1);
	                    for(ArrayList<String> list : cachedResult)
	                    {
	                        ArrayList<String> newList = new ArrayList<String>(list);
	                        newList.add(0, str.substring(i,j+1));
	                        result.add(newList);
	                    }
	                }
	            }
	        }
	        map.put(i, result);   
	    }
	    return map.get(0);
	}
	
	private static int getMinCuts(String str)
	{
	    boolean[][] table = getPalindromeTable(str);
	    int[] minCuts = new int[str.length()];
	    
	    for(int i = str.length()-1; i >= 0; i--)
	    {
	        minCuts[i] = str.length() - i -1;
	        for(int j = i; j < str.length(); j++)
	        {
	        	if(table[i][j])
	        	{
	        		if(j == str.length()-1)
	        			minCuts[i] = 0;
	        		else
	        			minCuts[i] = Math.min(minCuts[i], 1+minCuts[j+1]);
	        	}
	        }
	    }
	    return minCuts[0];
	}
	
	private static ArrayList<ArrayList<String>> getAllPartitions(String str)
	{
	    ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
	    boolean[][] table = getPalindromeTable(str);
	    getAllPartitions(str, table, 0, result);
	    return result;
	}
	
	public static void main(String[] args)
	{
		ArrayList<ArrayList<String>> result = getAllPartitionsItr("bobcococ");
		for(ArrayList<String> list : result)
			System.out.println(list);
		//System.out.println(getMinCuts("bobcococ"));
	}
}
