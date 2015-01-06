
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
	
	public void setLeft(TreeNode node)
	{
		left_ = node;
	}
	
	public void setRight(TreeNode node)
	{
		right_ = node;
	}
}
