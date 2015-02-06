package games.core;

import java.util.ArrayList;
import java.util.Arrays;

public class ThreeSum 
{
	private static ArrayList<ArrayList<Integer>> getZeroSumTriplets(int[] array)
	{
		Arrays.sort(array);
		ArrayList<ArrayList<Integer>> triplets = new ArrayList<ArrayList<Integer>>();

		for(int i = 0; i < array.length - 2; i++)
		{
			if( i == 0 || array[i] > array[i-1])
			{
				int target = -array[i];
				int left = i+1;
				int right = array.length-1;

				while(left < right)
				{
					int sum = array[left] + array[right];
					if(sum == target)
					{
						ArrayList<Integer> list = new ArrayList<Integer>();
						list.add(array[i]);
						list.add(array[left]);
						list.add(array[right]);

						triplets.add(list);
						left++;
						right--;

						while(left < right && array[right-1] == array[right])
							right--;

						while(left < right && array[left+1] == array[left])
							left++;
					}
					else if(sum > target)
						right--;
					else
						left++;
				}
			}
		}
		return triplets;
	}
	
	public static void main(String[] args)
	{
		int[] a = {-1,0,1,2,-1,-4};
		System.out.println(getZeroSumTriplets(a));
	}
}
