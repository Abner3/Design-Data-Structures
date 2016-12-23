import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class problem3 
{

	private int length, height, amplify;
	private int finalLength, finalHeight;
	
	private char[] startingMatrix, finalMatrix;
	
	public void amplify(int[] finalMatrix)
	{
		
	}
	
	public static void main(String[] args) throws FileNotFoundException
	{
		Scanner reader = new Scanner(new File("cowsignal.in"));
		
		height = reader.nextInt();
		length = reader.nextInt();
		amplify = reader.nextInt();
		
		for(int x = length; x <= length; x++)
		{
			for(int x = height; x < height; x++)
			{
				startingMatrix[length][height] = reader.next();
			}
		}
	}
}
