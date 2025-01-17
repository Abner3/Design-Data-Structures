import java.util.*;
import java.io.*;


// Help Farmer John count the total number of crossing pairs
public class CowsCrossingPair {

	public static void main(String[] args) throws FileNotFoundException 
	{
		Scanner in = new Scanner(new File("circlecross.in"));
		PrintWriter out = new PrintWriter("circlecross.out");
		
		String cowsCrossing = in.next();
		
		for(int x = 0; x < cowsCrossing.length(); x++)
		{
			if(cowsCrossing.charAt(x) == cowsCrossing.charAt(x+1))
				cowsCrossing = cowsCrossing.substring(0, x-1) + cowsCrossing.substring(x+2, cowsCrossing.length());
		}
		
		System.out.print(cowsCrossing);
		out.println(cowsCrossing.length());
	}

}
