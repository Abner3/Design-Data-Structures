
public class SortedSLLPQ<E extends Comparable<E>> implements MyPriorityQueue<E> 
{

	private ListNode queueHead;
	private int objectCount;

	public SortedSLLPQ()
	{
		queueHead = null;
		objectCount = 0;
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
		for (ListNode node = queueHead; node != null; node = node.getNext()) 
		{
			stringbuf.append(node.getValue()+" ");
		}
		stringbuf.append("]");
		return stringbuf.toString();
	}
}