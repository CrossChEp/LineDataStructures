package LineStructures.LinkedList;

public class Node <T> {
    public Node <T> prevNode;
    public T value;
    public Node <T> nextNode;

    public Node() {

    }

    public Node(T value) {
        this.value = value;
    }
}
