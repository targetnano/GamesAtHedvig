package games.core;

import games.utils.Pair;
import games.utils.TreeNode;

public class largestBST 
{
	private static int maxNodes = 0;
	private static TreeNode maxRoot = null;
	
	private static Pair<Integer, TreeNode> getLargestBST(int min, int max, TreeNode root)
	{
	    if(root == null)
	        return null;

	    if(root.value() >= min && root.value() <= max)
	    {
	        Pair<Integer, TreeNode> leftInfo = getLargestBST(min, root.value(), root.left());
	        Pair<Integer, TreeNode> rightInfo = getLargestBST(root.value(), max, root.right());

	        TreeNode parent = new TreeNode(root.value());
	        TreeNode leftChild = leftInfo == null ? null : leftInfo.v();
	        TreeNode rightChild = rightInfo == null ? null : rightInfo.v();
	        parent.left(leftChild);
	        parent.right(rightChild);

	        int numNodes = 1 + (leftInfo == null ? 0 : leftInfo.k()) +
	                        (rightInfo == null ? 0 : rightInfo.k());
	        if(numNodes > maxNodes)
	        {
	            maxNodes = numNodes;   
	            // BUG: Assigned maxRoot = root
	            maxRoot = parent;
	        }
	        
	        // BUG: Returned parent as root
	        return new Pair<Integer, TreeNode>(numNodes, parent);
	    }
	    else
	    {
	    	getLargestBST(Integer.MIN_VALUE, Integer.MAX_VALUE, root);
	        return null;
	    }
	}
	
	public static void main(String[] args)
	{
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(0);
		
		n2.left(n1);
		n2.right(n3);
		Pair<Integer, TreeNode> maxInfo = getLargestBST(Integer.MIN_VALUE, Integer.MAX_VALUE, n2);
		System.out.println(maxInfo.k());
	}
}
