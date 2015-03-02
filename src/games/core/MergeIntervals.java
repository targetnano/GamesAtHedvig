package games.core;

import games.utils.Interval;
import games.utils.IntervalComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MergeIntervals 
{

	private static List<Interval> mergeIntervals(List<Interval> intervals)
	{
	    if(intervals.size() <= 1)
	        return intervals;
	    Collections.sort(intervals, new IntervalComparator());
	    
	    List<Interval> result = new ArrayList<Interval>();
	    Interval prevInterval = intervals.get(0);
	    for(int i = 1; i < intervals.size(); i++)
	    {
	        Interval curInterval = intervals.get(i);
	        if(curInterval.left() > prevInterval.right())
	        {
	            result.add(prevInterval);
	            prevInterval = curInterval;
	        }
	        else
	            prevInterval = new Interval(prevInterval.left(), Math.max(prevInterval.right(), curInterval.right()));
	    }
	    result.add(prevInterval);
	    return result;
	}
	
	public static void main(String[] args)
	{
		Interval a = new Interval(1,3);
		Interval b = new Interval(2,6);
		Interval c = new Interval(8,10);
		Interval d = new Interval(15,18);

		List<Interval> list = new ArrayList<Interval>();
		list.add(c);
		list.add(a);
		list.add(d);
		list.add(b);
		System.out.println(mergeIntervals(list));
	}
}
