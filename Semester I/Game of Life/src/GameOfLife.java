import java.awt.Color;
import java.awt.Graphics;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GameOfLife extends JPanel {

	public static int[][] soup;
	public static int cellSize = 11;
	public static int rows;
	public static int columns;
	public static void main(String[] args) throws InterruptedException {

		JFrame f = new JFrame();
		Scanner kboard = new Scanner(System.in);
		System.out.println("Please input the filename:");
		String fileName = kboard.nextLine();
		kboard.close();
		if (!fileName.endsWith(".soup"))
		{
			return;
		}
		try {
			readSoup(fileName);
		} catch (FileNotFoundException e) {
			System.out.println("Error 404: File not Found");
			return;
		}
		f.setSize(1000, 1000);
		GameOfLife l = new GameOfLife();
		f.add(l);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);

		while(true)
		{
			l.progresses();

			Thread.sleep(600);
			l.repaint();
		}
	}


	public void paint(Graphics g)
	{
		g.setColor(Color.gray);
		g.fillRect(0, 0, columns * cellSize, rows * cellSize);
		g.setColor(Color.green);
		for (int r = 0; r < rows; r++)
			for (int c = 0; c < columns; c++)
			{
				if (soup[r][c] != 0)
					g.fillRect(cellSize*c, cellSize*r, cellSize, cellSize);
			}
	}

	// Opens file fileName and puts the soup described inside it into the soup array.
	// Also sets rows and columns to proper values.
	// The soup file must be in the following format:
	// - the first line of the file is two numbers, the number of rows
	// and number of columns, separated by a space
	// - followed by the promised number of rows, each of which has 0s and 1s, with no spaces separating
	public static void readSoup(String fileName) throws FileNotFoundException
	{
		try{
			Scanner s=new Scanner(new File(fileName));
			rows=s.nextInt();
			columns=s.nextInt();
			soup=new int[rows][columns];
			for(int x=0; x<rows;x++)
				for(int y=0; y<columns;y++)
					soup[x][y]=s.nextInt();
			s.close();
		}
		catch(FileNotFoundException e){
			System.out.println("Error 404: File not Found");
			return;
		}
	}


	// Updates the soup according to the rules of Life
	public void progresses()
	{
		int [][] temp=new int[rows][columns];
		int r,c;
		r=rows;
		c=columns;
		for(int x=0; x<r;x++)
			for(int y=0;y<c;y++)
				if(alive(x,y))
					temp[x][y]=1;
				else
					temp[x][y]=0;
		soup=temp;
	}
	public static boolean alive(int j, int i){
		if(soup[j][i]==1)
			return checkNeighbors(j,i)==2||checkNeighbors(j,i)==3;
		else if(soup[j][i]==0&&checkNeighbors(j,i)==3)
			return true;
		else
			return false;
	}
	public static int checkNeighbors(int x, int y) {
		if(x==0){
			if(y==0){
				return soup[x][y+1]+soup[x+1][y]+soup[x+1][y+1];}
			else if(y==columns-1){
				return soup[x][y-1]+soup[x+1][y]+soup[x+1][y-1];}
			return soup[x][y+1]+soup[x+1][y]+soup[x+1][y+1]+soup[x][y-1]+soup[x+1][y-1];}

		else if(x==rows-1){
			if(y==0){
				return soup[x][y+1]+soup[x-1][y]+soup[x-1][y+1];
			}
			else if(y==columns-1){
				return soup[x][y-1]+soup[x-1][y]+soup[x-1][y-1];
			}
			return soup[x][y+1]+soup[x-1][y-1]+soup[x][y-1]+soup[x-1][y]+soup[x-1][y+1];}

		if(y==0){
			return soup[x+1][y]+soup[x+1][y+1]+soup[x][y+1]+soup[x-1][y]+soup[x-1][y+1];
		}
		else if(y==columns-1){
			return soup[x+1][y]+soup[x+1][y-1]+soup[x][y-1]+soup[x-1][y]+soup[x-1][y-1];}
		else{
			return soup[x][y+1]+soup[x+1][y]+soup[x+1][y+1]+soup[x-1][y-1]+soup[x][y-1]+soup[x-1][y]+soup[x-1][y+1]+soup[x+1][y-1];}
	}
}
