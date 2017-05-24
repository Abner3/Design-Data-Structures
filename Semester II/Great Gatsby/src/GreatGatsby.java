import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;


public class GreatGatsby 
{
	private static int chainOrder, numOfCharacters;
	private static String fileNameIn, fileNameOut;
	private String finalWord;
	private BufferedReader br;
	private HashMap<String,ArrayList<String>> mainMap;
	
	
	
	public GreatGatsby(String fileNameIn, int chainOrder, String fileNameOut, int numOfCharacters) throws FileNotFoundException
	{
		//use buffered reader
		this.fileNameIn = fileNameIn;
		this.chainOrder = chainOrder;
		this.fileNameOut = fileNameOut;
		this.numOfCharacters = numOfCharacters;
		this.mainMap = new HashMap<String,ArrayList<String>>(); //actually using ArrayList for chars
		br = new BufferedReader(new FileReader("fileNameIn"));
		
		computeCombinations();
	}
	
	
	
	/**
	 * @param one the string to figure out the combination
	 * @return the char that comes after the string
	 */
	public String nextChar(String one)
	{
		ArrayList<String> store;
		Random random = new Random();
		int randomInt;
		
		
		//go through HashMap and return the string/char (depends on markov chain order)
		store = mainMap.get(one);
		randomInt = random.nextInt(store.size());
		
		return (String)store.get(randomInt);
	}
	
	/**
	 * @param one the whole string of greatgatsby
	 * @return the hashmap is made with all combinations
	 */
	public void computeCombinations()
	{
		//use chainOrder
		char first, second, third;
		String phrase;
		
		first = (char) br.read();
		
		while(br.ready())
		{
			second = (char) br.read();
			phrase = (char)first + (char)second;
			third = (char) br.read();
			if(mainMap.get(phrase) == null)
				mainMap.put(phrase,new ArrayList<String>()).add(second + third);
			else
				mainMap.get(phrase).add(second + third);

		}
		
		
		for(int counter = 0; counter < one.length(); counter++)
		{
			temp = one.substring(counter, chainOrder+counter);
			
			//initializing the arrayList
			if(mainMap.get(temp) == null)
			{				//put(key, value) //value is String ArrayList //add a string to the ArrayList
				mainMap.put(temp,new ArrayList<String>()).add(one.substring(chainOrder+counter, chainOrder+counter+1));
			}
			else
			{
				mainMap.get(temp).add(one.substring(chainOrder+counter, chainOrder+counter+1));
			}
		}
	}
	
}