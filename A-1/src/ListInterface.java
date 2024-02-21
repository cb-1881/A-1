public interface ListInterface<E> {
    void add(E newEntry);
    boolean add(int newPosition, E newEntry);
    E remove(int givenPosition);
    void clear();
    E replace(int givenPosition, E newEntry);
    E getEntry(int givenPosition);
    E[] toArray();
    boolean contains(E anEntry);
    int getLength();
    boolean isEmpty();
}
