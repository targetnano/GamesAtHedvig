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
	
	public String toString()
	{
		return left_ + "-" + right_;
	}
}
