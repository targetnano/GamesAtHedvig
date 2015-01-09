package games.core;

import games.utils.ListNode;
import games.utils.TreeNode;

public class SortedListToBST 
{

	private static ListNode head;
	
	private static TreeNode listToBst(ListNode listNode)
	{
	    int length = listNode.length();
	    head = listNode;
	    return listToBst(0, length-1);
	}

	private static TreeNode listToBst(int start, int end)
	{
	    if(end >= start)
	    {
	        int mid = start + (end - start) / 2;
	        TreeNode left = listToBst(start, mid-1);
	        TreeNode curNode = new TreeNode(head.value());
	        curNode.setLeft(left);
	        head = head.next();
	        TreeNode right = listToBst(mid+1, end);
	        curNode.setRight(right);
	        return curNode;
	    }
	    else
	        return null;
	}
	
	public static void main(String[] args)
	{
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		n1.next(n2);
		n2.next(n3);
		TreeNode root = listToBst(n1);
		TreeNode.printInorder(root);
	}
}
