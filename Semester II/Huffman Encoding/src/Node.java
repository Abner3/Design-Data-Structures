
public class Node implements Comparable<Node>
{
	int frequency, huffmanCode;
	char letter;
	Node left, right;
	
	
	//for nodes that have a letter
	public Node(char letter, int counter)
	{
		this.letter = letter;
		this.frequency = counter;
	}
	
	//for nodes that don't have a letter associated in the huffman tree
	public Node(int counter, Node left, Node right)
	{
		this.frequency = counter;
		setRightNode(right);
		setLeftNode(left);
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
	
	public void setHuffmanCode(int huffmanCode)
	{
		this.huffmanCode = huffmanCode;
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
	
	public int getHuffmanCode(int huffmanCode)
	{
		return huffmanCode;
	}
	
	public int addHuffmanCode(int huffmanCode)
	{
		this.huffmanCode += huffmanCode;
		return huffmanCode;
	}
	
	//action methods
	public void add(int count)
	{
		this.frequency += count;
	}
	
	public int compareTo(Node other)
	{
		return this.frequency - frequency; //+ = this node is greater
	}
	
	public String toString()
	{
		return "Letter: " + letter + "Frequency: " + frequency;
	}
}
