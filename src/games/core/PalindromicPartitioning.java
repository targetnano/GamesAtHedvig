package games.core;

import java.util.ArrayList;

public class PalindromicPartitioning 
{

	private static boolean[][] getPalindromeTable(String str)
	{
	    boolean[][] table = new boolean[str.length()][str.length()];
	    for(int i = 0; i < table.length; i++)
	        table[i][i] = true;
	    
	    for(int i = 0; i < table.length; i++)
	    {
	        for(int j = 0; j < table[0].length; j++)
	        {
	            boolean equal = str.charAt(i) == str.charAt(j);
	            if( i+1 > j-1)
	            {
	                if(equal)
	                    table[i][j] = true;
	            }
	            else if( table[i+1][j-1] && equal)
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

	private static ArrayList<ArrayList<String>> getAllPartitions(String str)
	{
	    ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
	    boolean[][] table = getPalindromeTable(str);
	    getAllPartitions(str, table, 0, result);
	    return result;
	}
	
	public static void main(String[] args)
	{
		ArrayList<ArrayList<String>> result = getAllPartitions("cbaba");
		for(ArrayList<String> list : result)
			System.out.println(list);
	}
}
