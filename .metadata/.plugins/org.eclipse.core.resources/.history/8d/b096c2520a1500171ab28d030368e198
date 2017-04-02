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
	private BufferedReader readThis;
	
	private HashMap<String,ArrayList<String>> mainMap;
	
	
	
	
	public GreatGatsby(String one, int two, String three, int four) throws FileNotFoundException
	{
		//use buffered reader
		fileNameIn = one;
		chainOrder = two;
		fileNameOut = three;
		numOfCharacters = four;
		readThis = new BufferedReader(new FileReader(new File(fileNameIn)));
		mainMap = new HashMap<String,ArrayList<String>>(); //actually using ArrayList for chars
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
	
	public void computeCombinations(String one)
	{
		
	}
	
}