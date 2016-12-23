// Implements a singly-linked list.

import java.util.Iterator;

public class SinglyLinkedList implements Iterable<Object>
{
	private ListNode head;
	private int nodeCount;


	// Constructor: creates an empty list

	// make them out of list nodes
	public SinglyLinkedList()
	{
		head = null;
		nodeCount = 0;
	}


	// Constructor: creates a list that contains all elements from the array values, in the same order

	// make them out of list nodes
	public SinglyLinkedList(Object[] values)
	{		
		nodeCount = values.length; //initialize nodeCount
		head = null; //initialize head

		if (values.length == 0)
			return;

		head = new ListNode(values[0]);
		ListNode node1 = head;


		for(int x = 1; x < values.length; x++)
		{
			node1.setNext(new ListNode(values[x]));
			node1 = node1.getNext();
			//add(0, values[x]);
		}	
	}


	// Returns true if this list is empty; otherwise returns false.
	public boolean isEmpty()
	{
		if(nodeCount != 0)
			return false;
		return true;
	}


	// Returns the number of elements in this list.
	public int size()
	{
		return nodeCount; //returns instance variable
	}


	// Returns true if this list contains an element equal to obj;
	// otherwise returns false.
	public boolean contains(Object obj) 
	{
		if (indexOf(obj) == -1)
			return false;
		return true;
	}


	// Returns the index of the first element in equal to obj;
	// if not found, returns -1.
	public int indexOf(Object obj) //error
	{
		ListNode node1 = head;
		for(int x = 0; x < nodeCount; x++) //for loop checks out
		{
			if(node1.getValue().equals(obj)) //checks if obj equals obj
				return x-1;
			node1 = node1.getNext(); //assigns the next node as itself to check that value AKA traverse
		}
		return -1;
	}

	// Adds obj to this collection.  Returns true if successful;
	// otherwise returns false.
	public boolean add(Object obj)
	{
		add(nodeCount, obj);
		return true;
	}


	// Add obj to 
	// something something something

	//recursive add at the end method
	private ListNode add(ListNode head, Object obj)
	{
		/*if(this.head.getNext() == null)
		{
			this.head.setNext(new ListNode(obj));
			return this.head.getNext();
		}
		add(this.head.getNext(),obj);

		return this.head = this.head.getNext();
		 */

		//class answer
		if (this.head == null)
		{
			return new ListNode(obj);
		}
		this.head.setNext(add(this.head.getNext(),obj));
		return this.head;
	}

	// Inserts obj to become the i-th element. Increments the size of the list by one.

	// use setNext()
	// increment nodeCount
	public void add(int i, Object obj)
	{		
		if(i > nodeCount)
		{
			throw new IndexOutOfBoundsException();
		}


		//special cases
		if(nodeCount == 0)
		{
			head = new ListNode(obj);
			nodeCount++;
		}

		else if(nodeCount == 1)
		{
			ListNode node1 = head;
			ListNode node2 = new ListNode(obj); // ListNode for the parameter obj
			node1.setNext(node2);
			nodeCount++;
		}

		else{
			//start a node at the head
			ListNode node1 = head;


			for(int x = 1; x < i; x++) //stops 1 before the destination
			{
				node1 = node1.getNext();
			}

			ListNode node2 = node1.getNext(); //the one being shifted right

			ListNode newNode = new ListNode(obj); //creates a listNode for the obj passed in

			//adding listNode
			newNode.setNext(node2);

			//completing the adding
			node1.setNext(newNode); //points the node at this different node
			nodeCount++;
			//should I make a new listNode and replace the listNode as a whole in the Singly Linked List
		}
	}





	// Removes the first element that is equal to obj, if any.
	// Returns true if successful; otherwise returns false.
	public boolean remove(Object obj)
	{
		if (nodeCount == 1)
		{
			if (head.getValue().equals(obj))
			{
				head = null;
				nodeCount--;
				return true;
			}
		}

		if(head == null)
		{
			return false;
		}

		if(head.getValue().equals(obj))
		{
			head = head.getNext();
			nodeCount--;
			return true;
		}

		for(ListNode node1 = head; node1.getNext() != null ;node1 = node1.getNext())
		{
			ListNode node2 = node1.getNext();

			if (node2.getValue().equals(obj))
			{
				node1.setNext(node2.getNext());
				//found the obj, now "shift" the array
				nodeCount--;
				return true;
			}
		}
		return false;
	}



	//getters and setters
	public Object get(int i)
	{
		if(nodeCount == 0)
		{
			throw new IndexOutOfBoundsException();

		}
		
		ListNode node1 = head;
		for(int x = 0; x < i; x++)
		{
			node1 = node1.getNext();
		}

		return node1.getValue();

	}


	// Replaces the i-th element with obj and returns the old value.
	public Object set(int i, Object obj)
	{
		if(nodeCount < i)
		{
			throw new IndexOutOfBoundsException();
		}
		
		// traversing listNode
		ListNode node1 = head;

		for (int x = 0; x < i-1; x++)
		{
			node1 = node1.getNext();
		}

		ListNode node2 = node1.getNext(); //this assisgn the node we DONT want
		ListNode node3 = new ListNode(obj, node2.getNext()); //leverages node2's pointer

		node1.setNext(node3); //finish up "replacing" node2 AKA node we don't want

		return node2;
	}


	// Removes the i-th element and returns its value.
	// Decrements the size of the list by one.
	public Object remove(int i)
	{
		if(i > nodeCount)
		{
			throw new IndexOutOfBoundsException();
		}
		
		if (i == 1)
		{
			ListNode temp = head;
			head = head.getNext();
			nodeCount--;
			return temp;
		}
		
		ListNode node1 = head;

		for(int x = 0; x < i-1; x++)
		{
			node1 = node1.getNext();
		}

		ListNode node2 = node1.getNext(); //this is going to bridge the gap between the deleted node
		node2 = node2.getNext(); //skips over the node we DONT want
		ListNode deletedNode = node1.getNext(); //store the deleted node
		node1.setNext(node2);

		return deletedNode;
	}


	// Returns a string representation of this list.
	public String toString()
	{
		String output = "{ ";
		for(ListNode node1 = head; node1 != null; node1 = node1.getNext())
		{
			output += node1.getValue() + " ";
		}

		output += "}";
		return output;
	}


	@Override
	public Iterator<Object> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
}
