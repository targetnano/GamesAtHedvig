package games.core;

import games.utils.Pair;
import games.utils.TreeNode;

public class DeepestNode 
{

	private static TreeNode findDeepest(TreeNode root)
	{
	    if(root == null) return null;
	    Pair<TreeNode, Integer> pair = new Pair<TreeNode, Integer>(null, 0);
	    findDeepest(0,root,pair);
	    return pair.k();
	}

	private static void findDeepest(int curDepth, TreeNode root, Pair<TreeNode,Integer> pair)
	{
	    if(root == null)
	        return;
	    
	    findDeepest(curDepth+1, root.left(), pair);
	    if(curDepth >= pair.v())
	    {
	        pair.k(root);
	        pair.v(curDepth);
	    }
	    findDeepest(curDepth+1, root.right(), pair);
	}
	
	public static void main(String[] args)
	{
		TreeNode a = new TreeNode(6);
		TreeNode b = new TreeNode(6);
		TreeNode c = new TreeNode(5);
		TreeNode d = new TreeNode(7);
		TreeNode e = new TreeNode(4);
		
		a.left(c);
		c.left(e);
		c.right(b);
		a.right(d);
		d.left(b);
		
		System.out.println(findDeepest(a).value());
	}
}
