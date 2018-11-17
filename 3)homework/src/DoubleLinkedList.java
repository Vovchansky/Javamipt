public class DoubleLinkedList implements MyIntegerList {
    private Node head;
    private Node tail;
    private int size;

    private class Node {
        int elem;
        Node nextNode;
        Node prevNode;

        Node() {
        }

        Node(int elem) {
            this.elem = elem;
        }
    }

    @Override
    public void addToHead(int elem) {
        Node a = new Node(elem);

        if (this.head == null) {
            this.head = a;
            this.tail = a;
        } else {
            a.nextNode = this.head;
            this.head.prevNode = a;
            this.head = a;
        }

        size++;
    }

    @Override
    public void addToTail(int elem) {
        Node a = new Node();
        a.elem = elem;
        if (this.head == null) {
            this.head = a;
            this.tail = a;
        } else {
            a.prevNode = this.tail;
            this.tail.nextNode = a;
            this.tail = a;
        }
        size++;
    }

    @Override
    public int getByIndex(int index) {
        int count = 0;
        Node currNode = this.head;
        while (currNode != null) {
            if (count == index)
                break;
            else {
                count++;
                currNode = currNode.nextNode;
            }
        }
        return currNode.elem;
    }

    @Override
    public int[] toArray() {
        int[] array = new int[this.size()];
        Node currNode = this.head;
        int i = 0;
        while (currNode != null) {
            array[i] = currNode.elem;
            i++;
            currNode = currNode.nextNode;
        }
        return array;
    }

    @Override
    public void removeByIndex(int index) {
        int count = 0;
        Node currNode = this.head;
        while (currNode != null) {
            if (count == index) {
                Node newPrev = currNode.prevNode;
                Node newNext = currNode.nextNode;
                if (newPrev == null) {
                    if (newNext == null)
                        removeAll();
                    else {
                        this.head = newNext;
                        newNext.prevNode = null;
                    }
                } else if (newNext == null) {
                    this.tail = newPrev;
                    newPrev.nextNode = null;
                } else {
                    newNext.prevNode = newPrev;
                    newPrev.nextNode = newNext;
                }
                currNode = null;
            } else {
                count++;
                currNode = currNode.nextNode;
            }
        }
        size--;
    }

    @Override
    public void removeAll() {
        this.head = null;
        this.tail = null;
        size = 0;
    }

    @Override
    public String printList() {
        Node currNode = this.head;
        String outLine = "[";
        while (currNode != null) {
            outLine += (currNode.elem + (currNode.nextNode == null ? "" : ", "));
            currNode = currNode.nextNode;
        }
        return outLine += "]";
    }

    @Override
    public boolean containsElem(int elem) {
        Node currNode = this.head;
        while (currNode != null) {
            if (currNode.elem == elem) {
                return true;
            } else {
                currNode = currNode.nextNode;
            }
        }

        return false;
    }

    @Override
    public int size() {
        return this.size;
    }
}

