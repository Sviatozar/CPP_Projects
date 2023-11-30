package Task_2;

public class MyQueue<E> {
    private final MyLinkedList<E> list;

    public MyQueue(MyLinkedList<E> list) {
        this.list = list;
    }

    public void offer(E e) {
        list.addLast(e);
    }

    public E peek() {
        return list.getFirst();
    }

    public E poll() {
        E tmp = list.getFirst();
        list.removeFirst();
        return tmp;
    }

    @Override
    public String toString() {
        return list.toString();
    }
}

