import java.sql.Array;
import java.util.*;

public class MyArrayList<T> {
    private Object[] data;
    private int size;

    public MyArrayList(int initialCapacity) {
        if (initialCapacity < 0)
            throw new IllegalArgumentException();
        data = new Object[initialCapacity];
    }

    public MyArrayList() {
        data = new Object[10];
    }

    private void grow(int newCapacity) {
        data = Arrays.copyOf(data, newCapacity);
    }

    private void grow() {
        size++;
        if (size == data.length) {
            grow(data.length * 2);
        }
    }

    public void add(T e) {
        if (size == 0) {
            data[size] = e;
            size++;
        } else {
            ensureCapacity(size + 1);
            data[size] = e;
            grow();
        }
    }

    public void add(int index, T element) {
        indexChecker(index);
        ensureCapacity(size + 1);
        Object[] newData = Arrays.copyOf(data, data.length + 1);
        newData[newData.length - 1] = element;
        for (int i = newData.length - 1; i > index; i--) {
            Object tmp = newData[i];
            newData[i] = newData[i - 1];
            newData[i - 1] = tmp;
        }
        data = newData;
        grow();
    }

    public void addAll(Object[] c) {
        for (Object o : c) {
            add(size, (T) o);
        }
    }

    public void addAll(int index, Object[] c) {
        indexChecker(index);
        for (int i = 0; i < c.length; i++) {
            add(index + i, (T) c[i]);
        }
    }

    public void ensureCapacity(int minCapacity) {
        if (minCapacity < size) {
            throw new IllegalArgumentException();
        }
        if (size + minCapacity != data.length) {
            grow(data.length * 2);
        }
    }

    public T get(int index) {
        indexChecker(index);
        return (T) data[index];
    }

    public T remove(int index) {
        indexChecker(index);
        Object[] newData = new Object[data.length];
        int j = 0;
        for (int i = 0; i < newData.length; i++) {
            if (i != index) {
                newData[j++] = data[i];
            }
        }
        data = Arrays.copyOf(newData, data.length);
        size--;
        return (T) data[index];
    }

    public int size() {
        return size;
    }

    public void indexChecker(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public String toString() {
        String str = "";
        for (int i = 0; i < size; i++) {
            str += data[i].toString() + "\n";
        }
        return str.trim();
    }
}