package games.core;

import games.utils.TreeNode;

public class BSTToDList 
{

	private static TreeNode bstToDList(TreeNode root)
	{
	    if(root == null)
	        return null;

	    if(root.left() != null)
	    {
	        TreeNode left = bstToDList(root.left());
	        while(left.right() != null)
	            left = left.right();
	        root.left(left);
	        left.right(root);
	    }
	    if(root.right() != null)
	    {
	        TreeNode right = bstToDList(root.right());
	        while(right.left() != null)
	            right = right.left();
	        root.right(right);
	        right.left(root);
	    }
	    return root;
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
		
		TreeNode node = bstToDList(n50);
		System.out.println(node);
	}
}
