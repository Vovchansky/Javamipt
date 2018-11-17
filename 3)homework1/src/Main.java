public class Main {
    public static void check(MyIntegerList list) {
        for (int i = 0; i < 10; i++) {
            list.insert(i);
        }
        list.printList();
        int[] array = list.toArray();
        for (int i = 0; i < 10; i++)
            System.out.print(array[i] + " ");
        System.out.println();
        for (int i = 0; i < 10; i++) {
            list.remove(0);
            list.printList();
        }
        for (int i = 0; i < 10; i++) {
            list.insert(i);
        }
        list.printList();
        list.removeAll();
        list.printList();
        list.insert(28);
        list.printList();
        System.out.println(list.get(0));
        System.out.println(list.contains(28));
        System.out.println("МассивСписок наших дедов");
    }

    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        check(list);
    }
}
