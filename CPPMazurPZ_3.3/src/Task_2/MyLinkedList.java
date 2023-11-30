package Task_2;

import java.util.NoSuchElementException;

public class MyLinkedList<E> {
    private int size;
    private Element<E> first;
    private Element<E> last;

    public MyLinkedList() {
    }

    public void add(E e) {
        if (size != 0) {
            Element<E> elementNew = new Element<E>(e, null, last);
            last.setNext(elementNew);
            last = elementNew;
        } else {
            Element<E> elementNew = new Element<>(e, null, null);
            last = elementNew;
            first = elementNew;
        }
        size++;
    }

    public void add(int index, E element) {
        checkIndex(index);
        if (index == 0) {
            addFirst(element);
        } else if (index == size - 1) {
            addLast(element);
        } else {
            Element<E> elementBefore = findByIndex(index - 1);
            Element<E> elementAfter = findByIndex(index);
            Element<E> newElement = new Element<E>(element, elementAfter, elementBefore);
            elementBefore.setNext(newElement);
            elementAfter.setPrev(newElement);
            size++;
        }
    }

    private void checkIndex(int index) {
        if (!(index >= 0 || index < size))
            throw new IndexOutOfBoundsException();
    }

    public void addFirst(E e) {
        Element<E> newElement = new Element<E>(e, first, null);
        first.setPrev(newElement);
        first = newElement;
        size++;
    }

    public void addLast(E e) {
        ;
        Element<E> newElement = new Element<E>(e, null, last);
        last.setNext(newElement);
        last = newElement;
        size++;
    }

    public E get(int index) {
        return findByIndex(index).getElement();
    }

    public E getFirst() {
        checkElement(first);
        return first.getElement();
    }

    public E getLast() {
        checkElement(last);
        return last.getElement();
    }

    public E remove(int index) {
        checkIndex(index);
        Element<E> elementBefore = findByIndex(index - 1);
        Element<E> elementAfter = findByIndex(index + 1);
        elementBefore.setNext(elementAfter);
        elementAfter.setPrev(elementBefore);
        size--;
        return findByIndex(index).getElement();
    }

    public E removeFirst() {
        checkElement(first);
        first.getNext().setPrev(null);
        first = first.getNext();
        size--;
        return first.getElement();
    }

    public E removeLast() {
        checkElement(last);
        last.getPrev().setNext(null);
        last = last.getPrev();
        size--;
        return last.getElement();
    }

    public void set(int index, E e) {
        checkIndex(index);
        Element<E> receivedElement = findByIndex(index);
        receivedElement.setElement(e);
    }

    public int size() {
        return size;
    }

    public int indexOf(E e) {
        checkSize();
        for (int i = 0; i < size; i++) {
            if (get(i).equals(e)) {
                return i;
            }
        }
        return -1;
    }

    private Element<E> findByIndex(int index) {
        checkIndex(index);
        Element<E> tmp = first;
        for (int i = 0; i < index; i++) {
            tmp = tmp.getNext();
        }
        return tmp;
    }

    private void checkSize() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
    }

    private void checkElement(Element<E> element) {
        if (element == null)
            throw new NoSuchElementException();
    }

    @Override
    public String toString() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        String result = "[" + first.getElement() + ", ";
        Element<E> tmp = first;
        while (tmp.hasNext()) {
            result += tmp.next().getElement();
            tmp = tmp.next();
            if (tmp.hasNext()) {
                result += ", ";
            } else {
                result += "]";
            }
        }
        return result;
    }
}
