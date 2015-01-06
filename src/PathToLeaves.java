import java.util.ArrayList;
import java.util.List;


public class PathToLeaves 
{

	private static void printPathToLeaves(TreeNode node, List<TreeNode> path)
	{
		if(node == null)
			return;
	    path.add(node);
	    
	    if(node.left() == null && node.right() == null)
	    {
	        for(TreeNode n : path)
	            System.out.print(n.value() + " ");
	        System.out.println("");
	        path.remove(path.size()-1);
	        return;
	    }

	    printPathToLeaves(node.left(), path);
	    printPathToLeaves(node.right(), path);
	    path.remove(path.size()-1);
	}
	
	public static void main(String[] args)
	{
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		
		n2.setLeft(n1);
		n2.setRight(n3);
		printPathToLeaves(n2, new ArrayList<TreeNode>());
	}
}
