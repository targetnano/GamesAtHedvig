package games.core;
import games.utils.ListNode;
import games.utils.Pair;


public class LinkedListAddition 
{

	/**
	 * Given two numbers represented as linked lists, returns the sum in 
	 * the form of a linked list.
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	private static ListNode addLists(ListNode a, ListNode b)
	{
	    int aLength = a.length();
	    int bLength = b.length();

	    ListNode longer = a;
	    ListNode shorter = b;
	    int diff = Math.abs(aLength - bLength);
	    if(diff != 0)
	    {
	        longer = aLength > bLength ? a : b;
	        shorter = aLength < bLength ? a : b;
	    }
	    Pair<ListNode, Integer> pair = addLists(diff, longer, shorter);
	    ListNode head = pair.k();
	    if(pair.v() > 0)
	    {
	        ListNode node = new ListNode(pair.v());
	        head = node;
	        node.setNext(pair.k());
	    }
	    return head;
	}

	private static Pair<ListNode, Integer> addLists(int diff, ListNode longer, ListNode shorter)
	{
	    Pair<ListNode, Integer> pair = new Pair<ListNode, Integer>(null, 0);
	    if(longer == null && shorter == null)
	        return pair;

	    int sum = 0;
	    if(diff > 0)
	    {
	        pair = addLists(diff-1, longer.next(), shorter);
	        sum = longer.value() + pair.v();
	    }
	    else
	    {
	        pair = addLists(diff, longer.next(), shorter.next());
	        sum = longer.value() + shorter.value() + pair.v();
	    }
	    int digit = sum % 10;
	    int carry = sum / 10;
	    pair.v(carry);
	    ListNode node = new ListNode(digit);
	    node.setNext(pair.k());
	    pair.k(node);
	    return pair;
	}
	
	public static void main(String args[])
	{
		ListNode n1 = new ListNode(9);
		ListNode n2 = new ListNode(9);
		ListNode n3 = new ListNode(8);
		ListNode n4 = new ListNode(8);
		ListNode n5 = new ListNode(3);
		ListNode n6 = new ListNode(5);
		
		n1.setNext(n2);
		n2.setNext(n5);
		n5.setNext(n6);
		n3.setNext(n4);
		ListNode result = addLists(n1, n3);
		
		while(result != null)
		{
			System.out.print(result.value());
			result = result.next();
		}
	}
}
