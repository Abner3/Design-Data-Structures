import java.io.*;
import java.util.*;
import java.lang.*;


public class HuffmanEncoding {

	private PriorityQueue<Node> tree;
	private Map<Character, Integer> frequency;
	private ArrayList<Node> listOfNodes;

	
	public HuffmanEncoding(BufferedReader brFile) throws IOException
	{
		frequency = new HashMap<Character, Integer>();
		listOfNodes = new ArrayList();
		tree = new PriorityQueue();
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
		
	}
	
	/**
	 * @return contents of hashset; # of occurrences of a char
	 */
	public String toString()
	{
		return frequency.toString();
	}
}
