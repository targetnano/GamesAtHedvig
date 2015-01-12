package games.core;

import java.util.HashMap;
import java.util.Map;

import games.utils.GraphNode;

public class CloneGraph 
{

	private static GraphNode<Integer> cloneGraph(GraphNode<Integer> graphNode)
	{
	    Map<GraphNode<Integer>,GraphNode<Integer>> copyMap = new HashMap<GraphNode<Integer>,GraphNode<Integer>>();
	    return clone(graphNode, copyMap);
	}

	private static GraphNode<Integer> clone(GraphNode<Integer> graphNode, Map<GraphNode<Integer>,GraphNode<Integer>> copyMap)
	{
	    if(graphNode == null)
	        return null;

	    if(copyMap.containsKey(graphNode))
	        return copyMap.get(graphNode);

	    GraphNode<Integer> clone = new GraphNode<Integer>(graphNode.getValue());
	    copyMap.put(graphNode, clone);

	    for(GraphNode<Integer> neighbor : graphNode.neighbors())
	    {
	        clone.addNeighbor(clone(neighbor, copyMap));
	    }
	    return clone;
	}
	
	public static void main(String[] args)
	{
		GraphNode<Integer> n1 = new GraphNode<Integer>(1);
		GraphNode<Integer> n2 = new GraphNode<Integer>(2);
		GraphNode<Integer> n3 = new GraphNode<Integer>(3);
		GraphNode<Integer> n4 = new GraphNode<Integer>(4);

		n1.addNeighbor(n2);
		n2.addNeighbor(n1);
		n2.addNeighbor(n3);
		n3.addNeighbor(n2);
		n3.addNeighbor(n4);
		n4.addNeighbor(n3);
		n1.addNeighbor(n4);
		n4.addNeighbor(n1);
		GraphNode<Integer> clone = cloneGraph(n1);
		System.out.println(clone);
	}
}
