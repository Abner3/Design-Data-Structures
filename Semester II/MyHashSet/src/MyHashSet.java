import java.lang.Integer;

// Implements a singly-linked list.

public class MyHashSet {
	private ListNode[] buckets;
	private int objCount;
	private double loadFactorLimit;

	// Constructor: creates an empty hash set with default parameters
	public MyHashSet()
	{
		this.buckets = new ListNode[10];
		this.objCount = 0;
		this.loadFactorLimit = 0.75;
	}

	// Constructor: creates a hash set with the given initial bucket size and load factor limit
	public MyHashSet(int bucketCount, double loadFactorLimit)
	{
		this.buckets = new ListNode[bucketCount];
		this.objCount = 0;
		this.loadFactorLimit = loadFactorLimit;
	}

	// Return a pointer to the bucket array
	public ListNode[] getBuckets() {
		return this.buckets;
	}

	// Returns true if this set is empty; otherwise returns false.
	public boolean isEmpty()
	{
		return (objCount == 0);
	}

	// Returns the number of elements in this set.
	public int size()
	{
		return objCount;
	}

	// Returns the current load factor (objCount / buckets)
	public double currentLoadFactor() {
		return (double)objCount / (double)buckets.length;
	}

	// Return the bucket index for the object
	public int whichBucket(Object obj) {
		return obj.hashCode() % this.buckets.length;
	}

	// Return the bucket index for the object w/ custom mod
	public int whichBucket(Object obj, int mod) {
		return obj.hashCode() % mod;
	}

	// Return true if the object exists in the set, otherwise false.
	// 
	public boolean contains(Object obj)
	{
		if(buckets[whichBucket(obj)] != null) //check if there are listNodes in the bucket
		{
			for(ListNode next = buckets[whichBucket(obj)]; next.getNext() != null; next = next.getNext()) //go through all the listNodes in the bucket
			{
				if(buckets //accesses the array of list nodes
						[whichBucket(obj)] //gets index of obj
								.getValue() //gets value (obj) of the array of list nodes
								.equals(obj)) //makes comparison
					return true;
			}		 
		}
		return false;
	}


	// Add an object to the set.
	// If the object already exists in the set you should *not* add another. No duplicates
	// Return true if the object was added; false if the object already exists.
	// If an item should be added, add it to the beginning of the bucket.

	// After adding the element, check if the load factor is greater than the limit.
	// - If so, you must call rehash with double the current bucket size.
	public boolean add(Object obj) {
		if(!contains(obj)) //checks if there is obj
		{
			if (buckets[whichBucket(obj)] == null) //checks if empty bucket
			{
				buckets[whichBucket(obj)] = new ListNode(obj, null);
				objCount++;

				//check load factor
				if(loadFactorLimit < currentLoadFactor())
				{
					rehash(buckets.length *2);
				}
				return true;
			}

			else //if bucket already has a listNode
			{
				buckets[whichBucket(obj)] = new ListNode(obj, buckets[whichBucket(obj)]);
				objCount++;

				//check load factor
				if(loadFactorLimit < currentLoadFactor())
				{
					rehash(buckets.length *2);
				}
				return true;
			}
		}

		return false;
	}


	// Remove the object.  Return true if successful, false if the object did not exist
	public boolean remove(Object obj) {

		if(!contains(obj)) //checks if obj is in the bucket //CHECK IF CONTAINS
			return false;

		if(obj.equals(buckets[whichBucket(obj)].getValue()))
		{
			buckets[whichBucket(obj)] = buckets[whichBucket(obj)].getNext();
			objCount--;
			return true;
		}

		//use this listNode to go through all listNodes in the bucket and remove accordingly
		ListNode previous = buckets[whichBucket(obj)];

		while(previous != null)
		{
			if(previous.getNext().getValue().equals(obj))
			{
				previous.setNext(previous.getNext().getNext());
				objCount--;
				return true;
			}

			previous = previous.getNext();
		}

		//none of the listNodes in the bucket contain obj
		return false;
	}


	// Rehash the set so that it contains the given number of buckets
	// Loop through all existing buckets, from 0 to length
	// rehash each object into the new bucket array in the order they appear on the original chain.
	public void rehash(int newBucketCount) {
		ListNode[] newBuckets = new ListNode[newBucketCount];

		//go through all buckets and/or listNodes and rehash into new list of listNodes
		for(int x = 0; x < buckets.length; x++)
		{
			if(buckets != null)
			{
			for(ListNode current = buckets[x]; current.getNext() != null; current = current.getNext())
			{
				add(whichBucket(current, newBucketCount));
			}
			}
		}
	}


	// The output should be in the following format:
	// [ #1, #2 | { b#: v1 v2 v3 } { b#: v1 v2 } ]
	// #1 is the objCount
	// #2 is the number of buckets
	// For each bucket that contains objects, create a substring that indicates the bucket index
	// And list all of the items in the bucket (in the order they appear)
	public String toString() {
		String intro = "[ " + objCount + ", " + buckets.length +" |";
		String bucketsInfo = "";
		ListNode getNextLN;

		for(int x = 0; x < buckets.length; x++) //traverse array of listNodes
		{

			if(buckets[x] != null)
			{
				bucketsInfo += (" { b" + x + ": " + buckets[x].getValue());
				getNextLN = buckets[x];

				//traverse listNode in buckets
				while(getNextLN.getNext() != null)
				{
					bucketsInfo += " " + getNextLN.getValue();
					getNextLN = getNextLN.getNext();
				}

				if(getNextLN.getNext() == null)
				{
					//end string for bucketsInfo for one bucket]
					bucketsInfo += " }";
				}
			}
		}

		return intro + bucketsInfo + " ]";
	}

}
