
public class Node implements Comparable<Node>
{
	protected int frequency;
	protected String huffmanCode;
	protected char letter;
	protected Node left, right;
	
	
	//for nodes that have a letter
	public Node(char letter, int counter)
	{
		this.letter = letter;
		this.frequency = counter;
		huffmanCode = "";
	}
	
	//for nodes that don't have a letter associated in the huffman tree
	public Node(int counter, Node left, Node right)
	{
		this.frequency = counter;
		setRightNode(right);
		setLeftNode(left);
		huffmanCode = "";
	}
	
	
	
	//setters
	public void setRightNode(Node node1)
	{
		right = node1;
	}
	
	public void setLeftNode(Node node1)
	{
		left = node1;
	}
	
	public void setFrequency(int frequency)
	{
		this.frequency = frequency;
	}
	
	public void setHuffmanCode(String code)
	{
		this.huffmanCode = code;
	}
	
	
	//getters
	public Node getRightNode()
	{
		return right;
	}
	
	public Node getLeftNode()
	{
		return left;
	}
	
	public int getFrequency()
	{
		return frequency;
	}
	
	public String getHuffmanCode()
	{
		return huffmanCode;
	}
	
	
	//action methods
	public void add(int count)
	{
		this.frequency += count;
	}
	
	public void addHuffmanCode(String huffmanCode)
	{
		this.huffmanCode += huffmanCode;
	}
	
	public int compareTo(Node other)
	{
		return this.frequency - other.frequency; //+ = this node is greater
	}
	
	public String toString()
	{
		return "Letter: " + letter + "Frequency: " + frequency;
	}
}
