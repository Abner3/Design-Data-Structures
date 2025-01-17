import java.io.*;

public class RunLengthEncoder 
{
	public static void main (String[] args) throws IOException
	{
		char currentChar, nextChar;
		int counter;
		
		
		BufferedReader br = new BufferedReader(new FileReader("RLEencodeTest.txt"));
		FileWriter fw = new FileWriter("outputEncoder.txt");
		
		currentChar = (char) br.read();
		
		while(br.ready())
		{
			counter = 0; //counts the successive # of occurrences of a specific character
			nextChar = (char) br.read();
			
			//checks if the character is repeated
			if(currentChar == nextChar)
			{
				//loops until reaches border between two characters
				while(currentChar == nextChar)
				{
					currentChar = nextChar;
					nextChar = (char) br.read();
					counter++;
				}
				
				//counted and have the currentChar
				fw.write(currentChar + (int)counter); //check the counter part
				
				//getting ready for the next characters
				currentChar = nextChar;
			}
			
			//single character
			else
			{
				fw.write(currentChar);
				currentChar = nextChar;
			}
			
		}
		fw.close();
		br.close();
	}
}
