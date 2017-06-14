import java.io.*;
import java.util.*;

public class CodeGenerator 
{
	public static void main(String[] args) throws IOException 
	{
		BufferedReader br = new BufferedReader(new FileReader("frequencyCountInput.txt"));
		PrintWriter pw = new PrintWriter("huffmanCodes.txt");
		//PrintWriter pw2 = new PrintWriter("")
		
		
		CodeGeneratorHelper huffman = new CodeGeneratorHelper(br);
		//use heap
		
		
		for(Node temp: huffman.arrayOfNodes)
		{
			pw.println(temp.getHuffmanCode());
		}
		
		
		
		pw.close();
		br.close();
	}
}
