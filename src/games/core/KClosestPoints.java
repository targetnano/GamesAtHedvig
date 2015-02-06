package games.core;

import games.utils.Point;

import java.util.Random;

public class KClosestPoints 
{
	private static void getKClosestPoints(Point[] points, int k)
	{
		Random r = new Random();
		int lo = 0;
		int hi = points.length-1;

		while(true)
		{
			int randIdx = r.nextInt(hi - lo) + lo;
			int partitionIdx = partition(points, lo, hi, randIdx);
			if(partitionIdx ==  k-1)
			{
				for(int i = 0; i <= k-1; i++)
					System.out.println(points[i].dist());
				return;
			}
			else if(partitionIdx > k-1)
				hi = partitionIdx-1;
			else
				lo = partitionIdx+1;
		}
	}

	private static int partition(Point[] points, int lo, int hi, int pivotIdx)
	{
		int smallIdx = 0;
		Point pivot = points[pivotIdx];
		swap(points, hi, pivotIdx);

		for(int i = lo; i < hi; i++)
		{
			if(points[i].dist() < pivot.dist())
			{
				swap(points, smallIdx, i);
				smallIdx++;
			}
		}
		return smallIdx;
	}

	private static void swap(Point[] points, int idx1, int idx2)
	{
		Point temp = points[idx1];
		points[idx1] = points[idx2];
		points[idx2] = temp;
	}
	
	public static void main(String[] args)
	{
		Point[] points = new Point[10];
		for(int i = 9, j = 0; i >= 0; i--, j++)
		{
			points[j] = new Point(0,0);
			points[j].setDist(i);
		}
		getKClosestPoints(points, 4);
	}
}
