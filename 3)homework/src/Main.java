import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int n, p;
        boolean kek = true;
        MyIntegerList list = new DoubleLinkedList();
        System.out.println((char)27 + "[35mHello!\n" +
                "This is my DoubleLinkedList realization.\n" +
                "Please follow the instructions for it and enjoy. =)");
        while (kek) {
            System.out.println((char)27 + "[31mENTER A NUMBER: \n" +
                    (char)27 + "[33m(1) to add an element to the head of the list\n" +
                    "(2) to add an element to the tail of the list\n" +
                    "(3) to remove an element by its index\n" +
                    "(4) to remove the whole list\n" +
                    "(5) to exit the program");
            n = reader.nextInt();
            switch (n) {
                case 1:
                    System.out.println("Type an element you want to add to the list");
                    p = reader.nextInt();
                    list.addToHead(p);
                    System.out.println((char)27 + "[36m" + list.printList());
                    break;
                case 2:
                    System.out.println("Type an element you want to add to the list");
                    p = reader.nextInt();
                    list.addToTail(p);
                    System.out.println((char)27 + "[36m" + list.printList());
                    break;
                case 3:
                    System.out.println("Type the index of the element you want to remove from the list");
                    p = reader.nextInt();
                    list.removeByIndex(p);
                    System.out.println((char)27 + "[36m" + list.printList());
                    break;
                case 4:
                    list.removeAll();
                    System.out.println((char)27 + "[36m" + list.printList());
                    break;
                case 5:
                    kek = false;
                    break;
                default:
                    System.out.println((char)27 + "[31mType the suitable number");
                    break;
            }
        }
        System.out.println((char)27 + "[32mGoodbye!");
        reader.close();
    }
}
