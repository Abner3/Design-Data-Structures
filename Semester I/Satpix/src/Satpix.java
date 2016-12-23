import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author AStout
 *
 */
public class Satpix {

	static int sizeOfLargestPasture = 0;
	static int length, width;
	public static void main (String[] args) throws IOException
	{
		boolean[][] booleanArr = fileToBoolArray();
		//Stuff for you to code!

		PrintWriter out = new PrintWriter("satpix.out");
		out.println(sizeOfLargestPasture);
		out.close();
	}

	//buffered reader for char and scanner for strings
	//file reader if using buffered reader fileReader(inFile)
	private static boolean[][] fileToBoolArray() throws FileNotFoundException
	{
		// Helper method which converts the file into a 2D
		// array of booleans
		
		//scan in the ints for length and width
		Scanner textReader = new Scanner(new File("satpix.in")); //where's file?
		length = textReader.nextInt();
		width = textReader.nextInt();
		
		//buffer read in satpix char map
		
	}


	//base case is then there is false boolea ns around the true booleans (pasture)
	//or if false boolean is where method is called
	private static int recursivelyMeasureAndMarkPasture(int row, int col, boolean[][] arr)
	{
		// Recursive method which uses the flood-fill algorithm to
		// count the size of a single pasture and "mark" it so it is not double-counted


		if(arr[row-1][col])
		{
			recursivelyMeasureAndMarkPasture(row-1, col, arr);
		}

		if(arr[row+1][col])
		{
			recursivelyMeasureAndMarkPasture(row+1, col, arr);
		}

		if(arr[row][col-1])
		{
			recursivelyMeasureAndMarkPasture(row, col-1, arr);
		}

		if(arr[row][col+1])
		{
			recursivelyMeasureAndMarkPasture(row, col+1, arr);
		}

		
		//base cases
		
		if(arr[row][col])
		{
			return sizeOfLargestPasture++;
		}
		
		if(!arr[row][col])
		{
			return sizeOfLargestPasture;
		}
	}

}
