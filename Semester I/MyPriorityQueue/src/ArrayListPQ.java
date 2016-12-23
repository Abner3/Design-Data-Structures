import java.util.ArrayList;

public class ArrayListPQ<E extends Comparable<E>> implements MyPriorityQueue<E>{

	private ArrayList<E> queue;
	
	public ArrayListPQ()
	{
		queue = new ArrayList<E>();
	}
	
	public void add(E obj)
	{
		queue.add(obj); //add to the array list
	}
	
	public E removeMin()
	{		
		E minimum = queue.get(0);
		int pos = 1;
		
		for(int x = 1; x < queue.size(); x++)
		{
			if(minimum.compareTo(queue.get(x)) > 1)
			{
				minimum = queue.get(x); 
				pos = x;
			}
		}
		
		queue.remove(pos);
		return minimum;
	}
	
	//peek and remove return the same thing
	public E peek()
	{
		E minimum = queue.get(0);
		int pos = 1;
		
		for(; pos < queue.size(); pos++)
		{
			if(minimum.compareTo(queue.get(pos)) > 1)
			{
				minimum = queue.get(pos); 
			}
		}
		
		return minimum;
	}
	
	public boolean isEmpty()
	{
		if(queue.size() == 0)
			return true;
					
		return false;
	}
	
	public int size()
	{
		return queue.size();
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
