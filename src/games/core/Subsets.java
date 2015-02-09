package games.core;

import java.util.ArrayList;
import java.util.Arrays;

public class Subsets 
{

	/**
	 * Prints without duplicates
	 * @param result
	 * @param current
	 * @param index
	 * @param array
	 */
	private static void getAllSubsets(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> current, int index, int[] array)
	{
	    for(int i = index; i < array.length; i++)
	    {
	    	// Remove this 'if' block if duplicates are needed
	    	if(i > index && array[i] == array[i-1])
	    		continue;
	        ArrayList<Integer> newSubset = new ArrayList<Integer>(current);
	        newSubset.add(array[i]);
	        result.add(newSubset);
	        getAllSubsets(result, newSubset, i+1, array);
	    }
	}

	private static ArrayList<ArrayList<Integer>> getAllSubsets(int[] array)
	{
	    ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
	    getAllSubsets(result, new ArrayList<Integer>(), 0, array);
	    result.add(new ArrayList<Integer>());
	    return result;
	}

	public static void main(String[] args)
	{
	    int[] array = {1,2,2};
	    Arrays.sort(array);
	    ArrayList<ArrayList<Integer>> result = getAllSubsets(array);
	    for(ArrayList<Integer> list : result)
	    {
	        System.out.println(list);
	    }
	}
}
