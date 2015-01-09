package games.utils;

import java.util.ArrayList;
import java.util.List;

public class NaryTreeNode 
{

	private int value_;
	private List<NaryTreeNode> children_ = new ArrayList<NaryTreeNode>();
	
	public NaryTreeNode(int value)
	{
		value_ = value;
	}
	
	public void addChild(NaryTreeNode child)
	{
		children_.add(child);
	}
	
	public List<NaryTreeNode> getChildren()
	{
		return children_;
	}
	
	public int value()
	{
		return value_;
	}
	
	public int numChildren()
	{
		return children_.size();
	}
	
	public String toString()
	{
		return value_ + ":" + children_;
	}
}
