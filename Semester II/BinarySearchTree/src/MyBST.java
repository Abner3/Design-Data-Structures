// Implements a BST with TreeNode nodes

import java.util.Stack;
import java.util.Iterator;
import java.util.NoSuchElementException;

//@SuppressWarnings("unchecked")
// Normally, TreeNode and MyTreeSet would be "generic" (type-specific)
// classes and hold Comparable objects, but this is beyond the scope of
// the Java Methods book. Without @SuppressWarnings, this class would give
// three "Unchecked cast" warnings.

// ((Comparable)node.getValue()).compareTo( )
public class MyBST
{
	private TreeNode root;  // holds the root of this BST

	// Constructor: creates an empty BST.
	public MyBST()
	{
		root = null;
	}

	// Returns true if this BST contains value; otherwise returns false.
	public boolean contains(Object value)
	{
		return contains(root, value);
	}

	// Adds value to this BST, unless this tree already holds value.
	// Returns true if value has been added; otherwise returns false.
	public boolean add(Object value)
	{
		if (contains(value))
			return false;
		root = add(root, value);
		return true;
	}

	// Removes value from this BST.  Returns true if value has been
	// found and removed; otherwise returns false.
	public boolean remove(Object value)
	{
		if (!contains(value))
			return false;
		root = remove(root, value);
		return true;
	}

	// Returns a string representation of this BST.
	public String toString()
	{
		String str = toString(root);
		if (str.endsWith(", "))
			str = str.substring(0, str.length() - 2);
		return "[" + str + "]";
	}

	//*************** Private helper methods: *********************

	// Returns true if the BST rooted at node contains value;
	// otherwise returns false (recursive version).

	// Recursive version:
	private boolean contains(TreeNode node, Object value)
	{                                                                                                   
		if (node == null)
			return false;
		else
		{
			int  diff = ((Comparable<Object>)value).compareTo(node.getValue());
			if (diff == 0)
				return true;
			else if (diff < 0)
				return contains(node.getLeft(), value);
			else // if (diff > 0)
				return contains(node.getRight(), value);
		}
	}

	/*
  // Iterative version:
  private boolean contains(TreeNode node, Object value)
  {
    while (node != null)
    {
      int  diff = ((Comparable<Object>)value).compareTo(node.getValue());
      if (diff == 0)
        return true;
      else if (diff < 0)
        node = node.getLeft();
      else // if (diff > 0)
        node = node.getRight();
    }
    return false;
  }
	 */

	// Adds value to the BST rooted at node. Returns the
	// root of the new tree.
	// Precondition: the tree rooted at node does not contain value.
	private TreeNode add(TreeNode node, Object value)
	{
		if(node == null)
		{
//			node = new TreeNode(value);
//			return node;
			return new TreeNode(value);
		}
		//else if(node > value)
		//{
		//node = new TreeNo);
		//}
		//
		//&& node.getLeft() == null
		//node.setLeft(new TreeNode(value));
		else
		{
			int diff = ((Comparable)value).compareTo(node.getValue());

			if (diff < 0)
			{
				return add(node.getLeft(), value);
			}
			else if (diff > 0)
			{
				return add(node.getRight(), value);
			}
			
			else
			{
				return node;
			}
		}
	}


	// Removes value from the BST rooted at node.
	// Returns the root of the new tree.
	// Precondition: the tree rooted at node contains value.
	private TreeNode remove(TreeNode node, Object value)
	{
		if(node.getValue().equals(value))
		{
			return removeRoot(node);
		}
		
		if(node.getLeft() == null)
		{
			return node;
		}
		//else if(node > value)
		//{
		//node = new TreeNo);
		//}
		//
		//&& node.getLeft() == null
		//node.setLeft(new TreeNode(value));
		else
		{
			int diff = ((Comparable)value).compareTo(node.getValue());

			if (diff < 0)
			{
				return add(node.getLeft(), value);
			}
			else if (diff > 0)
			{
				return add(node.getRight(), value);
			}
		}
		return node;
	}


	// Removes the root of the BST rooted at root
	// replacing it with the smallest node from the right subtree.
	// Returns the root of the new tree.
	private TreeNode removeRoot(TreeNode root)
	{
		if((root.getLeft() == null || root.getRight() == null) && (root.getLeft() !=null || root.getRight() != null))
		{
			if(root.getLeft() != null)
				root = root.getLeft();
			
			else if(root.getRight() != null)
				root = root.getRight();
			
			else
				System.out.println("Check removeRoot");
			
		}
		
		else if(root.getLeft() == null && root != this.root)
		{
			this.root.setRight(root);
			return root.getLeft();
		}
		
		else if(root.getRight() != null && root.getRight().getLeft() == null)
		{
			root.setLeft(root);
			root = root.getRight().setLeft(root.getLeft());
		}
		
		else
		{
			return root;
		}
	}

	// Returns a string representation of the tree rooted at node.
	private String toString(TreeNode node)
	{
		if (node == null)
			return "";
		else
			return toString(node.getLeft()) + node.getValue() + ", " +
			toString(node.getRight());
	}

	// recursive method example
	/*
	 * ListNode recusiveMethod(ListNode node)
	 * {
	 * 	if(node == null)
	 * 		do stuff here
	 * 	else if(node node is what we want 
	 * 		Change node
	 * 	else
	 * 	{
	 * 		recursiveMethod(node.getNext(node.getNext()))1
	 * 		return node;
	 * 	}
	 * }
	 */
}
