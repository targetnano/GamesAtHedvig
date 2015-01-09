package games.core;

import games.utils.NaryTreeNode;

import java.util.ArrayList;
import java.util.List;

public class NaryTreeSerializer 
{
	private static int listIndex = 0;
	
	private static void serialize(List<Integer> list, NaryTreeNode root)
	{
	    if(root == null)
	        return;

	    list.add(root.value());
	    List<NaryTreeNode> children = root.getChildren();
	    list.add(children.size());

	    for(NaryTreeNode child : children)
	        serialize(list, child);
	}
	
	private static NaryTreeNode deserialize(List<Integer> list)
	{
	    if(listIndex == list.size())
	        return null;

	    NaryTreeNode root = new NaryTreeNode(list.get(listIndex++));
	    int numChildren = list.get(listIndex++);

	    for(int i = 0; i < numChildren; i++)
	        root.addChild(deserialize(list));

	    return root;
	}
	
	public static void main(String[] args)
	{
		NaryTreeNode n1 = new NaryTreeNode(1);
		NaryTreeNode n2 = new NaryTreeNode(2);
		NaryTreeNode n3 = new NaryTreeNode(3);
		NaryTreeNode n4 = new NaryTreeNode(4);
		NaryTreeNode n5 = new NaryTreeNode(5);
		
		n1.addChild(n4);
		n1.addChild(n3);
		n1.addChild(n2);
		n3.addChild(n5);

		List<Integer> list = new ArrayList<Integer>();
		serialize(list, n1);
		for(Integer i : list)
			System.out.print(i + " ");
		
		NaryTreeNode n = deserialize(list);
		System.out.println(n);
	}
}
