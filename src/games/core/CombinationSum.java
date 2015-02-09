package games.core;

import java.util.ArrayList;
import java.util.Arrays;

public class CombinationSum 
{

	/**
	 * Ref: http://n00tc0d3r.blogspot.com/2013/01/combination-sum.html
	 * Returns all unique subsets.
	 * Note: Every element must be used only once.
	 * @param index
	 * @param target
	 * @param array
	 * @param curList
	 * @param result
	 */
	private static void combinationSum(int index, int target, int[] array, ArrayList<Integer> curList, ArrayList<ArrayList<Integer>> result)
	{
	    if(target == 0)
	    {
	        result.add(new ArrayList<Integer>(curList));
	        return;
	    }
	    for(int i = index; i < array.length; i++)
	    {
	    	// This is to avoid duplicates
	    	if( i > index && array[i] == array[i-1]) continue;
	    	
	         if(target - array[i] >= 0)
	         {
	             curList.add(array[i]);
	             combinationSum(i+1, target-array[i], array, curList, result);
	             curList.remove(curList.size()-1);
	         }   
	    }
	}

	/**
	 * Same as above but here, we can use same number
	 * unlimited no. of times
	 * 
	 * @param index
	 * @param target
	 * @param array
	 * @param curList
	 * @param result
	 */
	private static void combinationSum2(int index, int target, int[] array, ArrayList<Integer> curList, ArrayList<ArrayList<Integer>> result)
	{
	    if(target == 0)
	    {
	        result.add(new ArrayList<Integer>(curList));
	        return;
	    }
	    for(int i = index; i < array.length; i++)
	    {
	    	// This is to avoid duplicates
	    	if( i > index && array[i] == array[i-1]) continue;
	    	
	         if(target - array[i] >= 0)
	         {
	             curList.add(array[i]);
	             combinationSum2(i, target-array[i], array, curList, result);
	             curList.remove(curList.size()-1);
	         }   
	    }
	}

	private static ArrayList<ArrayList<Integer>> combinationSum(int[] array, int target)
	{
	    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
	    combinationSum2(0, target, array, new ArrayList<Integer>(), result);
	    return result;
	}

	public static void main(String[] args)
	{
	    int[] array = {2,1,5};
	    Arrays.sort(array);
	    int target = 8;
	    ArrayList<ArrayList<Integer>> result = combinationSum(array, target);
	    for(ArrayList<Integer> list : result)
	        System.out.println(list);
	}
}
