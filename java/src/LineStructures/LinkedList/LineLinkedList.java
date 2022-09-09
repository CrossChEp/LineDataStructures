package LineStructures.LinkedList;

public class LineLinkedList <T> {
    private Node<T> firstNode;
    private Node<T> lastNode;

    public LineLinkedList() {
        firstNode = new Node<>();
        lastNode = new Node<>();
    }

    public void append(T element) {
        Node<T> node = new Node<>(element);
        if(firstNode.nextNode == null) {
            firstNode.nextNode = node;
            node.prevNode = firstNode;
            lastNode.prevNode = node;
            return;
        }
        Node<T> head = firstNode;
        while (head.nextNode != null) {
            head = head.nextNode;
        }
        head.nextNode = node;
        node.prevNode = head;
        lastNode.prevNode = node;
        node.nextNode = lastNode;
    }

    public void add(int index, T element) {
        Node<T> headNode = firstNode.nextNode;
        int currentIndex = 0;
        while (headNode.nextNode != null) {
            if(currentIndex == index) {

            }
        }
    }

    public void pop() {
        Node<T> currentNode = lastNode.prevNode;
        currentNode.prevNode.nextNode = lastNode;
        lastNode.prevNode = currentNode.prevNode;
    }

    public void pop(T element) {
        Node<T> headNode = firstNode.nextNode;
        while (headNode.nextNode != null) {
            if(headNode.value == element) {
                headNode.prevNode.nextNode = headNode.nextNode;
                headNode.nextNode.prevNode = headNode.prevNode;
                return;
            }
            headNode = headNode.nextNode;
        }
    }

    public void pop(int index) {
        int indexCounter = 0;
        Node<T> headNode = firstNode.nextNode;
        while (headNode.nextNode != null) {
            if(indexCounter == index) {
                headNode.prevNode.nextNode = headNode.nextNode;
                headNode.nextNode.prevNode = headNode.prevNode;
                return;
            }
            indexCounter++;
            headNode = headNode.nextNode;
        }
    }

    public void print() {
        Node<T> head = firstNode.nextNode;
        while (head.nextNode != null) {
            System.out.println(head.value);
            head = head.nextNode;
        }
    }
}
