package games.core;

import games.utils.TreeNode;

public class BSTToCircularDList 
{

	private static TreeNode head_;
	private static TreeNode prev_;
	private static TreeNode root_;
	
	private static void bstToCircularDList(TreeNode root)
	{
	    if(root == null)
	        return;

	    bstToCircularDList(root.left());
	    if(prev_ == null)
	        head_ = root;
	    else
	        prev_.right(root);

	    root.left(prev_);
	    head_.left(root);

	    // IMPORTANT: HAVE TO save this right node
	    TreeNode right = root.cloneRight();
	    root.right(head_);
	    prev_ = root;
	    bstToCircularDList(right);
	}

	public static void main(String[] args)
	{
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		
		n2.left(n1);
		n2.right(n3);
		root_ = n2;
		bstToCircularDList(root_);
		System.out.println(n2);
	}
}
