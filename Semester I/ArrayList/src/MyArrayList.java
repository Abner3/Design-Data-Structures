/*
 * Your indexed functions should throw IndexOutOfBoundsException if index is invalid!
 */
//check usage of this.xxx
//tasks, make this efficient and not use many duplicate arrays

public class MyArrayList<E> {

	/* Internal Object counter */
	protected int objectCount;

	/* Internal Object array */
	protected E[] internalArray;

	/* A trigger and counter of zero element(s) */
	protected boolean isEmpty = false;
	protected int numOfEmpty;

	/* Constructor: Create it with whatever capacity you want? */
	@SuppressWarnings("unchecked")
	public MyArrayList() {
		this.internalArray = (E[])new Object[100];
		objectCount=0;
	}


	/* Constructor with initial capacity */
	@SuppressWarnings("unchecked")
	public MyArrayList(int initialCapacity){
		this.internalArray = (E[])new Object[initialCapacity];
		objectCount=0;
	}


	/* Return the number of active slots in the array list
    Size accounts for empty spaces unlike .length*/
	public int size() {
		return objectCount;
	}


	/* Are there zero objects in the array list? */
	public boolean isEmpty() {
		return objectCount==0;
	}

	//throw IndexOutOfBoundsException if index is invalid!
	/* Get the index-th object in the list. */
	public E get(int index) {
		try{
			return internalArray[index];
		}
		catch (IndexOutOfBoundsException e)	//throw IndexOutOfBoundsException if index is invalid!
		{
			return null; 
		}
	}


	/* Replace the object at index with obj.  returns object that was replaced. */
	public E set(int index, E obj) {
		try{
			E obj1 = internalArray[index];
			internalArray[index] = obj;
			return obj1;
		}
		catch (IndexOutOfBoundsException e) //throw IndexOutOfBoundsException if index is invalid!
		{
			System.out.println("Caught set(int, E) exception");
			return null;
		}
	}


	/* Insert an object at index */
	@SuppressWarnings("unchecked") //might transfer elements over in the wrong index
	public void add(int index, E obj) {
		objectCount++; //adding one b/c add method
		try{
			if (index-1 < internalArray.length) //copies everything over, inserts obj, and shifts current array
			{
				for (int max = internalArray.length; index-1 < max; max--) //shifts everything to the right of index by one
				{
					internalArray[max-1] = internalArray[max-2];
				}
				internalArray[index] = obj; //check if the element to the right of this is replaced
			}

			else if (index+1 > internalArray.length) //copies everything over if internalArray is full, inserts obj 
			{
				E[] newArray = (E[]) new Object[objectCount*2];
				for(int c = 0; c < index; c++) //transferring elements before the index over
				{
					newArray[c] = internalArray[c];
				}
				newArray[index] = obj; //final element to include
				internalArray = newArray;
			}

			else
			{
				System.out.println("Skipped the if else statements in add(int, E)");
			}
		}

		catch (IndexOutOfBoundsException e){ //throw IndexOutOfBoundsException if index is invalid!
			System.out.println("Caught add(int,E) exception");
		}

	}


	/* Add an object to the end of the list; returns true */
	@SuppressWarnings("unchecked")  //increment array by x2
	public boolean add(E obj) 
	{
		add(objectCount, obj);
		return true;
	}

	/* Remove the object at index and shift.  Returns removed object. */
	public E remove(int index) {
		objectCount--;
		E temp = get(index);
		for (; index < objectCount; index++)
		{
			internalArray[index-1] = internalArray[index]; //check if this overrides any var to the left of index
		}
		return temp;
	}

	/* Removes the first occurrence of the specified element from this list,
	 * if it is present. If the list does not contain the element, it is unchanged.
	 * More formally, removes the element with the lowest index i such that
	 * (o==null ? get(i)==null : o.equals(get(i))) (if such an element exists).
	 * Returns true if this list contained the specified element (or equivalently,
	 * if this list changed as a result of the call). */
	public boolean remove(E obj) { //use the pre-existing remove() 
		int removeIndex = (Integer) null;

		for(;objectCount-1 > 0 ; objectCount--) //check and store for first occurrence of obj from right to left
		{
			if (internalArray[objectCount]==obj) //Extra credit for doing this from left to right (break;)
			{
				removeIndex = objectCount;
			}
		}
		
		if(removeIndex != (Integer) null)
		{
			remove(removeIndex);
			return true;
		}
		return false;
	}

	/* For testing; your string should output as "{ X X X X ... }" where X X X X ... are the elements in the array.
	 * If the array is empty, it should return "{ }".  If there is one element, "{ X }", etc.
	 * Elements are separated by a space. */
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		for(int c = 0; c < objectCount; c++) //try doing this using for each loop
		{
			buffer.append(internalArray[c] + " ");
		}
		return "{ " + buffer.toString() + " }";
	}


}
