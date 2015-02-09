package games.core;

import games.utils.ListNode;

public class RotateList 
{

	private static ListNode rotateList(ListNode head, int k)
	{
	    int len = 0;
	    ListNode curNode = head;
	    while(curNode != null)
	    {
	        curNode = curNode.next();
	        len++;
	    }
	    
	    if(len == 0 || k == 0 || k%len == 0)
	        return head;
	    
	    ListNode prev = head;
	    curNode = head;
	    int i = len - k;
	    while(true)
	    {
	        i--;
	        if(i == 0)
	            prev = curNode;
	        if(curNode.next() == null)
	        {
	            curNode.next(head);
	            break;
	        }
	        else
	            curNode = curNode.next();
	    }
	    ListNode newHead = prev.next();
	    prev.next(null);
	    return newHead;
	}
	
	public static void main(String[] args)
	{
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(2);
		ListNode c = new ListNode(3);
		ListNode d = new ListNode(4);
		ListNode e = new ListNode(5);
		
		a.next(b);
		b.next(c);
		c.next(d);
		d.next(e);
		ListNode newHead = rotateList(a,4);
		newHead.printList();
	}
}
