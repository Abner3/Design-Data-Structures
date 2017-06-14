import java.io.*;
import java.util.*;
import java.lang.*;


public class CodeGeneratorHelper {

	private Map<Character, Integer> frequency;
	protected Node arrayOfNodes[];
	private PriorityQueue<Node> priorityQueue;
	private Node root;

	
	public CodeGeneratorHelper(BufferedReader brFile) throws IOException
	{
		frequency = new HashMap<Character, Integer>();
		arrayOfNodes = new Node[256];
		priorityQueue = new PriorityQueue<Node>();
		
		countCharacters(brFile);
		listOfNodes();
		createTree();
		createHuffmanCodes(root);
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
		
		
		/*
		for(Character key: frequency.keySet())
		{
			arrayOfNodes.add(new Node(key,frequency.get(key)));
		}*/
		
		for(int counter = 0; counter < 256; counter++)
		{
			
			//checks if it should make a null node
			if(frequency.get((char)counter) == null)
			{
				
				arrayOfNodes[counter] = new Node((char)counter, 0);
			}
			
			//makes the node according to the hashmap
			else
				arrayOfNodes[counter] = new Node((char)counter, frequency.get(new Character((char)counter)));
		}
	}

	public void createTree()
	{
		Node small1, small2;
		
		//created a PQ 
		for(Node temp:arrayOfNodes)
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
			
			//Might be necessary
			//listOfNodes.add(root);
		}
	}
	

	public void createHuffmanCodes(Node temp)
	{
		//base case
		if(temp.getLeftNode() == null && temp.getRightNode() == null)
			return;
		
		if(temp.getLeftNode() != null)
		{
			temp.getLeftNode().setHuffmanCode(temp.getHuffmanCode()+ "0");
			createHuffmanCodes(temp.getLeftNode());
		}
		
		if(temp.getRightNode() != null)
		{
			temp.getRightNode().setHuffmanCode(temp.getHuffmanCode() + "1");
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
