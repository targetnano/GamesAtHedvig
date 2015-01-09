package games.utils;

public class ListNode 
{

	private int val_;
	private ListNode next_;
	
	public ListNode(int val)
	{
		val_ = val;
	}
	
	public int value()
	{
		return val_;
	}
	
	public ListNode next()
	{
		return next_;
	}
	
	public void next(ListNode next)
	{
		next_ = next;
	}
	
	public int length()
	{
		int length = 0;
		ListNode temp = this;
		while(temp != null)
		{
			temp = temp.next();
			length++;
		}
		return length;
	}
	
	public String toString()
	{
		return Integer.toString(val_);
	}
}
