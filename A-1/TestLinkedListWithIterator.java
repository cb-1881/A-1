import java.util.Iterator;

public class TestLinkedListWithIterator {
    public static void main(String[] args) {
        LinkedListWithIterator<String> myList = new LinkedListWithIterator<>();
        myList.add("First");
        myList.add("Second");
        myList.add("Third");
        myList.remove(1);
        Iterator<String> iterator = myList.getIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
