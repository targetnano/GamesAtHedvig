package games.core;

import games.utils.ListNode;

public class PartitionList 
{
	private static ListNode partitionList(ListNode head, int x)
	{
	    if(head == null)
	        return head;

	    ListNode lesserHead = null;
	    ListNode lesserTail = null;
	    ListNode greaterHead = null;
	    ListNode greaterTail = null;

	    ListNode it = head;
	    while(it != null)
	    {
	        int val = it.value();
	        if(val < x)
	        {
	            if(lesserHead == null)
	            {
	                lesserHead = it;
	                lesserTail = it;
	            }
	            else
	            {
	                lesserTail.next(it);
	                lesserTail = lesserTail.next();
	            }
	        }
	        else
	        {
	            if(greaterHead == null)
	            {
	                greaterHead = it;
	                greaterTail = it;
	            }
	            else
	            {
	                greaterTail.next(it);
	                greaterTail = greaterTail.next();
	            }
	        }
	        it = it.next();
	    }
	    lesserTail.next(greaterHead);
	    greaterTail.next(null);
	    return lesserHead;
	}
	
	public static void main(String[] args)
	{
		ListNode a = new ListNode(6);
		ListNode b = new ListNode(4);
		ListNode c = new ListNode(3);
		ListNode d = new ListNode(2);
		ListNode e = new ListNode(5);
		ListNode f = new ListNode(2);
		
		a.next(b);
		b.next(c);
		c.next(d);
		d.next(e);
		e.next(f);
		ListNode result = partitionList(a, 3);
		
		while(result != null)
		{
			System.out.print(result.value() + " ");
			result = result.next();
		}
	}
}
