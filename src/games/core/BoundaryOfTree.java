package games.core;

import games.utils.TreeNode;

public class BoundaryOfTree 
{

	private static void printLeftBoundary(TreeNode root, boolean isBoundary)
	{
	    if(root == null)
	        return;

	    if(root.left() == null && root.right() == null)
	    {
	        System.out.print(root.value()+ " ");
	        return;
	    }

	    if(isBoundary)
	        System.out.print(root.value()+ " ");
	    printLeftBoundary(root.left(), isBoundary);
	    printLeftBoundary(root.right(), isBoundary && root.left() == null);
	}

	private static void printRightBoundary(TreeNode root, boolean isBoundary)
	{
	    if(root == null)
	        return;

	    if(root.left() == null && root.right() == null)
	    {
	        System.out.print(root.value()+ " ");
	        return;
	    }

	    printRightBoundary(root.left(), isBoundary && root.right() == null);
	    printRightBoundary(root.right(), isBoundary);
	    if(isBoundary)
	        System.out.print(root.value()+ " ");
	}

	private static void printBoundary(TreeNode root)
	{
	    if(root == null)
	        return;
	    System.out.print(root.value() + " ");
	    printLeftBoundary(root.left(), true);
	    printRightBoundary(root.right(), true);
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
		
		printBoundary(n50);
	}
}
