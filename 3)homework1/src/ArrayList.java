import java.nio.ByteBuffer;
import java.util.Arrays;

public class ArrayList implements MyIntegerList {
    private static final int DEFAULT_CAPACITY = 10;
    private static final Object[] EMPTY_ELEMENTDATA = new Object[DEFAULT_CAPACITY];
    transient Object[] elementData;
    private int size;

    public ArrayList() {
        this.elementData = EMPTY_ELEMENTDATA;
    }

    public ArrayList(int initialCapacity) {
        this.elementData = new Object[initialCapacity];
    }

    @Override
    public boolean ensureCapacity() {
        return (this.size + 1 <= this.elementData.length);
    }

    @Override
    public void insert(int elem) {
        if (!ensureCapacity()) {
            int oldCapacity = this.elementData.length;
            int newCapacity = oldCapacity + (oldCapacity >> 1);
            Object[] oldArray = this.elementData;
            Object[] newArray = new Object[newCapacity];
            System.arraycopy(oldArray, 0, newArray, 0, this.size);
            this.elementData = newArray;
        }
        this.elementData[this.size++] = elem;
    }

    @Override
    public int get(int index) {
        for (int i = 0; i < this.size; i++) {
            if (i == index)
                return (int) this.elementData[i];
        }
        return -1;
    }

    @Override
    public int[] toArray() {
        int[] array = new int[this.size()];
        for (int i = 0; i < this.size; i++)
            array[i] = (int) this.elementData[i];
        return array;
    }

    @Override
    public void remove(int index) {
        int numMoved = this.size - index - 1;
        System.arraycopy(this.elementData, index + 1, this.elementData, index, numMoved);
        this.elementData[--this.size] = null;
        trimToSize();
    }

    @Override
    public void trimToSize() {
        if (this.size < this.elementData.length) {
            this.elementData = (this.size == 0) ? EMPTY_ELEMENTDATA : Arrays.copyOf(this.elementData, this.size);
        }
    }

    @Override
    public void removeAll() {
        for (int i = 0; i < this.size; i++)
            this.elementData[i] = null;
        this.elementData = new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }

    @Override
    public void printList() {
        System.out.print("[");
        for (int i = 0; i < this.size; i++)
            System.out.print(this.elementData[i] + (i == this.size - 1 ? "" : ", "));
        System.out.println("]");
    }

    @Override
    public boolean contains(int elem) {
        for (int i = 0; i < this.size; i++) {
            if (this.elementData[i].equals(elem))
                return true;
        }
        return false;
    }

    @Override
    public int size() {
        return this.size;
    }
}
