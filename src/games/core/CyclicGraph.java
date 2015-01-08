package games.core;
import games.utils.GraphNode;


public class CyclicGraph {

	/**
	 * Checks if the given undirected graph has a cycle
	 * @param node
	 * @param parent
	 * @return
	 */
	private static boolean isUndirectedGraphCyclic(GraphNode<Integer> node, GraphNode<Integer> parent)
	{
	    if(node.visited())
	        return true;

	    node.visit();
	    for(GraphNode<Integer> neighbor : node.neighbors())
	    {
	        if(!neighbor.equals(parent))
	        {
	            if(isUndirectedGraphCyclic(neighbor, node))
	                return true;
	        }
	    }
	    return false;
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
		System.out.println(isUndirectedGraphCyclic(n1, null));
	}
}
