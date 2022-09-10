package LineStructures.LinkedList;

public class LineLinkedList <T> {
    private final Node<T> firstNode;
    private final Node<T> lastNode;
    private int size;

    public LineLinkedList() {
        firstNode = new Node<>();
        lastNode = new Node<>();
        size = 0;
    }

    public LineLinkedList(T[] array) {
        firstNode = new Node<>();
        lastNode = new Node<>();
        size = 0;
        for(var element: array) {
            append(element);
        }
    }

    public int size() {
        return size;
    }

    public void append(T element) {
        Node<T> node = new Node<>(element);
        if(firstNode.nextNode == null) {
            setUpFirstNode(node);
            return;
        }
        Node<T> head = firstNode;
        while (head.nextNode != null) {
            head = head.nextNode;
        }
        link(node, head.prevNode, lastNode);
        head.prevNode.nextNode = node;
        lastNode.prevNode = node;
        size++;
    }

    private void setUpFirstNode(Node<T> node) {
        link(node, firstNode, lastNode);
        firstNode.nextNode = node;
        lastNode.prevNode = node;
    }

    public void append(int index, T element) {
        Node<T> headNode = firstNode.nextNode;
        int currentIndex = 0;
        while (headNode.nextNode != null) {
            if(currentIndex == index) {
                addNewNode(headNode, element);
                return;
            }
            headNode = headNode.nextNode;
            currentIndex++;
        }
        size++;
    }

    private void addNewNode(Node<T> headNode, T element) {
        Node<T> newNode = new Node<>(element);
        link(newNode, headNode.prevNode, headNode);
        newNode.prevNode.nextNode = newNode;
        newNode.nextNode.prevNode = newNode;
    }

    public void pop() {
        Node<T> currentNode = lastNode.prevNode;
        currentNode.prevNode.nextNode = lastNode;
        lastNode.prevNode = currentNode.prevNode;
        size--;
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
        size--;
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
        size--;
    }

    private void link(Node<T> node) {
        node.prevNode.nextNode = node.nextNode;
        node.nextNode.prevNode = node.prevNode;
    }

    private void link(Node<T> node, Node<T> prevNode, Node<T> nextNode) {
        node.nextNode = nextNode;
        node.prevNode = prevNode;
    }

    public void print() {
        Node<T> head = firstNode.nextNode;
        while (head.nextNode != null) {
            System.out.println(head.value);
            head = head.nextNode;
        }
    }
}
