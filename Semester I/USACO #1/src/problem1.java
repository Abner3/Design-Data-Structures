import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class problem1 
{

	private int R1x1, R1x2, R1y1, R1y2;
	private int R2x1, R2x2, R2y1, R2y2;
	private int minimum = Integer.MAX_VALUE, maximum = 0; //used to compute length and width
	private int finalLength, finalHeight;
	
	
	public void main(String[] args) throws FileNotFoundException
	{
		
		Scanner reader = new Scanner(new File("square.in"));

		//read first line of input: x,y then x,y of the top right corner
		R1x1 = reader.nextInt();
		R1y1 = reader.nextInt();
		R1x2 = reader.nextInt();
		R1y2 = reader.nextInt();
		
		//read second line of input: x,y then x,y of the top right corner
		R2x1 = reader.nextInt();
		R2y1 = reader.nextInt();
		R2x2 = reader.nextInt();
		R2y2 = reader.nextInt();

		//close Scanner
		reader.close();

		//compute length
		if(R1x1 <= minimum)
			minimum = R1x1;
		if (R1x2 >= minimum)
			minimum = R1x2;
		if(R2x1 <= minimum)
			minimum = R2x1;
		if (R2x2 >= minimum)
			minimum = R2x2;
		
		if(R1x1 >= maximum)
			maximum = R1x1;
		if (R1x2 >= maximum)
			maximum = R1x2;
		if(R2x1 <= maximum)
			maximum = R2x1;
		if (R2x2 >= maximum)
			maximum = R2x2;
		
		finalLength = maximum-minimum;
		
		//compute height
		minimum = Integer.MAX_VALUE;
		maximum = 0;
		
		if(R1y1 <= minimum)
			minimum = R1y1;
		if(R1y2 >= minimum)
			minimum = R1y2;
		if(R2y1 <= minimum)
			minimum = R2y1;
		if(R2y2 >= minimum)
			minimum = R2y2;
		
		if(R1y1 >= maximum)
			maximum = R1y1;
		if(R1y2 >= maximum)
			maximum = R1y2;
		if(R2y1 <= maximum)
			maximum = R2y1;
		if(R2y2 >= maximum)
			maximum = R2y2;
				
		finalHeight = maximum-minimum;
		
		//output
		PrintWriter pw = new PrintWriter("square.out");
		pw.println(finalLength*finalHeight);
		pw.close();
	}
}
