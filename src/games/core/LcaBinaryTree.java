package games.core;

import games.utils.TreeNode;

public class LcaBinaryTree 
{

	private static TreeNode lca(TreeNode root, TreeNode n1, TreeNode n2)
	{
	    if(root == null)
	        return null;

	    if(root.equals(n1) || root.equals(n2))
	        return root;

	    TreeNode left = lca(root.left(), n1, n2);
	    TreeNode right = lca(root.right(), n1, n2);

	    if(left == null && right != null)
	        return right;
	    else if(left != null && right == null)
	        return left;
	    else if(left != null && right != null)
	        return root;
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
		
		TreeNode lca = lca(n50, n60, n80);
		System.out.println(lca.value());
	}

}
