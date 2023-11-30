package Task_2;

public class Element<T> {
    private T element;
    private Element<T> next;
    private Element<T> prev;

    public Element(T element, Element<T> next, Element<T> prev) {
        this.element = element;
        this.next = next;
        this.prev = prev;
    }

    public Element<T> getNext() {
        return next;
    }

    public void setNext(Element<T> next) {
        this.next = next;
    }

    public Element<T> getPrev() {
        return prev;
    }

    public void setPrev(Element<T> prev) {
        this.prev = prev;
    }

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public boolean hasNext() {
        return next != null;
    }

    public Element<T> next() {
        return next;
    }
}
