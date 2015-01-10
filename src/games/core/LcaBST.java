package games.core;

import games.utils.TreeNode;

public class LcaBST 
{

	private static TreeNode lca(TreeNode root, TreeNode n1, TreeNode n2)
	{
	    if(root == null)
	        return null;

	    if(n1.value() > n2.value())
	        return lca(root, n2, n1);

	    if( root.value() >= n1.value() && root.value() <= n2.value())
	        return root;

	    else if(root.value() < n1.value())
	        return lca(root.right(), n1, n2);

	    else if(root.value() > n2.value())
	        return lca(root.left(), n1, n2);

	    return null;
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
		
		TreeNode lca = lca(n50, n70, n60);
		System.out.println(lca.value());

	}
}
