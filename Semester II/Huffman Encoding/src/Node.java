
public class Node implements Comparable<Node>
{
	int counter;
	char letter;
	Node left, right;
	
	
	public Node(char letter, int counter)
	{
		this.letter = letter;
		this.counter = counter;
	}
	
	public void setRightNode(Node node1)
	{
		right = node1;
	}
	
	public void setLeftNode(Node node1)
	{
		left = node1;
	}
	
	public Node getRightNode()
	{
		return right;
	}
	
	public Node getLeftNode()
	{
		return left;
	}
	
	public void add(int count)
	{
		this.counter += count;
	}
	
	public int compareTo(Node other)
	{
		return this.counter - counter;
	}
	
	public String toString()
	{
		return "Letter: " + letter + "Counter: " + counter;
	}
}
