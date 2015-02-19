package games.core;

import games.utils.Pair;
import games.utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class MaxDepthInBST 
{

	private static int maxDepthInBST(TreeNode root) 
	{
	    if(root == null) return 0;
	    
	    Queue<Pair<TreeNode,Integer>> q = new LinkedList<Pair<TreeNode,Integer>>();
	    q.add(new Pair<TreeNode,Integer>(root,0));
	    int maxDepth = 0;
	    while(!q.isEmpty())
	    {
	        Pair<TreeNode, Integer> pair = q.remove();
	        TreeNode node = pair.k();
	        int curDepth = pair.v();
	        
	        maxDepth = Math.max(maxDepth, curDepth);
	        if(node.left() != null)
	            q.add(new Pair<TreeNode,Integer>(node.left(),curDepth+1));
	        if(node.right() != null)
	            q.add(new Pair<TreeNode,Integer>(node.right(),curDepth+1));
	    }
	    return maxDepth;
	}
	
	public static void main(String[] args)
	{
		/**
		 *        50
     			/    \
 			 30       60
 			   \     /  \ 
			    35  55  70
              			/  \
            		   65   80
		 */
		TreeNode n35 = new TreeNode(35);
		TreeNode n30 = new TreeNode(30);
		TreeNode n55 = new TreeNode(55);
		TreeNode n60 = new TreeNode(60);
		TreeNode n70 = new TreeNode(70);
		TreeNode n80 = new TreeNode(80);
		TreeNode n65 = new TreeNode(65);
		TreeNode n50 = new TreeNode(50);
		
		n50.left(n30);
		n30.right(n35);
		n50.right(n60);
		n60.left(n55);
		n60.right(n70);
		n70.left(n65);
		n70.right(n80);
		
		System.out.println(maxDepthInBST(n50));
	}
}
