import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


public class GreatGatsbyTester {

	private static int chainOrder, numOfCharacters;
	private static String fileNameIn, fileNameOut;
	private static char current;
	
	public static void main(String[] args) throws IOException 
	{
		Scanner kb = new Scanner(System.in);
		
		
//		System.out.println("File to read from?");
//		fileNameIn = kb.next();
//		System.out.println("Markov chain order?");
//		chainOrder = kb.nextInt();
//		System.out.println("File to output to?");
//		fileNameOut = kb.next();
//		System.out.println("Number of characters to write?");
//		numOfCharacters = kb.nextInt();
		
		chainOrder = 2; numOfCharacters = 100; fileNameIn = "thegreatgatsby.txt"; fileNameOut = "thegreatgastby2.txt";
		
		GreatGatsby first = new GreatGatsby(fileNameIn, chainOrder, fileNameOut, numOfCharacters);
		
		StringBuffer gatsbyStringBuffer = new StringBuffer();
		BufferedReader br = new BufferedReader(new FileReader(fileNameIn));
		while(br.ready())
		{
			gatsbyStringBuffer.append((char)br.read());
		}
		first.computeCombinations(gatsbyStringBuffer.toString());
		
		
		br.close();
		System.out.println("second greatgatsby");
		kb.close();
	}
}
