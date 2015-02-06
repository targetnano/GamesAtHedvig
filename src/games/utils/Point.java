package games.utils;

public class Point implements Comparable<Point>
{

	private int x_;
	private int y_;
	private int dist_;
	
	public Point(int x, int y)
	{
		x_ = x;
		y_ = y;
	}
	
	public int x()
	{
		return x_;
	}
	
	public int y()
	{
		return y_;
	}

	public int dist()
	{
		return dist_;
	}
	
	public void setDist(int dist)
	{
		dist_ = dist;
	}
	
	public int compareTo(Point p) 
	{
		if(p.dist() == dist_)
			return 0;
		else if( dist_ < p.dist())
			return -1;
		else 
			return 1;
	}
}
