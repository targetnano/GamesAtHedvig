package games.core;

import games.utils.ListNode;

public class RemoveDuplicatesFromSortedList 
{

	private static ListNode removeDuplicatesFromList(ListNode head)
	{
	    ListNode newHead = null;
	    ListNode newTail = null;
	    
	    while(head != null)
	    {
	        boolean bVal = false;
	        while(head.next() != null && head.next().value() == head.value())
	        {
	            bVal = true;
	            head = head.next();
	        }
	        if(!bVal)
	        {
	            if(newHead == null)
	            {
	                newHead = head;
	                newTail = head;
	            }
	            else
	            {
	              newTail.next(head);
	              newTail = newTail.next();
	            }
	                
	        }
	        head = head.next();
	    }
	    // Need to set this for sure
	    if(newTail != null)
	    	newTail.next(null);
	    return newHead;
	}
	
	public static void main(String[] args)
	{
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(1);
		ListNode node3 = new ListNode(2);
		ListNode node4 = new ListNode(3);
		ListNode node5 = new ListNode(3);

		
		node1.next(node2);
		node2.next(node3);
		node3.next(node4);
		node4.next(node5);
		ListNode result = removeDuplicatesFromList(node1);
		while(result != null)
		{
			System.out.print(result.value());
			result = result.next();
		}
	}
}
