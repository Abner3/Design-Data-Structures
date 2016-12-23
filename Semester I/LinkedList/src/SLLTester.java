import java.util.Iterator;
public class SLLTester
{
    public static void main(String[] args)
    {
        SinglyLinkedList a = new SinglyLinkedList();
        System.out.println("Size of A: " + a.size()); //check
        String[] input = {"Adam", "Betsy", "Caroline", "David"};
        SinglyLinkedList b = new SinglyLinkedList(input);
        System.out.println("Size of B: " + b.size()); //check
        
        System.out.println(a); //check
        System.out.println(b); //check
        System.out.println();
        
        System.out.println("Does List A contain the word \"Caroline\"? " + a.contains("Caroline") + " in the " + a.indexOf("Caroline") + " index.");
        System.out.println("Does List B contain the word \"Caroline\"? " + b.contains("Caroline") + " in the " + b.indexOf("Caroline") + " index.\n"); //check
        
        System.out.println(a.add("Zoe") + "  " + b.add("Eddie")); //check
        System.out.println("Size of A: " + a.size());
        System.out.println("Size of B: " + b.size()); //check
        System.out.println(a.remove("Zoe") + "  " + a.remove("Zoe") + "  " + b.remove("Adam")); //check
        System.out.println("Size of A: " + a.size());
        System.out.println("Size of B: " + b.size());
        
        System.out.println(a);
        System.out.println(b);
        System.out.println();
        
        try 
        {
            System.out.println(a.get(2));
        } 
        catch (IndexOutOfBoundsException iobe) 
        {
            System.out.println("IndexOutOfBoundsException was thrown when attempted to \"a.get(2)\"");
        }
        System.out.println(b.get(2));
        
        try 
        {
            System.out.println(a.set(2, "Fritz"));
        } 
        catch (IndexOutOfBoundsException iobe) 
        {
            System.out.println("IndexOutOfBoundsException was thrown when attempted to \"a.set(2, \"Fritz\")\"");
        }        
        System.out.println(b.set(2, "Fritz")+ "\n");
        
        System.out.println(a);
        System.out.println(b + "\n");
        
        try 
        {
            a.add(2, "Gina");
        } 
        catch (IndexOutOfBoundsException iobe) 
        {
            System.out.println("IndexOutOfBoundsException was thrown when attempted to \"a.add(2, \"Gina\")\"");
        }
        System.out.println("Size of A: " + a.size());
        b.add(2, "Gina");
        System.out.println("Size of B: " + b.size());
        System.out.println(a);
        System.out.println(b);
        System.out.println();
        
        try 
        {
            System.out.println(a.remove(2));
        } 
        catch (IndexOutOfBoundsException iobe) 
        {
            System.out.println("IndexOutOfBoundsException was thrown when attempted to \"a.remove(2)\"");
        }
        System.out.println("Size of A: " + a.size());
        System.out.println(b.remove(2));
        System.out.println("Size of B: " + b.size());
        System.out.println(a);
        System.out.println(b);
        
        SinglyLinkedList longList = new SinglyLinkedList();
        long startTime = System.currentTimeMillis();
        for (int x = 0; x < 3000; x++)
            longList.add("C");
        longList.add(0,"B");
        for (int x = 0; x < 3000; x++)
            longList.add(0, "A");
        longList.add("D");
        System.out.println("Index of \"B\": " + longList.indexOf("B"));
        System.out.println("Index of \"D\": " + longList.indexOf("D"));
        longList.add(longList.size()-5, "E");
        longList.set(longList.size()-4, "F");
        System.out.println("Should be E: " + longList.get(longList.size()-6));
        System.out.println("Should be F: " + longList.get(longList.size()-4));
        System.out.println("Should be F: " + longList.remove(longList.size()-4));
        System.out.println("Should be true: " + longList.remove("E"));
        System.out.println("Methods are working: " + !longList.contains("E"));
        System.out.println("Methods are working: " + (longList.indexOf("F") == -1));
        System.out.println("Index of B: " + longList.indexOf("B"));
        System.out.println("THIS WILL TAKE ABOUT 10 SECONDS ... PLEASE BE PATIENT.");
        for (int iteration = 0; iteration < 100000; iteration++)
        {
            longList.isEmpty();
            longList.add("Z");
            longList.indexOf("Z");
            longList.add(0,"G");
            longList.contains("Z");
            longList.set(5000, "H");
            longList.remove("Z");
            longList.remove(5000);
            longList.get(longList.size()-1);
        }        
        long endTime = System.currentTimeMillis();
        System.out.println("YOUR SCORE: " + (15000 - (endTime - startTime)));
        System.out.println("Textbook solution's score: 2828");
        System.out.println("My computer's slower: 4267-98ish");

    } 
}