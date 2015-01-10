package games.utils;

public class TreeNode 
{
	
	private int val_;
	private TreeNode right_;
	private TreeNode left_;
	
	public TreeNode(int val)
	{
		val_ = val;
	}
	
	public int value()
	{
		return val_;
	}
	
	public TreeNode left()
	{
		return left_;
	}
	
	public TreeNode right()
	{
		return right_;
	}
	
	public TreeNode cloneRight()
	{
		if(right_ == null)
			return null;
		else
			return new TreeNode(right_.val_);
	}
	
	public void left(TreeNode node)
	{
		left_ = node;
	}
	
	public void right(TreeNode node)
	{
		right_ = node;
	}
	
	public static void printInorder(TreeNode node)
	{
		if(node == null)
			return;
		printInorder(node.left());
		System.out.println(node.value());
		printInorder(node.right());
	}
	
	public String toString()
	{
		return Integer.toString(val_);
	}
	
	public boolean equals(TreeNode n)
	{
		return val_ == n.value();
	}
}
