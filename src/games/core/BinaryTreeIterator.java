package games.core;

import java.util.Stack;

import games.utils.TreeNode;

class BinaryTreeIterator
{
    TreeNode current_;
    Stack<TreeNode> stack = new Stack<TreeNode>();
    
    public BinaryTreeIterator(TreeNode source)
    {
        current_ = source;
    }
    
    public boolean hasNext()
    {
        return !stack.isEmpty() || current_ != null;
    }
    
    public TreeNode next()
    {
        TreeNode next = null;
        while(!stack.isEmpty() || current_ != null)
        {
            if(current_ != null)
            {
                stack.push(current_);
                current_ = current_.left();
            }
            else
            {
                next = stack.pop();
                current_ = next.right();
                break;
            }
        }
        return next;
    }
    
    public void remove()
    {
        
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

		BinaryTreeIterator it = new BinaryTreeIterator(n50);
		while(it.hasNext())
		{
			TreeNode node = it.next();
			System.out.println(node.value());
		}
    }
}