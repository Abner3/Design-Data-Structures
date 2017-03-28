import java.util.Scanner;

public class TruthLogic {

	static boolean first;
	static boolean second;
	
	static boolean AND(boolean one, boolean two)
	{
		return (one && two);
	}
	
	static boolean OR(boolean one, boolean two)
	{
		return (one || two); 
	}
	
	static boolean NOT(boolean one)
	{
		return !one; 
	}
	
	public static void main(String[] args) {

		Scanner kb = new Scanner(System.in);

		first = kb.nextBoolean();
		second = kb.nextBoolean();
		
		System.out.println(AND(first,second));
		
		
		first = kb.nextBoolean();
		second = kb.nextBoolean();
		
		System.out.println(OR(first,second));
		
		
		first = kb.nextBoolean();
		
		System.out.println(NOT(first));
		
		kb.close();
	}

}
