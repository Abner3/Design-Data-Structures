import java.awt.Graphics;

/**
 * Implements the list of messages for teletext
 */
public class TeletextList
{
  private ListNode2 heading, topNode;

  /**
   * Creates a circular list of headlines. check
   * First creates a circular list with one node, "Today's headlines:". check
   * Saves a reference to that node in heading. check
   * Adds a node holding an empty string before heading check
   * and another node holding an empty string after heading. check
   * Appends all the strings from headlines to the list, after check
   * the blank line that follows heading, check
   * preserving their order.  Sets topNode equal to heading. check?
   */
  public TeletextList(String[] headlines)
  {
	  heading = new ListNode2("Today's headlines:"); //why do i first have to initialize heading?
	  ListNode2 empty1 = new ListNode2("", heading, null);
	  ListNode2 empty2 = new ListNode2("", empty1, heading);
	  empty1.setNext(empty2);
	  heading.setNext(empty1);
	  heading.setPrevious(empty2);
	  
	  for(String headline : headlines)
		  addAfter(empty1, headline);
	  
	  topNode = heading;
  }

  /**
   * Inserts a node with msg into the headlines list after the blank
   * line that follows heading.
   */
  public void insert(String msg)
  {
	  addAfter(heading.getNext(), msg);
  }

  /**
   * Deletes the node that follows topNode from the headlines list,
   * unless that node happens to be heading or the node before or after
   * heading that holds a blank line.
   */
  public void delete()
  {
	  if(topNode.getNext().getValue() == "" || topNode.getNext().getValue() == "Today's headlines:")
		  return;
	  remove(topNode.getNext());
  }

  /**
   * Scrolls up the headlines list, advancing topNode to the next node.
   */
  public void scrollUp()
  {
	  topNode = topNode.getNext();
  }

  /**
   * Adds a new node with msg to the headlines list before a given node.
   * Returns a reference to the added node.
   */
  private ListNode2 addBefore(ListNode2 node, String msg)
  {
	  ListNode2 node1 = new ListNode2(msg, node.getPrevious(), node);
	  node.setPrevious(node1);
	  node1.getPrevious().setNext(node1);
	  
	  return node1;
  }

  /**
   * Adds a new node with msg to the headlines list after a given node.
   * Returns a reference to the added node.
   */
  private ListNode2 addAfter(ListNode2 node, String msg)
  {
	  ListNode2 node1 = new ListNode2(msg, node, node.getNext());
	  node.setNext(node1);
	  node1.getNext().setPrevious(node1);
	  
	  return node1;
  }

  /**
   * Removes a given node from the list.
   */
  private void remove(ListNode2 node)
  {
	  ListNode2 node1 = node.getPrevious();
	  node1.setNext(node.getNext());
  }

  /**
   * Draws nLines headlines in g, starting with topNode at x, y
   * and incrementing y by lineHeight after each headline.
   */
  public void draw(Graphics g, int x, int y, int lineHeight, int nLines)
  {
    ListNode2 node = topNode;
    for (int k = 1; k <= nLines; k++)
    {
      g.drawString((String)node.getValue(), x, y);
      y += lineHeight;
      node = node.getNext();
    }
  }
}
