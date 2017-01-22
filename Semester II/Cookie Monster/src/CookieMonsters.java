import java.util.ArrayDeque;
import java.util.PriorityQueue;

/* YOU ARE ALLOWED (AND EXPECTED) TO USE THE JAVA ARRAYDEQUE CLASS */

public class CookieMonsters {

    private int [][] cookieGrid;
    private int numRows;
    private int numCols;
    private int mostCookies = -1;
    private int maxCallStackDepth = -1; //Used only for recursive technique

    public CookieMonsters(int [][] cookieGrid) {
        this.cookieGrid = cookieGrid;
        this.numRows    = cookieGrid.length;
        this.numCols    = cookieGrid[0].length;
    }

    /* Return the calculated most cookies edible on the optimal path. */
    public int getMostCookies() {
        return mostCookies;
    }

    private boolean goodPoint(int row, int col) {
        return (row >= 0 && row < numRows && col >= 0 && col < numCols && cookieGrid[row][col] >= 0);
    }

	/* RECURSIVELY calculates the route which grants the most cookies, and returns the maximum depth the call stack reached during the operation. */
	public int maxCallStackDepth() {
		this.mostCookies = recursiveOptimalPath(0, 0, 1);
		return maxCallStackDepth;
	}	

	/* Helper function for the above, which returns the maximum number of cookies edible starting at coordinate (row, col). */
	/* From any given position, always check right before checking down */
	/* Also, updates the maxCallStackDepth variable, to find out how deep the recursion call stack got during the operation. 
	 * I've implemented this part already (you should add 1 to the depth when it calls itself). */ 
	private int recursiveOptimalPath(int row, int col, int depth) {
		int x = 0, y = 0;
		if (depth > this.maxCallStackDepth){
			this.maxCallStackDepth = depth;
		}
		
		if(!goodPoint(row, col)){
			return 0;
		}
		
		x = cookieGrid[row][col] + recursiveOptimalPath(row, col + 1, depth + 1);
		y = cookieGrid[row][col] + recursiveOptimalPath(row + 1, col, depth + 1);
		
		return (x > y)? x:y;
	}

	/* Calculate the route which grants the most cookies, and return the maximum queue size during the operation. */
    /* From any given position, always check right before checking down */
    /* Set this.mostCookies before returning */
    public int maxQueueSize() {
        ArrayDeque<PathMarker> queue = new ArrayDeque<PathMarker>();
        int maxQueueSize = 0;
        int mostCookiesSoFar = -1;
        queue.addFirst(new PathMarker(0, 0, cookieGrid[0][0]));
        int x = 0, y = 0;
        
        while(!queue.isEmpty()){
        	x = queue.peek().row;
        	y = queue.peek().col;
        	if(goodPoint(x + 1, y)){
        		queue.add(new PathMarker(x + 1, y, queue.peek().total + cookieGrid[x + 1][y]));
        	}
        	
        	if(goodPoint(x, y + 1)){
        		queue.add(new PathMarker(x, y + 1, queue.peek().total + cookieGrid[x][y + 1]));
        	}
        	
        	if(mostCookiesSoFar < queue.peek().total)
        	{
        		mostCookiesSoFar = queue.peek().total;
        	}
        	        	
        	if(maxQueueSize < queue.size()){
        		maxQueueSize = queue.size();
        	}
        	queue.poll();
        }
        this.mostCookies = mostCookiesSoFar;
        return maxQueueSize;
    }

    /* Calculate the route which grants the most cookies, and return the maximum stack size during the operation. */
    /* From any given position, always check right before checking down */
    /* Set this.mostCookies before returning */
    public int maxStackSize() {
        ArrayDeque<PathMarker> stack = new ArrayDeque<PathMarker>();
        int maxStackSize = 0;
        int mostCookiesSoFar = -1;
        stack.addFirst(new PathMarker(0, 0, cookieGrid[0][0]));
        int x = 0, y = 0;
        
        while(!stack.isEmpty()){
        	x = stack.peek().row;
        	y = stack.peek().col;
        	if(goodPoint(x + 1, y)){
        		stack.add(new PathMarker(x + 1, y, stack.peek().total + cookieGrid[x + 1][y]));
        	}
        	
        	if(goodPoint(x, y + 1)){
        		stack.add(new PathMarker(x, y + 1, stack.peek().total + cookieGrid[x][y + 1]));
        	}
        	
        	if(mostCookiesSoFar < stack.peek().total){
        		mostCookiesSoFar = stack.peek().total;
        	}
        	        	
        	if(maxStackSize < stack.size()){
        		maxStackSize = stack.size();
        	}
        	stack.pop();
        }
        this.mostCookies = mostCookiesSoFar;
        return maxStackSize;
    }

    /* Calculate the route which grants the most cookies, and return the maximum priority queue size during the operation. */
    /* From any given position, always check right before checking down */
    /* Set this.mostCookies before returning */
    public int maxPriorityQueueSize() {
        HeapPQ<PathMarker> priorityQueue = new HeapPQ<PathMarker>();
        int maxPriorityQueueSize = 0;
        int mostCookiesSoFar = -1;
        int x = 0, y = 0;
        priorityQueue.add(new PathMarker(0, 0, cookieGrid[0][0]));
        while(!priorityQueue.isEmpty()){
        	x = priorityQueue.peek().row;
        	y = priorityQueue.peek().col;
        	if(goodPoint(x + 1, y)){
        		priorityQueue.add(new PathMarker(x + 1, y, priorityQueue.peek().total + cookieGrid[x + 1][y]));
        	}
        	
        	if(goodPoint(x, y + 1)){
        		priorityQueue.add(new PathMarker(x, y + 1, priorityQueue.peek().total + cookieGrid[x][y + 1]));
        	}
        	
        	if(mostCookiesSoFar < priorityQueue.peek().total){
        		mostCookiesSoFar = priorityQueue.peek().total;
        	}
        	        	
        	if(maxPriorityQueueSize < priorityQueue.size()){
        		maxPriorityQueueSize = priorityQueue.size();
        	}
        	priorityQueue.removeMin();
        }
        this.mostCookies = mostCookiesSoFar;
        return maxPriorityQueueSize;
    }


}