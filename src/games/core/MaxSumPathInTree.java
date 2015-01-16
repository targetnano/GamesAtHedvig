package games.core;

import games.utils.TreeNode;

public class MaxSumPathInTree 
{

	private static int totalMax = Integer.MIN_VALUE;
	
	private static int maxSumPath(TreeNode root)
	{
	    if(root == null)
	        return 0;

	    int leftSum = maxSumPath(root.left());
	    int rightSum = maxSumPath(root.right());

	    // This is the max for the path that passes through this subtree
	    int maxToPassUp = Math.max(root.value(), Math.max(leftSum, rightSum) + root.value());
	    
	    // This is the max at each subtree
	    int maxDown = Math.max(Math.max(maxToPassUp, leftSum+rightSum+root.value()), root.value());
	    if(maxDown > totalMax)
	        totalMax = maxDown;
	    return maxToPassUp;
	}
	
	private static int maxSumPathBetweenLeaves(TreeNode root)
	{
	    if(root == null)
	        return 0;

	    int leftSum = maxSumPathBetweenLeaves(root.left());
	    int rightSum = maxSumPathBetweenLeaves(root.right());

	    int maxInSubTree = leftSum + rightSum + root.value();
	    if(maxInSubTree > totalMax)
	        totalMax = maxInSubTree;

	    int maxToPassUp = Math.max(leftSum, rightSum) + root.value();
	    return maxToPassUp;
	}
	
	public static void main(String[] args)
	{
		/**
		 *        50
     			/    \
 			 30       1
 			/  \     /  \ 
			-5  -44  55  -70
              			/  \
            		   -3   -80
		 */
		TreeNode n5 = new TreeNode(-5);
		TreeNode n35 = new TreeNode(-44);
		TreeNode n30 = new TreeNode(30);
		TreeNode n55 = new TreeNode(55);
		TreeNode n60 = new TreeNode(1);
		TreeNode n70 = new TreeNode(-70);
		TreeNode n80 = new TreeNode(-80);
		TreeNode n65 = new TreeNode(-3);
		TreeNode n50 = new TreeNode(50);
		
		n50.left(n30);
		n30.left(n5);
		n30.right(n35);
		n50.right(n60);
		n60.left(n55);
		n60.right(n70);
		n70.left(n65);
		n70.right(n80);

		maxSumPathBetweenLeaves(n50);
		System.out.println(totalMax);
	}
}
