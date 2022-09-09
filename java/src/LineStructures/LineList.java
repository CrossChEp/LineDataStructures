package LineStructures;

import exceptions.NoSuchElementException;

import java.rmi.NoSuchObjectException;
import java.util.Arrays;
import java.util.Collections;

public class LineList <T> {
    private int capacity;
    private int size;
    private Object[] elements;
    private int currentIndex;

    public LineList() {
        capacity = 10;
        size = 0;
        elements = new Object[capacity];
        currentIndex = 0;
    }

    public int size() {
        return size;
    }

    public Object[] toArray() {
        return elements;
    }

    public void append(T element) {
        if(currentIndex >= elements.length - 1) {
            grow();
        }
        elements[currentIndex] = element;
        size++;
        currentIndex++;
    }

    public void append(int index, T element) {
        if(index >= size) {
            throw new IndexOutOfBoundsException("you try to insert element to the index " + index +
                    ", although the size of list is just " + size);
        }
        if(capacity >= elements.length - 1) {
            grow();
        }

        currentIndex++;
        Object[] tempArr = new Object[capacity];

        for(int i = 0; i < index; i++) {
            tempArr[i] = elements[i];
        }

        tempArr[index] = element;

        for(int i = index + 1; i < elements.length; i++) {
            tempArr[i] = elements[i - 1];
        }

        elements = tempArr;
        size++;
    }

    private void grow() {
        capacity *= 1.5;
        Object[] tempList = new Object[capacity];
        for(int i = 0; i < elements.length; i++) {
            tempList[i] = elements[i];
        }
        elements = tempList;
    }

    public void pop() {
        Object[] newArr = new Object[capacity];
        for(int i = 0; i < currentIndex - 1 ; i++) {
            newArr[i] = elements[i];
        }
        for(int i = currentIndex; i < elements.length; i++) {
            newArr[i] = elements[i];
        }
        elements = newArr;
        size--;
        currentIndex--;
    }

    public void pop(T element) {
        int elementIndex = indexOf(element);
        Object[] tempArr = new Object[capacity];
        for(int i = 0; i < elementIndex; i++) {
            tempArr[i] = elements[i];
        }
        for(int i = elementIndex; i < elements.length - 1; i++) {
            tempArr[i] = elements[i + 1];
        }
        elements = tempArr;
        size--;
        currentIndex--;
    }

    public int indexOf(T element) {
        for(int i = 0; i < elements.length; i++) {
            if(elements[i] == element) {
                return i;
            }
        }
        throw new NoSuchElementException("there is no such element in list");
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(T element) {
        for(int i = 0; i < currentIndex; i++) {
            if(elements[i] == element) {
                return true;
            }
        }
        return false;
    }

    public void print() {
        for(int i = 0; i < currentIndex; i++) {
            System.out.println(elements[i]);
        }
    }
}
