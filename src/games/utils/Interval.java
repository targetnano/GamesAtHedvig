package games.utils;

public class Interval 
{

	private int left_;
	private int right_;
	
	public Interval(int left, int right)
	{
		left_ = left;
		right_ = right;
	}
	
	public int left()
	{
		return left_;
	}
	
	public int right()
	{
		return right_;
	}
	
	public int compare(Interval interval)
	{
		int val = 0;
		if(left_ < interval.left())
			val = -1;
		else if(left_ > interval.left())
			val = 1;
		return val;
	}
	
	public String toString()
	{
		return left_ + "-" + right_;
	}
}
