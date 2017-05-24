import java.io.*;
import java.util.*;
import java.lang.*;


public class HuffmanEncoding {

	private Map<Character, Integer> frequency;
	private ArrayList<Node> listOfNodes;
	private PriorityQueue<Node> priorityQueue;
	private Node root;

	
	public HuffmanEncoding(BufferedReader brFile) throws IOException
	{
		frequency = new HashMap<Character, Integer>();
		listOfNodes = new ArrayList<Node>();
		priorityQueue = new PriorityQueue<Node>();
		countCharacters(brFile);
		listOfNodes();
		createTree();
	}
	
	
	/**
	 * @return nothing, just fills in the frequency matrix
	 * @throws IOException 
	 */
	public void countCharacters(BufferedReader brFile) throws IOException
	{
		while(brFile.ready())
		{
			Character temp = new Character((char)brFile.read());
			
			//check if ints are initialized
			if(frequency.get(temp) == null)
				frequency.put(temp, 1);
				
			else
				frequency.put(temp, frequency.get(temp) + 1); 
		}
	}
	
	
	public void listOfNodes()
	{
		for(Character key: frequency.keySet())
		{
			listOfNodes.add(new Node(key,frequency.get(key)));
		}
	}

	public void createTree()
	{
		Node small1, small2;
		
		//created a PQ 
		for(Node temp:listOfNodes)
		{
			priorityQueue.add(temp);
		}
		
		//create the Huffman tree
		
		while(priorityQueue.size() != 1)
		{
			small1 = priorityQueue.remove();
			small2 = priorityQueue.remove();
			
			root = new Node(small1.getFrequency() + small2.getFrequency(), small1, small2);
			
			priorityQueue.add(root);
		}
			root = new Node (null, small2.getCounter() + small1.getCounter);
		}
	}
	

	public void createHuffmanCodes(Node temp)
	{
		//base case
		if(temp.getLeftNode() == null && temp.getRightNode() == null)
			return;
		
		if(temp.getLeftNode() != null)
		{
			temp.getRightNode().addHuffmanCode(0);
			createHuffmanCodes(temp.getLeftNode());
		}
		
		if(temp.getRightNode() != null)
		{
			temp.getRightNode().addHuffmanCode(1);
			createHuffmanCodes(temp.getRightNode());
		}
		
		
	}
	
	
	/**
	 * @return contents of hashset; # of occurrences of a char
	 */
	public String toString()
	{
		return frequency.toString();
	}
}
