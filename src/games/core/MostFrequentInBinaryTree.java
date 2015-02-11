package games.core;

import games.utils.Pair;
import games.utils.TreeNode;

public class MostFrequentInBinaryTree 
{

	private static TreeNode getMostFrequent(TreeNode root)
	{
	    if(root == null) return null;
	    Pair<TreeNode, Integer> pair = new Pair<TreeNode, Integer>(null, 0);
	    inOrderWalk(0,null,root,pair);
	    return pair.k();
	}

	private static void inOrderWalk(int freq, TreeNode prev, TreeNode root, Pair<TreeNode,Integer> pair)
	{
	    if(root.left() != null)
	    	inOrderWalk(freq, prev, root.left(), pair);

	    if(prev == null)
	    {
	        freq++;
	        pair.k(root);
	        pair.v(freq);
	    }
	    
	    else if(prev.value() != root.value())
	    {
	        if(pair.v() < freq)
	        {
	            pair.v(freq);
	            pair.k(root);
	        }
	        freq = 1;
	    }
	    if(root.right() != null)
	    	inOrderWalk(freq, root, root.right(), pair);
	}
	
	public static void main(String[] args)
	{
		TreeNode a = new TreeNode(6);
		TreeNode b = new TreeNode(6);
		TreeNode c = new TreeNode(5);
		TreeNode d = new TreeNode(7);
		TreeNode e = new TreeNode(4);
		
		a.left(c);
		c.left(e);
		c.right(b);
		a.right(d);
		//d.left(b);
		
		System.out.println(getMostFrequent(a).value());
	}
}
