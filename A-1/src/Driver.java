//package src;
//Driver for LinkedlistwithIterator
import java.util.Iterator;

public class Driver {
    public static void main(String[] args) {
        LinkedListWithIterator<String> myList = new LinkedListWithIterator<>();

        // Add elements
        myList.add("Dave");
        myList.add("Richard");
        myList.add("Larry");
        myList.add("Dan");

        // Display elements
        System.out.println("List Contents:");
        Iterator<String> iterator = myList.getIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }



        // Remove an element
        myList.remove(2); // Removes "World"

        // Display elements after removal
        System.out.println("\nList after removing an element:");
        Iterator<String> postRemovalIterator = myList.getIterator();
        while (postRemovalIterator.hasNext()) {
            System.out.println(postRemovalIterator.next());
        }

        // Clear the list
        myList.clear();

        // Check if list is empty
        if (myList.isEmpty()) {
            System.out.println("\nThe list is now empty.");
        }
    }
}