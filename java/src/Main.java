import LineStructures.LinkedList.LineLinkedList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        LineLinkedList<String> linkedList = new LineLinkedList<>();
        linkedList.append("Hello!");
        linkedList.append("He!");
        linkedList.append("He!");
        linkedList.append("He!");
        linkedList.append("He!");
        linkedList.print();
        linkedList.add(2, "e");
        linkedList.print();
    }
}
