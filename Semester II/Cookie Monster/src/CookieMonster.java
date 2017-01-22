import java.util.ArrayDeque;
import java.util.PriorityQueue;

/* YOU ARE ALLOWED (AND EXPECTED) TO USE THE JAVA ARRAYDEQUE AND PRIORITYQUEUE CLASSES */

public class CookieMonster {

	private int [][] cookieGrid;
	private int numRows;
	private int numCols;
	private int mostCookies = 0;
	private int maxCallStackDepth = -1; //Used only for recursive technique

	public CookieMonster(int [][] cookieGrid) 
	{
		this.cookieGrid = cookieGrid;
		this.numRows    = cookieGrid.length; //top -> down
		this.numCols    = cookieGrid[0].length; //left -> right
	}

	/* Return the calculated most cookies edible on the optimal path. */
	public int getMostCookies() 
	{
		return mostCookies;
	}

	//check
	private boolean goodPoint(int row, int col) //checks if the coordinate is on the grid
	{
		return (row >= 0 && row < numRows && col >= 0 && col < numCols && cookieGrid[row][col] >= 0);
	}

	/* RECURSIVELY calculates the route which grants the most cookies, and returns the maximum depth the call stack reached during the operation. */
	//check
	public int maxCallStackDepth()
	{
		this.mostCookies = recursiveOptimalPath(0, 0, 1);
		return maxCallStackDepth;
	}

	/* Helper function for the above, which returns the maximum number of cookies edible starting at coordinate (row, col). */
	/* From any given position, always check right before checking down */
	/* Also, updates the maxCallStackDepth variable, to find out how deep the recursion call stack got during the operation. 
	 * I've implemented this part already (you should add 1 to the depth when it calls itself). */ 
	private int recursiveOptimalPath(int row, int col, int depth)
	{
		if (depth > this.maxCallStackDepth)
			this.maxCallStackDepth = depth;

		/* -- YOU IMPLEMENT THIS -- */

		int totalCookie = 0;
		int compareCookie = 0;
		
		//this compares values to the right and bottom and return the total | base case
		if(goodPoint(row,col))
		{
			totalCookie = cookieGrid[row][col];
			if(goodPoint(row,col+1) || goodPoint(row+1,col))
			{
				if(goodPoint(row,col+1))
				{
					compareCookie = cookieGrid[row][col+1];
				}

				if(goodPoint(row+1,col))
				{
					if(compareCookie < cookieGrid[row+1][col])
					{
						compareCookie = cookieGrid[row+1][col];
					}
				}
				return totalCookie + compareCookie;
			}
		}
		else //base case
			return 0;

		//comparison of bottom and right PATHS
		if(recursiveOptimalPath(row+1,col,depth+1) > recursiveOptimalPath(row,col+1,depth+1))
			return recursiveOptimalPath(row+1,col,depth+1) + cookieGrid[row][col];

		return recursiveOptimalPath(row,col+1,depth+1) + cookieGrid[row][col];

	}

	/* Calculate the route which grants the most cookies, and return the maximum queue size during the operation. */
	/* From any given position, always check right before checking down */
	/* Set this.mostCookies before returning */
	public int maxQueueSize() 
	{
		ArrayDeque<PathMarker> queue = new ArrayDeque<PathMarker>();
		int maxQueueSize = 0;
		int mostCookiesSoFar = -1;
		queue.addFirst(new PathMarker(0, 0, cookieGrid[0][0]));

		/* -- YOU IMPLEMENT THIS -- */
		while (!queue.isEmpty())
		{		
			//check maxQueueSize
			if(maxQueueSize < queue.size())
			{
				maxQueueSize = queue.size();
			}
			
			PathMarker store = queue.remove();
			
			//check mostCookies
			if(mostCookiesSoFar < store.total)
			{
				mostCookiesSoFar = store.total;
			}
			
			//adding right path
			if(goodPoint(store.row+1, store.col))
			{
				PathMarker right = new PathMarker(store.row+1, store.col, cookieGrid[store.row+1][store.col] + store.total);
				queue.add(right);
			}
			
			//adding down path
			if(goodPoint(store.row, store.col+1))
			{
				PathMarker down = new PathMarker(store.row, store.col+1, cookieGrid[store.row][store.col+1] + store.total);
				queue.add(down);
			}
			
		}
		
		this.mostCookies = mostCookiesSoFar;
		return maxQueueSize;
	}

	/* Calculate the route which grants the most cookies, and return the maximum stack size during the operation. */
	/* From any given position, always check right before checking down */
	/* Set this.mostCookies before returning */
	//change queue to stack and change add and remove
	public int maxStackSize() 
	{
		ArrayDeque<PathMarker> stack = new ArrayDeque<PathMarker>();
		int maxStackSize = 0;
		int mostCookiesSoFar = -1;
		stack.addFirst(new PathMarker(0, 0, cookieGrid[0][0]));

		/* -- YOU IMPLEMENT THIS -- */

	}

	/* Calculate the route which grants the most cookies, and return the maximum priority queue size during the operation. */
	/* From any given position, always check right before checking down */
	/* Set this.mostCookies before returning */
	public int maxPriorityQueueSize()
	{
		HeapPQ<PathMarker> priorityQueue = new HeapPQ<PathMarker>();
		int maxPriorityQueueSize = 0;
		int mostCookiesSoFar = -1;
		priorityQueue.add(new PathMarker(0, 0, cookieGrid[0][0]));

		/* -- YOU IMPLEMENT THIS -- */
		
		return priorityQueue.size();
	}


}

//path in queues don't shrink until path gets until finish line
//path in stack shrink earlier since the paths usually get crossed out and reach their finish destination faster

//Breadth-first search: when using a queue
//Depth-first search: when using a stack