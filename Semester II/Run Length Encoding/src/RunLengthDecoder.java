import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class RunLengthDecoder //DONE
{
	public static void main(String[] args) throws IOException 
	{
		char currentChar, nextChar;
		int totalNumber;


		BufferedReader br = new BufferedReader(new FileReader("RLEmystery.txt"));


		FileWriter fw = new FileWriter("outputDecoder.txt");

		currentChar = (char) br.read();
		
		while(br.ready())
		{
			nextChar = (char) br.read();
			totalNumber = 1;


			if(currentChar == nextChar)
			{
				totalNumber = br.read(); //read as an int
				
				for(int counter = 0; counter < totalNumber; counter++)
				{
					fw.write(currentChar);
				}
				currentChar = nextChar;
			}
			
			else
			{
				fw.write(nextChar);
				currentChar = nextChar;
			}
		}

		br.close();
		fw.close();
	}
}