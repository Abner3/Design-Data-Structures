public class HeapPQ<E extends Comparable<E>> implements MyPriorityQueue<E> {

	private E[] heap;
	private int objectCount;
	
	//this is a min heap. First index has the lowest value
	@SuppressWarnings("unchecked")
	public HeapPQ()
    {
        this.heap = (E[])new Comparable[3];
        this.objectCount = 0;
    }
	
	//Adds obj to the Priority Queue
	//START AT INDEX 1
	//Check
	public void add(E obj)
	{
		heap[1 + objectCount]  = obj;
		bubbleUp(1 + objectCount);
		this.objectCount++;
	}
	
	//Removes and returns the MINIMUM element from the Priority Queue
	public E removeMin()
	{
		E temp = heap[1]; //store for return at the end
		heap[1] = null; //Check this
		
		//"sort" the heap tree out because index 1 is now removed
		swap(1, objectCount+1);
		bubbleDown(1);
		
		this.objectCount--;
		return temp;
	}
	
	//Returns the MINIMUM element from the Priority Queue without removing it
	//Check
	public E peek()
	{
		return heap[1];
	}
	
	// Returns true if the priority queue is empty
	//Check
	public boolean isEmpty()
	{
		return (objectCount < 1); //if objCount is less than 1, returns true
	}
	
	//Returns the number of elements in the priority queue
	//Check
	public int size()
	{
		return objectCount;
	}
	
	public String toString()
	{
		StringBuffer stringbuf = new StringBuffer("[");
		for (int i = 0; i < objectCount; i++)
		{
			stringbuf.append(heap[i+1]);
			if (i < objectCount - 1)
				stringbuf.append(", ");
		}
		stringbuf.append("]\nor alternatively,\n");

		for(int rowLength = 1, j = 0; j < objectCount; rowLength *= 2)
		{
			for (int i = 0; i < rowLength && j < objectCount; i++, j++)
			{
				stringbuf.append(heap[j+1] + " ");
			}
			stringbuf.append("\n");
			if (j < objectCount)
			{
				for (int i = 0; i < Math.min(objectCount - j, rowLength*2); i++)
				{
					if (i%2 == 0)
						stringbuf.append("/");
					else
						stringbuf.append("\\ ");
				}
				stringbuf.append("\n");
			}
		}
		return stringbuf.toString();
	}
	
	
	//helper methods
	
	//Doubles the size of the heap array
	//Check
	private void increaseCapacity()
	{
		E[] tempHeap = (E[])new Comparable[heap.length*2];
		for(int x = 1; x <= objectCount; x++)
		{
			tempHeap[x] = heap[x];
		}
		this.heap = tempHeap;
	}

	//Returns the index of the "parent" of index i
	
	private int parent(int i) throws NullPointerException
	{
		//check clause
		if(i <= 0 || i >= heap.length)
		{
			throw new NullPointerException();
		}
		
		return i/2;
	}
	
	//Returns the *smaller child* of index i
	//should work
	private int smallerChild(int i) throws NullPointerException
	{
		//node i's children: node 2i or 2i+1
		E plusOne = null, timesTwo = null;
		//check that children exist
		
		//check if 2i+1 exists
		if(2*i+1 < heap.length)
			plusOne = heap[2*i+1];
		
		//check if 2i exists
		if(2*i < heap.length)
			timesTwo = heap[2*i];
		
		//compare the two children
		if (timesTwo.compareTo(plusOne) > 1)
			return 2*i+1; //return index of plusOne
		
		if (plusOne.compareTo(timesTwo) > 1)
			return 2*i; //return index of timesTwo
			
		return -1; //return if conditions don't find the smaller child
	}
	
	//Swaps the contents of indices i and j
	//check
	private void swap(int i, int j)
	{
		E temp = heap[i];
		
		heap[i] = heap[j];
		heap[j] = temp;
	}

	// Bubbles the element at index i upwards until the heap properties hold again.
	// Heap property = min heap
	//check
	private void bubbleUp(int i)
	{
		//check if it even has a parent | base case
		if(i <= 1)
			return;
		
		
		//use swap(int, int) and parent(int)
		while(heap[parent(i)].compareTo(heap[i]) > 1) //while parent is bigger than child (current i)
		{
			swap(i, parent(i));
		}
	}
	
	// Bubbles the element at index i downwards until the heap properties hold again.
	// 2i or 2i+1 for child
	private void bubbleDown(int i)
	{
		if(heap[parent(i)].compareTo(heap[i]) > 1 && heap[smallerChild(i)].compareTo(heap[i]) < 1) //this holds correct heap properties | base case
			return;
		
		swap(i, smallerChild(i));
		bubbleDown(smallerChild(i));
	}

}
