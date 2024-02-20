import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedListWithIterator<E extends Comparable<E>> extends MyLList<E>{
    public Iterator<E> getIterator() {
        return new Iterator<E>() {
            private Node<E> currentNode = getFirstNode(); // Using getter method

            @Override
            public boolean hasNext() {
                return currentNode != null;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                E data = currentNode.data;
                currentNode = currentNode.next;
                return data;
            }
        };
    }
}
