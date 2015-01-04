import java.util.ArrayList;
import java.util.List;


public class GraphNode<T>
{
	private T value_;
	private List<GraphNode<T>> neighbors_ = new ArrayList<GraphNode<T>>();
	public enum color 
	{
		UNCOLORED,
		RED,
		BLUE
	}
	private color c_;
	
	public GraphNode(T val)
	{
		value_ = val;
		c_ = color.UNCOLORED;
	}
	
	public boolean isColored()
	{
		return c_ != color.UNCOLORED;
	}
	
	public T getValue()
	{
		return value_;
	}
	
	public List<GraphNode<T>> neighbors()
	{
		return neighbors_;
	}
	
	public void addNeighbor(GraphNode<T> node)
	{
		neighbors_.add(node);
	}
	
	public void setColor(color c)
	{
		c_ = c;
	}
	
	public color color()
	{
		return c_;
	}
}
