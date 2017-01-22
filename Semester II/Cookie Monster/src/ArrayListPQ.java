import java.util.ArrayList;

public class ArrayListPQ<E extends Comparable<E>> implements MyPriorityQueue<E>{

	private ArrayList<E> queue;
	
	public ArrayListPQ()
	{
		queue = new ArrayList<E>();
	}
	
	public void add(E obj)
	{
		
	}
	
	public E removeMin()
	{
		
	}
	
	public E peek()
	{
		
	}
	
	public boolean isEmpty()
	{
		
	}
	
	public int size()
	{
		
	}
	
	public String toString()
	{
		StringBuffer stringbuf = new StringBuffer ("[ ");	
		for (int i = 0; i < queue.size(); i++)
		{
			stringbuf.append(queue.get(i)+" ");
		}
		stringbuf.append("]");
		return stringbuf.toString();
	}

}
