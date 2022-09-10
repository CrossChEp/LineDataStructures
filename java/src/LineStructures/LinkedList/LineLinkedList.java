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
            node.nextNode = lastNode;
            return;
        }
        Node<T> head = firstNode;
        while (head.nextNode != null) {
            head = head.nextNode;
        }
        node.prevNode = head.prevNode;
        node.nextNode = lastNode;
        head.prevNode.nextNode = node;
        lastNode.prevNode = node;
    }

    public void add(int index, T element) {
        Node<T> headNode = firstNode.nextNode;
        int currentIndex = 0;
        while (headNode.nextNode != null) {
            if(currentIndex == index) {
                Node<T> newNode = new Node<>(element);
                newNode.prevNode = headNode.prevNode;
                newNode.nextNode = headNode;
                newNode.prevNode.nextNode = newNode;
                newNode.nextNode.prevNode = newNode;
                return;
            }
            headNode = headNode.nextNode;
            currentIndex++;
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
                link(headNode);
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
                link(headNode);
                return;
            }
            indexCounter++;
            headNode = headNode.nextNode;
        }
    }

    private void link(Node<T> node) {
        node.prevNode.nextNode = node.nextNode;
        node.nextNode.prevNode = node.prevNode;
    }

    public void print() {
        Node<T> head = firstNode.nextNode;
        while (head.nextNode != null) {
            System.out.println(head.value);
            head = head.nextNode;
        }
    }
}
