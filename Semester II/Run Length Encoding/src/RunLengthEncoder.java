import java.io.*;

public class RunLengthEncoder 
{
	public static void main (String[] args)
	{
		char currentChar, nextChar;
		int counter;
		
		
		BufferedReader br = new BufferedReader(new FileReader("RLEencodetest.txt"));
		FileWriter fw = new FileWriter("outputEncoder.txt");
		
		currentChar = br.read();
		
		while(br.ready())
		{
			counter = 0;
			nextChar = br.read();
			
			//checks if the character is repeated
			if(currentChar == nextChar)
			{
				//loops until reaches border between two characters
				while(currentChar == nextChar)
				{
					currentChar = nextChar;
					nextChar = br.read();
					counter++;
				}
				
				//counted and have the currentChar
				fw.write(currentChar + (char)counter);
				
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
