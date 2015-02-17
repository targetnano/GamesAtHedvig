package games.core;

import games.utils.TreeNode;

public class KthNodeInBST 
{

	private static TreeNode kthNode(int k, TreeNode root)
	{
	    if(root == null)
	        return null;
	    
	    while(root != null)
	    {
	        int leftCount = (root.left() == null) ? 0 : root.left().count();
	        if(leftCount+1 == k)
	            return root;
	        else if(leftCount+1 > k)
	            root = root.left();
	        else if(leftCount+1 < k)
	        {
	            root = root.right();
	            k -= 1+leftCount;
	        }
	    }
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
		TreeNode n5 = new TreeNode(5,1);
		TreeNode n35 = new TreeNode(35,1);
		TreeNode n30 = new TreeNode(30,3);
		TreeNode n55 = new TreeNode(55,1);
		TreeNode n60 = new TreeNode(60,5);
		TreeNode n70 = new TreeNode(70,3);
		TreeNode n80 = new TreeNode(80,1);
		TreeNode n65 = new TreeNode(65,1);
		TreeNode n50 = new TreeNode(50,9);
		
		n50.left(n30);
		n30.left(n5);
		n30.right(n35);
		n50.right(n60);
		n60.left(n55);
		n60.right(n70);
		n70.left(n65);
		n70.right(n80);
		System.out.println(kthNode(3,n50));
	}
}
