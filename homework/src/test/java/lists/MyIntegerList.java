package lists;
public interface MyIntegerList {

    void addToTail(int elem);

    void addToHead(int elem);

    int getByIndex(int index);

    int[] toArray();

    void removeByIndex(int index);

    void removeAll();

    String printList();

    boolean containsElem(int elem);

    int size();

}