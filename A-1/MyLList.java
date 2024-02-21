
//import java.util.Iterator;
//import java.util.NoSuchElementException;


public class MyLList<E extends Comparable<E>> implements ListInterface<E>{
    private Node<E> firstNode;
    private int length;

  protected class Node<E> {
    E data;
    Node<E> next;

    // Node constructor
    Node(E dataPortion) {
        this.data = dataPortion;
        this.next = null;
    }
}


    public MyLList() {
        firstNode = null;
        length = 0;
    }

    @Override
    public int getLength() {
    return length;
     }

    // Implement methods from ListInterface here
    // Examples:
    @Override
    public void add(E newEntry) {
        Node<E> newNode = new Node<>(newEntry);
        if (isEmpty()) {
            firstNode = newNode;
        } else {
            Node<E> lastNode = getNodeAt(length);
            lastNode.next = newNode;
        }
        length++;
    }

@Override
public boolean add(int newPosition, E newEntry) {
    if (newPosition >= 1 && newPosition <= length + 1) {
        Node<E> newNode = new Node<>(newEntry);
        if (newPosition == 1) { // Case: Add at the beginning
            newNode.next = firstNode;
            firstNode = newNode;
        } else { // Case: Add at the end or in the middle
            Node<E> nodeBefore = getNodeAt(newPosition - 1);
            newNode.next = nodeBefore.next;
            nodeBefore.next = newNode;
        }
        length++; // Increase the size of the list
        return true;
    } else {
        return false; // newPosition out of bounds
    }
}




    @Override
     public boolean isEmpty() {
        return length == 0;
       }

    protected Node<E> getFirstNode() {
    return firstNode;
}


@Override
public boolean contains(E anEntry) {
    Node<E> currentNode = firstNode;
    while (currentNode != null) {
        if (currentNode.data.equals(anEntry)) {
            return true;
        }
        currentNode = currentNode.next;
    }
    return false;
}

@Override
public E[] toArray() {
    // Suppress unchecked cast warnings, as this is an inherent issue with generic arrays in Java
    @SuppressWarnings("unchecked")
    E[] result = (E[])new Object[length]; // This will cause an unchecked cast warning
    int index = 0;
    Node<E> currentNode = firstNode;
    while (currentNode != null) {
        result[index] = currentNode.data;
        currentNode = currentNode.next;
        index++;
    }
    return result;
}


    // Additional methods like remove(), clear(), getEntry() etc. follow similar patterns
    // of navigating and manipulating the linked list

    private Node<E> getNodeAt(int givenPosition) {
        assert (givenPosition >= 1) && (givenPosition <= length);
        Node<E> currentNode = firstNode;
        for (int i = 1; i < givenPosition; i++) {
            currentNode = currentNode.next;
        }
        return currentNode;
    }

    @Override
public E getEntry(int givenPosition) {
    if ((givenPosition >= 1) && (givenPosition <= length)) {
        Node<E> currentNode = getNodeAt(givenPosition);
        return currentNode.data;
    } else {
        throw new IndexOutOfBoundsException("Illegal position given to getEntry operation.");
    }
}

@Override
public void clear() {
    firstNode = null; // Discard references to any nodes
    length = 0;       // Reset the length of the list
}


@Override
public E replace(int givenPosition, E newEntry) {
    if ((givenPosition >= 1) && (givenPosition <= length)) {
        Node<E> desiredNode = getNodeAt(givenPosition);
        E originalEntry = desiredNode.data;
        desiredNode.data = newEntry;
        return originalEntry;
    } else {
        throw new IndexOutOfBoundsException("Illegal position given to replace operation.");
    }
}

@Override
public E remove(int givenPosition) {
    if ((givenPosition >= 1) && (givenPosition <= length)) {
        E result = null; // To return the removed data

        if (givenPosition == 1) { // Case: remove the first node
            result = firstNode.data; // Save the data to return
            firstNode = firstNode.next; // Remove the first node
        } else { // Case: not the first node
            Node<E> nodeBefore = getNodeAt(givenPosition - 1); // Get node before the one to remove
            Node<E> nodeToRemove = nodeBefore.next; // The node to remove
            result = nodeToRemove.data; // Save the data to return
            Node<E> nodeAfter = nodeToRemove.next; // The node after the one to remove
            nodeBefore.next = nodeAfter; // Remove the node by bypassing it
        }

        length--; // Decrease length of the list
        return result; // Return the removed data
    } else {
        throw new IndexOutOfBoundsException("Illegal position given to remove operation.");
    }
}


    // Implement other methods from ListInterface...
}
