package games.core;
import games.utils.GraphNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BipartiteGraph 
{
	// Checks if the given graph is bipartite
	private static boolean isBipartite(GraphNode<Integer> node)
	{
	    if(node == null)
	        return false;
	    Queue<GraphNode<Integer>> queue = new LinkedList<GraphNode<Integer>>();
	    node.setColor(GraphNode.color.RED);
	    queue.offer(node);
	    while(!queue.isEmpty())
	    {
	        GraphNode<Integer> n = queue.remove();
	        GraphNode.color myColor = n.color();
	        GraphNode.color neighborColor = (myColor == GraphNode.color.RED) ? GraphNode.color.BLUE: GraphNode.color.RED;
	        List<GraphNode<Integer>> list = n.neighbors();
	        for(GraphNode<Integer> neighbor : list)
	        {
	            if(neighbor.color().equals(myColor))
	                return false;

	            else if(!neighbor.isColored())
	            {
	                neighbor.setColor(neighborColor);
	                queue.offer(neighbor);
	            }
	        }
	    }
	    return true;
	}
	
	public static void main(String args[])
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
		//n1.addNeighbor(n4);
		//n4.addNeighbor(n1);
		System.out.println(isBipartite(n1));
	}
}
