package games.core;

import games.utils.TreeNode;

public class LargestBSTSubTree 
{

	private static int maxNodes = 0;
	private static TreeNode maxRoot = null;
	
	private static class SubTreeInfo
	{
		int nodeCount_;
		int min_;
		int max_;
		
		SubTreeInfo(int nodeCount, int min, int max)
		{
			nodeCount_ = nodeCount;
			min_ = min;
			max_ = max;
		}
		
		public int nodeCount()
		{
			return nodeCount_;
		}
		
		public int min()
		{
			return min_;
		}
		
		public int max()
		{
			return max_;
		}
	}
	
	private static SubTreeInfo largestBSTSubtree(TreeNode node)
	{
	    if(node == null)
	        return new SubTreeInfo(0, Integer.MAX_VALUE, Integer.MIN_VALUE);

	    SubTreeInfo leftInfo = largestBSTSubtree(node.left());
	    SubTreeInfo rightInfo = largestBSTSubtree(node.right());

	    if(leftInfo == null || rightInfo == null)
	        return null;

	    int val = node.value();
	    if(val >= leftInfo.max() && val <= rightInfo.min())
	    {
	        int numNodes = leftInfo.nodeCount() + rightInfo.nodeCount() + 1;
	        int newMin = Math.min(val, leftInfo.min());
	        int newMax = Math.max(val, rightInfo.max());
	        if(numNodes > maxNodes)
	        {
	            maxNodes = numNodes;
	            maxRoot = node;
	        }
	        return new SubTreeInfo(numNodes, newMin, newMax);
	    }
	    else
	        return null;
	}
	
	public static void main(String[] args)
	{
		/**
		 *        50
     			/    \
 			 30       60
 			/  \     /  \ 
			5   20  45  70
              			/  \
            		   65   80

		 */
		TreeNode n5 = new TreeNode(5);
		TreeNode n20 = new TreeNode(20);
		TreeNode n30 = new TreeNode(30);
		TreeNode n45 = new TreeNode(45);
		TreeNode n60 = new TreeNode(60);
		TreeNode n70 = new TreeNode(70);
		TreeNode n80 = new TreeNode(80);
		TreeNode n65 = new TreeNode(65);
		TreeNode n50 = new TreeNode(50);
		
		n50.left(n30);
		n30.left(n5);
		n30.right(n20);
		n50.right(n60);
		n60.left(n45);
		n60.right(n70);
		n70.left(n65);
		n70.right(n80);
		
		SubTreeInfo info = largestBSTSubtree(n50);
		System.out.println(maxRoot.value());
	}
}
