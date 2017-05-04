import java.io.*;
import java.util.*;
import java.lang.*;


public class HuffmanEncoding {

	private Map<Character, Integer> frequency;

	
	public HuffmanEncoding(BufferedReader brFile) throws IOException
	{
		frequency = new HashMap<Character, Integer>();
		countCharacters(brFile);
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
	
	
	public void huffmanTree()
	{
		
	}

	/**
	 * @return contents of hashset; # of occurances of a char
	 */
	public String toString()
	{
		return frequency.toString();
	}
}