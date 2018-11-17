public interface MyIntegerList {
    boolean ensureCapacity();

    void insert(int elem);

    int get(int index);

    int[] toArray();

    void remove(int index);

    void trimToSize();

    void removeAll();

    void printList();

    boolean contains(int elem);

    int size();
}
