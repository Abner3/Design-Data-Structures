public class HeapPQ<E extends Comparable<E>> implements MyPriorityQueue<E> {

	private E[] heap;
	private int objectCount;
	
	public HeapPQ()
    {
        this.heap = (E[])new Comparable[3];
        this.objectCount = 0;
    }
	
	//Adds obj to the Priority Queue
	public void add(E obj)
	{
		
	}
	
	//Removes and returns the MINIMUM element from the Priority Queue
	//the closer to a the smaller the number
	public E removeMin()
	{
		E temp = heap[1]; //store for return at the end
		
		//"sort" the heap tree out
		swap(1, heap.length);
		bubbleDown(1);
		
		return temp;
	}
	
	//Returns the MINIMUM element from the Priority Queue without removing it
	public E peek()
	{
		return heap[1];
	}
	
	// Returns true if the priority queue is empty
	public boolean isEmpty()
	{
		return heap.length==0;
	}
	
	//Returns the number of elements in the priority queue
	public int size()
	{
		return heap.length;
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
	private void increaseCapacity()
	{
		E[] tempHeap = (E[])new Comparable[heap.length*2];
		for(int x = 0; x <= heap.length; x++)
		{
			tempHeap[x] = heap[x];
		}
		this.heap = tempHeap;
	}

	//Returns the index of the "parent" of index i
	private int parent(int i) throws NullPointerException
	{
		//check if it has a parent
		if(i == 1)
		{
			throw new NullPointerException();
		}
		
		//node i/2 round down for parent
		if(i%2==1)
		{
			return (i/2)-1;
		}
		return i/2;
	}
	
	//Returns the *smaller child* of index i
	private int smallerChild(int i) throws NullPointerException
	{
		//node i's children: node 2i or 2i+1
		
		if(2*i+1 > heap.length)
		{
			if(i*2 > heap.length)
				throw new NullPointerException();
			return i*2;
		}
		
		//now we know children are present
		if(heap[i*2].compareTo(heap[i*2+1]) > 0)
			return i*2;
	}
	
	//Swaps the contents of indices i and j
	private void swap(int i, int j)
	{
		E temp = heap[i];
		
		heap[i] = heap[j];
		heap[j] = temp;
	}

	// Bubbles the element at index i upwards until the heap properties hold again.
	private void bubbleUp(int i)
	{
		//check if it even has a parent
		if(i >= 1)
			return;
		
		//use swap(int, int) and parent(int)
		swap(i, parent(i));
		bubbleUp(parent(i));
	}
	
	// Bubbles the element at index i downwards until the heap properties hold again.
	private void bubbleDown(int i)
	{
		if(heap[parent(i)].compareTo(heap[i]) > 0 && heap[smallerChild(i)].compareTo(heap[i]) < 0)
		{
			return;
		}
		swap(i, smallerChild(i));
		bubbleDown(smallerChild(i));
	}

}
