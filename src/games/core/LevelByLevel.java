package games.core;

import java.util.LinkedList;
import java.util.Queue;

import games.utils.TreeNode;

public class LevelByLevel 
{

	private static void levelBylevel(TreeNode root)
	{
	    if(root == null)
	        return;

	    Queue<TreeNode> curLevel = new LinkedList<TreeNode>();
	    Queue<TreeNode> nextLevel = new LinkedList<TreeNode>();

	    curLevel.add(root);

	    while(!curLevel.isEmpty())
	    {
	        TreeNode node = curLevel.remove();
	        System.out.print(node.value() + " ");
	        if(node.left() != null)
	            nextLevel.add(node.left());

	        if(node.right() != null)
	            nextLevel.add(node.right());

	        if(curLevel.isEmpty())
	        {
	            Queue<TreeNode> temp = curLevel;
	            curLevel = nextLevel;
	            nextLevel = temp;
	            System.out.println("");
	        }
	    }
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
		
		levelBylevel(n50);
	}
	
}
