package games.core;

import games.utils.TreeNode;

public class MinimumTreeDepth 
{

	static int minDepth = Integer.MAX_VALUE;
	
	private static void getMinDepth(TreeNode root, int depth)
	{
	    if(root == null)
	        return;

	    if(depth >= minDepth)
	        return;

	    if(root.left() == null && root.right() == null)
	    {
	        minDepth = Math.min(minDepth, depth);
	        return;
	    }
	    getMinDepth(root.left(), depth+1);
	    getMinDepth(root.right(), depth+1);
	}
	
	public static void main(String[] args)
	{
		/**
		 *        50
     			/    \
 			 30       60
 			/  \     /  \ 
			5   35  55  70
              			/  \
            		   65   80
		 */
		TreeNode n5 = new TreeNode(5);
		TreeNode n35 = new TreeNode(35);
		TreeNode n30 = new TreeNode(30);
		TreeNode n55 = new TreeNode(55);
		TreeNode n60 = new TreeNode(60);
		TreeNode n70 = new TreeNode(70);
		TreeNode n80 = new TreeNode(80);
		TreeNode n65 = new TreeNode(65);
		TreeNode n50 = new TreeNode(50);
		
		n50.left(n30);
		n30.left(n5);
		n30.right(n35);
		n50.right(n60);
		n60.left(n55);
		n60.right(n70);
		n70.left(n65);
		n70.right(n80);
		
		getMinDepth(n50, 0);
		System.out.println(minDepth);
	}
}
