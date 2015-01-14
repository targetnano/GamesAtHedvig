package games.core;

import games.utils.Interval;

import java.util.ArrayList;
import java.util.List;

public class MergeIntervals 
{

	private static List<Interval> mergeIntervals(List<Interval> intervals)
	{
	    if(intervals.size() <= 1)
	        return intervals;

	    List<Interval> result = new ArrayList<Interval>();
	    Interval curInterval = intervals.get(0);
	    for(int i = 1; i < intervals.size(); i++)
	    {
	        Interval interval = intervals.get(i);
	        if(interval.left() > curInterval.right())
	        {
	            result.add(curInterval);
	            curInterval = interval;
	        }
	        else
	            curInterval = new Interval(curInterval.left(), Math.max(curInterval.right(), interval.right()));
	    }
	    result.add(curInterval);
	    return result;
	}
	
	public static void main(String[] args)
	{
		Interval a = new Interval(1,3);
		Interval b = new Interval(2,6);
		Interval c = new Interval(8,10);
		Interval d = new Interval(15,18);

		List<Interval> list = new ArrayList<Interval>();
		list.add(a);
		list.add(b);
		list.add(c);
		list.add(d);
		System.out.println(mergeIntervals(list));
	}
}
