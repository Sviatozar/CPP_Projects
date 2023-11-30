package Task_2;

public class MyStack<E> {
    private final MyLinkedList<E> list;

    public MyStack(MyLinkedList<E> list) {
        this.list = list;
    }

    public void push(E e) {
        list.addLast(e);
    }

    public E pop() {
        E tmp = list.getLast();
        list.removeLast();
        return tmp;
    }

    @Override
    public String toString() {
        return list.toString();
    }
}

